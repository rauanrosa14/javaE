<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
    <%@ page import="com.drogarede.model.JavaBeans"%>
   	<%@ page import="java.util.ArrayList" %>
   	<% 
   		@ SuppressWarnings ("unchecked")
    	ArrayList<JavaBeans> lista  = (ArrayList<JavaBeans>) request.getAttribute("contatos");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> DADOS </title>
<link rel="stylesheet" href="estilo.css">
<link rel="icon" href="doctor_black.png" >
</head>
<body>
	<h2> Tabela de Dados</h2>
	<a class="Botao1" href="form.html"> ADICIONAR NOVOS DADOS</a>
	<a class="Botao3" href="report">RELÁTORIO</a>
	<a class="Botao1" href="index.html">VOLTAR </a>
	<table id="tabela1">
		<thead>
			<tr>
			<th> ID </th>
			<th> NOME </th>
			<th> PRODUTO </th>
			<th> DIA </th>
			<th> CPF </th>
			<th> FOME	</th>
			<th> E-mail </th>
			<th> Opções </th>
			</tr>
		</thead>
		<tbody>
			<%for(int i =0;i<lista.size();i++){%>
			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getProd()%></td>
				<td><%=lista.get(i).getDia() %></td>
				<td><%=lista.get(i).getCpf()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td ><a  href="select?idcon=<%=lista.get(i).getIdcon()%>" class="Botao2">EDITAR </a></td>
				<td ><a  href="javascript: excluir(<%=lista.get(i).getIdcon()%>)" class="Botao3" >EXCLUIR </a></td>
			</tr>
			<%}%>
		</tbody>
		<script src="scripts/excluir.js"></script>
	</table>
</body>
</html>