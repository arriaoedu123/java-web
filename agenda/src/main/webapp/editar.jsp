<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
	<title>Agenda de Contatos</title>
</head>
<body class="form-body">
	<div class="form-container">
		<form name="formContato" action="update">
			<table>
				<tr>
					<td class="input-td">
						<label class="label" for="id">ID</label>
						<input class="input" type="text" id="id" name="idcon" placeholder="Ex:. 1" value="<% out.print(request.getAttribute("idcon")); %>" readonly disabled>
					</td>
				</tr>
				<tr>
					<td class="input-td">
						<label class="label" for="name">Nome <small>*</small></label>
						<input class="input" type="text" id="name" name="nome" placeholder="Ex:. Jobervaldo" value="<% out.print(request.getAttribute("nome")); %>" required>
					</td>
				</tr>
				<tr>
					<td class="input-td">
						<label class="label" for="phone">Telefone <small>*</small></label>
						<input class="input" type="tel" id="phone" name="fone" placeholder="Ex:. (11) 91234-1234" pattern="[(][0-9]{2}[)][\s][0-9]{5}-[0-9]{4}" onkeypress="formatarTel(event)" maxlength="15" value="<% out.print(request.getAttribute("fone")); %>" required>
					</td>
				</tr>
				<tr>
					<td class="input-td">
						<label class="label" for="eaddress">E-mail</label>
						<input class="input" type="email" id="eaddress" name="email" placeholder="Ex:. exemplo@email.com" value="<% out.print(request.getAttribute("email")); %>">
					</td>
				</tr>
				<tr>
					<td class="input-td">
						<label class="label" for="obs">Obs Path</label>
						<input class="input" type="text" id="obs" name="obsPath" placeholder="Ex:. obs path">
					</td>
				</tr>
				<tr>
					<td class="button-td">
						<input type="submit" value="Editar" class="btn add-button">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>