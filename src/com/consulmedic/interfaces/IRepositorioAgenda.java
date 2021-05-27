package com.consulmedic.interfaces;

import java.util.List;

import com.consulmedic.model.Agenda;
import com.consulmedic.model.Consulta;

public interface IRepositorioAgenda {
	public boolean cadastrar(Agenda agenda);

	public boolean editar(Agenda agenda);

	public boolean excluir(Agenda agenda);

	public List<Agenda> agendamentos();

}
