package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrrj.dominio.Reparo;

public class PersistenciaReparo {

	private ConexaoBD c;
	private Connection conexao;
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}
	
	public Integer adicionarReparo(String descricaoBreve, String descricaoDetalhada, double tempoMedioDeExecucao,
			Double valorMaoDeObra){
		Integer id = null;
		abrirConexao();
		ResultSet rs;
		String sql = "insert into reparo (descricao_breve,descricao_detalhada,tempo_medio_execucao, valor_mao_de_obra) values(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps = conexao.prepareStatement(sql);
			ps.setString(1, descricaoBreve);
			ps.setString(2, descricaoDetalhada);
			ps.setDouble(3, tempoMedioDeExecucao);
			ps.setDouble(4, valorMaoDeObra);
			ps.execute();
			rs = ps.getGeneratedKeys();
//			fecharConexao();
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
	
	public Reparo recuperarReparo(Integer id){
		Reparo reparo = null;
		abrirConexao();
		ResultSet rs;
		String sql = "select * from reparo where id = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()){
				reparo = new Reparo(rs.getString("descricao_breve"), rs.getString("descricao_detalhada"), rs.getDouble("tempo_medio_execucao"), rs.getDouble("valor_mao_de_obra"));
				reparo.setId(rs.getInt("id"));
			}
			fecharConexao();
			return reparo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Reparo> listarReparos(){
		Reparo r;
		ArrayList<Reparo> reparos = new ArrayList<Reparo>();
		abrirConexao();
		ResultSet rs;
		String sql = "select * from reparo";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				r = new Reparo(rs.getString("descricao_breve"), rs.getString("descricao_detalhada"), rs.getDouble("tempo_medio_execucao"), rs.getDouble("valor_mao_de_obra"));
				r.setId(rs.getInt("id"));
				reparos.add(r);
			}
			return reparos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Reparo> recuperarReparosPorServico(Integer idServico){
		ArrayList<Reparo> reparos = new ArrayList<Reparo>();
		abrirConexao();
		ResultSet rs;
		String sql = "select * from servico_reparo where id_servico = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, idServico);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Reparo r = recuperarReparo(rs.getInt("id_reparo"));
				reparos.add(r);
			}
			return reparos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
}
