package br.ufrrj.dominio;

import java.util.Date;

public class Parcela {
	private Integer id;
	private double valor;
	private boolean paga;
	private Date dataVencimento;
	
	public Parcela(double valor, boolean paga,  Date dataVencimento) {
		super();
		this.valor = valor;
		this.paga = paga;
		this.dataVencimento = dataVencimento;
	}

	public double getValor() {
		return valor;
	}

	public boolean isPaga() {
		return paga;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}
	
	public void pagar(){
		this.paga = true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
