package br.ufrrj.fronteira;

import java.util.Scanner;

import br.ufrrj.controladores.ControladorCliente;
import br.ufrrj.dominio.Cliente;

public class BuscarCliente {

	public static void buscar() {
		ControladorCliente controladorCliente = new ControladorCliente();
		Cliente cli;
		String cpf;
		Scanner teclado = new Scanner(System.in);
		System.out.println("CPF: ");
		cpf = teclado.nextLine();
		
		cli = controladorCliente.recuperarCliente(cpf);
		
		if(cli != null){
			System.out.println("cpf: "+cli.getCpf());
			System.out.println("nome: "+cli.getNome());
		}else{
			System.out.println("Nao foi encontrado nenhum cliente com o cpf informado.");
		}
		teclado.close();
	}
	
}
