package br.ufrrj.dominio;

public class Fabricante {
	
	private Integer id;
	private String nome;
	private String telefone;
	
	
	
	public Fabricante(Integer id, String nome, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public Integer getId() {
		return id;
	}
	
}
