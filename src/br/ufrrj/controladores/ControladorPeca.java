package br.ufrrj.controladores;

import java.util.ArrayList;

import br.ufrrj.dominio.Peca;
import br.ufrrj.persistencia.PersistenciaPeca;

public class ControladorPeca {
	
	PersistenciaPeca persistenciaPeca = new PersistenciaPeca();
	ControladorEstoque controladorEstoque = new ControladorEstoque();
	
	public void cadastrarPeca(Peca p){
		persistenciaPeca.adicionarPeca(p.getCodigo(), p.getCategoria().getNome(), p.getDescricao(), p.getLocalizacao(), p.getValorCompra(), p.getValorVenda(),p.getFabricante().getId());
		controladorEstoque.adicionarPecaNoEstoque(p.getCodigo(),p.getQuantidadeEstoque());
	}
	
	public ArrayList<Peca> listarPecas(){
		return persistenciaPeca.listarPecas();
	}
}
