package br.com.sunsystem.entregas.model;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.sunsystem.entregas.exceptions.BuscaLogradouro;
import br.com.sunsystem.entregas.exceptions.CepWebService;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long idEndereco;
	
	@Column(nullable = false)
	private String cep = "";
	
	@Column(nullable = false)
	private String logradouro = "";
	
	@Column(nullable = false)
	private String numero = "";
	
	@Column(nullable = false)
	private String complemento = "";
	
	@Column(nullable = false)
	private String bairro = "";
	
	@Column(nullable = false)
	private String cidade = "";
	
	@Column(nullable = false)
	private String uf = "";
	
	public Endereco() {
		
	}

	public Endereco(Long idEndereco, String cep, String logradouro, String numero, String complemento, String bairro,
			String cidade, String uf) {
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
		CepWebService c = new BuscaLogradouro().BuscaLogradouro(cep);

        if (c != null) {
            this.logradouro = c.getLogradouro();
            this.cidade = c.getCidade();
            this.uf = c.getEstado();
            this.bairro = c.getBairro();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível encontar o CEP!", "Erro!!!"));
        }
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (idEndereco == null) {
			if (other.idEndereco != null)
				return false;
		} else if (!idEndereco.equals(other.idEndereco))
			return false;
		return true;
	}
	
		
}
