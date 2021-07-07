package com.zanatta.desafioconquer.model;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import org.hibernate.annotations.BatchSize;

/**
 * Entidade que representa um GastoPorEstabelecimento.
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 07/07/2021
 */
@Entity
@Table(name = "GASTO_POR_ESTABELECIMENTO")
@BatchSize(size = 100)
public class GastoPorEstabelecimento {

	private Long codigo;
	private GastosPagamentoCartaoParam gastosPagamentoCartaoParam;
	private String cnpjFormatado;
	private String cpfFormatado;
	private String id;
	private String nome;
	private String nomeFantasiaReceita;
	private String numeroInscricaoSocial;
	private String razaoSocialReceita;
	private String tipo;
	private BigDecimal valorTotal;
	private Integer version;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COD_GAS_POR_EST")
	public Long getCodigo() {
		return this.codigo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_GAS_PAG_CAR_PARAM", nullable = false)
	public GastosPagamentoCartaoParam getGastosPagamentoCartaoParam() {
		return this.gastosPagamentoCartaoParam;
	}

	@Column(name = "CNPJ")
	public String getCnpjFormatado() {
		return this.cnpjFormatado;
	}

	@Column(name = "CPF")
	public String getCpfFormatado() {
		return this.cpfFormatado;
	}

	@Column(name = "ID")
	public String getId() {
		return this.id;
	}

	@Column(name = "NOME")
	public String getNome() {
		return this.nome;
	}

	@Column(name = "NOME_FANTASIA_RECEITA")
	public String getNomeFantasiaReceita() {
		return this.nomeFantasiaReceita;
	}

	@Column(name = "NUM_INSCRICAO_ESTADUAL")
	public String getNumeroInscricaoSocial() {
		return this.numeroInscricaoSocial;
	}

	@Column(name = "RAZAO_SOCIAL_RECEITA")
	public String getRazaoSocialReceita() {
		return this.razaoSocialReceita;
	}

	@Column(name = "TIPO")
	public String getTipo() {
		return this.tipo;
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

	public void setCnpjFormatado(final String cnpjFormatado) {
		this.cnpjFormatado = cnpjFormatado;
	}

	public void setCpfFormatado(final String cpfFormatado) {
		this.cpfFormatado = cpfFormatado;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setNomeFantasiaReceita(final String nomeFantasiaReceita) {
		this.nomeFantasiaReceita = nomeFantasiaReceita;
	}

	public void setNumeroInscricaoSocial(final String numeroInscricaoSocial) {
		this.numeroInscricaoSocial = numeroInscricaoSocial;
	}

	public void setRazaoSocialReceita(final String razaoSocialReceita) {
		this.razaoSocialReceita = razaoSocialReceita;
	}

	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	public void setValorTotal(final BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setVersion(final Integer version) {
		this.version = version;
	}

	@Transient
	public static String[] getFieldsToCsv() {
		final List<Field> fields = Arrays.asList(GastoPorEstabelecimento.class.getDeclaredFields());
		return fields.stream()
				.filter(fd -> !"codigo".equals(fd.getName())
						&& !"version".equals(fd.getName())
						&& !"gastosPagamentoCartaoParam".equals(fd.getName()))
				.map(Field::getName).toArray(String[]::new);
	}

	@Transient
	public static List<Object> getValuesToCsv(final GastoPorEstabelecimento gpm) {
		return Arrays.asList(gpm.getCnpjFormatado(),
				gpm.getCpfFormatado(),
				gpm.getId(),
				gpm.getNome(),
				gpm.getNomeFantasiaReceita(),
				gpm.getNumeroInscricaoSocial(),
				gpm.getRazaoSocialReceita(),
				gpm.getTipo(),
				gpm.getValorTotal());
	}

}
