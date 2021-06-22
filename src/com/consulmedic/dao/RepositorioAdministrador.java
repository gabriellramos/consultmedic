package com.consulmedic.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.consulmedic.factory.ConnectionFactory;
import com.consulmedic.model.Administrador;

public class RepositorioAdministrador{
	public Connection conexao; 
	Administrador adm;
	
	public RepositorioAdministrador() {
		adm = new Administrador();
	}

	public boolean inserirInfoClinica(String nomeClinica, String enderecoClinica, String telefoneClinica) {
		
		adm.setNomeClinica(nomeClinica);
		adm.setEnderecoClinica(enderecoClinica);
		adm.setTelefoneClinica(telefoneClinica);
		
		return true;
	}

	public boolean alterarInfoClinica(String nomeClinica, String enderecoClinica, String telefoneClinica) {
		adm.setNomeClinica(nomeClinica);
		adm.setEnderecoClinica(enderecoClinica);
		adm.setTelefoneClinica(telefoneClinica);
		return true;
	}

	@Override
	public String toString() {
		String mensagem = "[nomeClinica] = "+adm.getNomeClinica()+"\n"
						+ "[enderecoClinica] = "+adm.getEnderecoClinica()+"\n"
						+ "[telefoneClinica] = "+adm.getTelefoneClinica();
						
		return mensagem;
	}
	
	public void getAdministrador() {
		conexao = new ConnectionFactory().createConnectionToPostgreSQL();
		String sql = "SELECT * FROM administrador;";
		try {
			PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql) ;
			ResultSet rs = statement.executeQuery();
			statement.execute();
			conexao.close();
			Administrador adm = new Administrador();
			adm.setCpf(rs.getString("cpf"));
			adm.setNome(rs.getString("nome"));
			adm.setSenha(rs.getString("senha"));
			this.adm = adm;
		}catch(Exception e) {
			
		}
		
	}
	
	public void alteraAdm(Administrador adm, String cpf) {
		conexao = new ConnectionFactory().createConnectionToPostgreSQL();
		String sql = "UPDATE administrador SET cpf = ?, "
				+ "endereco = ?, telefone = ?, nome = ?, datanascimento = ?, "
				+ "idade = ?, nomeusuario = ?, senha = ?, usuariologado = ?, "
				+ "nomeclinica = ?, enderecoclinica = ?, telefoneclinica = ?"
				+ "WHERE cpf = ?;";
		try {
			PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql);
			
		}catch(Exception e) {
			
		}
	}

}
