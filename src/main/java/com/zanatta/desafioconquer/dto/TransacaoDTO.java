package com.zanatta.desafioconquer.dto;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para object Transacao
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@XmlRootElement
public class TransacaoDTO {

	@JsonProperty("dataTransacao") private String dataTransacao;
	@JsonProperty("estabelecimento") private EstabelecimentoDTO estabelecimento;
	@JsonProperty("id") private String id;
	@JsonProperty("mesExtrato") private String mesExtrato;
	@JsonProperty("portador") private PortadorDTO portador;
	@JsonProperty("tipoCartao") private TipoCartaoDTO tipoCartao;
	@JsonProperty("unidadeGestora") private UnidadeGestoraDTO unidadeGestora;
	@JsonProperty("valorTransacao") private String valorTransacao;

	public String getDataTransacao() {
		return this.dataTransacao;
	}

	public EstabelecimentoDTO getEstabelecimento() {
		return this.estabelecimento;
	}

	public String getId() {
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

	public String getValorTransacao() {
		return this.valorTransacao;
	}

	public void setDataTransacao(final String dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public void setEstabelecimento(final EstabelecimentoDTO estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public void setId(final String id) {
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

	public void setValorTransacao(final String valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

}
