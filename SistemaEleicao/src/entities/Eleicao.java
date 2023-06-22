package entities;

import java.io.Serializable;
import java.util.Date;

public class Eleicao implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String tipo;
	private Date dataInicio;
	private Date dataFinal;
	private int qtdTotalVotos;
	
	public Eleicao() {}

	public Eleicao(int id, String nome, String tipo, Date dataInicio, Date dataFinal, int qtdTotalVotos) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.qtdTotalVotos = qtdTotalVotos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public int getQtdTotalVotos() {
		return qtdTotalVotos;
	}

	public void setQtdTotalVotos(int qtdTotalVotos) {
		this.qtdTotalVotos = qtdTotalVotos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eleicao other = (Eleicao) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}