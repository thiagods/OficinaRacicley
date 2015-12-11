package br.ufrrj.dominio;

import java.util.ArrayList;
import java.util.Date;

public class Servico {
	
	private Integer id;
	private Date data; 
	private ArrayList<Reparo> reparosRealizados;
	private ArrayList<Peca> pecasTrocadas;
	private double valorMaoDeObra;
	private double orcamento;
	
	public Date getData() {
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
