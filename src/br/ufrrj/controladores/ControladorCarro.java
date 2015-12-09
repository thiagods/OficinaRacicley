package br.ufrrj.controladores;

import java.util.ArrayList;

import br.ufrrj.dominio.Carro;
import br.ufrrj.persistencia.PersistenciaCarro;

public class ControladorCarro {
	
	PersistenciaCarro persistenciaCarro = new PersistenciaCarro();
	
	public void cadastrarCarro(String placa, String marca, String cor, int ano, String modelo, String cpfCliente){
		persistenciaCarro.cadastrarCarro(placa, marca, cor, ano, modelo, cpfCliente);
	}
	
	public Carro recuperarcCarro(String placa){
		return persistenciaCarro.recuperarCarro(placa);
	}
	
	public ArrayList<Carro> recuperarCarrosPorCliente(String cpfCliente){
		return persistenciaCarro.recuperarCarroPorCliente(cpfCliente);
	}
}
