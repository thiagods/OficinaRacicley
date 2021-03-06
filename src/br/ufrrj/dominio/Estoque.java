package br.ufrrj.dominio;

import java.util.ArrayList;

import br.ufrrj.controladores.ControladorEstoque;

public class Estoque {
	
	private static Estoque estoque;
	
	private ArrayList<Peca> pecasNoEstoque;

	private Estoque() {
	}

	public Estoque(Estoque estoque, ArrayList<Peca> pecasNoEstoque) {
		super();
		this.pecasNoEstoque = pecasNoEstoque;
	}

	public ArrayList<Peca> getPecasNoEstoque() {
		return pecasNoEstoque;
	}
	
	public static synchronized Estoque getEstoque(){
		if(estoque == null){
			ControladorEstoque controladorEstoque = new ControladorEstoque();
			estoque = controladorEstoque.recuperarEstoque(new Estoque());
		}
		return estoque;
	}
	public void setPecasNoEstoque(ArrayList<Peca> pecas){
		this.pecasNoEstoque = pecas;
	}
	
	public Peca recuperarPeca(Peca peca){
		for(Peca p :pecasNoEstoque){
			if(peca.getCodigo().equals(p.getCodigo()))
				return p;
		}
		
		return null;
	}
	
	public Peca recuperarPecaPorCodigo(String codigo){
		for(Peca p :pecasNoEstoque){
			if(p.getCodigo().equals(codigo))
				return p;
		}
		
		return null;
	}
}
