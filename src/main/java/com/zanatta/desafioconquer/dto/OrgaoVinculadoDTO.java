package com.zanatta.desafioconquer.dto;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para object OrgaoVinculado
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@XmlRootElement
public class OrgaoVinculadoDTO {

	@JsonProperty("cnpj") private String cnpj;
	@JsonProperty("codigoSIAFI") private String codigoSIAFI;
	@JsonProperty("nome") private String nome;
	@JsonProperty("sigla") private String sigla;

	public String getCnpj() {
		return this.cnpj;
	}

	public String getCodigoSIAFI() {
		return this.codigoSIAFI;
	}

	public String getNome() {
		return this.nome;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setCnpj(final String cnpj) {
		this.cnpj = cnpj;
	}

	public void setCodigoSIAFI(final String codigoSIAFI) {
		this.codigoSIAFI = codigoSIAFI;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setSigla(final String sigla) {
		this.sigla = sigla;
	}

}
