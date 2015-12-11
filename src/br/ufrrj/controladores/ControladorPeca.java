package br.ufrrj.controladores;

import br.ufrrj.dominio.Endereco;
import br.ufrrj.dominio.Fornecedor;
import br.ufrrj.dominio.Peca;
import br.ufrrj.persistencia.PersistenciaPeca;

public class ControladorPeca {
	
	PersistenciaPeca persistenciaPeca = new PersistenciaPeca();
	ControladorEstoque controladorEstoque = new ControladorEstoque();
	
	public void cadastrarPeca(Peca p){
		persistenciaPeca.adicionarPeca(p.getCodigo(), p.getCategoria().getNome(), p.getDescricao(), p.getLocalizacao(), p.getQuantidadeEstoque(), p.getValorCompra(), p.getValorVenda());
		controladorEstoque.adicionarPecaNoEstoque(p.getCodigo(),p.getQuantidadeEstoque());
	}
}
