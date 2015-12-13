package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrrj.dominio.Pagamento;
import br.ufrrj.dominio.Parcela;
import br.ufrrj.dominio.TipoPagamento;

public class PersistenciaPagamento {
	PersistenciaParcela persistenciaParcela = new PersistenciaParcela();
	
	private ConexaoBD c;
	private Connection conexao;
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}
	
	public Integer adicionarPagamento(String tipoPagamento, double valorTotal){
		Integer id = null;
		abrirConexao();
		ResultSet rs;
		String sql = "insert into pagamento (tipo_pagamento,valor_total) values(?,?)";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, tipoPagamento);
			ps.setDouble(2, valorTotal);
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
	
	public Pagamento recuperarPagamento(Integer idPagamento){
		ArrayList<Parcela> parcelas = new ArrayList<Parcela>();
		Pagamento p = null;
		abrirConexao();
		ResultSet rs;
		String sql = "select * from pagamento where id = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, idPagamento);
			rs = ps.executeQuery();
			
			while(rs.next()){
				parcelas = persistenciaParcela.recuperarParcelasPorPagamento(idPagamento);
				p = new Pagamento(TipoPagamento.valueOf(rs.getString("tipo_pagamento")), rs.getDouble("valor_total"), null);
				p.setParcelas(parcelas);
			}
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
}
