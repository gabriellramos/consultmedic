package com.consulmedic.dao;

import java.util.ArrayList;
import java.util.List;

import com.consulmedic.interfaces.IRepositorioPaciente;
import com.consulmedic.model.Paciente;


public class RepositorioPaciente implements IRepositorioPaciente{
	
	List<Paciente> listaPacientes = new ArrayList<>();
	RepositorioPessoa repPessoas = new RepositorioPessoa();
	
	

	@Override
	public boolean salvaPaciente(Paciente paciente) {
		try {
			boolean cadastrado = false;
			
			for (Paciente p : listaPacientes) {
				if(p.getCpf() == paciente.getCpf()) {
					cadastrado = true;
				}
			}
			if (!cadastrado)
				listaPacientes.add(paciente);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@Override
	public boolean deletarPacientePorCPF(String cpf) {
		for (Paciente paciente: listaPacientes) {
			if (paciente.getCpf() == cpf) {
				listaPacientes.remove(paciente);
				return true;
			}
		}

		return false;
	}

	@Override
	public List<Paciente> listarPacientes() {
		// TODO Auto-generated method stub
		return this.listaPacientes;
	}
	
	@Override
	public boolean alteraPaciente(Paciente paciente) {
		for (Paciente p: listaPacientes) {
			if (paciente.getCpf() == p.getCpf()) {
				listaPacientes.remove(p);
				listaPacientes.add(paciente);
				return true;
			}
		}
		return false;
	}
}
