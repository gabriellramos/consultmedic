package com.consulmedic.interfaces;

import java.util.List;

import com.consulmedic.model.*;

public interface IRepositorioProntuario {
	public void inserirDescricaoProntuario();

	public void visualizarProntuario(Paciente paciente);

	public void setProntuario(Prontuario prontuario);

	public List<Descricao> listaDescricoes(Paciente paciente);

}
