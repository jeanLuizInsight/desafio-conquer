package com.zanatta.desafioconquer.dto;

/**
 * DTO para object Municipio
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
public class MunicipioDTO {

	private String codigoIBGE;
	private String nomeIBGE;
	private String pais;
	private UfDTO Uf;

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
		return this.Uf;
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
		this.Uf = uf;
	}

}
