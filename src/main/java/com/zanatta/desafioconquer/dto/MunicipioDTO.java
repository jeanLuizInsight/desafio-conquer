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
		return this.codigoIBGE;
	}

	public String getNomeIBGE() {
		return this.nomeIBGE;
	}

	public String getPais() {
		return this.pais;
	}

	public UfDTO getUf() {
		return this.uf;
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

}
