package br.ufrrj.controladores;

import java.util.ArrayList;

import br.ufrrj.dominio.Parcela;
import br.ufrrj.persistencia.PersistenciaParcela;

public class ControladorParcela {
	
	PersistenciaParcela persistenciaParcela = new PersistenciaParcela();
	
	public void adicionarParcelas(ArrayList<Parcela> parcelas, Integer idPagamento){
		persistenciaParcela.adicionarParcelas(parcelas, idPagamento);
	}
}
