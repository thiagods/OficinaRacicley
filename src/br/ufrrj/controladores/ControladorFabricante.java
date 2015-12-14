package br.ufrrj.controladores;

import java.util.ArrayList;

import br.ufrrj.dominio.Fabricante;
import br.ufrrj.persistencia.PersistenciaFabricante;

public class ControladorFabricante {
	
	PersistenciaFabricante persistenciaFabricante = new PersistenciaFabricante();
	
	public boolean cadastrarFabricante(String nome, String telefone){
		return persistenciaFabricante.adicionar(nome, telefone);
	}
	
	public Fabricante recuperarFabricante(Integer idFabricante ){
		Fabricante f = persistenciaFabricante.recuperarFabricante(idFabricante);
		return f;
	}
	
	public ArrayList<Fabricante> listarFabricantes(){
		return persistenciaFabricante.listarFabricantes();
	}
}
