package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufrrj.dominio.Fornecedor;

public class PersistenciaFornecedor {
	
	private ConexaoBD c;
	private Connection conexao;
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}
	
	public void adicionarFornecedor(String telefone, String nomeVendedor, Integer idEndereco){
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
		}	
		fecharConexao();
	}
}
