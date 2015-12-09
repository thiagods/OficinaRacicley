package br.ufrrj.dominio;

public class Carro {
	
	private String placa;
	private String marca;
	private String cor;
	private int ano;
	private String modelo;
	
	
	
	public Carro(String placa, String marca, String cor, int ano, String modelo) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.cor = cor;
		this.ano = ano;
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public String getMarca() {
		return marca;
	}
	public String getCor() {
		return cor;
	}
	public int getAno() {
		return ano;
	}
	public String getModelo() {
		return modelo;
	}	
}
