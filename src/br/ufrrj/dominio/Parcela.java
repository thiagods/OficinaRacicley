package br.ufrrj.dominio;

import java.util.Date;

public class Parcela {
	private double valor;
	private boolean paga;
	private Date dataVencimento;
	
	public Parcela(double valor, Date dataVencimento) {
		super();
		this.valor = valor;
		this.paga = false;
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
	
	
}
