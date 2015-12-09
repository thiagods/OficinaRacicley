package br.ufrrj.dominio;

public class Peca {
	
	private String codigo;
	private String categoria;
	private String descricao;
	private String localizacao;
	private int quantidadeEstoque;
	private int valorCompra;
	private int valorVenda;
	
	public String getCodigo() {
		return codigo;
	}
	public String getCategoria() {
		return categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public int getValorCompra() {
		return valorCompra;
	}
	public int getValorVenda() {
		return valorVenda;
	}
}
