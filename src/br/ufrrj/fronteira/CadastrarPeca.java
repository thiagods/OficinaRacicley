package br.ufrrj.fronteira;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufrrj.controladores.ControladorFabricante;
import br.ufrrj.controladores.ControladorPeca;
import br.ufrrj.dominio.CategoriaPeca;
import br.ufrrj.dominio.Fabricante;
import br.ufrrj.dominio.Peca;

public class CadastrarPeca {
	
	public static void cadastrar(){
		
		Peca p;
		ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
		ControladorPeca controladorPeca = new ControladorPeca();
		ControladorFabricante controladorFabricante = new ControladorFabricante();
		
		String codigo;	
		String descricao;
		String localizacao;
		CategoriaPeca categoria;
		int selecionado;
		int quantidadeEstoque;
		double valorCompra;
		double valorVenda;
		Integer idFabricante;
		System.out.println("Cadastrar Peca\n");
		Scanner teclado = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);
		
		System.out.println("Entre com o codigo:");
		codigo = teclado.nextLine();
		System.out.println("Entre com a categoria:");
		System.out.println("1 - MOTOR\n2 - LANTERNAGEM\n3 - ELETRICO");
		selecionado = teclado2.nextInt();
		categoria = selecionaCategoria(selecionado);
		System.out.println("Entre com a descricao:");
		descricao = teclado.nextLine();
		System.out.println("Entre com a localizacao:");
		localizacao = teclado.nextLine();

		System.out.println("Entre com a quantidade:");
		quantidadeEstoque = teclado2.nextInt();
		System.out.println("Entre com o valor de compra:");
		valorCompra = teclado2.nextInt();
		System.out.println("Entre com o valor de venda:");
		valorVenda = teclado2.nextDouble();
		
		fabricantes = controladorFabricante.listarFabricantes();
		System.out.println("Fabricante:");
		for(Fabricante f : fabricantes){
			System.out.println(f.getId()+" - "+ f.getNome());
		}
		idFabricante = teclado2.nextInt();
		
		p = new Peca(codigo, categoria, descricao, localizacao, quantidadeEstoque, valorCompra, valorVenda,new Fabricante(idFabricante, null, null));
		if(controladorPeca.cadastrarPeca(p) == true)
			System.out.println("Peca cadastrada com sucesso");
		else
			System.out.println("Nao foi possivel cadastrar a peca.");
		
	}
	
	private static CategoriaPeca selecionaCategoria(int selecionado) {
		
		CategoriaPeca categoriaPeca = null;
		
		if(selecionado == 1){
			categoriaPeca = CategoriaPeca.MOTOR;
		}
		else if(selecionado == 2){
			categoriaPeca = CategoriaPeca.LANTERNAGEM;			
		}
		else if(selecionado == 3){
			categoriaPeca = CategoriaPeca.ELETRICO;
		}
		else{
			System.err.println("Erro ao selecionar");
			
		}
		return categoriaPeca;		
	}
}
