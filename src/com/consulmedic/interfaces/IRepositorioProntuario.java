package com.consulmedic.interfaces;

import java.util.List;

import com.consulmedic.model.*;

public interface IRepositorioProntuario {
	public boolean salvaProntuario(Prontuario prontuario);
	public boolean deletarPacientePorCPF(String cpf);
	public List<Paciente> listarPacientes();
	public boolean alteraPaciente(Paciente paciente);

}
