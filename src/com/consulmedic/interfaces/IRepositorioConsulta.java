package com.consulmedic.interfaces;

import java.util.List;

import com.consulmedic.model.*;

public interface IRepositorioConsulta {
	
	public boolean cadastrar(Consulta consulta);

	public boolean editar(Consulta consulta);

	public boolean cancelar(Consulta consulta);

	public List<Consulta> listaConsultas();
	
	public List<Consulta> listaConsultas(Paciente paciente);

	public List<Consulta> listaConsultasPorMedico(Medico medico);
}
