package br.ufrrj.dominio;

public enum TipoPagamento {
	
	CREDITO("credito",1), DEBITO("debito",2), CHEQUE("cheque",3), DINHEIRO("dinheiro",4);
	
	private String tipo;
	private Integer codigo;
	
	TipoPagamento(String tipo, Integer codigo) {
		this.tipo = tipo;
		this.codigo = codigo;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	
	public Integer getCodigo() {
		return codigo;
	}

	public static TipoPagamento find(Integer codigo){
		for(TipoPagamento tipo : TipoPagamento.values()){
			if(codigo == tipo.codigo)
				return tipo;
		}
		return null;
	}
	
//	public static TipoPagamento findPorTipo(String nomeTipo){
//		for(TipoPagamento tipo : TipoPagamento.values()){
//			if(nomeTipo == tipo.tipo)
//				return tipo;
//		}
//		return null;
//	}
}
