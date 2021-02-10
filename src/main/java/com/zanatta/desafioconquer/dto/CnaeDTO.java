package com.zanatta.desafioconquer.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para object Cnae
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@XmlRootElement
public class CnaeDTO {

	@JsonProperty("classe") private String classe;
	@JsonProperty("codigoClasse") private String codigoClasse;
	@JsonProperty("codigoDivisao") private String codigoDivisao;
	@JsonProperty("codigoGrupo") private String codigoGrupo;
	@JsonProperty("codigoSecao") private String codigoSecao;
	@JsonProperty("codigoSubclasse") private String codigoSubclasse;
	@JsonProperty("divisao") private String divisao;
	@JsonProperty("grupo") private String grupo;
	@JsonProperty("secao") private String secao;
	@JsonProperty("subclasse") private String subclasse;

	public String getClasse() {
		return this.classe;
	}

	public String getCodigoClasse() {
		return this.codigoClasse;
	}

	public String getCodigoDivisao() {
		return this.codigoDivisao;
	}

	public String getCodigoGrupo() {
		return this.codigoGrupo;
	}

	public String getCodigoSecao() {
		return this.codigoSecao;
	}

	public String getCodigoSubclasse() {
		return this.codigoSubclasse;
	}

	public String getDivisao() {
		return this.divisao;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public String getSecao() {
		return this.secao;
	}

	public String getSubclasse() {
		return this.subclasse;
	}

	public void setClasse(final String classe) {
		this.classe = classe;
	}

	public void setCodigoClasse(final String codigoClasse) {
		this.codigoClasse = codigoClasse;
	}

	public void setCodigoDivisao(final String codigoDivisao) {
		this.codigoDivisao = codigoDivisao;
	}

	public void setCodigoGrupo(final String codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	public void setCodigoSecao(final String codigoSecao) {
		this.codigoSecao = codigoSecao;
	}

	public void setCodigoSubclasse(final String codigoSubclasse) {
		this.codigoSubclasse = codigoSubclasse;
	}

	public void setDivisao(final String divisao) {
		this.divisao = divisao;
	}

	public void setGrupo(final String grupo) {
		this.grupo = grupo;
	}

	public void setSecao(final String secao) {
		this.secao = secao;
	}

	public void setSubclasse(final String subclasse) {
		this.subclasse = subclasse;
	}

}
