package com.consulmedic.model;

public class Funcionario extends Pessoa{
	private String nomeUsuario;
    private String senha;
    private boolean usuarioLogado;
    
    public Funcionario() {
    	super();
    	setTipoPessoa("funcionario");
    }
    
	@Override
	public void setCpf(String cpf) {
		// TODO Auto-generated method stub
		super.setCpf(cpf);
		setNomeUsuario();
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario() {
		this.nomeUsuario = this.getCpf();
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


	@Override
	public String toString() {
		String mensagem = "[usuario] = "+getNomeUsuario()+"\n"
						+ "[nome] = "+getNome()+"\n"
						+ "[senha] = "+getSenha()+"\n"
						+ "[tipoFuncionario] = "+getTipoPessoa();
		return mensagem;
	}
    
    
}
