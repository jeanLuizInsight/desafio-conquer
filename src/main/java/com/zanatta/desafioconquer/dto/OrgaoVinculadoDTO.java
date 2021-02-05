package com.zanatta.desafioconquer.dto;

/**
 * DTO para object OrgaoVinculado
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 05/02/2021
 */
public class OrgaoVinculadoDTO {

	private String cnpj;
	private String codigoSIAFI;
	private String descricaoPoder;
	private String nome;
	private OrgaoMaximoDTO orgaoMaximo;
	private String sigla;

	public String getCnpj() {
		return this.cnpj;
	}

	public String getCodigoSIAFI() {
		return this.codigoSIAFI;
	}

	public String getDescricaoPoder() {
		return this.descricaoPoder;
	}

	public String getNome() {
		return this.nome;
	}

	public OrgaoMaximoDTO getOrgaoMaximo() {
		return this.orgaoMaximo;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setCnpj(final String cnpj) {
		this.cnpj = cnpj;
	}

	public void setCodigoSIAFI(final String codigoSIAFI) {
		this.codigoSIAFI = codigoSIAFI;
	}

	public void setDescricaoPoder(final String descricaoPoder) {
		this.descricaoPoder = descricaoPoder;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setOrgaoMaximo(final OrgaoMaximoDTO orgaoMaximo) {
		this.orgaoMaximo = orgaoMaximo;
	}

	public void setSigla(final String sigla) {
		this.sigla = sigla;
	}

}
