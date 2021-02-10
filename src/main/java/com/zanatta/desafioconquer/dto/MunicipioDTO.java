package com.zanatta.desafioconquer.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para object Municipio
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@XmlRootElement
public class MunicipioDTO {

	@JsonProperty("codigoIBGE") private String codigoIBGE;
	@JsonProperty("nomeIBGE") private String nomeIBGE;
	@JsonProperty("pais") private String pais;
	@JsonProperty("uf") private UfDTO uf;

	public String getCodigoIBGE() {
		return codigoIBGE;
	}

	public String getNomeIBGE() {
		return nomeIBGE;
	}

	public String getPais() {
		return pais;
	}

	public UfDTO getUf() {
		return uf;
	}

	public void setCodigoIBGE(final String codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	public void setNomeIBGE(final String nomeIBGE) {
		this.nomeIBGE = nomeIBGE;
	}

	public void setPais(final String pais) {
		this.pais = pais;
	}

	public void setUf(final UfDTO uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoIBGE == null) ? 0 : codigoIBGE.hashCode());
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
		MunicipioDTO other = (MunicipioDTO) obj;
		if (codigoIBGE == null) {
			if (other.codigoIBGE != null)
				return false;
		} else if (!codigoIBGE.equals(other.codigoIBGE))
			return false;
		return true;
	}
}
