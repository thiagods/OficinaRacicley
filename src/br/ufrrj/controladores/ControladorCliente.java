package br.ufrrj.controladores;

import br.ufrrj.dominio.Carro;
import br.ufrrj.dominio.Cliente;
import br.ufrrj.dominio.Endereco;
import br.ufrrj.persistencia.PersistenciaCliente;

public class ControladorCliente {
	
	PersistenciaCliente persistenciaCliente = new PersistenciaCliente();
	ControladorCarro controladorCarro = new ControladorCarro();
	ControladorEndereco controladorEndereco = new ControladorEndereco();
	ControladorServico controladorServico = new ControladorServico();
	
	public void cadastrarCliente(Cliente cliente, Carro carro, Endereco endereco){
		Integer idEndereco;
		idEndereco = controladorEndereco.cadastrarEndereco(endereco.getNumero(), endereco.getLogradouro(), endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(), endereco.getUf(), endereco.getCep());
		persistenciaCliente.CadastrarCliente(cliente.getCpf(), cliente.getNome(), cliente.getTelefone(), idEndereco);
		controladorCarro.cadastrarCarro(carro.getPlaca(), carro.getMarca(), carro.getCor(), carro.getAno(), carro.getModelo(), cliente.getCpf());
	}
	
	public Cliente recuperarCliente(String cpf){
		Cliente cli = persistenciaCliente.recuperarClientePorCpf(cpf);
		cli.setServicos(controladorServico.recuperarServicosPorCliente(cpf));
		return cli; 
	}
}
