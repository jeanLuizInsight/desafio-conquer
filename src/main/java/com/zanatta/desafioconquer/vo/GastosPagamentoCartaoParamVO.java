package com.zanatta.desafioconquer.vo;

import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * VO para filtros de tela de consulta à API.
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
public class GastosPagamentoCartaoParamVO {

	private String mesExtratoInicio;
	private String mesExtratoFim;
	private String dataTransacaoInicio;
	private String dataTransacaoFim;
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
		return this.mesExtratoInicio;
	}

	@NotEmpty(message = "{gastosPagamentoCartaoParamVO.mesExtratoFim.empty}")
	@Pattern(regexp = "^(0[1-9]{1}|1[0-2]{1})/\\d{4}$", message = "{gastosPagamentoCartaoParamVO.mesExtratoFim.pattern}")
	public String getMesExtratoFim() {
		return this.mesExtratoFim;
	}

	public String getDataTransacaoInicio() {
		return this.dataTransacaoInicio;
	}

	public String getDataTransacaoFim() {
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

	public void setDataTransacaoInicio(final String dataTransacaoInicio) {
		this.dataTransacaoInicio = dataTransacaoInicio;
	}

	public void setDataTransacaoFim(final String dataTransacaoFim) {
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

}
