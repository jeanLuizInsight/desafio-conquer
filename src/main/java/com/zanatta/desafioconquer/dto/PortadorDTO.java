package com.zanatta.desafioconquer.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para object Portador
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@XmlRootElement
public class PortadorDTO {

	@JsonProperty("codigoFormatado") private String codigoFormatado;
	@JsonProperty("nome") private String nome;

	public String getCodigoFormatado() {
		return this.codigoFormatado;
	}

	public String getNome() {
		return this.nome;
	}

	public void setCodigoFormatado(final String codigoFormatado) {
		this.codigoFormatado = codigoFormatado;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

}
