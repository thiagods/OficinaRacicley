package br.ufrrj.fronteira;

import java.util.Scanner;

import br.ufrrj.controladores.ControladorEstoque;
import br.ufrrj.dominio.Estoque;
import br.ufrrj.dominio.Peca;

public class ComprarPeca {
	
	public static void comprar(){
		ControladorEstoque controladorEstoque = new ControladorEstoque();
		Estoque e = Estoque.getEstoque();
		String codigo;
		Integer qtd;
		Peca p;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Entre com o codigo da peca desejada.");
		listarPecas(e);
		codigo = teclado.next();
		
		p = e.recuperarPecaPorCodigo(codigo);
		
		System.out.println("Entre com a quantidade a ser comprada:");
		qtd = teclado.nextInt();
		
		controladorEstoque.comprarPeca(p,qtd,e);
		
		teclado.close();
	}
	
	public static void listarPecas(Estoque e){
		for(Peca peca : e.getPecasNoEstoque()){
			System.out.println(peca.getCodigo()+" - "+peca.getDescricao());
		}
	}
	
}
