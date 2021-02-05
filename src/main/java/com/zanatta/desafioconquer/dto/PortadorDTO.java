package com.zanatta.desafioconquer.dto;

/**
 * DTO para object Portador
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
public class PortadorDTO {

	private String codigoFormatado;
	private String nome;

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
