<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
	<title>Lojinha</title>
</head>
<body class="body add-body">
	<div class="container add-container">
		<h1 class="add-title">Lojinha</h1>
		<a href="novo.html" class="btn new-button">Novo produto</a>
		
		<table class="tabela">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Quantidade</th>
					<th>Valor</th>
					<th>Vencimento</th>
					<th>Marca</th>
					<th>Categoria</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<% for (int i = 0; i < lista.size(); i++) { %>
					<tr>	
						<td><%=lista.get(i).getIdpro() %> </td>
						<td><%=lista.get(i).getNome() %> </td>
						<td><%=lista.get(i).getQuantidade() %> </td>
						<td><%=lista.get(i).getValor() %> </td>
						<td><%=lista.get(i).getVencimento() %> </td>
						<td><%=lista.get(i).getMarca() %> </td>
						<td><%=lista.get(i).getCategoria() %> </td>
						<td>
							<a href="select?idpro=<%=lista.get(i).getIdpro()%>" class="edit-button">Editar</a>
							<a href="javascript: confirmar(<%=lista.get(i).getIdpro()%>)" class="delete-button">Deletar</a>
						</td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	
	<script src="scripts/script.js"></script>
</body>
</html>