package br.ufrrj.fronteira;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import br.ufrrj.controladores.ControladorCliente;
import br.ufrrj.controladores.ControladorPeca;
import br.ufrrj.controladores.ControladorReparo;
import br.ufrrj.controladores.ControladorServico;
import br.ufrrj.dominio.Cliente;
import br.ufrrj.dominio.Pagamento;
import br.ufrrj.dominio.Peca;
import br.ufrrj.dominio.Reparo;
import br.ufrrj.dominio.Servico;
import br.ufrrj.dominio.TipoPagamento;

public class RealizarServico {
	public static boolean realizarServico(){
		//TODO: Tem que fazer essa tela
		ControladorServico controladorServico = new ControladorServico();
		ControladorCliente controladorCliente = new ControladorCliente();
		Cliente cliente;
		String cpf;
		Servico servico;
		Date data = new Date();
		Calendar c = new GregorianCalendar();
		int dia;
		int mes;
		int ano;
		Integer indicePecaSelecionada = -1;
		Integer nParcelas = 0;
		TipoPagamento tipoPagamento;
		
		ArrayList<Reparo> reparosRealizados = new ArrayList<Reparo>();
		ArrayList<Peca> pecasTrocadas = new ArrayList<Peca>();
//		ArrayList<Peca> pecasPossiveis = new ArrayList<Peca>(); 
		double valorMaoDeObra;
		
		Scanner teclado2 = new Scanner(System.in);
		
		System.out.println("CPF do cliente:");
		cpf = teclado2.next();
		
		cliente = controladorCliente.recuperarCliente(cpf);
		if(cliente == null){
			System.out.println("O cpf informado nao pertence a nenhum cliente");
			return false;
		}
		
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
			
			listarTiposPagamento();
			tipoPagamento = TipoPagamento.find(teclado2.nextInt());
			if(!tipoPagamento.equals(TipoPagamento.DINHEIRO)){
				while(nParcelas < 1 || nParcelas > 3){
					System.out.println("Entre com o numero de parcelas (de 1 a 3):");
					nParcelas = teclado2.nextInt();
				}
			}else{
				nParcelas = 1;
			}
			Pagamento p = new Pagamento(tipoPagamento, servico.getOrcamento(), nParcelas);
			servico.setPagamento(p);
			controladorServico.realizarServico(servico, cpf);
			teclado2.close();
		}else{
			System.out.println("Orcamento nao aprovado.");
			teclado2.close();
		}
		
		return true;
	}
	
	private static void listarTiposPagamento(){
		System.out.println("Selecione o tipo de Pagamento");
		for(TipoPagamento tipo : TipoPagamento.values()){
			System.out.println(tipo.getCodigo()+" - "+tipo.name());
		}
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
