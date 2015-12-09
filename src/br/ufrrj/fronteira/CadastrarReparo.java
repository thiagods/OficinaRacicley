package br.ufrrj.fronteira;

import java.util.Scanner;

import br.ufrrj.controladores.ControladorReparo;
import br.ufrrj.dominio.Reparo;

public class CadastrarReparo {

	public static void cadastrar() {
		
		ControladorReparo controladorReparo = new ControladorReparo();
		String descricaoBreve;
		String descricaoDetalhada;
		String tempoMedioDeExecucao;
		Double valorMaoDeObra;
		Reparo r;
		
		Scanner teclado = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);
		
		System.out.println("Entre com a descricao:");
		descricaoBreve = teclado.next();
		System.out.println("Entre com a descricao detalhada:");
		descricaoDetalhada = teclado.next();
		System.out.println("Entre com o tempo de Execucao:");
		tempoMedioDeExecucao = teclado.next();
		System.out.println("Entre com o valor da mao de obra:");
		valorMaoDeObra = teclado2.nextDouble();
		
		r = new Reparo(descricaoBreve, descricaoDetalhada, tempoMedioDeExecucao, valorMaoDeObra);		
		
		controladorReparo.cadastrarReparo(r);
		
		teclado.close();
		teclado2.close();
	}
}