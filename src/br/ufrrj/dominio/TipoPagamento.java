package br.ufrrj.dominio;

public enum TipoPagamento {
	
	CREDITO("credito"), DEBITO("debito"), CHEQUE("cheque"), DINHEIRO("dinheiro");
	
	private String tipo;
	
	TipoPagamento(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return tipo;
	}
}
