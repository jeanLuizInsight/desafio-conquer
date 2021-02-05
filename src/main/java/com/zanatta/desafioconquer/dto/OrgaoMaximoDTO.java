package com.zanatta.desafioconquer.dto;

/**
 * DTO para object OrgaoMaximo
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
public class OrgaoMaximoDTO {

	private Long codigo;
	private String nome;
	private String sigla;

	public Long getCodigo() {
		return this.codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setSigla(final String sigla) {
		this.sigla = sigla;
	}

}
