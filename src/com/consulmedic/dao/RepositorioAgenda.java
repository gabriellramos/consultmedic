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
			boolean horarioDisponivel = true;
			for (Agenda a : agendamentos()) {
				if (a.getDataConsulta() == agenda.getDataConsulta()) {
					horarioDisponivel = false;
					return horarioDisponivel;
				}	
			}
			if (horarioDisponivel)
				agendamentos.add(agenda);
			
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean editar(Agenda agenda) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(Agenda agenda) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Agenda> agendamentos() {
		return this.agendamentos;
	}

}
