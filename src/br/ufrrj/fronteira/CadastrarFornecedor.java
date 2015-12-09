package br.ufrrj.fronteira;

import java.util.Scanner;

import br.ufrrj.controladores.ControladorFornecedor;
import br.ufrrj.dominio.Endereco;
import br.ufrrj.dominio.Fornecedor;

public class CadastrarFornecedor {
	
	public static void cadastrar(){
		ControladorFornecedor controladorFornecedor = new ControladorFornecedor();
		Fornecedor f;
		String telefone;
		String nomeVendedor;
		Endereco endereco;
		
		
		Integer numero;
		String logradouro;
		String complemento;
		String bairro;
		String cidade;
		String uf; 
		String cep;
		
		Scanner teclado = new Scanner(System.in);
		
		//Fornecedor
		System.out.println("Telefone:");
		telefone = teclado.next();
		System.out.println("Nome do vendedor");
		nomeVendedor = teclado.next();
		
		//endereco
		System.out.println("Numero:");
		numero = teclado.nextInt();
		System.out.println("Logradouro:");
		logradouro = teclado.next();
		System.out.println("Complemento:");
		complemento = teclado.next();
		System.out.println("Bairro:");
		bairro = teclado.next();
		System.out.println("Cidade:");
		cidade = teclado.next();
		System.out.println("Uf:");
		uf = teclado.next();
		System.out.println("Cep:");
		cep = teclado.next();
		endereco = new Endereco(0, numero, logradouro, complemento, bairro, cidade, uf, cep);
		
		f = new Fornecedor(0, telefone, nomeVendedor, endereco);
		controladorFornecedor.cadastrarFornecedor(f);
		
		teclado.close();
	}
	
}
