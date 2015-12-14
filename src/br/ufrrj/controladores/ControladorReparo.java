package br.ufrrj.controladores;

import java.util.ArrayList;

import br.ufrrj.dominio.Reparo;
import br.ufrrj.persistencia.PersistenciaReparo;

public class ControladorReparo {
	
	PersistenciaReparo persistenciaReparo = new PersistenciaReparo();
	
	public boolean cadastrarReparo(Reparo r){
		if(persistenciaReparo.adicionarReparo(r.getDescricaoBreve(), r.getDescricaoDetalhada(), r.getTempoMedioDeExecucao(), r.getValorMaoDeObra()) == -1)
			return false;
		return true;
	}
	
	public ArrayList<Reparo> listarReparos(){
		return persistenciaReparo.listarReparos();
	}
	
	public ArrayList<Reparo> recuperarReparoPorServico(Integer idServico){
		return persistenciaReparo.recuperarReparosPorServico(idServico);
	}

}
