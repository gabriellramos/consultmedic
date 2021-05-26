package com.consulmedic.dao;

import com.consulmedic.model.Administrador;

public class RepositorioAdministrador{
	Administrador adm;
	
	public RepositorioAdministrador() {
		adm = new Administrador();
	}

	public boolean inserirInfoClinica(String nomeClinica, String enderecoClinica, String telefoneClinica) {
		adm.setNomeClinica(nomeClinica);
		adm.setEnderecoClinica(enderecoClinica);
		adm.setTelefoneClinica(telefoneClinica);
		return true;
	}

	public boolean alterarInfoClinica(String nomeClinica, String enderecoClinica, String telefoneClinica) {
		adm.setNomeClinica(nomeClinica);
		adm.setEnderecoClinica(enderecoClinica);
		adm.setTelefoneClinica(telefoneClinica);
		return true;
	}

	@Override
	public String toString() {
		String mensagem = "[nomeClinica] = "+adm.getNomeClinica()+"\n"
						+ "[enderecoClinica] = "+adm.getEnderecoClinica()+"\n"
						+ "[telefoneClinica] = "+adm.getTelefoneClinica();
						
		return mensagem;
	}
	
	public void setAdministrador(Administrador adm) {
		this.adm = adm;
	}
}
