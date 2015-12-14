package br.ufrrj.controladores;

import java.util.ArrayList;

import br.ufrrj.dominio.Estoque;
import br.ufrrj.dominio.Peca;
import br.ufrrj.dominio.Reparo;
import br.ufrrj.dominio.Servico;
import br.ufrrj.persistencia.PersistenciaServico;

public class ControladorServico {
	
	PersistenciaServico persistenciaServico = new PersistenciaServico();
	ControladorPagamento controladorPagamento = new ControladorPagamento();
	ControladorReparo controladorReparo = new ControladorReparo();
	ControladorPeca controladorPeca = new ControladorPeca();
	ControladorEstoque controladorEstoque = new ControladorEstoque();
	
	public void realizarServico(Servico servico, String cpfCliente){
		Integer idPagamento;
		idPagamento = controladorPagamento.cadastrarPagamento(servico.getPagamento());
		persistenciaServico.adicionarServico(servico.getData(), servico.getReparosRealizados(), servico.getPecasTrocadas(), idPagamento,cpfCliente);
		Estoque estoque = Estoque.getEstoque();
		controladorEstoque.utilizarPecas(estoque,servico.getPecasTrocadas());
		
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
	
	public ArrayList<Servico> recuperarServicosPorCliente(String cpf){
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		servicos = persistenciaServico.recuperarServicosPorCliente(cpf);
		ArrayList<Servico> servicos2 = new ArrayList<Servico>();
		Servico servico;
		
		for(Servico s : servicos){
			ArrayList<Reparo> reparos = controladorReparo.recuperarReparoPorServico(s.getId());
			ArrayList<Peca> pecas = controladorPeca.recuperaPecaPorServico(s.getId());
			servico = new Servico(s.getId(), s.getData(), reparos, pecas);
			servico.setPagamento(s.getPagamento());
			servicos2.add(servico);
		}
		
		
		return servicos2;
	}
	
}
