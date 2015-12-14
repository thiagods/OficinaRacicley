package br.ufrrj.controladores;

import br.ufrrj.dominio.Pagamento;
import br.ufrrj.dominio.Parcela;
import br.ufrrj.dominio.Servico;
import br.ufrrj.persistencia.PersistenciaPagamento;

public class ControladorPagamento {
	
	PersistenciaPagamento persistenciaPagamento = new PersistenciaPagamento();
	ControladorParcela controladorParcela = new ControladorParcela();
	
	public Integer cadastrarPagamento(Pagamento p){
		Integer idPagamento;
		idPagamento = persistenciaPagamento.adicionarPagamento(p.getTipoPagamento().name(), p.getValorTotal());
		controladorParcela.adicionarParcelas(p.getParcelas(), idPagamento);
		return idPagamento;
	}
	
	public Pagamento recuperarPagamento(Integer idPagamento){
		return persistenciaPagamento.recuperarPagamento(idPagamento);
	}

	public void pagarParcelas(Servico servico, Integer nParcelas) {
		for(Parcela p : servico.getPagamento().getParcelasNaoPagas()){
			if(nParcelas > 0){
				controladorParcela.pagarParcela(p);
				nParcelas--;
			}
		}
	}
	
}
