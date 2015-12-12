package br.ufrrj.dominio;

import java.util.ArrayList;
import java.util.Date;

public class Servico {
	
	private Integer id;
	private Date data; 
	private ArrayList<Reparo> reparosRealizados;
	private ArrayList<Peca> pecasTrocadas;
	private double valorMaoDeObra;
	
	
	
	public Servico(Integer id, Date data, ArrayList<Reparo> reparosRealizados,
			ArrayList<Peca> pecasTrocadas, double valorMaoDeObra) {
		super();
		this.id = id;
		this.data = data;
		this.reparosRealizados = reparosRealizados;
		this.pecasTrocadas = pecasTrocadas;
		this.valorMaoDeObra = valorMaoDeObra;
	}
	
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
		double orcamento = 0;
		for(Reparo r : reparosRealizados){
			orcamento += (r.getValorMaoDeObra()*r.getTempoMedioDeExecucao());
		}
		for(Peca p : pecasTrocadas){
			orcamento += p.getValorVenda();
		}
		
		return orcamento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
