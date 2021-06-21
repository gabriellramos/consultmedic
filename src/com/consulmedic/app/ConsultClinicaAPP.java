package com.consulmedic.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.consulmedic.factory.ConnectionFactory;
import com.consulmedic.model.*;

public class ConsultClinicaAPP {

	public static final Connection conexao = new ConnectionFactory().createConnectionToPostgreSQL();
	
	public static void main(String[] args) throws SQLException{
		inicializaSistema();
	}
	
	public static void inicializaSistema() throws SQLException{
		//inicializando sistema cadastrando administrador
		Funcionario adm = new Administrador();
		adm.setNome("admin");
		adm.setCpf("00000000000");
		adm.setSenha("admin");
		
		String sql = "insert into administrador (nome, cpf, senha, tipoPessoa) values (?,?,?,?);";
		try {
			PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
			statement.setString(1, adm.getNome());
			statement.setString(2, adm.getCpf());
			statement.setString(3, adm.getSenha());
			statement.setString(4, adm.getTipoPessoa());
			statement.execute();
		}catch(SQLException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
