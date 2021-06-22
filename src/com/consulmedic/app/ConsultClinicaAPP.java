package com.consulmedic.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.consulmedic.dao.*;
import com.consulmedic.factory.ConnectionFactory;
import com.consulmedic.model.*;

public class ConsultClinicaAPP {

	public static Connection conexao;
	public static final RepositorioFuncionario repoFunc = new RepositorioFuncionario();
	public static final RepositorioMedico repoMedico = new RepositorioMedico();
	public static final RepositorioPaciente repoPaciente = new RepositorioPaciente();
	
	public static void main(String[] args) throws SQLException{
		
		Funcionario adm = new Administrador();
		
		inicializaSistema();
	}
	
	public static void inicializaSistema() throws SQLException{
		//inicializando sistema cadastrando administrador
		Administrador adm = new Administrador();
		ResultSet rs;
		conexao = new ConnectionFactory().createConnectionToPostgreSQL();
		
		adm.setNome("admin");
		adm.setCpf("00000000000");
		adm.setSenha("admin");
		
		
		System.out.println("Salvando funcionario tipo ADM");
		repoFunc.salvaFuncionario(adm);
		listarFuncionarios(repoFunc);
		adm.setCpf("02108343237");
		adm.setNome("Gabriel Ramos Nascimento");
		repoFunc.alteraFuncionario(adm,"00000000000");
		listarFuncionarios(repoFunc);
		
		//listarFuncionarios(repoFunc);
		/*
		String sql = "SELECT * FROM administrador;";
		
		try {
			PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
			
			statement.execute();
			System.out.println("FOi");
			rs = statement.executeQuery();
			
			conexao.close();
			System.out.println(rs.getRow());
			if (rs.getRow() == 0) {
				conexao = ConnectionFactory().createConnectionToPostgreSQL();
				
				sql = "INSERT INTO administrador (nome, cpf, senha, tipopessoa, usuariologado) VALUES (?,?,?,?,?);";
				statement = (PreparedStatement) conexao.prepareStatement(sql);
				statement.setString(1, adm.getNome());
				statement.setString(2, adm.getCpf());
				statement.setString(3, adm.getSenha());
				statement.setString(4,adm.getTipoPessoa());
				statement.setBoolean(5, false);
				
				statement.execute();
				System.out.println("Cadastrou usuário inicial no banco");
			}
			
		}catch(Exception e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
		}
		*/
	}

	public static void listarFuncionarios(RepositorioFuncionario rp) {
		rp.listarFuncionarios();
		for (Funcionario p : rp.listarFuncionarios()) {
			System.out.println(p.toString());
			System.out.println("---------------------------------------");
		}
	}
}
