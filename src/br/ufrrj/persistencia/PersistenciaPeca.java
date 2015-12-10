package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrrj.dominio.Carro;
import br.ufrrj.dominio.Endereco;
import br.ufrrj.dominio.Fornecedor;
import br.ufrrj.dominio.Peca;

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
	
	public ArrayList<Peca> listarPecas(){
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
//				Endereco end = persistenciaEndereco.recuperarEndereco(resultset.getInt("id_endereco"));
//				f = new Fornecedor(resultset.getInt("id"), resultset.getString("telefone"), resultset.getString("nome_vendedor"), end);
//				fornecedores.add(f);
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public Peca recuperarPeca(Integer idPeca){
		Peca peca = null;
		abrirConexao();
		ResultSet rs;
		String sql = "select * from peca where id = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, idPeca);
			rs = ps.executeQuery();
			
			while(rs.next()){
				peca = new Peca(rs.getString("codigo"), rs.getString("categoria"), rs.getString("descricao"), rs.getString("localizacao"), rs.getInt("quantidade_estoque"), rs.getDouble("valor_compra"), rs.getDouble("valor_venda"));
			}
			fecharConexao();
			return peca;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
}
