package br.ufrrj.fronteira;

import java.util.Scanner;

import br.ufrrj.dominio.Peca;

public class CadastrarPeca {
	
	public static void cadastrar(){
		
		Peca p;
		String codigo;
		String categoria;
		String descricao;
		String localizacao;
		int quantidadeEstoque;
		double valorCompra;
		double valorVenda;
		
		Scanner teclado = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);
		
		System.out.println("Entre com o codigo:");
		codigo = teclado.next();
		System.out.println("Entre com a categoria:");
		categoria = teclado.next();
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

}
