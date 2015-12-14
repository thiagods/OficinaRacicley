package br.ufrrj.fronteira;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufrrj.controladores.ControladorCliente;
import br.ufrrj.controladores.ControladorPagamento;
import br.ufrrj.controladores.ControladorServico;
import br.ufrrj.dominio.Cliente;
import br.ufrrj.dominio.Servico;

public class RealizarPagamento {
	public static boolean realizar(){
		ControladorCliente controladorCliente = new ControladorCliente();
		ControladorPagamento controladorPagamento = new ControladorPagamento();
		String cpf;
		Cliente cliente;
		Servico servico;
		int nParcelas = -1;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Realizar Pagamento\n");
		System.out.println("Entre com o cpf do cliente");
		cpf = teclado.next();
		
		cliente = controladorCliente.recuperarCliente(cpf);
		if(cliente == null){
			System.out.println("Nao foi encontrado nenhum cliente com o cpf informado.");
			teclado.close();
			return false;
		}
//		servicos = controladorServico.recuperarServicosPorCliente(cpf);
		servico = selecionarServico(cpf);
		
		if(servico == null){
			System.out.println("Este cliente nao possui nenhum servico registrado.");
			teclado.close();
			return false;
		}
		
		if(servico.getPagamento().getNParcelasNaoPagas() == 0){
			System.out.println("Este servico nao possui parcelas a serem pagas.");
			teclado.close();
			return false;
		}

		while(nParcelas < 0 || nParcelas > servico.getPagamento().getNParcelasNaoPagas()){
			System.out.println("Ha "+servico.getPagamento().getNParcelasNaoPagas()+" parcelas nao pagas");
			System.out.println("Deseja pagar quantas parcelas?");
			nParcelas = teclado.nextInt();
		}
		
		controladorPagamento.pagarParcelas(servico,nParcelas);
		teclado.close();
		
		return true;
	}
	
	private static Servico selecionarServico(String cpf){
		ControladorServico controladorServico = new ControladorServico();
		
		ArrayList<Servico> servicosPossiveis = new ArrayList<Servico>();
		int indiceServicoSelecionado = -2;
		Scanner teclado2 = new Scanner(System.in);
		
		servicosPossiveis = controladorServico.recuperarServicosPorCliente(cpf);
		while(!servicosPossiveis.isEmpty()){
			System.out.println("Selecione o servico a ser pago.");
			for(int i=0; i<servicosPossiveis.size(); i++){
				System.out.println(i+" - "+servicosPossiveis.get(i).getData().toString());
			}
			indiceServicoSelecionado = teclado2.nextInt();
			return servicosPossiveis.get(indiceServicoSelecionado);
		}
		return null;
	}
}
