package com.consulmedic.model;

public class Administrador extends Funcionario{
	private String nomeClinica;
    private String enderecoClinica;
    private String telefoneClinica;
    
	public Administrador() {
		super();
		setTipoPessoa("administrador");
	}
	
	public String getNomeClinica() {
		return nomeClinica;
	}
	public void setNomeClinica(String nomeClinica) {
		this.nomeClinica = nomeClinica;
	}
	public String getEnderecoClinica() {
		return enderecoClinica;
	}
	public void setEnderecoClinica(String enderecoClinica) {
		this.enderecoClinica = enderecoClinica;
	}
	public String getTelefoneClinica() {
		return telefoneClinica;
	}
	public void setTelefoneClinica(String telefoneClinica) {
		this.telefoneClinica = telefoneClinica;
	}
    
    
}
