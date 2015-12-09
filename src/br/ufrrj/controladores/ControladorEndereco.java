package br.ufrrj.controladores;

import br.ufrrj.dominio.Endereco;
import br.ufrrj.persistencia.PersistenciaEndereco;

public class ControladorEndereco {
	PersistenciaEndereco persistenciaEndereco = new PersistenciaEndereco();
	
	public Integer cadastrarEndereco(Integer numero, String logradouro, String complemento, String bairro, String cidade, String uf, String cep){
		return persistenciaEndereco.adicionarEndereco(numero, logradouro, complemento, bairro, cidade, uf, cep);
	}
	
	public Endereco recuperarEndereco(Integer id){
		return persistenciaEndereco.recuperarEndereco(id);
	}
}
