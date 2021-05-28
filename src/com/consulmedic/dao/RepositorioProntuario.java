package com.consulmedic.dao;

import java.util.List;

import com.consulmedic.interfaces.IRepositorioProntuario;
import com.consulmedic.model.*;


public class RepositorioProntuario implements IRepositorioProntuario{
	Prontuario prontuarioPaciente;
	public RepositorioProntuario() {
		prontuarioPaciente = new Prontuario();
	}

	@Override
	public void inserirDescricaoProntuario() {
		
		
	}

	@Override
	public void visualizarProntuario(Paciente paciente) {
		
	}

	@Override
	public void setProntuario(Prontuario prontuario) {
		this.prontuarioPaciente = prontuario;
	}

	@Override
	public List<Descricao> listaDescricoes(Paciente paciente) {
		return paciente.getProntuarioPaciente().getDescricaoConsultas();
	}

}
