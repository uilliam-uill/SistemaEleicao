package model.dao;

import java.util.List;

import entities.Eleicao;

public interface EleicaoDao {
	List<Eleicao> findByType();
	Eleicao findByName(String nomeEleicao);
}
