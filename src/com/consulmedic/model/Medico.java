package com.consulmedic.model;

public class Medico extends Funcionario{
	private String crm;
	private String ufCrm;
	private String especialidade;
	
	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getUfCrm() {
		return ufCrm;
	}

	public void setUfCrm(String ufCrm) {
		this.ufCrm = ufCrm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	
	 
	 
	 
	 
}
