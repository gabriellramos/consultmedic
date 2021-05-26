package com.consulmedic.interfaces;

import java.util.List;

import com.consulmedic.model.*;

public interface IRepositorioFuncionario {
	
	public boolean salvaFuncionario(Funcionario funcionario);
	public boolean deletarFuncionarioPorCPF(String cpf);
	public List<Funcionario> listarFuncionarios();
	public boolean alteraFuncionario(Funcionario funcionario);
	
	
	public boolean login(String username, String senha);
	public boolean deslogar(String username);
	
}
