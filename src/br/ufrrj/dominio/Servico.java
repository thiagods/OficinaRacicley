package br.ufrrj.dominio;

import java.util.ArrayList;

public class Servico {
	
	private String data; 
	private ArrayList<Reparo> reparosRealizados;
	private ArrayList<Peca> pecasTrocadas;
	private double valorMaoDeObra;
	private double orcamento;
	
	public String getData() {
		return data;
	}
	public ArrayList<Reparo> getReparosRealizados() {
		return reparosRealizados;
	}
	public ArrayList<Peca> getPecasTrocadas() {
		return pecasTrocadas;
	}
	public double getValorMaoDeObra() {
		return valorMaoDeObra;
	}
	public double getOrcamento() {
		return orcamento;
	}
}
