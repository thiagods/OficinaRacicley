package br.ufrrj.dominio;

import java.util.ArrayList;

import br.ufrrj.controladores.ControladorEstoque;

public class Estoque {
	private ControladorEstoque controladorEstoque = new ControladorEstoque();
	private Estoque estoque = controladorEstoque.recuperarEstoque();
	
	private ArrayList<Peca> pecasNoEstoque;
	
	

	public Estoque() {
		if(estoque == null)
			estoque = new Estoque();
	}

	public Estoque(Estoque estoque, ArrayList<Peca> pecasNoEstoque) {
		super();
		this.pecasNoEstoque = pecasNoEstoque;
	}

	public ArrayList<Peca> getPecasNoEstoque() {
		return pecasNoEstoque;
	}
	
	public Estoque getEstoque(){
		return estoque;
	}
	public void setPecasNoEstoque(ArrayList<Peca> pecas){
		this.pecasNoEstoque = pecas;
	}
}
