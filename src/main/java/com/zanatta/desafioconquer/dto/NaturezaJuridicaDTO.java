package com.zanatta.desafioconquer.dto;

/**
 * DTO para object NaturezaJuridica
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
public class NaturezaJuridicaDTO {

	private Long codigo;
	private String codigoTipo;
	private String descricao;
	private String descricaoTipo;

	public Long getCodigo() {
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

	public void setCodigo(final Long codigo) {
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
