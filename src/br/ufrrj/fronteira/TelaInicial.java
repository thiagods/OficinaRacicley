package br.ufrrj.fronteira;

import java.util.Scanner;


public class TelaInicial {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int opcao;
		System.out.println("Oficina Racicley\n");
		System.out.println("Selecione a opcao desejada:");
		System.out.println("1 - Cadastrar Fornecedor\n2 - Cadastrar Fabricante\n3 - Cadastrar Cliente");
		System.out.println("4 - Cadastrar Reparo\n5 - Cadastrar Peca\n6 - Realizar Servico");
		System.out.println("7 - Comprar Peca\n8 - Realizar Pagamento");
		opcao = teclado.nextInt();
		switch (opcao){
			case 1:
				CadastrarFornecedor.cadastrar();
				break;
			case 2:
				CadastrarFabricante.cadastrar();
				break;
			case 3:
				CadastrarCliente.cadastrar();
				break;
			case 4:
				CadastrarReparo.cadastrar();
				break;
			case 5:
				CadastrarPeca.cadastrar();
				break;
			case 6:
				RealizarServico.realizarServico();
				break;
			case 7:
				ComprarPeca.comprar();
				break;
			case 8:
				RealizarPagamento.realizar();
				break;
		}
	}
}
