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
		
		return false;
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
		// TODO Auto-generated method stub
		return null;
	}

}
