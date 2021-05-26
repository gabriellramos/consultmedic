package com.consulmedic.model;

public class Paciente extends Pessoa {
	private String cartaoSus;
	private Prontuario prontuarioPaciente;
	private String dataRegistro;

	public Paciente() {
		super();
	}

	public Paciente(String nome, String endereco, String telefone, String cpf, String dataNascimento, int idade,
			String cartaoSus, String dataRegistro) {
		super.setCpf(cpf);
		super.setNome(nome);
		super.setDataNascimento(dataNascimento);
		super.setIdade(idade);
		super.setTelefone(telefone);
		super.setTipoPessoa("paciente");
		super.setEndereco(endereco);
		
		setCartaoSus(cartaoSus);
		
		prontuarioPaciente = new Prontuario(getCpf(), getNome());
	}

	public Prontuario getProntuarioPaciente() {
		return prontuarioPaciente;
	}

	public void setProntuarioPaciente(Prontuario prontuarioPaciente) {
		this.prontuarioPaciente = prontuarioPaciente;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getCartaoSus() {
		return cartaoSus;
	}

	public void setCartaoSus(String cartaoSus) {
		this.cartaoSus = cartaoSus;
	}

	@Override
	public String toString() {
		return "Paciente{" + "cartaoSus='" + cartaoSus + '\'' + ", nome='" + getNome() + '\'' + ", endereco='"
				+ getEndereco() + '\'' + ", telefone='" + getTelefone() + '\'' + ", cpf='" + getCpf() + '\''
				+ ", dataNascimento='" + getDataNascimento() + '\'' + ", idade=" + getIdade() + '\'' + ", tipo="
				+ getTipoPessoa() + '}';
	}

}
