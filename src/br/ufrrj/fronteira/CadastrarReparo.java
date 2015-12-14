package br.ufrrj.fronteira;

import java.util.Scanner;

import br.ufrrj.controladores.ControladorReparo;
import br.ufrrj.dominio.Reparo;

public class CadastrarReparo {

	public static void cadastrar() {
		
		ControladorReparo controladorReparo = new ControladorReparo();
		String descricaoBreve;
		String descricaoDetalhada;
		double tempoMedioDeExecucao;
		Double valorMaoDeObra;
		Reparo r;
		
		System.out.println("Cadastrar Reparo\n");
		Scanner teclado = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);
		
		System.out.println("Entre com a descricao:");
		descricaoBreve = teclado.nextLine();
		System.out.println("Entre com a descricao detalhada:");
		descricaoDetalhada = teclado.nextLine();
		System.out.println("Entre com o tempo de Execucao:");
		tempoMedioDeExecucao = teclado2.nextDouble();
		System.out.println("Entre com o valor da mao de obra:");
		valorMaoDeObra = teclado2.nextDouble();
		
		r = new Reparo(descricaoBreve, descricaoDetalhada, tempoMedioDeExecucao, valorMaoDeObra);		
		
		if(controladorReparo.cadastrarReparo(r) == true)
			System.out.println("Reparo cadastrado com sucesso");
		else
			System.out.println("O reparo nao pode ser cadastrado.");
		
		teclado.close();
		teclado2.close();
	}
}