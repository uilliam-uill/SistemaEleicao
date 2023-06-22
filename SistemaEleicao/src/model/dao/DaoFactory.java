package model.dao;

import db.DB;
import model.dao.impl.CandidatoDaoJDBC;
import model.dao.impl.EleicaoDaoJDBC;
import model.dao.impl.PessoaDaoJDBC;


public class DaoFactory {

	public static PessoaDao createPessoaDao() {
		return new PessoaDaoJDBC(DB.getConnection());
	}
	
	public static CandidatoDao createCandidatoDao() {
		return new CandidatoDaoJDBC(DB.getConnection());
	}
	
	public static EleicaoDao createEleicaoDao() {
		return new EleicaoDaoJDBC(DB.getConnection());
	}	

}
