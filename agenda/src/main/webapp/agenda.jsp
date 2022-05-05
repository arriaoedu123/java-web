<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<title>Lojinha</title>
</head>
<body class="body add-body">
	<div class="container add-container">
		<h1 class="home-title">Lojinha</h1>
		<a href="novo.html" class="btn new-button">Novo produto</a>

		<table class="tabela">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Fone</th>
					<th>Email</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<% for (int i = 0; i < lista.size(); i++) { %>
					<tr>	
						<td><%=lista.get(i).getIdcon() %> </td>
						<td><%=lista.get(i).getNome() %> </td>
						<td><%=lista.get(i).getFone() %> </td>
						<td><%=lista.get(i).getEmail() %> </td>
						<td>
							<a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="edit-button">Editar</a>
							<a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)" class="delete-button">Deletar</a>
						</td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	
	<script src="scripts/script.js"></script>
</body>
</html>