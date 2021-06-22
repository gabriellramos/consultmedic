package com.consulmedic.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.consulmedic.factory.ConnectionFactory;
import com.consulmedic.model.*;

public class ConsultClinicaAPP {

	public static Connection conexao;
	
	public static void main(String[] args) throws SQLException{
		inicializaSistema();
	}
	
	public static void inicializaSistema() throws SQLException{
		//inicializando sistema cadastrando administrador
		Funcionario adm = new Administrador();
		ResultSet rs;
		conexao = ConnectionFactory().createConnectionToPostgreSQL();
		
		adm.setNome("admin");
		adm.setCpf("00000000000");
		adm.setSenha("admin");
		
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
	}

	private static ConnectionFactory ConnectionFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
