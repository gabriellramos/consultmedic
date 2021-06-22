package com.consulmedic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.consulmedic.factory.ConnectionFactory;
import com.consulmedic.interfaces.IRepositorioFuncionario;
import com.consulmedic.model.*;
import com.mysql.jdbc.Statement;

public class RepositorioFuncionario implements IRepositorioFuncionario {
	List<Funcionario> listaFuncionarios = new ArrayList<>();
	static Connection conexao;
	static ResultSet rs;

	@Override
	public boolean salvaFuncionario(Funcionario funcionario) {

		try {
			boolean cadastrado = false;
			conexao = new ConnectionFactory().createConnectionToPostgreSQL();
			// listaFuncionarios = listarFuncionarios();

			for (Funcionario f : listaFuncionarios) {

				if (funcionario.getCpf().compareTo(f.getCpf()) == 0) {

					cadastrado = true;
					break;
				} else
					cadastrado = false;

			}

			if (!cadastrado) {

				// mandar para o banco

				conexao = new ConnectionFactory().createConnectionToPostgreSQL();
				String sql = "INSERT INTO funcionario "
						+ "(cpf, endereco,telefone,nome,datanascimento,idade,tipopessoa,nomeusuario,senha, usuariologado)"
						+ "VALUES (?,?,?,?,?,?,?,?,?,?);";
				PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
				statement.setString(1, funcionario.getCpf());
				statement.setString(2, funcionario.getEndereco());
				statement.setString(3, funcionario.getTelefone());
				statement.setString(4, funcionario.getNome());
				statement.setString(5, funcionario.getDataNascimento());
				statement.setInt(6, funcionario.getIdade());
				statement.setString(7, funcionario.getTipoPessoa());
				statement.setString(8, funcionario.getNomeUsuario());
				statement.setString(9, funcionario.getSenha());
				statement.setBoolean(10, funcionario.isUsuarioLogado());

				statement.execute();
				conexao.close();
			}

		} catch (Exception e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}

		return true;
	}

	@Override
	public boolean deletarFuncionarioPorCPF(String cpf) {

		String sql = "DELETE FROM funcionario WHERE cpf = ?";
		try {
			listaFuncionarios = listarFuncionarios();

			for (Funcionario funcionario : listaFuncionarios)
				if (funcionario.getCpf().compareTo(cpf) == 0) {
					System.out.println("entrou");
					System.out.println("apagou funcionario");
					conexao = new ConnectionFactory().createConnectionToPostgreSQL();
					PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
					statement.setString(1, cpf);

					statement.execute();

					conexao.close();
					return true;
				}

		} catch (Exception e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
		}

		return false;
	}

	@Override
	public List<Funcionario> listarFuncionarios() {
		try {
			listaFuncionarios.clear();
			conexao = new ConnectionFactory().createConnectionToPostgreSQL();
			String sql = "SELECT * FROM funcionario";
			PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
			rs = statement.executeQuery();
			conexao.close();
			while (rs.next()) {
				Funcionario f = new Funcionario();
				f.setCpf(rs.getString("cpf"));
				f.setEndereco(rs.getString("endereco"));
				f.setTelefone(rs.getString("telefone"));
				f.setNome(rs.getString("nome"));
				f.setDataNascimento(rs.getString("datanascimento"));
				f.setIdade(rs.getInt("idade"));
				f.setSenha(rs.getString("senha"));
				f.setUsuarioLogado(rs.getBoolean("usuariologado"));

				listaFuncionarios.add(f);
			}
		} catch (Exception e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
		}
		return this.listaFuncionarios;
	}

	@Override
	public boolean alteraFuncionario(Funcionario funcionario, String cpf) {
		listaFuncionarios = listarFuncionarios();
		PreparedStatement statement;

		for (Funcionario f : listaFuncionarios) {
			if (cpf.compareTo(f.getCpf()) == 0) {
				try {
					conexao = new ConnectionFactory().createConnectionToPostgreSQL();
					String sql = "UPDATE funcionario" + "SET endereco = ?,telefone = ?,"
							+ "nome = ? ,datanascimento = ?," + "idade = ?, tipopessoa = ?,"
							+ "nomeusuario = ?, senha = ?, usuariologado = ?, cpf = ?" + "WHERE cpf = ?;";

					statement = conexao.prepareStatement(sql);
					statement.setString(1, funcionario.getEndereco());
					statement.setString(2, funcionario.getTelefone());
					statement.setString(3, funcionario.getNome());
					statement.setString(4, funcionario.getDataNascimento());
					statement.setInt(5, funcionario.getIdade());
					statement.setString(6, funcionario.getTipoPessoa());
					statement.setString(7, funcionario.getNomeUsuario());
					statement.setString(8, funcionario.getSenha());
					statement.setBoolean(9, funcionario.isUsuarioLogado());
					statement.setString(10, funcionario.getCpf());
					statement.setString(11, cpf);

					statement.execute();
					conexao.close();

				} catch (Exception e) {
					Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean login(String username, String senha) {
		listaFuncionarios = listarFuncionarios();
		for (Funcionario f : listaFuncionarios) {
			if (f.getCpf().compareTo(username) == 0 && f.getSenha().compareTo(senha) == 0) {
				try {
					conexao = new ConnectionFactory().createConnectionToPostgreSQL();
					String sql = "UPDATE funcionario set usuariologado = ? WHERE nomeusuario = ?;";
					PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
					statement.setBoolean(1, true);
					statement.setString(2, username);
					statement.execute();
					conexao.close();
					return true;
				} catch (Exception e) {
					Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
				}

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
