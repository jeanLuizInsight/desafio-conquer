package com.zanatta.desafioconquer.dto;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para object UF
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@XmlRootElement
public class UfDTO {

	@JsonProperty("nome") private String nome;
	@JsonProperty("sigla") private String sigla;

	public String getNome() {
		return this.nome;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setSigla(final String sigla) {
		this.sigla = sigla;
	}

}
