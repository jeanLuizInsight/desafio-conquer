package com.zanatta.desafioconquer.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.zanatta.desafioconquer.model.GastosPagamentoCartaoParam;

/**
 * VO para filtros de tela de consulta à API.
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
public class GastosPagamentoCartaoParamVO {

	private String mesExtratoInicio;
	private String mesExtratoFim;
	private LocalDate dataTransacaoInicio;
	private LocalDate dataTransacaoFim;
	private Integer tipoCartao;
	private String codigoOrgao;
	private String cpfPortador;
	private String cpfCnpjFavorecido;
	private BigDecimal valorDe;
	private BigDecimal valorAte;
	private Integer pagina;

	@NotEmpty(message = "{gastosPagamentoCartaoParamVO.mesExtratoInicio.empty}")
	public String getMesExtratoInicio() {
		return this.mesExtratoInicio;
	}

	@NotEmpty(message = "{gastosPagamentoCartaoParamVO.mesExtratoFim.empty}")
	public String getMesExtratoFim() {
		return this.mesExtratoFim;
	}

	public LocalDate getDataTransacaoInicio() {
		return this.dataTransacaoInicio;
	}

	public LocalDate getDataTransacaoFim() {
		return this.dataTransacaoFim;
	}

	public Integer getTipoCartao() {
		return this.tipoCartao;
	}

	public String getCodigoOrgao() {
		return this.codigoOrgao;
	}

	public String getCpfPortador() {
		return this.cpfPortador;
	}

	public String getCpfCnpjFavorecido() {
		return this.cpfCnpjFavorecido;
	}

	public BigDecimal getValorDe() {
		return this.valorDe;
	}

	public BigDecimal getValorAte() {
		return this.valorAte;
	}

	public Integer getPagina() {
		return this.pagina;
	}

	public void setMesExtratoInicio(final String mesExtratoInicio) {
		this.mesExtratoInicio = mesExtratoInicio;
	}

	public void setMesExtratoFim(final String mesExtratoFim) {
		this.mesExtratoFim = mesExtratoFim;
	}

	public void setDataTransacaoInicio(final LocalDate dataTransacaoInicio) {
		this.dataTransacaoInicio = dataTransacaoInicio;
	}

	public void setDataTransacaoFim(final LocalDate dataTransacaoFim) {
		this.dataTransacaoFim = dataTransacaoFim;
	}

	public void setTipoCartao(final Integer tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

	public void setCodigoOrgao(final String codigoOrgao) {
		this.codigoOrgao = codigoOrgao;
	}

	public void setCpfPortador(final String cpfPortador) {
		this.cpfPortador = cpfPortador;
	}

	public void setCpfCnpjFavorecido(final String cpfCnpjFavorecido) {
		this.cpfCnpjFavorecido = cpfCnpjFavorecido;
	}

	public void setValorDe(final BigDecimal valorDe) {
		this.valorDe = valorDe;
	}

	public void setValorAte(final BigDecimal valorAte) {
		this.valorAte = valorAte;
	}

	public void setPagina(final Integer pagina) {
		this.pagina = pagina;
	}

	public static GastosPagamentoCartaoParam buildGastosPagamentoCartaoParam(final GastosPagamentoCartaoParamVO vo) {
		final GastosPagamentoCartaoParam param = new GastosPagamentoCartaoParam();
		param.setCodigoOrgao(vo.getCodigoOrgao());
		param.setCpfCnpjFavorecido(vo.getCpfCnpjFavorecido());
		param.setCpfPortador(vo.getCpfPortador());
		if (vo.getDataTransacaoFim() != null) {
			param.setDataTransacaoFim(Date.from(vo.getDataTransacaoFim().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		}
		if (vo.getDataTransacaoInicio() != null) {
			param.setDataTransacaoInicio(Date.from(vo.getDataTransacaoInicio().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		}
		param.setMesExtratoFim(vo.getMesExtratoFim());
		param.setMesExtratoInicio(vo.getMesExtratoInicio());
		param.setPagina(vo.getPagina());
		param.setTipoCartao(vo.getTipoCartao());
		param.setValorAte(vo.getValorAte());
		param.setValorDe(vo.getValorDe());
		return param;
	}

}
