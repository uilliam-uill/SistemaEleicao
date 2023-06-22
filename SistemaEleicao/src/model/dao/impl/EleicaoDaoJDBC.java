package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.DB;
import db.DbException;
import entities.Eleicao;
import model.dao.EleicaoDao;

public class EleicaoDaoJDBC implements EleicaoDao {
	
	private Connection conn;

	public EleicaoDaoJDBC(Connection conn) {
		this.conn = conn;
	}


	@Override
	public List<Eleicao> findByType() {
		
	    Connection conn = null;
	    PreparedStatement st = null;
	    ResultSet rs = null;
	    List<Eleicao> eleicoes = new ArrayList<>();
	    
	    try {
	        conn = DB.getConnection();
	        st = conn.prepareStatement("SELECT * FROM eleicao WHERE dataFinal >= DATE(NOW())");
	        rs = st.executeQuery();
	        while (rs.next()) {
	            Eleicao eleicao = new Eleicao();
	            eleicao.setTipo(rs.getString("tipo"));
	            eleicoes.add(eleicao);
	        }
	        
	        return eleicoes;
	        
	    } catch (SQLException ex) {
	        throw new DbException(ex.getMessage());
	    } finally {
	        DB.closeResultSet(rs);
	        DB.closeStatement(st);

	    }
	}


	@Override
	public Eleicao findByName(String nomeEleicao) {
	    Connection conn = null;
	    PreparedStatement st = null;
	    ResultSet rs = null;
	    Eleicao eleicao = new Eleicao();

	    try {
	        conn = DB.getConnection();
	        st = conn.prepareStatement("SELECT * FROM eleicao WHERE tipo = ?");
	        st.setString(1, nomeEleicao);
	        rs = st.executeQuery();

	        if (rs.next()) {
	            int id = rs.getInt("id");
	            String nome = rs.getString("nome");
	            String tipo = rs.getString("tipo");
	            Date dataInicio = rs.getDate("dataInicio");
	            Date dataFinal = rs.getDate("dataFinal");
	            int qtdTotalVotos = rs.getInt("qtdTotalVotos");
	            eleicao = new Eleicao(id, nome, tipo, dataInicio, dataFinal, qtdTotalVotos);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        DB.closeResultSet(rs);
	        DB.closeStatement(st);
	    }

	    return eleicao;
	}}

