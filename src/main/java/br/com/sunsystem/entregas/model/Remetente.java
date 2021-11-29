package br.com.sunsystem.entregas.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Remetente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRemetente;

	@Column(nullable = false)
	private String cpf = "";

	@Column(nullable = false)
	private String nome = "";

	@OneToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco = new Endereco();

	public Long getIdDestinarario() {
		return idRemetente;
	}

	public void setIdDestinarario(Long idRemetente) {
		this.idRemetente = idRemetente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRemetente == null) ? 0 : idRemetente.hashCode());
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
		Remetente other = (Remetente) obj;
		if (idRemetente == null) {
			if (other.idRemetente != null)
				return false;
		} else if (!idRemetente.equals(other.idRemetente))
			return false;
		return true;
	}

}
