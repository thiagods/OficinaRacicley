package br.ufrrj.dominio;

public class Fornecedor {
	
	private Integer id;
	private String telefone;
	private String nomeVendedor;
	private Endereco endereco;
	
	public String getTelefone() {
		return telefone;
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public Integer getId() {
		return id;
	}
	public Fornecedor(Integer id, String telefone, String nomeVendedor,
			Endereco endereco) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.nomeVendedor = nomeVendedor;
		this.endereco = endereco;
	}
	
}
