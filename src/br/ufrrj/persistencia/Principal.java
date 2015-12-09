package br.ufrrj.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrrj.fronteira.CadastrarFabricante;

public class Principal {
	
	public static void novaGenese(ConexaoBD c){
		System.out.println("dropou end:"+c.executar("drop table endereco"));
		System.out.println("dropou fabri:"+c.executar("drop table fabricante"));
		System.out.println("dropou carro:"+c.executar("drop table carro"));
		System.out.println("dropou cliente:"+c.executar("drop table cliente"));
		System.out.println("dropou fornecedor:"+c.executar("drop table fornecedor"));
		
		//eu criei essas 4 tabelas.
		//isso funciona
		System.out.println("cr endereco:"+c.executar("create table endereco(id INT auto_increment PRIMARY KEY NOT NULL, numero INT, logradouro VARCHAR(255), complemento VARCHAR(255), bairro VARCHAR(255),cidade VARCHAR(255), uf VARCHAR(255),cep VARCHAR(255));"));
		System.out.println("cr cliente:"+c.executar("create table cliente(cpf  VARCHAR(12) PRIMARY KEY NOT NULL, nome VARCHAR(255), telefone VARCHAR(255), id_endereco INT NOT NULL, FOREIGN KEY (id_endereco) references endereco(id));"));
		System.out.println("cr carro: "+c.executar("create table carro(placa VARCHAR(8) PRIMARY KEY NOT NULL, marca VARCHAR(255), cor VARCHAR(255), ano INT, modelo VARCHAR(255), cpf_cliente VARCHAR(12) NOT NULL, FOREIGN KEY (cpf_cliente) references cliente(cpf));"));
		System.out.println("cr fabri:"+c.executar("create table fabricante(id INT auto_increment PRIMARY KEY NOT NULL, nome VARCHAR(255), telefone VARCHAR(255))"));
		System.out.println("cr forne:"+c.executar("create table fornecedor(id INT auto_increment NOT NULL, telefone VARCHAR(255), nome_vendedor VARCHAR(255), id_endereco INT NOT NULL, FOREIGN KEY (id_endereco) references endereco(id))"));
	}
	
	public static void main(String[] args) throws SQLException {
		ConexaoBD c = new ConexaoBD();
		ResultSet result;
		c.abrirConexao();
//		novaGenese(c);
		//testando...
//		CadastrarFabricante.cadastrar();
//		System.out.println("criou: "+c.executar("create table candango(id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, nome VARCHAR(255));"));
//		System.out.println("dropou: "+c.executar("drop table Candango"));
//		System.out.println("inseriu: "+c.executar("insert into fabricante (nome,telefone) values('Tigre','321321');"));
//		System.out.println("deletou: "+c.executar("delete from fabricante where id=1;"));
	    result = c.executarSelectQuery("select * from fornecedor");

	    while(result.next()){
	    	System.out.println(result.getInt("id"));
	    	System.out.println(result.getString("nome_vendedor"));
//	    	System.out.println(result.getString("nome"));
	    }
		c.fecharConexao();
	}
	
}
