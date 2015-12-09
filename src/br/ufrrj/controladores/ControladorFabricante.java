package br.ufrrj.controladores;

import java.util.ArrayList;

import br.ufrrj.dominio.Fabricante;
import br.ufrrj.persistencia.PersistenciaFabricante;

public class ControladorFabricante {
	
	PersistenciaFabricante persistenciaFabricante = new PersistenciaFabricante();
	
	public void cadastrarFabricante(String nome, String telefone){
		persistenciaFabricante.adicionar(nome, telefone);
	}
	
	public Fabricante recuperarFabricante(Integer idFabricante ){
		Fabricante f = persistenciaFabricante.recuperarFabricante(idFabricante);
		return f;
	}
	
	public ArrayList<Fabricante> listarFabricantes(){
		return persistenciaFabricante.listarFabricantes();
	}
}
