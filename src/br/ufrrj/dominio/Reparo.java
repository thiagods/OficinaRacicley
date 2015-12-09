package br.ufrrj.dominio;

public class Reparo {
	
	private String descricaoBreve;
	private String descricaoDetalhada;
	private String tempoMedioDeExecucao;
	private Servico valorMaoDeObra;
	
	public String getDescricaoBreve() {
		return descricaoBreve;
	}
	public String getDescricaoDetalhada() {
		return descricaoDetalhada;
	}
	public String getTempoMedioDeExecucao() {
		return tempoMedioDeExecucao;
	}
	public Servico getValorMaoDeObra() {
		return valorMaoDeObra;
	}
}
