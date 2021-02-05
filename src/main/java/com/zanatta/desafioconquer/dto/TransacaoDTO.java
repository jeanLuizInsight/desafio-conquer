package com.zanatta.desafioconquer.dto;

import java.math.BigDecimal;

/**
 * DTO para object Transacao
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
public class TransacaoDTO {

	private String dataTransacao;
	private EstabelecimentoDTO estabelecimento;
	private float id;
	private String mesExtrato;
	private PortadorDTO portador;
	private TipoCartaoDTO tipoCartao;
	private UnidadeGestoraDTO unidadeGestora;
	private BigDecimal valorTransacao;

	public String getDataTransacao() {
		return this.dataTransacao;
	}

	public EstabelecimentoDTO getEstabelecimento() {
		return this.estabelecimento;
	}

	public float getId() {
		return this.id;
	}

	public String getMesExtrato() {
		return this.mesExtrato;
	}

	public PortadorDTO getPortador() {
		return this.portador;
	}

	public TipoCartaoDTO getTipoCartao() {
		return this.tipoCartao;
	}

	public UnidadeGestoraDTO getUnidadeGestora() {
		return this.unidadeGestora;
	}

	public BigDecimal getValorTransacao() {
		return this.valorTransacao;
	}

	public void setDataTransacao(final String dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public void setEstabelecimento(final EstabelecimentoDTO estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public void setId(final float id) {
		this.id = id;
	}

	public void setMesExtrato(final String mesExtrato) {
		this.mesExtrato = mesExtrato;
	}

	public void setPortadorObject(final PortadorDTO portador) {
		this.portador = portador;
	}

	public void setTipoCartao(final TipoCartaoDTO tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

	public void setUnidadeGestora(final UnidadeGestoraDTO unidadeGestora) {
		this.unidadeGestora = unidadeGestora;
	}

	public void setValorTransacao(final BigDecimal valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

}
