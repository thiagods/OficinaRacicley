package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrrj.dominio.Carro;
import br.ufrrj.dominio.CategoriaPeca;
import br.ufrrj.dominio.Endereco;
import br.ufrrj.dominio.Fabricante;
import br.ufrrj.dominio.Fornecedor;
import br.ufrrj.dominio.Peca;
import br.ufrrj.dominio.Reparo;

public class PersistenciaPeca {
	private ConexaoBD c;
	private Connection conexao;
	PersistenciaFabricante persistenciaFabricante = new PersistenciaFabricante();
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}
	
	public void adicionarPeca(String codigo, String categoria, String descricao,String localizacao,double valor_compra,double valor_venda, Integer idFabricante){
		abrirConexao();
		String sql = "insert into peca (codigo, categoria, descricao,localizacao, valor_compra, valor_venda, id_fabricante) values(?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, codigo);
			ps.setString(2, categoria);
			ps.setString(3, descricao);
			ps.setString(4,localizacao);
			ps.setDouble(5, valor_compra);
			ps.setDouble(6, valor_venda);
			ps.setInt(7, idFabricante);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}	
		fecharConexao();
	}
	
	
	public ArrayList<Peca> listarPecas(){
		Peca p;
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		abrirConexao();
		ResultSet rs;
		String sql = "select * from peca";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Fabricante f = persistenciaFabricante.recuperarFabricante(rs.getInt("id_fabricante"));
				p = new Peca(rs.getString("codigo"), CategoriaPeca.valueOf(rs.getString("categoria")), rs.getString("descricao"), rs.getString("localizacao"), -1, rs.getDouble("valor_compra"), rs.getDouble("valor_venda"), f);
				pecas.add(p);
			}
			return pecas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public Peca recuperarPeca(String codigo){
		Peca peca = null;
		abrirConexao();
		ResultSet rs;
		String sql = "select * from peca where codigo = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, codigo);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Fabricante f = persistenciaFabricante.recuperarFabricante(rs.getInt("id_fabricante"));
				peca = new Peca(rs.getString("codigo"), CategoriaPeca.valueOf(rs.getString("categoria")), rs.getString("descricao"), rs.getString("localizacao"), -1, rs.getDouble("valor_compra"), rs.getDouble("valor_venda"), f);
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
	
	public ArrayList<Peca> recuperarPecasPorServico(Integer idServico){
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		abrirConexao();
		ResultSet rs;
		String sql = "select * from servico_peca where id_servico = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, idServico);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Peca p = recuperarPeca(rs.getString("codigo_peca"));
				pecas.add(p);
			}
			return pecas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
}
