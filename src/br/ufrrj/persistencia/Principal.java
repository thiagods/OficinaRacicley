package br.ufrrj.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrrj.dominio.CategoriaPeca;
import br.ufrrj.dominio.Estoque;
import br.ufrrj.dominio.Fabricante;
import br.ufrrj.dominio.Pagamento;
import br.ufrrj.dominio.Peca;
import br.ufrrj.dominio.TipoPagamento;

public class Principal {
	
	public static void novaGenese(ConexaoBD c){
		System.out.println("dropou end:"+c.executar("drop table endereco"));
		System.out.println("dropou fabri:"+c.executar("drop table fabricante"));
		System.out.println("dropou carro:"+c.executar("drop table carro"));
		System.out.println("dropou cliente:"+c.executar("drop table cliente"));
		System.out.println("dropou fornecedor:"+c.executar("drop table fornecedor"));
		System.out.println("dropou reparo:"+c.executar("drop table reparo"));
		System.out.println("dropou peca:"+c.executar("drop table peca"));
		System.out.println("dropou estoque:"+c.executar("drop table estoque"));
		System.out.println("dropou servico:"+c.executar("drop table servico"));

		
		//eu criei essas 4 tabelas.
		//isso funciona
		System.out.println("cr endereco:"+c.executar("create table endereco(id INT auto_increment PRIMARY KEY NOT NULL, numero INT, logradouro VARCHAR(255), complemento VARCHAR(255), bairro VARCHAR(255),cidade VARCHAR(255), uf VARCHAR(255),cep VARCHAR(255));"));
		System.out.println("cr cliente:"+c.executar("create table cliente(cpf  VARCHAR(12) PRIMARY KEY NOT NULL, nome VARCHAR(255), telefone VARCHAR(255), id_endereco INT NOT NULL, FOREIGN KEY (id_endereco) references endereco(id));"));
		System.out.println("cr carro: "+c.executar("create table carro(placa VARCHAR(8) PRIMARY KEY NOT NULL, marca VARCHAR(255), cor VARCHAR(255), ano INT, modelo VARCHAR(255), cpf_cliente VARCHAR(12) NOT NULL, FOREIGN KEY (cpf_cliente) references cliente(cpf));"));
		System.out.println("cr fabri:"+c.executar("create table fabricante(id INT auto_increment PRIMARY KEY NOT NULL, nome VARCHAR(255), telefone VARCHAR(255))"));
		System.out.println("cr forne:"+c.executar("create table fornecedor(id INT auto_increment NOT NULL, telefone VARCHAR(255), nome_vendedor VARCHAR(255), id_endereco INT NOT NULL, FOREIGN KEY (id_endereco) references endereco(id))"));
		System.out.println("cr reparo:"+c.executar("create table reparo(id INT auto_increment NOT NULL, descricao_breve VARCHAR(255), descricao_detalhada VARCHAR(255), tempo_medio_execucao VARCHAR(255),valor_mao_de_obra DOUBLE NOT NULL);"));
		System.out.println("cr peca:"+c.executar("create table peca(codigo VARCHAR(255) PRIMARY KEY NOT NULL, categoria VARCHAR(255), descricao VARCHAR(255), localizacao VARCHAR(255), valor_compra DOUBLE NOT NULL, valor_venda DOUBLE NOT NULL, id_fabricante INT NOT NULL, FOREIGN KEY (id_fabricante) REFERENCES fabricante (id));"));
		System.out.println("cr estoque:"+c.executar("create table estoque(codigo_peca VARCHAR(255) NOT NULL, quantidade INT, FOREIGN KEY (codigo_peca) REFERENCES peca(codigo) );"));
		System.out.println("cr servico:"+c.executar("create table servico( );"));
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
	    result = c.executarSelectQuery("select * from estoque");
	    
//	    PersistenciaFabricante persistenciaFabricante = new PersistenciaFabricante();
//	    ArrayList<Fabricante> fabricantes = persistenciaFabricante.listarFabricantes();
	    
	    //Pagamento pag = new Pagamento(TipoPagamento.CREDITO, 500, 3);
	    
	    //ESTOQUE
//	    Estoque est = Estoque.getEstoque();
//	    ArrayList<Peca> pecas = new ArrayList<Peca>();
//	    Peca peca = new Peca("lala", CategoriaPeca.MOTOR, "lala", "lala", 500, 500, 500, new Fabricante(1, "lala", "lala"));
//	    pecas.add(peca);
//	    est.setPecasNoEstoque(pecas);
//	    Estoque est2 = Estoque.getEstoque();

	    while(result.next()){
//	    	System.out.println(result.getInt("id"));
	    	System.out.println(result.getString("codigo_peca"));
//	    	System.out.println(result.getString("nome"));
//	    	System.out.println(result.getString("categoria"));
	    	System.out.println(result.getInt("quantidade"));
	    }
		c.fecharConexao();
	}
	
}
