package br.ufrrj.controladores;

import java.util.ArrayList;
import java.util.Date;

import br.ufrrj.dominio.Peca;
import br.ufrrj.dominio.Reparo;
import br.ufrrj.persistencia.PersistenciaServico;

public class ControladorServico {
	
	PersistenciaServico persistenciaServico = new PersistenciaServico();
	
	public void cadastrarServico(Date data, ArrayList<Reparo> reparosRealizados, ArrayList<Peca> pecasTrocadas, double valorMaoDeObra, double orcamento){
		persistenciaServico.adicionarServico(data, reparosRealizados, pecasTrocadas, valorMaoDeObra, orcamento);
	}
	
}
