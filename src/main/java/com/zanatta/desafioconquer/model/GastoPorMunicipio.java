package com.zanatta.desafioconquer.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.annotations.BatchSize;

/**
 * Entidade que representa um GastoPorMunicipio.
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 09/02/2021
 */
@Entity
@Table(name = "GOSTO_POR_MUNICIPIO")
@BatchSize(size = 100)
public class GastoPorMunicipio {

	private Long codigo;
	private GastosPagamentoCartaoParam gastosPagamentoCartaoParam;
	private String codigoIBGE;
	private String nomeIBGE;
	private String pais;
	private String ufNome;
	private String ufSigla;
	private BigDecimal valorTotal;
	private Integer version;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COD_GAS_POR_MUN")
	public Long getCodigo() {
		return this.codigo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_GAS_PAG_CAR_PARAM", nullable = false)
	public GastosPagamentoCartaoParam getGastosPagamentoCartaoParam() {
		return this.gastosPagamentoCartaoParam;
	}

	@Column(name = "CODIGO_IBGE")
	public String getCodigoIBGE() {
		return this.codigoIBGE;
	}

	@Column(name = "NOME_IBGE")
	public String getNomeIBGE() {
		return this.nomeIBGE;
	}

	@Column(name = "PAIS")
	public String getPais() {
		return this.pais;
	}

	@Column(name = "UF_NOME")
	public String getUfNome() {
		return this.ufNome;
	}

	@Column(name = "UF_SIGLA")
	public String getUfSigla() {
		return this.ufSigla;
	}

	@Column(name = "VALOR_TOTAL")
	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	@Version
	@Column(name = "VERSION")
	public Integer getVersion() {
		return this.version;
	}

	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
	}

	public void setGastosPagamentoCartaoParam(final GastosPagamentoCartaoParam gastosPagamentoCartaoParam) {
		this.gastosPagamentoCartaoParam = gastosPagamentoCartaoParam;
	}

	public void setCodigoIBGE(final String codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	public void setNomeIBGE(final String nomeIBGE) {
		this.nomeIBGE = nomeIBGE;
	}

	public void setPais(final String pais) {
		this.pais = pais;
	}

	public void setUfNome(final String ufNome) {
		this.ufNome = ufNome;
	}

	public void setUfSigla(final String ufSigla) {
		this.ufSigla = ufSigla;
	}

	public void setValorTotal(final BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setVersion(final Integer version) {
		this.version = version;
	}

}
