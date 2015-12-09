package br.ufrrj.dominio;

import java.util.ArrayList;

public class Cliente {
	
	private String cpf;
	private String nome;
	private ArrayList<Carro> carros;
	private String telefone;
	private Endereco endereco;
	
	
	
	public Cliente(String cpf, String nome, ArrayList<Carro> carros,
			String telefone, Endereco endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.carros = carros;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public ArrayList<Carro> getCarros() {
		return carros;
	}
	public String getTelefone() {
		return telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}	
}
