package br.ufrrj.controladores;

import java.util.ArrayList;
import java.util.Date;

import br.ufrrj.dominio.Peca;
import br.ufrrj.dominio.Reparo;
import br.ufrrj.persistencia.PersistenciaServico;

public class ControladorServico {
	
	PersistenciaServico persistenciaServico = new PersistenciaServico();
	
	public void realizarServico(Date data, ArrayList<Reparo> reparosRealizados, ArrayList<Peca> pecasTrocadas){
		//Aqui vai entrar mais coisa? Tipo, aqui ta so cadastrando, ne?
		//O orcamento nao ta confirmado ainda nao, ne?
		persistenciaServico.adicionarServico(data, reparosRealizados, pecasTrocadas);
	}
	
}
