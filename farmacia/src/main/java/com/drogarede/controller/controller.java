package com.drogarede.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drogarede.model.DAO;
import com.drogarede.model.JavaBeans;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class controller.
 */
@WebServlet(urlPatterns = {"/controller", "/main" , "/insert" , "/select" , "/update" ,"/delete" , "/report"})
public class controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
    
    /** The contato. */
    JavaBeans contato = new JavaBeans(); 
    
    /**
     * Instantiates a new controller.
     */
    public controller() {
        super();
       
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if(action.equals("/main"))
		{
			dados(request,response);
		}else if(action.equals("/insert")) {
			novoDado(request,response);
		}else if(action.equals("/select")) {
			listardados(request,response);
		}else if(action.equals("/update")){
			editardados(request,response);
		}else if(action.equals("/delete")){
			deletedados(request,response);
		}else if(action.equals("/report")){
			relatorio(request,response);
		}else {
			response.sendRedirect("index.html");
		}
	}
	
	/**
	 * Dados.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void dados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarContatos();	
		
		request.setAttribute("contatos",lista);
		RequestDispatcher rd = request.getRequestDispatcher("dados.jsp");
		rd.forward(request,response);
	}
	

	/**
	 * Novo dado.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void novoDado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//System.out.println(request.getParameter("nome"));
			//System.out.println(request.getParameter("cpf"));
			contato.setNome(request.getParameter("nome"));
			contato.setProduto(request.getParameter("produto"));
			contato.setDia(request.getParameter("dia"));
			contato.setCpf(request.getParameter("cpf"));
			contato.setFone(request.getParameter("fone"));
			contato.setEmail(request.getParameter("email"));
			dao.InserirDados(contato);
			response.sendRedirect("main");
	}
	
	/**
	 * Listardados.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listardados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String idcon = request.getParameter("idcon");
			System.out.println(idcon);
			contato.setIdcon(idcon);
			//exutar metodo dao
			dao.selecionarContato(contato);
			//
			request.setAttribute("idcon", contato.getIdcon());
			request.setAttribute("nome", contato.getNome());
			request.setAttribute("produto", contato.getProd());
			request.setAttribute("dia", contato.getDia());
			request.setAttribute("cpf", contato.getCpf());
			request.setAttribute("fone", contato.getFone());
			request.setAttribute("email", contato.getEmail());
			RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
			rd.forward(request, response);
			
	}
	
	/**
	 * Editardados.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editardados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			contato.setNome(request.getParameter("idcon"));
			contato.setNome(request.getParameter("nome"));
			contato.setProduto(request.getParameter("produto"));
			contato.setDia(request.getParameter("dia"));
			contato.setCpf(request.getParameter("cpf"));
			contato.setFone(request.getParameter("fone"));
			contato.setEmail(request.getParameter("email"));
			System.out.println("pondo o dado recebido no banco de daods");
			dao.update(contato);
			response.sendRedirect("main");
			
	}

	/**
	 * Deletedados.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void deletedados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			contato.setIdcon(request.getParameter("idcon"));
			dao.deletedados(contato);
			response.sendRedirect("main");
	}
	
	/**
	 * Relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void relatorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Gerando Relatorio PDF!!");
			Document document = new Document();
			try {
				response.setContentType("apllication/pdf");
	
				response.addHeader("Content-Disposition","inline; filename="+"dados.pdf");
				
				//
				PdfWriter.getInstance(document,response.getOutputStream());
				document.open();
				document.add(new Paragraph("Lista de Dados:"));
				document.add(new Paragraph(" "));
				PdfPTable tabela = new PdfPTable(6);
				PdfPCell  col1 = new PdfPCell(new Paragraph("NOME"));
				PdfPCell col2 = new PdfPCell(new Paragraph("PRODUTO"));
				PdfPCell col3 = new PdfPCell(new Paragraph("DIA"));
				PdfPCell col4 = new PdfPCell(new Paragraph("CPF"));
				PdfPCell col5 = new PdfPCell(new Paragraph("FONE"));
				PdfPCell col6 = new PdfPCell(new Paragraph("E-MAIL"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				tabela.addCell(col6);
				ArrayList<JavaBeans> lista = dao.listarContatos();
				for(int i =0;i < lista.size();i++) {
					tabela.addCell(lista.get(i).getNome());
					tabela.addCell(lista.get(i).getProd());
					tabela.addCell(lista.get(i).getDia());
					tabela.addCell(lista.get(i).getCpf());
					tabela.addCell(lista.get(i).getFone());
					tabela.addCell(lista.get(i).getEmail());
				}
				document.add(tabela);
				document.close();
			}catch (Exception e) {
				System.out.println(e);
				document.close();
			}
	}
}
