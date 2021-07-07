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

	@JsonProperty("cpfFormatado") private String cpfFormatado;
	@JsonProperty("nis") private String nis;
	@JsonProperty("nome") private String nome;

	public String getCpfFormatado() {
		return this.cpfFormatado;
	}

	public String getNis() {
		return this.nis;
	}

	public String getNome() {
		return this.nome;
	}

	public void setCpfFormatado(final String cpfFormatado) {
		this.cpfFormatado = cpfFormatado;
	}

	public void setNis(final String nis) {
		this.nis = nis;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

}
