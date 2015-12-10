package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public Integer adicionarReparo(String descricaoBreve, String descricaoDetalhada, String tempoMedioDeExecucao,
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
			ps.setString(3, tempoMedioDeExecucao);
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
}
