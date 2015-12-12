package br.ufrrj.fronteira;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.sql.rowset.serial.SerialArray;

import br.ufrrj.controladores.ControladorPeca;
import br.ufrrj.controladores.ControladorReparo;
import br.ufrrj.controladores.ControladorServico;
import br.ufrrj.dominio.Peca;
import br.ufrrj.dominio.Reparo;
import br.ufrrj.dominio.Servico;

public class RealizarServico {
	public static void realizarServico(){
		//TODO: Tem que fazer essa tela
		ControladorServico controladorServico = new ControladorServico();
		
		Servico servico;
		Date data = new Date();
		Calendar c = new GregorianCalendar();
		int dia;
		int mes;
		int ano;
		Integer indicePecaSelecionada = -1;
		
		ArrayList<Reparo> reparosRealizados = new ArrayList<Reparo>();
		ArrayList<Peca> pecasTrocadas = new ArrayList<Peca>();
//		ArrayList<Peca> pecasPossiveis = new ArrayList<Peca>(); 
		double valorMaoDeObra;
		
		Scanner teclado2 = new Scanner(System.in);
		
		System.out.println("Dia: ");
		c.set(Calendar.DAY_OF_MONTH, teclado2.nextInt());
		System.out.println("Mes: ");
		c.set(Calendar.MONTH, teclado2.nextInt());
		System.out.println("Ano: ");
		c.set(Calendar.YEAR, teclado2.nextInt());		
		data = c.getTime();
		
		reparosRealizados = selecionarReparos();
		pecasTrocadas = selecionarPecas();
		
		
		servico = new Servico(null, data, reparosRealizados, pecasTrocadas);
		
		System.out.println("Valor do orçamento: R$"+servico.getOrcamento());
		System.out.println("Deseja aprovar o orcamento?\n1 - SIM\n2 - NAO");
		if(teclado2.nextInt() == 1){
			controladorServico.realizarServico(data, reparosRealizados, pecasTrocadas);
		}
		
		teclado2.close();
	}
	
	private static ArrayList<Reparo> selecionarReparos(){
		ArrayList<Reparo> reparosPossiveis = new ArrayList<Reparo>();
		ControladorReparo controladorReparo = new ControladorReparo();
		int indiceReparoSelecionado = -2;
		Scanner teclado = new Scanner(System.in);
		ArrayList<Reparo> reparosRealizados = new ArrayList<Reparo>();
		
		reparosPossiveis = controladorReparo.listarReparos();
		while(indiceReparoSelecionado  != -1 && !reparosPossiveis.isEmpty()){
			System.out.println("Selecione o reparo a ser realizado. Para encerrar, entre com -1");
			for(int i=0; i<reparosPossiveis.size(); i++){
				System.out.println(i+" - "+reparosPossiveis.get(i).getDescricaoBreve());
			}
			indiceReparoSelecionado = teclado.nextInt();
			if(indiceReparoSelecionado != -1){
				reparosRealizados.add(reparosPossiveis.get(indiceReparoSelecionado));
				reparosPossiveis.remove(indiceReparoSelecionado);
			}
		}
		
		return reparosRealizados;
	}
	
	private static ArrayList<Peca> selecionarPecas(){
		ArrayList<Peca> pecasPossiveis = new ArrayList<Peca>();
		ControladorPeca controladorPeca = new ControladorPeca();
		int indicePecaSelecionada = -2;
		Scanner teclado = new Scanner(System.in);
		ArrayList<Peca> pecasTrocadas = new ArrayList<Peca>();
		
		pecasPossiveis = controladorPeca.listarPecas();
		while(indicePecaSelecionada  != -1 && !pecasPossiveis.isEmpty()){
			System.out.println("Selecione a peca a ser trocada. Para encerrar, entre com -1");
			for(int i=0; i<pecasPossiveis.size(); i++){
				System.out.println(i+" - "+pecasPossiveis.get(i).getDescricao());
			}
			indicePecaSelecionada = teclado.nextInt();
			if(indicePecaSelecionada != -1){
				pecasTrocadas.add(pecasPossiveis.get(indicePecaSelecionada));
				pecasPossiveis.remove(indicePecaSelecionada);
			}
		}
		
		return pecasTrocadas;
	}
	
}
