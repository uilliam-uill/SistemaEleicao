package entities;

import java.io.Serializable;

public class Candidato extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idCandidato;
    private String partido;
    private int numeroPartido;
    private int numeroCandidato;
    private String foto;
    private int votos;
    private Chapa chapa;

    public Candidato() {
    }
    

	public Candidato(int id, String nome, String cpf, String titulo, Endereco endereco, String email, String senha,
			String perfil, String autorizacao, int idCandidato, String partido, int numeroPartido, int numeroCandidato,
			String foto, int votos) {
		super(id, nome, cpf, titulo, endereco, email, senha, perfil, autorizacao);
		this.idCandidato = idCandidato;
		this.partido = partido;
		this.numeroPartido = numeroPartido;
		this.numeroCandidato = numeroCandidato;
		this.foto = foto;
		this.votos = votos;
	}


	public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public int getNumeroPartido() {
        return numeroPartido;
    }

    public void setNumeroPartido(int numeroPartido) {
        this.numeroPartido = numeroPartido;
    }

    public int getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(int numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public void adicionarVoto() {
        votos++;
    }


	public Chapa getChapa() {
		return chapa;
	}


	public void setChapa(Chapa chapa) {
		this.chapa = chapa;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idCandidato;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		if (idCandidato != other.idCandidato)
			return false;
		return true;
	}
	
}
