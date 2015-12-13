package br.ufrrj.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.ufrrj.dominio.Pagamento;
import br.ufrrj.dominio.Peca;
import br.ufrrj.dominio.Reparo;
import br.ufrrj.dominio.Servico;

public class PersistenciaServico {
	
	PersistenciaReparo persistenciaReparo = new PersistenciaReparo();
	PersistenciaPeca persistenciaPeca = new PersistenciaPeca();
	PersistenciaPagamento persistenciaPagamento = new PersistenciaPagamento();
	
	private ConexaoBD c;
	private Connection conexao;
	
	private void abrirConexao(){
		c = new ConexaoBD();
		conexao = c.abrirConexao();
	}
	
	private void fecharConexao(){
		c.fecharConexao();
	}

	public void adicionarServico(Date data, ArrayList<Reparo> reparosRealizados, ArrayList<Peca> pecasTrocadas, Integer idPagamento, String cpfCliente) {
		abrirConexao();
		java.sql.Date dataSql = new java.sql.Date(data.getTime());
		Integer idServico = null;
		String sql = "insert into servico (data,id_pagamento,cpf_cliente) values(?,?,?)";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setDate(1, dataSql);
			ps.setInt(2, idPagamento);
			ps.setString(3, cpfCliente);
			ps.execute();
			
			rs = ps.getGeneratedKeys();
			while(rs.next()){
				idServico = rs.getInt(1);
			}
			
			adicionarServicoReparos(idServico, reparosRealizados);
			adicionarServicoPecas(idServico, pecasTrocadas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}	
		fecharConexao();
		
	}
	
	//So chamar se a conexao estiver aberta. Por isso eh privado
	private void adicionarServicoReparos(Integer idServico,ArrayList<Reparo> reparosRealizados){
		String sql = "insert into servico_reparo(id_servico, id_reparo) values(?,?)";
		PreparedStatement ps;
		for(Reparo r : reparosRealizados){
			try {
				ps = conexao.prepareStatement(sql);
				ps.setInt(1, idServico);
				ps.setInt(2, r.getId());
				
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	}
	
	private void adicionarServicoPecas(Integer idServico,ArrayList<Peca> pecasTrocadas){
		String sql = "insert into servico_peca(id_servico, codigo_peca) values(?,?)";
		PreparedStatement ps;
		for(Peca p : pecasTrocadas){
			try {
				ps = conexao.prepareStatement(sql);
				ps.setInt(1, idServico);
				ps.setString(2, p.getCodigo());
				
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	}
	
	public Servico recuperarServico(Integer id){
		Servico s = null;
		ArrayList<Reparo> reparos = new ArrayList<Reparo>();
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		Pagamento pagamento;
		abrirConexao();
		ResultSet rs;
		String sql = "select * from servico where id = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()){
				pagamento = persistenciaPagamento.recuperarPagamento(rs.getInt("id_pagamento"));
				s = new Servico(rs.getInt("id"), rs.getDate("data"), null, null);
				s.setPagamento(pagamento);
			}
			fecharConexao();
			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Servico> recuperarServicosPorCliente(String cpf){
		Servico s = null;
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		Pagamento pagamento;
		abrirConexao();
		ResultSet rs;
		String sql = "select * from servico where cpf_cliente = ?";
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, cpf);
			rs = ps.executeQuery();
			
			while(rs.next()){
				pagamento = persistenciaPagamento.recuperarPagamento(rs.getInt("id_pagamento"));
				s = new Servico(rs.getInt("id"), rs.getDate("data"), null, null);
				s.setPagamento(pagamento);
				servicos.add(s);
			}
			fecharConexao();
			return servicos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fecharConexao();
			e.printStackTrace();
		}
		
		return null;
	}

}
