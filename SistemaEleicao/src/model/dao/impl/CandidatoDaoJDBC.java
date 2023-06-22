package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import entities.Candidato;
import entities.Chapa;
import model.dao.CandidatoDao;

public class CandidatoDaoJDBC implements CandidatoDao {

	private Connection conn;
	
	public CandidatoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Candidato obj) {
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			st = conn.prepareStatement(
					"INSERT INTO pessoa(nome, cpf, titulo, email, senha, perfil)" + "VALUES (?, ?, ?, ?, ?, 'comum')");

			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setString(3, obj.getTitulo());
			st.setString(4, obj.getEmail());
			st.setString(5, obj.getSenha());
			st.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}

	}
	
	@Override
	public Candidato findByNome(String nomeCandidato) {

		 Candidato candidato = new Candidato();
		 Chapa chapa = new Chapa(); // criamos uma nova instância de Chapa

		    PreparedStatement st = null;
		    ResultSet rs = null;

		    try {
		        st = conn.prepareStatement("SELECT candidato.foto, "
		                + "candidato.partido, candidato.numeroPartido, "
		                + "candidato.numeroCandidato, pessoa.nome, chapa.descricao "
		                + "FROM candidato "
		                + "INNER JOIN pessoa ON candidato.id = pessoa.id "
		                + "INNER JOIN eleicao_candidato ON candidato.id = eleicao_candidato.candidato_id "
		                + "INNER JOIN eleicao_chapa ON eleicao_candidato.eleicao_id = eleicao_chapa.eleicao_id "
		                + "INNER JOIN chapa ON eleicao_chapa.chapa_id = chapa.id "
		                + "WHERE pessoa.nome = ? ");
		        st.setString(1, nomeCandidato);

		        rs = st.executeQuery();

		        if (rs.next()) {
		            candidato.setFoto(rs.getString("foto"));
		            candidato.setNome(rs.getString("nome"));
		            candidato.setPartido(rs.getString("partido"));
		            candidato.setNumeroPartido(rs.getInt("numeroPartido"));
		            candidato.setNumeroCandidato(rs.getInt("numeroCandidato"));
		            chapa.setDescricao(rs.getString("descricao"));
		            candidato.setChapa(chapa); // definimos a Chapa associada ao Candidato
		        }


	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DB.closeResultSet(rs);
	        DB.closeStatement(st);
	    }

	    return candidato;

	}
}
