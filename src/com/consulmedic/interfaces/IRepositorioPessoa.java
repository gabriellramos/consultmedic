package com.consulmedic.interfaces;

import java.util.List;

import com.consulmedic.model.*;

public interface IRepositorioPessoa {
	public boolean salvaPessoa(Pessoa pessoa);
	public boolean deletarPessoaPorCPF(String cpf);
	public List<Pessoa> listarPessoa();
	public boolean alteraPessoa(Pessoa pessoa);
}
