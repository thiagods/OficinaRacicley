package br.ufrrj.controladores;

import java.util.ArrayList;
import java.util.Date;

import br.ufrrj.dominio.Peca;
import br.ufrrj.dominio.Reparo;
import br.ufrrj.dominio.Servico;
import br.ufrrj.persistencia.PersistenciaServico;

public class ControladorServico {
	
	PersistenciaServico persistenciaServico = new PersistenciaServico();
	ControladorPagamento controladorPagamento = new ControladorPagamento();
	ControladorReparo controladorReparo = new ControladorReparo();
	ControladorPeca controladorPeca = new ControladorPeca();
	
	public void realizarServico(Servico servico){
		Integer idPagamento;
		idPagamento = controladorPagamento.cadastrarPagamento(servico.getPagamento());
		persistenciaServico.adicionarServico(servico.getData(), servico.getReparosRealizados(), servico.getPecasTrocadas(), idPagamento);
	}
	
	public Servico recuperarServico(Integer idServico){
		Servico servico = persistenciaServico.recuperarServico(idServico);
		Servico servico2; 
		ArrayList<Reparo> reparos = controladorReparo.recuperarReparoPorServico(idServico);
		ArrayList<Peca> pecas = controladorPeca.recuperaPecaPorServico(idServico);
		servico2 = new Servico(servico.getId(), servico.getData(), reparos, pecas);
		servico2.setPagamento(servico.getPagamento());
		return servico2;
	}
	
}
