package br.ufrrj.fronteira;

import java.util.Scanner;

import br.ufrrj.controladores.ControladorEndereco;
import br.ufrrj.controladores.ControladorFabricante;
import br.ufrrj.dominio.Endereco;
import br.ufrrj.dominio.Fabricante;

public class CadastrarFabricante {
	
	
	
	public static void cadastrar(){
		ControladorFabricante controladorFabricante = new ControladorFabricante();	
		String nome;
		String telefone;
		Scanner teclado = new Scanner(System.in);
				
		System.out.println("nome: ");
		nome = teclado.nextLine();
		
		System.out.println("telefone");
		telefone = teclado.nextLine();
		
		controladorFabricante.cadastrarFabricante(nome, telefone);
		teclado.close();
		
	}
}
