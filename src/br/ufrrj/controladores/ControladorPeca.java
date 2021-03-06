package br.ufrrj.controladores;

import java.util.ArrayList;

import br.ufrrj.dominio.Peca;
import br.ufrrj.persistencia.PersistenciaPeca;

public class ControladorPeca {
	
	PersistenciaPeca persistenciaPeca = new PersistenciaPeca();
	ControladorEstoque controladorEstoque = new ControladorEstoque();
	
	public boolean cadastrarPeca(Peca p){
		boolean retorno;
		retorno = persistenciaPeca.adicionarPeca(p.getCodigo(), p.getCategoria().name(), p.getDescricao(), p.getLocalizacao(), p.getValorCompra(), p.getValorVenda(),p.getFabricante().getId());
		controladorEstoque.adicionarPecaNoEstoque(p.getCodigo(),p.getQuantidadeEstoque());
		return retorno;
	}
	
	public ArrayList<Peca> listarPecas(){
		return persistenciaPeca.listarPecas();
	}

	public ArrayList<Peca> recuperaPecaPorServico(Integer idServico) {
		return persistenciaPeca.recuperarPecasPorServico(idServico);
	}
}
