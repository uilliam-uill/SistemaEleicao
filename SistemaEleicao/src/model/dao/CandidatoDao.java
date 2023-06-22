package model.dao;

import entities.Candidato;

public interface CandidatoDao {
	void insert(Candidato obj);
	Candidato findByNome(String nomeCandidato);
}
