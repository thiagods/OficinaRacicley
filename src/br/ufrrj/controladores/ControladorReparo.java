package br.ufrrj.controladores;

import br.ufrrj.dominio.Reparo;
import br.ufrrj.persistencia.PersistenciaReparo;

public class ControladorReparo {
	
	PersistenciaReparo persistenciaReparo = new PersistenciaReparo();
	
	public void cadastrarReparo(Reparo r){
		
		persistenciaReparo.adicionarReparo(r.getDescricaoBreve(), r.getDescricaoDetalhada(), r.getTempoMedioDeExecucao(), r.getValorMaoDeObra());
		
	}

}
