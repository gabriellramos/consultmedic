package com.consulmedic.model;

import java.sql.Timestamp;

public class Consulta {
	private int idConsulta;
	private Paciente paciente;
	private Medico medico;
	private Timestamp dataAgendamento;
	private Timestamp dataConsulta;
	private boolean consultaRealizada;
	private String turnoConsulta;

	public Consulta() {
		this.consultaRealizada = false;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Timestamp getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Timestamp dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Timestamp getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Timestamp dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public boolean isConsultaRealizada() {
		return consultaRealizada;
	}

	public void setConsultaRealizada(boolean consultaRealizada) {
		this.consultaRealizada = consultaRealizada;
	}

	public String getTurnoConsulta() {
		return turnoConsulta;
	}

	public void setTurnoConsulta(String turnoConsulta) {
		this.turnoConsulta = turnoConsulta;
	}

}
