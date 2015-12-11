package br.ufrrj.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Pagamento {
	
	private TipoPagamento tipoPagamento;
	private double valorTotal;
	private ArrayList<Parcela> parcelas;
	
	

	public Pagamento(TipoPagamento tipoPagamento, double valorTotal,
			Integer nParcelas) {
		super();
		this.tipoPagamento = tipoPagamento;
		this.valorTotal = valorTotal;
		this.parcelas = new ArrayList<Parcela>();
		criarParcelas(nParcelas);
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public ArrayList<Parcela> getParcelas() {
		return parcelas;
	}
	
	public void criarParcelas(Integer nParcelas){
		double valorParcela = valorTotal/nParcelas;
		Calendar dataAtual = Calendar.getInstance();
		
		
		for(int i = 0; i<nParcelas; i++){
			Date dataVencimento = dataAtual.getTime();
			Parcela p = new Parcela(valorParcela, dataVencimento);
			parcelas.add(p);
			dataAtual.roll(Calendar.MONTH, 1);
		}
	}
	public Calendar pulaMes(Calendar dataAtual){
		dataAtual.roll(Calendar.MONTH, 1);
		return dataAtual;
	}
	
}
