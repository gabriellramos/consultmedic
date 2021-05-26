package com.consulmedic.interfaces;

import java.util.List;

import com.consulmedic.model.*;

public interface IRepositorioMedico {
	
	public boolean salvaMedico(Medico medico);
	public boolean deletarMedicoPorCPF(String cpf);
	public List<Medico> listarMedicos();
	public boolean alteraMedico(Medico medico);
	
	
}
