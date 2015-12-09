package br.ufrrj.dominio;

public class Reparo {
	
	private String descricaoBreve;
	private String descricaoDetalhada;
	private String tempoMedioDeExecucao;
	private Double valorMaoDeObra;	
	
	public Reparo(String descricaoBreve, String descricaoDetalhada, String tempoMedioDeExecucao,
			Double valorMaoDeObra) {
		super();
		this.descricaoBreve = descricaoBreve;
		this.descricaoDetalhada = descricaoDetalhada;
		this.tempoMedioDeExecucao = tempoMedioDeExecucao;
		this.valorMaoDeObra = valorMaoDeObra;
	}
	
	public String getDescricaoBreve() {
		return descricaoBreve;
	}
	public String getDescricaoDetalhada() {
		return descricaoDetalhada;
	}
	public String getTempoMedioDeExecucao() {
		return tempoMedioDeExecucao;
	}
	public Double getValorMaoDeObra() {
		return valorMaoDeObra;
	}
}
