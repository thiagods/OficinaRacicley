package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrrj.dominio.Parcela;
import br.ufrrj.dominio.Peca;
import br.ufrrj.dominio.Reparo;

public class PersistenciaParcela {
	private ConexaoBD c;
	private Connection conexao;
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}
	
	public Integer adicionarParcela(double valor, boolean paga, Date dataVencimento, Integer idPagamento){
		Integer id = null;
		java.sql.Date dataSql = new Date(dataVencimento.getTime());
		abrirConexao();
		ResultSet rs;
		String sql = "insert into parcela(valor,paga,data_vencimento,id_pagamento) values(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setDouble(1, valor);
			ps.setBoolean(2, paga);
			ps.setDate(3, dataSql);
			ps.setInt(4, idPagamento);
			ps.execute();
			//retorna o id gerado no cadastro do pagamento
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

	public void adicionarParcelas(ArrayList<Parcela> parcelas, Integer idPagamento) {
		abrirConexao();
		String sql = "insert into parcela(valor,paga,data_vencimento,id_pagamento) values(?,?,?,?)";
		PreparedStatement ps;
		for(Parcela p : parcelas){
			try {
				java.sql.Date dataSql = new Date(p.getDataVencimento().getTime());
				ps = conexao.prepareStatement(sql);
				ps.setDouble(1, p.getValor());
				ps.setBoolean(2, p.isPaga());
				ps.setDate(3, dataSql);
				ps.setInt(4, idPagamento);
				
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				fecharConexao();
				e.printStackTrace();
			}	
		}
		fecharConexao();
		
	}
	
	public ArrayList<Parcela> recuperarParcelasPorPagamento(Integer idPagamento){
		ArrayList<Parcela> parcelas = new ArrayList<Parcela>();
		abrirConexao();
		ResultSet rs;
		String sql = "select * from parcela where id_pagamento = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, idPagamento);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Parcela p = new Parcela(rs.getDouble("valor"),rs.getBoolean("paga"), rs.getDate("data_vencimento"));
				p.setId(rs.getInt("id"));
				parcelas.add(p);
			}
			return parcelas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
}
