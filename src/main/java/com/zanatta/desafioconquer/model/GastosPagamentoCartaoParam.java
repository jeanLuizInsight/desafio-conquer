package com.zanatta.desafioconquer.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.annotations.BatchSize;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entidade que representa um GastosPagamentoCartaoParam (parametros da busca para o WS da API).
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 09/02/2021
 */
@Entity
@Table(name = "GOSTOS_PAGAMENTO_CARTAO_PARAM")
@BatchSize(size = 100)
public class GastosPagamentoCartaoParam {

	private Long codigo;
	private String mesExtratoInicio;
	private String mesExtratoFim;
	@DateTimeFormat(pattern = "dd/MM/yyyy") private Date dataTransacaoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy") private Date dataTransacaoFim;
	private Integer tipoCartao;
	private String codigoOrgao;
	private String cpfPortador;
	private String cpfCnpjFavorecido;
	private BigDecimal valorDe;
	private BigDecimal valorAte;
	private Integer pagina;
	private List<GastoPorMunicipio> gastosPorMunicipio;
	private Integer version;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COD_GAS_PAG_CAR_PARAM")
	public Long getCodigo() {
		return this.codigo;
	}

	@Column(name = "MES_EXTRATO_INICIO")
	public String getMesExtratoInicio() {
		return this.mesExtratoInicio;
	}

	@Column(name = "MES_EXTRATO_FIM")
	public String getMesExtratoFim() {
		return this.mesExtratoFim;
	}

	@Column(name = "DATA_TRANSACAO_INICIO")
	public Date getDataTransacaoInicio() {
		return this.dataTransacaoInicio;
	}

	@Column(name = "DATA_TRANSACAO_FIM")
	public Date getDataTransacaoFim() {
		return this.dataTransacaoFim;
	}

	@Column(name = "TIPO_CARTAO")
	public Integer getTipoCartao() {
		return this.tipoCartao;
	}

	@Column(name = "CODIGO_ORGAO")
	public String getCodigoOrgao() {
		return this.codigoOrgao;
	}

	@Column(name = "CPF_PORTADOR")
	public String getCpfPortador() {
		return this.cpfPortador;
	}

	@Column(name = "CPF_CNPJ_FAVORECIDO")
	public String getCpfCnpjFavorecido() {
		return this.cpfCnpjFavorecido;
	}

	@Column(name = "VALOR_DE")
	public BigDecimal getValorDe() {
		return this.valorDe;
	}

	@Column(name = "VALOR_ATE")
	public BigDecimal getValorAte() {
		return this.valorAte;
	}

	@Column(name = "PAGINA")
	public Integer getPagina() {
		return this.pagina;
	}

	@OneToMany(mappedBy = "gastosPagamentoCartaoParam")
	public List<GastoPorMunicipio> getGastosPorMunicipio() {
		return this.gastosPorMunicipio;
	}

	@Version
	@Column(name = "VERSION")
	public Integer getVersion() {
		return this.version;
	}

	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
	}

	public void setMesExtratoInicio(final String mesExtratoInicio) {
		this.mesExtratoInicio = mesExtratoInicio;
	}

	public void setMesExtratoFim(final String mesExtratoFim) {
		this.mesExtratoFim = mesExtratoFim;
	}

	public void setDataTransacaoInicio(final Date dataTransacaoInicio) {
		this.dataTransacaoInicio = dataTransacaoInicio;
	}

	public void setDataTransacaoFim(final Date dataTransacaoFim) {
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

	public void setGastosPorMunicipio(final List<GastoPorMunicipio> gastosPorMunicipio) {
		this.gastosPorMunicipio = gastosPorMunicipio;
	}

	public void setVersion(final Integer version) {
		this.version = version;
	}

}
