package br.ufrrj.dominio;

public class Peca {
	
	private String codigo;
	private CategoriaPeca categoria;
	private String descricao;
	private String localizacao;
	private int quantidadeEstoque;
	private double valorCompra;
	private double valorVenda;
	private Fabricante fabricante;
	
	public Peca(String codigo, CategoriaPeca categoria, String descricao,
			String localizacao, int quantidadeEstoque, double valorCompra,
			double valorVenda, Fabricante fabricante) {
		super();
		this.codigo = codigo;
		this.categoria = categoria;
		this.descricao = descricao;
		this.localizacao = localizacao;
		this.quantidadeEstoque = quantidadeEstoque;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.fabricante = fabricante;
	}
	public String getCodigo() {
		return codigo;
	}
	public CategoriaPeca getCategoria() {
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
	public double getValorCompra() {
		return valorCompra;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public Integer utilizar(){
		this.quantidadeEstoque -= 1;
		return this.quantidadeEstoque;
	}
	
	public Integer comprar(Integer qtd){
		this.quantidadeEstoque += qtd;
		return this.quantidadeEstoque;
	}
	
}
