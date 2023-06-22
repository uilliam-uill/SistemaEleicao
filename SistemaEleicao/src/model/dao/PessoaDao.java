package model.dao;

import java.util.List;

import entities.Endereco;
import entities.Pessoa;

public interface PessoaDao {
	void insert(Pessoa obj, Endereco endereco);
	void update(Pessoa obj);
	void deleteById(int id);
	Pessoa findById(int id);
	List<Pessoa> findAll();
	void insert(Pessoa obj);
}
