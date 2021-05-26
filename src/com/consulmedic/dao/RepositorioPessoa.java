package com.consulmedic.dao;

import java.util.ArrayList;
import java.util.List;

import com.consulmedic.interfaces.IRepositorioPessoa;
import com.consulmedic.model.*;

public class RepositorioPessoa implements IRepositorioPessoa{
	List<Pessoa> listaPessoas = new ArrayList<>();
	
	@Override
	public boolean salvaPessoa(Pessoa pessoa) {
		boolean cadastrado = false;
		try {
			for (Pessoa p : listaPessoas) {
				if(p.getCpf() == pessoa.getCpf()) {
					cadastrado = true;
				}
			}
			if (!cadastrado) {
				listaPessoas.add(pessoa);
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
		
	}

	@Override
	public boolean deletarPessoaPorCPF(String cpf) {
		
		for (Pessoa pessoa: listaPessoas) {
			if (pessoa.getCpf() == cpf) {
				listaPessoas.remove(pessoa);
				return true;
			}
		}

		return false;
	}

	@Override
	public List<Pessoa> listarPessoa() {
		// TODO Auto-generated method stub
		return this.listaPessoas;
		
	}

	@Override
	public boolean alteraPessoa(Pessoa pessoa) {
		for (Pessoa p: listaPessoas) {
			if (pessoa.getCpf() == p.getCpf()) {
				listaPessoas.remove(p);
				listaPessoas.add(pessoa);
				return true;
			}
		}
		return false;
	}

}
