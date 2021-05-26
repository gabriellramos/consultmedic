package com.consulmedic.model;

public class Descricao {
	private String cpfMedicoResponsavel;
	private String nomeMedico;
	private String dataDescricao;
	private String descricao;

	public Descricao() {

	}

	public String getCpfMedicoResponsavel() {
		return cpfMedicoResponsavel;
	}

	public void setCpfMedicoResponsavel(String cpfMedicoResponsavel) {
		this.cpfMedicoResponsavel = cpfMedicoResponsavel;
	}

	public String getDataDescricao() {
		return dataDescricao;
	}

	public void setDataDescricao(String dataDescricao) {
		this.dataDescricao = dataDescricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

}
