package br.ufrrj.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Pagamento {
	private Integer id;
	private TipoPagamento tipoPagamento;
	private double valorTotal;
	private ArrayList<Parcela> parcelas;

	public Pagamento(TipoPagamento tipoPagamento, double valorTotal,
			Integer nParcelas) {
		super();
		this.tipoPagamento = tipoPagamento;
		this.valorTotal = valorTotal;
		this.parcelas = new ArrayList<Parcela>();
		if(nParcelas != null)
			criarParcelas(nParcelas);
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Parcela> getParcelas() {
		return parcelas;
	}
	
	public boolean pago(){
		for(Parcela p : parcelas){
			if(!p.isPaga())
				return false;
		}
		return true;
	}
	
	public void pagar(){
		ArrayList<Parcela> parcelasPagas = new ArrayList<Parcela>();
		for(Parcela p : parcelas){
			p.pagar();
			parcelasPagas.add(p);
		}
	}
	
	
	
	public void criarParcelas(Integer nParcelas){
		double valorParcela = valorTotal/nParcelas;
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.roll(Calendar.MONTH, 1);
		
		for(int i = 0; i<nParcelas; i++){
			Date dataVencimento = dataAtual.getTime();
			Parcela p = new Parcela(valorParcela,false, dataVencimento);
			parcelas.add(p);
			dataAtual.roll(Calendar.MONTH, 1);
		}
	}

	public void setParcelas(ArrayList<Parcela> parcelas) {
		this.parcelas = parcelas;
	}
	
	
	
}
