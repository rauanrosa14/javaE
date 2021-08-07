<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="icon" href="imagens/doctor.png">
<link rel="stylesheet" href="estilo.css">
</head>
<body>
	<h1>EDITAR DADO</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td>
					<input id="Caixa3" type="text" name="idcon" readonly value="<% out.println(request.getAttribute("idcon"));%>">
				</td>
			</tr>
			<tr>
				<td>
					<input class="Caixa1"  type="text" name="nome"	value="<% out.println(request.getAttribute("nome")); %>">	
				</td>	
			</tr>
			<tr>
				<td>
					<input class="Caixa1"  type="text" name="produto"	value="<% out.println(request.getAttribute("produto"));%>">	
				</td>	
			</tr>
			<tr>
				<td>
					<input class="Caixa2" type="text" name="cpf"	value="<%out.println(request.getAttribute("cpf"));%>">	
				</td>	
			</tr>
			<tr>
				<td>
					<input class="Caixa1" type="text" name="dia"	value="<%out.println(request.getAttribute("dia"));%>">	
				</td>	
			</tr>
			<tr>
				<td>
					<input class="Caixa2" type="text" name="fone"	value="<%out.println(request.getAttribute("fone")); %>">	
				</td>	
			</tr>
			<tr>
				<td>
					<input class="Caixa1" type="text" name="email"	value="<%out.println(request.getAttribute("email"));%>">	
				</td>	
			</tr>
		</table>
		<input class="Botao1" type="button" value="Alterar" onclick="validar()" >
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>