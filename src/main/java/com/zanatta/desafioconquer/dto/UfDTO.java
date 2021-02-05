package com.zanatta.desafioconquer.dto;

/**
 * DTO para object UF
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
public class UfDTO {

	private String nome;
	private String sigla;

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
