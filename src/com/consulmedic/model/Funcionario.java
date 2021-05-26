package com.consulmedic.model;

public class Funcionario extends Pessoa{
	private String nomeUsuario;
    private String senha;
    private boolean usuarioLogado;
    private int matricula;
    
    public Funcionario() {
    	super();
    	setTipoPessoa("funcionario");
    }
      
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(boolean usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
    
    
}
