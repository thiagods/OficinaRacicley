package br.ufrrj.fronteira;

import java.util.Scanner;

import br.ufrrj.dominio.CategoriaPeca;
import br.ufrrj.dominio.Peca;

public class CadastrarPeca {
	
	public static void cadastrar(){
		
		Peca p;
		
		String codigo;	
		String descricao;
		String localizacao;
		CategoriaPeca categoria;
		int selecionado;
		int quantidadeEstoque;
		double valorCompra;
		double valorVenda;
		
		Scanner teclado = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);
		
		System.out.println("Entre com o codigo:");
		codigo = teclado.next();
		System.out.println("Entre com a categoria:");
		System.out.println("1 - MOTOR\n2 - LANTERNAGEM\n3 - ELETRICO");
		selecionado = teclado.nextInt();
		categoria = selecionaCategoria(selecionado);
		System.out.println("Entre com a descricao:");
		descricao = teclado.next();
		System.out.println("Entre com a localizacao:");
		localizacao = teclado.next();

		System.out.println("Entre com a quantidade:");
		quantidadeEstoque = teclado.nextInt();
		System.out.println("Entre com o valor de compra:");
		valorCompra = teclado.nextInt();
		System.out.println("Entre com o valor de venda:");
		valorVenda = teclado.nextDouble();
		
		
		p = new Peca(codigo, categoria, descricao, localizacao, quantidadeEstoque, valorCompra, valorVenda);
				
		teclado.close();
		teclado2.close();
	}
	
	private static CategoriaPeca selecionaCategoria(int selecionado) {
		
		CategoriaPeca categoriaPeca;
		
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
		return null;		
	}
}
