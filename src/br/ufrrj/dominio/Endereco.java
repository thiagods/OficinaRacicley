package br.ufrrj.dominio;

public class Endereco {
	
	private Integer id;
	private Integer numero;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	
	
	public Endereco(int id, int numero, String logradouro, String complemento,
			String bairro, String cidade, String uf, String cep) {
		super();
		this.id = id;
		this.numero = numero;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}
	public Integer getNumero() {
		return numero;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public String getUf() {
		return uf;
	}
	public String getCep() {
		return cep;
	}
	public Integer getId() {
		return id;
	}
	
}
