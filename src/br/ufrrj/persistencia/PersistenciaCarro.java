package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrrj.dominio.Carro;

public class PersistenciaCarro {
	private ConexaoBD c;
	private Connection conexao;
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}
	
	public boolean cadastrarCarro(String placa, String marca, String cor, int ano, String modelo, String cpfCliente){
		abrirConexao();
		String sql = "insert into carro (placa, marca, cor, ano, modelo, cpf_cliente) values(?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, placa);
			ps.setString(2, marca);
			ps.setString(3, cor);
			ps.setInt(4, ano);
			ps.setString(5, modelo);
			ps.setString(6, cpfCliente);
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
	
	public Carro recuperarCarro(String placa){
		Carro carro = null;
		abrirConexao();
		ResultSet rs;
		String sql = "select * from carro where placa = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, placa);
			rs = ps.executeQuery();
			
			while(rs.next()){
				carro = new Carro(rs.getString("placa"), rs.getString("marca"), rs.getString("cor"), rs.getInt("ano"), rs.getString("modelo"));
			}
			fecharConexao();
			return carro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Carro> recuperarCarroPorCliente(String cpfCliente){
		Carro carro;
		ArrayList<Carro> carros = new ArrayList<Carro>();
		abrirConexao();
		ResultSet rs;
		String sql = "select * from carro where cpf_cliente = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, cpfCliente);
			rs = ps.executeQuery();
			
			while(rs.next()){
				carro = new Carro(rs.getString("placa"), rs.getString("marca"), rs.getString("cor"), rs.getInt("ano"), rs.getString("modelo"));
				carros.add(carro);
			}
			fecharConexao();
			return carros;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
}
