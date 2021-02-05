package com.zanatta.desafioconquer.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para object Transacao
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@XmlRootElement
public class TransacaoDTO {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy") @JsonProperty("dataTransacao") private LocalDateTime dataTransacao;
	@JsonProperty("estabelecimento") private EstabelecimentoDTO estabelecimento;
	@JsonProperty("id") private float id;
	@JsonProperty("mesExtrato") private String mesExtrato;
	@JsonProperty("portador") private PortadorDTO portador;
	@JsonProperty("tipoCartao") private TipoCartaoDTO tipoCartao;
	@JsonProperty("unidadeGestora") private UnidadeGestoraDTO unidadeGestora;
	@JsonProperty("valorTransacao") private BigDecimal valorTransacao;

	public LocalDateTime getDataTransacao() {
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

	public void setDataTransacao(final LocalDateTime dataTransacao) {
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
