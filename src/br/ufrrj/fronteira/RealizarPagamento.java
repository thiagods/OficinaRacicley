package br.ufrrj.fronteira;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufrrj.controladores.ControladorCliente;
import br.ufrrj.controladores.ControladorServico;
import br.ufrrj.dominio.Cliente;
import br.ufrrj.dominio.Parcela;
import br.ufrrj.dominio.Servico;

public class RealizarPagamento {
	public static boolean realizar(){
		ControladorCliente controladorCliente = new ControladorCliente();
		ControladorServico controladorServico = new ControladorServico();
		String cpf;
		Cliente cliente;
		Servico servico;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Entre com o cpf do cliente");
		cpf = teclado.next();
		
		cliente = controladorCliente.recuperarCliente(cpf);
		if(cliente == null){
			System.out.println("Nao foi encontrado nenhum cliente com o cpf informado.");
			return false;
		}
//		servicos = controladorServico.recuperarServicosPorCliente(cpf);
		servico = selecionarServico(cpf);
		
		System.out.println("Selecione a parcela a ser paga");
		for(Parcela p : servico.getPagamento().getParcelas()){
			//Aqui vai listar as parcelas pro usuario escolher qual pagar
			//mas não seria melhor pagar sempre a primeira parcela não paga não?
		}
		
		//TODO: CONTINUAR
		
		return true;
	}
	
	private static Servico selecionarServico(String cpf){
		ControladorServico controladorServico = new ControladorServico();
		
		ArrayList<Servico> servicosPossiveis = new ArrayList<Servico>();
		int indiceServicoSelecionado = -2;
		Scanner teclado = new Scanner(System.in);
		
		servicosPossiveis = controladorServico.recuperarServicosPorCliente(cpf);
		while(!servicosPossiveis.isEmpty()){
			System.out.println("Selecione o servico a ser pago.");
			for(int i=0; i<servicosPossiveis.size(); i++){
				System.out.println(i+" - "+servicosPossiveis.get(i).getData().toString());
			}
			indiceServicoSelecionado = teclado.nextInt();
			teclado.close();
			return servicosPossiveis.get(indiceServicoSelecionado);
		}
		teclado.close();
		return null;
	}
}
