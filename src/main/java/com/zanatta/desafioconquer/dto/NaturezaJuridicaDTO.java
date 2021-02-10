package com.zanatta.desafioconquer.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para object NaturezaJuridica
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@XmlRootElement
public class NaturezaJuridicaDTO {

	@JsonProperty("codigo") private String codigo;
	@JsonProperty("codigoTipo") private String codigoTipo;
	@JsonProperty("descricao") private String descricao;
	@JsonProperty("descricaoTipo") private String descricaoTipo;

	public String getCodigo() {
		return this.codigo;
	}

	public String getCodigoTipo() {
		return this.codigoTipo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public String getDescricaoTipo() {
		return this.descricaoTipo;
	}

	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	public void setCodigoTipo(final String codigoTipo) {
		this.codigoTipo = codigoTipo;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public void setDescricaoTipo(final String descricaoTipo) {
		this.descricaoTipo = descricaoTipo;
	}

}
