package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrrj.dominio.Fabricante;

public class PersistenciaFabricante {
	
	private ConexaoBD c;
	private Connection conexao;
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}
	
	public void adicionar(String nome, String telefone){
		abrirConexao();
		String sql = "insert into fabricante (nome,telefone) values(?,?)";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, telefone);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}	
		fecharConexao();
	}
	
	public Fabricante recuperarFabricante(Integer id){
		Fabricante f = null;
		abrirConexao();
		ResultSet resultset;
		String sql = "select * from fabricante where id = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			resultset = ps.executeQuery();
			
			while(resultset.next()){
				f = new Fabricante(resultset.getInt("id"),resultset.getString("nome"),resultset.getString("telefone"));
			}
			fecharConexao();
			return f;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Fabricante> listarFabricantes(){
		Fabricante f;
		ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
		abrirConexao();
		ResultSet resultset;
		String sql = "select * from fabricante";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			resultset = ps.executeQuery();
			
			while(resultset.next()){
				f = new Fabricante(resultset.getInt("id"),resultset.getString("nome"),resultset.getString("telefone"));
				fabricantes.add(f);
			}
			return fabricantes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}	
}
