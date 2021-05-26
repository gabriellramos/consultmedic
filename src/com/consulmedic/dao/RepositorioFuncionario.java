package com.consulmedic.dao;

import java.util.ArrayList;
import java.util.List;

import com.consulmedic.interfaces.IRepositorioFuncionario;
import com.consulmedic.model.*;

public class RepositorioFuncionario implements IRepositorioFuncionario {
	List<Funcionario> listaFuncionarios = new ArrayList<>();

	@Override
	public boolean salvaFuncionario(Funcionario funcionario) {

		try {
			boolean cadastrado = false;
			for (Funcionario f : listaFuncionarios) {
				if (funcionario.getCpf() == f.getCpf()) {
					cadastrado = true;
					break;
				} else
					cadastrado = false;
			}
			if (!cadastrado)
				listaFuncionarios.add(funcionario);

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean deletarFuncionarioPorCPF(String cpf) {
		for (Funcionario funcionario : listaFuncionarios) {
			if (funcionario.getCpf() == cpf) {
				listaFuncionarios.remove(funcionario);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Funcionario> listarFuncionarios() {
		// TODO Auto-generated method stub
		return this.listaFuncionarios;
	}

	@Override
	public boolean alteraFuncionario(Funcionario funcionario) {
		for (Funcionario f : listaFuncionarios) {
			if (funcionario.getCpf() == f.getCpf()) {
				listaFuncionarios.remove(f);
				listaFuncionarios.add(funcionario);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean login(String username, String senha) {
		for (Funcionario f : listaFuncionarios) {
			if (f.getCpf() == username && f.getSenha() == senha) {
				f.setUsuarioLogado(true);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deslogar(String username) {
		for (Funcionario f : listaFuncionarios) {
			if (f.getCpf() == username && f.isUsuarioLogado()) {
				f.setUsuarioLogado(false);
				return true;
			}
		}
		return false;
	}

}
