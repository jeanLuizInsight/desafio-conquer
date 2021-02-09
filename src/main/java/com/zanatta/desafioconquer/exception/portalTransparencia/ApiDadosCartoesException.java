package com.zanatta.desafioconquer.exception.portalTransparencia;

/**
 * Classe de exception para uso da API de dados endpoint cartões
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 09/02/2021
 */
public class ApiDadosCartoesException extends Exception {

	private static final long serialVersionUID = 6467414906224547784L;

	public ApiDadosCartoesException() {
		super();
	}

	public ApiDadosCartoesException(final String message) {
		super(message);
	}

}
