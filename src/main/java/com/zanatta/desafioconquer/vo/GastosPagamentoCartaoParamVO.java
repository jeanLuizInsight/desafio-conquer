package com.zanatta.desafioconquer.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

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
	@Pattern(regexp = "^(0[1-9]{1}|1[0-2]{1})/\\d{4}$", message = "{gastosPagamentoCartaoParamVO.mesExtratoInicio.pattern}")
	public String getMesExtratoInicio() {
		return mesExtratoInicio;
	}

	@NotEmpty(message = "{gastosPagamentoCartaoParamVO.mesExtratoFim.empty}")
	@Pattern(regexp = "^(0[1-9]{1}|1[0-2]{1})/\\d{4}$", message = "{gastosPagamentoCartaoParamVO.mesExtratoFim.pattern}")
	public String getMesExtratoFim() {
		return mesExtratoFim;
	}

	public LocalDate getDataTransacaoInicio() {
		return dataTransacaoInicio;
	}

	public LocalDate getDataTransacaoFim() {
		return dataTransacaoFim;
	}

	public Integer getTipoCartao() {
		return tipoCartao;
	}

	public String getCodigoOrgao() {
		return codigoOrgao;
	}

	public String getCpfPortador() {
		return cpfPortador;
	}

	public String getCpfCnpjFavorecido() {
		return cpfCnpjFavorecido;
	}

	public BigDecimal getValorDe() {
		return valorDe;
	}

	public BigDecimal getValorAte() {
		return valorAte;
	}

	public Integer getPagina() {
		return pagina;
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

	public static GastosPagamentoCartaoParam buildGastosPagamentoCartaoParam(GastosPagamentoCartaoParamVO vo) {
		GastosPagamentoCartaoParam param = new GastosPagamentoCartaoParam();
		param.setCodigoOrgao(vo.getCodigoOrgao());
		param.setCpfCnpjFavorecido(vo.getCpfCnpjFavorecido());
		param.setCpfPortador(vo.getCpfPortador());
		if (vo.getDataTransacaoFim() != null)  {
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
