/**
 * 
 */

const formatarValor = (e) => {
	if (e.target.value.length == 0) {
		e.target.value += "R$"
	}
}

const confirmar = (idpro) => {
	let resposta = confirm("Deseja deletar?");

	if (resposta === true) {
		window.location.href = `delete?idpro=${idpro}`;
	}
}