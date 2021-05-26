package com.consulmedic.interfaces;

import java.util.List;

import com.consulmedic.model.*;

public interface IRepositorioPaciente {
	public boolean salvaPaciente(Paciente paciente);
	public boolean deletarPacientePorCPF(String cpf);
	public List<Paciente> listarPacientes();
	public boolean alteraPaciente(Paciente paciente);
}
