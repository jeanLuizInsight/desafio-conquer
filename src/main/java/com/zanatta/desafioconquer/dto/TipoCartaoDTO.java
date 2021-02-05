package com.zanatta.desafioconquer.dto;

/**
 * DTO para object TipoCartao
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
public class TipoCartaoDTO {

	private Long codigo;
	private String descricao;
	private float id;

	public Long getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public float getId() {
		return this.id;
	}

	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public void setId(final float id) {
		this.id = id;
	}

}
