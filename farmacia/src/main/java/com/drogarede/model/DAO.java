package com.drogarede.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
    
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/farmacia?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "12345678";
	
	/**
	 * Connectar.
	 *
	 * @return the connection
	 */
	private Connection connectar() {
		Connection con  = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}   
	
	/**
	 * Inserir dados.
	 *
	 * @param contato the contato
	 */
	public void InserirDados(JavaBeans contato) {
		String create = "Insert into dados (nome,produto,dia,cpf,fone,email) values (?,?,?,?,?,?)";
		try {
			Connection con = connectar();
			//prepaar o querry para execuao do banco de dados
			PreparedStatement pst  = con.prepareStatement(create);
			
			pst.setString(1,contato.getNome());
			pst.setString(2,contato.getProd());
			pst.setString(3,contato.getDia());
			pst.setString(4,contato.getCpf());
			pst.setString(5,contato.getFone());
			pst.setString(6,contato.getEmail());
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos(){
		//criandoobjeto para acessar o javaBeans
			ArrayList<JavaBeans> contatos = new ArrayList<>();
			String read = "select * from dados order by nome";
			try {
				Connection con = connectar();
				PreparedStatement pst = con.prepareStatement(read);
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					String idCon = rs.getString(1);
					String nome = rs.getString(2);
					String produto = rs.getString(3);
					String dia = rs.getString(4);
					String cpf = rs.getString(5);
					String fone = rs.getString(6);
					String email = rs.getString(7);
					contatos.add(new JavaBeans(idCon,nome,produto,dia,cpf,fone,email));
					
				}
				con.close();
				return contatos;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
	}
	
	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from dados where idcon = ?";
		try {
			Connection con = connectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1,contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setProduto(rs.getString(3));
				contato.setDia(rs.getString(4));
				contato.setCpf(rs.getString(5));
				contato.setFone(rs.getString(6));
				contato.setEmail(rs.getString(7));
			}
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	/**
	 * Update.
	 *
	 * @param contato the contato
	 */
	public void update(JavaBeans contato) {
		String create = "update dados set nome=?, produto=? , dia=? ,cpf=? ,fone=? ,email=? where idcon=?";
		try {
			Connection con = connectar();
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1,contato.getNome());
			pst.setString(2,contato.getProd());
			pst.setString(3,contato.getDia());
			pst.setString(4,contato.getCpf());
			pst.setString(5,contato.getFone());
			pst.setString(6,contato.getEmail());
			pst.setString(7,contato.getIdcon());
			
			pst.executeUpdate();
			con.close();
		}catch (Exception e) {
			System.out.println(e);

		}
	}
	
	/**
	 * Deletedados.
	 *
	 * @param contato the contato
	 */
	public void deletedados(JavaBeans contato) {
		String del = "delete from dados where idcon=?";
		try {
			Connection con = connectar();
			PreparedStatement pst = con.prepareStatement(del);
			pst.setString(1,contato.getIdcon());
			
			pst.executeUpdate();
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * Teste conexao.
	 */
	public void testeConexao(){
		try {
			Connection con = connectar();
			System.out.println(con);
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}

