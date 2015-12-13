package br.ufrrj.dominio;

import java.util.ArrayList;
import java.util.Date;

public class Servico {
	
	private Integer id;
	private Date data; 
	private ArrayList<Reparo> reparosRealizados;
	private ArrayList<Peca> pecasTrocadas;
	private Pagamento pagamento;
	
	public Servico(Integer id, Date data, ArrayList<Reparo> reparosRealizados,
			ArrayList<Peca> pecasTrocadas) {
		super();
		this.id = id;
		this.data = data;
		this.reparosRealizados = reparosRealizados;
		this.pecasTrocadas = pecasTrocadas;
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
	
	public double getValorMaoDeObra(){
		double maoDeObra = 0;
		
		for(Reparo r : reparosRealizados){
			maoDeObra += (r.getValorMaoDeObra()*r.getTempoMedioDeExecucao());
		}
		return maoDeObra;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Pagamento getPagamento(){
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
}
