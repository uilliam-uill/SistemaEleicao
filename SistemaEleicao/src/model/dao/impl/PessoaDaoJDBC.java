package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import entities.Endereco;
import entities.Pessoa;
import model.dao.PessoaDao;

public class PessoaDaoJDBC implements PessoaDao {

	private Connection conn;

	public PessoaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@SuppressWarnings("resource")
	public void insert(Pessoa obj, Endereco endereco) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn.setAutoCommit(false);

			// Inserção da pessoa
			st = conn.prepareStatement("INSERT INTO pessoa(nome, cpf, titulo, email, senha, perfil, candidatoElietor) "
					+ "VALUES (?, ?, ?, ?, ?, 'comum', 'eleitor')", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setString(3, obj.getTitulo());
			st.setString(4, obj.getEmail());
			st.setString(5, obj.getSenha());
			st.executeUpdate();

			// Obtém o id gerado pela inserção da pessoa
			rs = st.getGeneratedKeys();
			int idPessoa = 0;
			if (rs.next()) {
				idPessoa = rs.getInt(1);
			}

			// Inserção do endereço associado à pessoa
			if (endereco != null) {
				st = conn.prepareStatement(
						"INSERT INTO endereco(cidade, cep, bairro, numero, logradouro, pessoa_id, estado) "
								+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
				st.setString(1, endereco.getCidade());
				st.setInt(2, endereco.getCep());
				st.setString(3, endereco.getBairro());
				st.setInt(4, endereco.getNumero());
				st.setString(5, endereco.getLogradouro());
				st.setInt(6, idPessoa);
				st.setString(7, endereco.getEstado());

				st.executeUpdate();
			}

			conn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Pessoa obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pessoa findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Pessoa obj) {
		// TODO Auto-generated method stub

	}

}
