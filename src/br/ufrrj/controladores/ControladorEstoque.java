package br.ufrrj.controladores;

import br.ufrrj.dominio.Estoque;
import br.ufrrj.persistencia.PersistenciaEstoque;

public class ControladorEstoque {
	
	PersistenciaEstoque persistenciaEstoque = new PersistenciaEstoque();
	
	public Estoque recuperarEstoque(){
		return persistenciaEstoque.recuperaEstoque();
	}
	
}
