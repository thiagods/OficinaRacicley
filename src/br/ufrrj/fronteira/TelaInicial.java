package br.ufrrj.fronteira;

import java.util.Scanner;


public class TelaInicial {
	public static void main(String[] args) {	
		
		Scanner entrada = new Scanner(System.in);
		boolean loop = true;
		int opcao;
				
		while(loop)
		{
			System.out.println("Oficina Racicley\n");
			System.out.println("Selecione a opcao desejada:");
			System.out.println("1 - Cadastrar Fornecedor\n2 - Cadastrar Fabricante\n3 - Cadastrar Cliente");
			System.out.println("4 - Cadastrar Reparo\n5 - Cadastrar Peca\n6 - Realizar Servico");
			System.out.println("7 - Comprar Peca\n8 - Realizar Pagamento\n9 - Sair");
			System.out.print("Entre com a opcao: ");			
			opcao = entrada.nextInt();
			System.out.println("\n\n\n\n");
			
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
				case 9:
					loop = false;
					break;
			}			
		}
		entrada.close();
	}
}
