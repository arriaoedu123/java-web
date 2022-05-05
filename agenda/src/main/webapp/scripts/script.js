/**
 * 
 */

const confirmar = (idcon) => {
	let resposta = confirm("Deseja deletar?");

	if (resposta === true) {
		window.location.href = `delete?idcon=${idcon}`;
	}
}