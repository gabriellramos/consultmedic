package com.consulmedic.dao;

import java.util.ArrayList;
import java.util.List;

import com.consulmedic.interfaces.IRepositorioConsulta;
import com.consulmedic.model.*;

public class RepositorioConsulta implements IRepositorioConsulta {
	List<Consulta> consultas;

	public RepositorioConsulta() {
		consultas = new ArrayList<>();
	}

	@Override
	public boolean cadastrar(Consulta consulta) {
		try {
			/*
			 * faz o agendamento verificando o horario da consulta escolhido. se o horário
			 * estiver ocupado, não será possível realizar o agendamento
			 */
			boolean horarioDisponivel = true;
			int id;
			for (Consulta c : listaConsultas()) {
				if (c.getDataConsulta() == consulta.getDataConsulta()) {
					horarioDisponivel = false;
				}
			}

			id = consultas.size() + 1;
			consulta.setIdConsulta(id);

			if (horarioDisponivel)
				consultas.add(consulta);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean editar(Consulta consulta) {
		boolean horarioDisponivel = true;
		
		for (Consulta c : listaConsultas()) {
			if (c.getDataConsulta() == consulta.getDataConsulta()) {
				horarioDisponivel = false;
				return horarioDisponivel;
			}
		}
		
		if(horarioDisponivel)
			consultas.get(consulta.getIdConsulta() - 1).setDataConsulta(consulta.getDataConsulta());
		
		return true;

	}

	@Override
	public boolean cancelar(Consulta consulta) {
		for (Consulta c : listaConsultas()) {
			if (c.getIdConsulta() == consulta.getIdConsulta()) {
				consultas.remove(consulta);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Consulta> listaConsultas() {
		return this.consultas;
	}

	@Override
	public List<Consulta> listaConsultas(Paciente paciente) {
		List<Consulta> consultasPaciente = new ArrayList<>();
		
		for (Consulta c : listaConsultas()) {
			if (c.getPaciente().getCpf() == paciente.getCpf()) {
				consultasPaciente.add(c);
			}
		}
		
		return consultasPaciente;
	}

	@Override
	public List<Consulta> listaConsultasPorMedico(Medico medico) {
		List<Consulta> consultasMedico = new ArrayList<>();
		
		for (Consulta c : listaConsultas()) {
			if (c.getMedico().getCpf() == medico.getCpf()) {
				consultasMedico.add(c);
			}
		}
		
		return consultasMedico;
	}

}
