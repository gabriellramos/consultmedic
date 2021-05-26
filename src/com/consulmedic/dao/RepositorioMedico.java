package com.consulmedic.dao;

import java.util.ArrayList;
import java.util.List;

import com.consulmedic.interfaces.*;
import com.consulmedic.model.*;

public class RepositorioMedico implements IRepositorioMedico {
	
	List<Medico> listaMedicos = new ArrayList<>();
	
	
	@Override
	public boolean salvaMedico(Medico medico) {
		try {
			boolean cadastrado = false;
			for (Medico f : listaMedicos) {
				if (medico.getCpf() == f.getCpf()) 
					cadastrado = true;
				else
					cadastrado = false;
			}
			if (!cadastrado)
				listaMedicos.add(medico);

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean deletarMedicoPorCPF(String cpf) {
		for (Medico medico: listaMedicos) {
			if (medico.getCpf() == cpf) {
				listaMedicos.remove(medico);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Medico> listarMedicos() {
		// TODO Auto-generated method stub
		return this.listaMedicos;
	}

	@Override
	public boolean alteraMedico(Medico medico) {
		for (Medico f: listaMedicos) {
			if (medico.getCpf() == f.getCpf()) {
				listaMedicos.remove(f);
				listaMedicos.add(medico);
				return true;
			}
		}
		return false;
	}
	

}
