package com.consulmedic.dao;

import java.util.ArrayList;
import java.util.List;

import com.consulmedic.interfaces.IRepositorioAgenda;
import com.consulmedic.model.*;

public class RepositorioAgenda implements IRepositorioAgenda {
	List<Agenda> agendamentos;

	public RepositorioAgenda() {
		agendamentos = new ArrayList<>();
	}

	@Override
	public boolean cadastrar(Agenda agenda) {
		try {
			/*
			 * faz o agendamento verificando o horario da consulta escolhido. se o horário
			 * estiver ocupado, não será possível realizar o agendamento
			 */
			boolean horarioDisponivel = true;
			int id;
			for (Agenda a : agendamentos()) {
				if (a.getDataConsulta() == agenda.getDataConsulta()) {
					horarioDisponivel = false;
				}
			}

			id = agendamentos.size() + 1;
			agenda.setId(id);

			if (horarioDisponivel)
				agendamentos.add(agenda);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean editar(Agenda agenda) {
		boolean horarioDisponivel = true;
		for (Agenda a : agendamentos()) {
			if (a.getDataConsulta() == agenda.getDataConsulta()) {
				horarioDisponivel = false;
				return horarioDisponivel;
			}
		}
		if (horarioDisponivel) {
			agendamentos.get(agenda.getId() - 1).setDataConsulta(agenda.getDataConsulta());
		}
		return true;
	}

	@Override
	public boolean cancelar(Agenda agenda) {
		for (Agenda a : agendamentos()) {
			if (a.getId() == agenda.getId()) {
				agendamentos.remove(a);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Agenda> agendamentos() {
		return this.agendamentos;
	}

}
