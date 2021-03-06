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
	
	public Estoque recuperaEstoque(Estoque estoque){
//		Estoque est;
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
				Peca peca = persistenciaPeca.recuperarPeca(resultset.getString("codigo_peca"));
				peca.setQuantidadeEstoque(resultset.getInt("quantidade"));
				pecas.add(peca);
			}
//			est = new Estoque();
			estoque.setPecasNoEstoque(pecas);
			return estoque;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}

	public void adicionarPecaNoEstoque(String codigo, Integer qtd) {
		abrirConexao();
		String sql = "insert into estoque (codigo_peca, quantidade) values(?,?)";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, codigo);
			ps.setInt(2, qtd);
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}	
		fecharConexao();
		
	}

	public void utilizarPecas(Estoque estoque,ArrayList<Peca> pecasTrocadas) {
		abrirConexao();
		String sql = "UPDATE estoque SET (quantidade) = ? "
				+ "WHERE codigo_peca = ?";
		
		
		PreparedStatement ps;
		for(Peca peca : pecasTrocadas){
			
			Integer qtd = estoque.recuperarPeca(peca).utilizar();
			try {
				ps = conexao.prepareStatement(sql);
				ps.setInt(1, qtd);
				ps.setString(2, peca.getCodigo());
				
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				fecharConexao();
				e.printStackTrace();
			}
		}
		fecharConexao();
	}
	
	public void utilizarPeca(Estoque estoque,Peca pecaUtilizada) {
		abrirConexao();
		String sql = "UPDATE estoque SET (quantidade) = ? "
				+ "WHERE codigo_peca = ?";
				
		PreparedStatement ps;
	
		Integer qtd = estoque.recuperarPeca(pecaUtilizada).utilizar();
		try {
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, qtd);
			ps.setString(2, pecaUtilizada.getCodigo());
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		fecharConexao();
	}

	public void comprarPeca(Peca p, Integer qtd, Estoque estoque) {
		abrirConexao();
		String sql = "UPDATE estoque SET (quantidade) = ? "
				+ "WHERE codigo_peca = ?";
				
		PreparedStatement ps;
	
		Integer qtdNoEstoque = estoque.recuperarPeca(p).comprar(qtd);
		try {
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, qtdNoEstoque);
			ps.setString(2, p.getCodigo());
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		fecharConexao();
		
	}
}
