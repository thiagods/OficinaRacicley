package br.ufrrj.fronteira;

import java.util.Scanner;

import br.ufrrj.controladores.ControladorFabricante;

public class CadastrarFabricante {
	
	public static void cadastrar(){
		ControladorFabricante controladorFabricante = new ControladorFabricante();	
		String nome;
		String telefone;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Cadastrar Fabricante");		
		System.out.println("nome: ");
		nome = teclado.nextLine();
		
		System.out.println("telefone");
		telefone = teclado.nextLine();
		
		if(controladorFabricante.cadastrarFabricante(nome, telefone) == true){
			System.out.println("Fabricante cadastrado com sucesso");
		}else{
			System.out.println("Nao foi possivel cadastrar o fabricante");
		}
		teclado.close();
		
	}
}
