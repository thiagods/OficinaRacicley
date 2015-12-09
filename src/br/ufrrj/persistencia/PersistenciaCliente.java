package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrrj.dominio.Carro;
import br.ufrrj.dominio.Cliente;
import br.ufrrj.dominio.Endereco;

public class PersistenciaCliente {
	PersistenciaCarro persistenciaCarro = new PersistenciaCarro();
	PersistenciaEndereco persistenciaEndereco = new PersistenciaEndereco();
	private ConexaoBD c;
	private Connection conexao;
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}
	
	public void CadastrarCliente(String cpf, String nome, String telefone, Integer idEndereco){
		abrirConexao();
		String sql = "insert into cliente (cpf, nome, telefone, id_endereco) values(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, cpf);
			ps.setString(2, nome);
			ps.setString(3, telefone);
			ps.setInt(4, idEndereco);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}	
		fecharConexao();
	}
	//TODO
	public Cliente recuperarClientePorCpf(String cpf){
		Cliente cli = null;
		ArrayList<Carro> carros;
		Endereco endereco = null;
		abrirConexao();
		ResultSet rs;
		String sql = "select * from cliente where cpf = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, cpf);
			rs = ps.executeQuery();
			
			rs.next();
			
			if(rs.getRow() != 0){
				carros = persistenciaCarro.recuperarCarroPorCliente(cpf);
				endereco = persistenciaEndereco.recuperarEndereco(rs.getInt("id_endereco"));
				cli = new Cliente(rs.getString("cpf"), rs.getString("nome"), carros, rs.getString("telefone"), endereco);
			}
			fecharConexao();
			return cli;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
}
