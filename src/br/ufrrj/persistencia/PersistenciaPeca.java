package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrrj.dominio.Endereco;
import br.ufrrj.dominio.Fornecedor;

public class PersistenciaPeca {
	private ConexaoBD c;
	private Connection conexao;
	PersistenciaPeca persistenciaPeca = new PersistenciaPeca();
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}
	
	public void adicionarPeca(String codigo, String categoria, String descricao,String localizacao,int quantidade_estoque,double valor_compra,double valor_venda){
		abrirConexao();
		String sql = "insert into fornecedor (codigo, categoria, descricao,localizacao, quantidade_estoque, valor_compra, valor_venda) values(?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, codigo);
			ps.setString(2, categoria);
			ps.setString(3, descricao);
			ps.setString(4,localizacao);
			ps.setInt(5,quantidade_estoque);
			ps.setDouble(6, valor_compra);
			ps.setDouble(7, valor_venda);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}	
		fecharConexao();
	}
	// ISSO EH LISTAR FORNECEDOR E NAO PECA
	
	public ArrayList<Fornecedor> listarFornecedores(){
		Fornecedor f;
		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		abrirConexao();
		ResultSet resultset;
		String sql = "select * from fornecedor";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			resultset = ps.executeQuery();
			
			while(resultset.next()){
				Endereco end = persistenciaEndereco.recuperarEndereco(resultset.getInt("id_endereco"));
				f = new Fornecedor(resultset.getInt("id"), resultset.getString("telefone"), resultset.getString("nome_vendedor"), end);
				fornecedores.add(f);
			}
			return fornecedores;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
}
