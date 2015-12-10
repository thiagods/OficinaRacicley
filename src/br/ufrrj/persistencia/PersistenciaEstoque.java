package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrrj.dominio.Estoque;
import br.ufrrj.dominio.Peca;

public class PersistenciaEstoque {
	
	private ConexaoBD c;
	private Connection conexao;
	private PersistenciaPeca persistenciaPeca = new PersistenciaPeca();
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}
	
	public Estoque recuperaEstoque(){
		Estoque est;
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		abrirConexao();
		ResultSet resultset;
		String sql = "select * from estoque";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			resultset = ps.executeQuery();
			
			while(resultset.next()){
//				Peca = new Peca(resultset.getInt("id"), resultset.getString("telefone"), resultset.getString("nome_vendedor"), end);
				Peca peca = persistenciaPeca.recuperarPeca(resultset.getInt("id_peca"));
				peca.setQuantidadeEstoque(resultset.getInt("quantidade"));
				pecas.add(peca);
			}
			est = new Estoque();
			est.setPecasNoEstoque(pecas);
			return est;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
}
