package model;

public class JavaBeans {
	private String idpro;
	private String nome;
	private String quantidade;
	private String valor;
	private String vencimento;
	private String marca;
	private String categoria;

	public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public JavaBeans(String idpro, String nome, String quantidade, String valor, String vencimento, String marca,
			String categoria) {
		super();
		this.idpro = idpro;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.vencimento = vencimento;
		this.marca = marca;
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public JavaBeans() {
		super();
	}

	public String getIdpro() {
		return idpro;
	}

	public void setIdpro(String idpro) {
		this.idpro = idpro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
