package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrrj.dominio.Endereco;

public class PersistenciaEndereco {
	
	private ConexaoBD c;
	private Connection conexao;
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}
	
	public Integer adicionarEndereco(Integer numero, String logradouro, String complemento, String bairro, String cidade, String uf, String cep){
		Integer id = null;
		abrirConexao();
		ResultSet rs;
		String sql = "insert into endereco (numero,logradouro, complemento, bairro, cidade, uf, cep) values(?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, numero);
			ps.setString(2, logradouro);
			ps.setString(3, complemento);
			ps.setString(4, bairro);
			ps.setString(5, cidade);
			ps.setString(6, uf);
			ps.setString(7, cep);
			ps.execute();
			//retorna o id gerado no cadastro do endereco
			rs = ps.getGeneratedKeys();
			while(rs.next()){
				id = rs.getInt(1);
			}
			fecharConexao();
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
			return -1;
		}
		
	}
	
	public Endereco recuperarEndereco(Integer id){
		abrirConexao();
		Endereco end = null;
		ResultSet resultset;
		String sql = "select * from endereco where id = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			resultset = ps.executeQuery();
			
			while(resultset.next()){
				end = new Endereco(resultset.getInt("id"), resultset.getInt("numero"), resultset.getString("logradouro"), resultset.getString("complemento"), resultset.getString("bairro"), resultset.getString("cidade"), resultset.getString("uf"), resultset.getString("cep"));
			}
			return end;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		
		fecharConexao();
		return null;
	}
	
}
