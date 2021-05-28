package com.consulmedic.model;

import java.util.ArrayList;
import java.util.List;

public class Prontuario {
	
	private List<Descricao> descricaoConsultas;
	private String cpfPaciente;
	private String nome;

	public Prontuario() {}
	
	public Prontuario(String cpfString, String nome) {
		descricaoConsultas = new ArrayList<>();
		setNome(nome);
		setCpfPaciente(cpfString);
		System.out.println("Criação do prontuário do paciente - " + getNome() + "\n");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public List<Descricao> getDescricaoConsultas() {
		return descricaoConsultas;
	}

	public void setDescricaoConsultas(List<Descricao> descricaoConsultas) {
		this.descricaoConsultas = descricaoConsultas;
	}

}
