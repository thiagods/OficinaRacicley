package br.ufrrj.controladores;

import java.util.ArrayList;

import br.ufrrj.dominio.Endereco;
import br.ufrrj.dominio.Fornecedor;
import br.ufrrj.persistencia.PersistenciaEndereco;
import br.ufrrj.persistencia.PersistenciaFornecedor;

public class ControladorFornecedor {
	PersistenciaFornecedor persistenciaFornecedor = new PersistenciaFornecedor();
	PersistenciaEndereco persistenciaEndereco = new PersistenciaEndereco();
	public void cadastrarFornecedor(Fornecedor f){
		Endereco end = f.getEndereco();
		Integer idEndereco;
		//O metodo adicionarEndereco retorna o id gerado automaticamente
		idEndereco = persistenciaEndereco.adicionarEndereco(end.getNumero(), end.getLogradouro(), end.getComplemento(), end.getBairro(), end.getCidade(), end.getUf(), end.getCep());
		persistenciaFornecedor.adicionarFornecedor(f.getTelefone(), f.getNomeVendedor(), idEndereco);
	}
	
	public ArrayList<Fornecedor> listarFornecedor(){
		
		return persistenciaFornecedor.listarFornecedores();
	}
	
}
