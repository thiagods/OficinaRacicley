package br.ufrrj.controladores;

import java.util.ArrayList;

import br.ufrrj.dominio.Estoque;
import br.ufrrj.dominio.Peca;
import br.ufrrj.persistencia.PersistenciaEstoque;

public class ControladorEstoque {
	
	PersistenciaEstoque persistenciaEstoque = new PersistenciaEstoque();
	
	public Estoque recuperarEstoque(Estoque estoque){
		return persistenciaEstoque.recuperaEstoque(estoque);
	}

	public void adicionarPecaNoEstoque(String codigo, Integer qtd) {
		persistenciaEstoque.adicionarPecaNoEstoque(codigo, qtd);
	}

	public void utilizarPecas(Estoque estoque,ArrayList<Peca> pecasTrocadas) {
		persistenciaEstoque.utilizarPecas(estoque,pecasTrocadas);
	}

	public void comprarPeca(Peca p, Integer qtd, Estoque e) {
		persistenciaEstoque.comprarPeca(p,qtd,e);	
	}
	
	
	
}
