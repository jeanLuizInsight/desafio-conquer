package com.zanatta.desafioconquer.dto;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para object Estabelecimento
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@XmlRootElement
public class EstabelecimentoDTO {

	@JsonProperty("cnpjFormatado") private String cnpjFormatado;
	@JsonProperty("cpfFormatado") private String cpfFormatado;
	@JsonProperty("id") private String id;
	@JsonProperty("nome") private String nome;
	@JsonProperty("nomeFantasiaReceita") private String nomeFantasiaReceita;
	@JsonProperty("numeroInscricaoSocial") private String numeroInscricaoSocial;
	@JsonProperty("razaoSocialReceita") private String razaoSocialReceita;
	@JsonProperty("tipo") private String tipo;

	public String getCnpjFormatado() {
		return this.cnpjFormatado;
	}

	public String getCpfFormatado() {
		return this.cpfFormatado;
	}

	public String getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getNomeFantasiaReceita() {
		return this.nomeFantasiaReceita;
	}

	public String getNumeroInscricaoSocial() {
		return this.numeroInscricaoSocial;
	}

	public String getRazaoSocialReceita() {
		return this.razaoSocialReceita;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setCnpjFormatado(final String cnpjFormatado) {
		this.cnpjFormatado = cnpjFormatado;
	}

	public void setCpfFormatado(final String cpfFormatado) {
		this.cpfFormatado = cpfFormatado;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setNomeFantasiaReceita(final String nomeFantasiaReceita) {
		this.nomeFantasiaReceita = nomeFantasiaReceita;
	}

	public void setNumeroInscricaoSocial(final String numeroInscricaoSocial) {
		this.numeroInscricaoSocial = numeroInscricaoSocial;
	}

	public void setRazaoSocialReceita(final String razaoSocialReceita) {
		this.razaoSocialReceita = razaoSocialReceita;
	}

	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

}
