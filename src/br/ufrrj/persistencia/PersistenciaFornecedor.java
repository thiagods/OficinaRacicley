package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrrj.dominio.Endereco;
import br.ufrrj.dominio.Fornecedor;

public class PersistenciaFornecedor {
	
	private ConexaoBD c;
	private Connection conexao;
	PersistenciaEndereco persistenciaEndereco = new PersistenciaEndereco();
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}
	
	public boolean adicionarFornecedor(String telefone, String nomeVendedor, Integer idEndereco){
		abrirConexao();
		String sql = "insert into fornecedor (telefone,nome_vendedor,id_endereco) values(?,?,?)";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, telefone);
			ps.setString(2, nomeVendedor);
			ps.setInt(3, idEndereco);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
			return false;
		}	
		fecharConexao();
		return true;
	}
	
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
