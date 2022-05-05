<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<title>Lojinha - Editar</title>
</head>
<body class="form-body">
	<div class="form-container">
		<form name="formContato" action="update">
			<table>
				<tr>
					<td class="input-td"><label class="label" for="id">ID
					</label> <input class="input" type="text" id="id" name="idpro"
						placeholder="Ex:. Leite Condensado"
						value="<%out.print(request.getAttribute("idpro"));%>" readonly></td>
				</tr>
				<tr>
					<td class="input-td"><label class="label" for="name">Nome
							<small>*</small>
					</label> <input class="input" type="text" id="name" name="nome"
						placeholder="Ex:. Leite Condensado"
						value="<%out.print(request.getAttribute("nome"));%>" required></td>
				</tr>
				<tr>
					<td class="input-td"><label class="label" for="quant">Quantidade
							<small>*</small>
					</label> <input class="input number-input" type="number" id="quant"
						name="quantidade" placeholder="Ex:. 10"
						value="<%out.print(request.getAttribute("quantidade"));%>"
						required></td>
				</tr>
				<tr>
					<td class="input-td"><label class="label" for="value">Valor
							<small>*</small>
					</label> <input class="input" type="text" id="value" name="valor"
						placeholder="Ex:. R$5,99" onkeypress="formatarValor(event)"
						value="<%out.print(request.getAttribute("valor"));%>" required></td>
				</tr>
				<tr>
					<td class="input-td"><label class="label" for="expiration">Vencimento
							<small>*</small>
					</label> <input class="input date-input" type="date" id="expiration"
						name="vencimento"
						value="<%out.print(request.getAttribute("vencimento"));%>"
						required></td>
				</tr>
				<tr>
					<td class="input-td"><label class="label" for="brand">Marca
							<small>*</small>
					</label> <input class="input" type="text" id="brand" name="marca"
						placeholder="Ex:. Nestle"
						value="<%out.print(request.getAttribute("marca"));%>" required></td>
				</tr>
				<tr>
					<td class="input-td"><label class="label" for="category">Categoria
							<small>*</small>
					</label> <input class="input" type="text" id="category" name="categoria"
						placeholder="Ex:. Doce"
						value="<%out.print(request.getAttribute("categoria"));%>" required></td>
				</tr>
				<tr>
					<td class="button-td"><input type="submit" value="Editar"
						class="btn add-button"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>