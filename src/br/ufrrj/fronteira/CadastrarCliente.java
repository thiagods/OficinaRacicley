package br.ufrrj.fronteira;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import br.ufrrj.controladores.ControladorCliente;
import br.ufrrj.dominio.Carro;
import br.ufrrj.dominio.Cliente;
import br.ufrrj.dominio.Endereco;

public class CadastrarCliente {
	public static void cadastrar() {
		ControladorCliente controladorCliente = new ControladorCliente();
		//TODO: Problemas com o Scanner
		//quando tem mais de uma palavra, o next() da ruim. Ele só pega uma palavra
		//se eu usar o nextLine(), ele pega mais de uma palavra, mas da ruim na hora de usar o nextInt().
		String cpf;
		String nome;
		String telefone;
		
		Integer numero;
		String logradouro;
		String complemento;
		String bairro;
		String cidade;
		String uf; 
		String cep;
		
		String placa;
		String marca;
		String cor;
		Integer ano;
		String modelo;
		
		Cliente cliente;
		Endereco endereco;
		Carro carro;
		
		
		Scanner teclado = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);

		//cliente
		System.out.println("CPF:");
		cpf = teclado.next();
		System.out.println("Nome:");
		nome = teclado2.nextLine();
		System.out.println("Telefone:");
		telefone = teclado.next();

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
		
		//aqui pode entrar um loop pro cliente cadastrar quantos carros quiser.
		//nao vou fazer isso agora nao. Ta muito tarde. Vou dormir.
		//Se fizer, tem que modificar o metodo no controlador
		System.out.println("Informacoes do Carro:");
		System.out.println("Placa:");
		placa = teclado.next();
		System.out.println("Marca:");
		marca = teclado.next();
		System.out.println("Cor:");
		cor = teclado.next();
		System.out.println("Ano:");
		ano = teclado.nextInt();
		System.out.println("Modelo:");
		modelo = teclado.next();
		
		cliente = new Cliente(cpf, nome, new ArrayList<Carro>(), telefone, null);
		carro = new Carro(placa, marca, cor, ano, modelo);
		endereco = new Endereco(0, numero, logradouro, complemento, bairro, cidade, uf, cep);
		
		controladorCliente.cadastrarCliente(cliente, carro, endereco);
		
		teclado.close();
	}
}
