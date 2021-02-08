package com.zanatta.desafioconquer.dto;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para object Estabelecimento
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
@XmlRootElement
public class EstabelecimentoDTO {

	@JsonProperty("cnae") private CnaeDTO cnae;
	@JsonProperty("codigoFormatado") private String codigoFormatado;
	@JsonProperty("complementoEndereco") private String complementoEndereco;
	@JsonProperty("dataAbertura") private String dataAbertura;
	@JsonProperty("descricaoLogradouro") private String descricaoLogradouro;
	@JsonProperty("enderecoEletronico") private String enderecoEletronico;
	@JsonProperty("localidadePessoa") private String localidadePessoa;
	@JsonProperty("municipio") private MunicipioDTO municipio;
	@JsonProperty("naturezaJuridica") private NaturezaJuridicaDTO naturezaJuridica;
	@JsonProperty("nome") private String nome;
	@JsonProperty("nomeBairro") private String nomeBairro;
	@JsonProperty("nomeFantasiaReceita") private String nomeFantasiaReceita;
	@JsonProperty("numeroCEP") private String numeroCEP;
	@JsonProperty("numeroEndereco") private String numeroEndereco;
	@JsonProperty("numeroInscricaoSocial") private String numeroInscricaoSocial;
	@JsonProperty("numeroTelefone") private String numeroTelefone;
	@JsonProperty("razaoSocialReceita") private String razaoSocialReceita;
	@JsonProperty("tipoCodigo") private String tipoCodigo;
	@JsonProperty("tipoPessoa") private String tipoPessoa;

	public CnaeDTO getCnae() {
		return this.cnae;
	}

	public String getCodigoFormatado() {
		return this.codigoFormatado;
	}

	public String getComplementoEndereco() {
		return this.complementoEndereco;
	}

	public String getDataAbertura() {
		return this.dataAbertura;
	}

	public String getDescricaoLogradouro() {
		return this.descricaoLogradouro;
	}

	public String getEnderecoEletronico() {
		return this.enderecoEletronico;
	}

	public String getLocalidadePessoa() {
		return this.localidadePessoa;
	}

	public MunicipioDTO getMunicipio() {
		return this.municipio;
	}

	public NaturezaJuridicaDTO getNaturezaJuridica() {
		return this.naturezaJuridica;
	}

	public String getNome() {
		return this.nome;
	}

	public String getNomeBairro() {
		return this.nomeBairro;
	}

	public String getNomeFantasiaReceita() {
		return this.nomeFantasiaReceita;
	}

	public String getNumeroCEP() {
		return this.numeroCEP;
	}

	public String getNumeroEndereco() {
		return this.numeroEndereco;
	}

	public String getNumeroInscricaoSocial() {
		return this.numeroInscricaoSocial;
	}

	public String getNumeroTelefone() {
		return this.numeroTelefone;
	}

	public String getRazaoSocialReceita() {
		return this.razaoSocialReceita;
	}

	public String getTipoCodigo() {
		return this.tipoCodigo;
	}

	public String getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setCnae(final CnaeDTO cnae) {
		this.cnae = cnae;
	}

	public void setCodigoFormatado(final String codigoFormatado) {
		this.codigoFormatado = codigoFormatado;
	}

	public void setComplementoEndereco(final String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public void setDataAbertura(final String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public void setDescricaoLogradouro(final String descricaoLogradouro) {
		this.descricaoLogradouro = descricaoLogradouro;
	}

	public void setEnderecoEletronico(final String enderecoEletronico) {
		this.enderecoEletronico = enderecoEletronico;
	}

	public void setLocalidadePessoa(final String localidadePessoa) {
		this.localidadePessoa = localidadePessoa;
	}

	public void setMunicipio(final MunicipioDTO municipio) {
		this.municipio = municipio;
	}

	public void setNaturezaJuridica(final NaturezaJuridicaDTO naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setNomeBairro(final String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public void setNomeFantasiaReceita(final String nomeFantasiaReceita) {
		this.nomeFantasiaReceita = nomeFantasiaReceita;
	}

	public void setNumeroCEP(final String numeroCEP) {
		this.numeroCEP = numeroCEP;
	}

	public void setNumeroEndereco(final String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public void setNumeroInscricaoSocial(final String numeroInscricaoSocial) {
		this.numeroInscricaoSocial = numeroInscricaoSocial;
	}

	public void setNumeroTelefone(final String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public void setRazaoSocialReceita(final String razaoSocialReceita) {
		this.razaoSocialReceita = razaoSocialReceita;
	}

	public void setTipoCodigo(final String tipoCodigo) {
		this.tipoCodigo = tipoCodigo;
	}

	public void setTipoPessoa(final String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

}
