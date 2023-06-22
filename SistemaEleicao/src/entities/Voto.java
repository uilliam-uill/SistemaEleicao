package entities;

import java.io.Serializable;
import java.util.Date;

public class Voto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int qtdVotos;
	private Date data;
	private Date horas;
	
	public Voto () {}

	public Voto(int id, int qtdVotos, Date data, Date horas) {
		this.id = id;
		this.qtdVotos = qtdVotos;
		this.data = data;
		this.horas = horas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtdVotos() {
		return qtdVotos;
	}

	public void setQtdVotos(int qtdVotos) {
		this.qtdVotos = qtdVotos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHoras() {
		return horas;
	}

	public void setHoras(Date horas) {
		this.horas = horas;
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
		Voto other = (Voto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
