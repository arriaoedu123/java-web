/**
 * 
 */
 
 const formatarValor = (e) => {
	if (e.target.value.length == 0) {
		e.target.value += "R$"
	}
}