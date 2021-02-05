package com.zanatta.desafioconquer.dto;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para object UnidadeGestora
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@XmlRootElement
public class UnidadeGestoraDTO {

	@JsonProperty("codigo") private String codigo;
	@JsonProperty("nome") private String nome;
	@JsonProperty("orgaoVinculado") OrgaoVinculadoDTO orgaoVinculado;

	public String getCodigo() {
		return this.codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public OrgaoVinculadoDTO getOrgaoVinculado() {
		return this.orgaoVinculado;
	}

	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setOrgaoVinculado(final OrgaoVinculadoDTO orgaoVinculado) {
		this.orgaoVinculado = orgaoVinculado;
	}

}
