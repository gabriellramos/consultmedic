package com.consulmedic.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:postgresql://localhost:5432/clinica";
	private static final String DRIVER_MANAGER = "org.postgresql.Driver";
	
	//cria conex„o
	public static Connection createConnectionToPostgreSQL(){
		try {
			Class.forName(DRIVER_MANAGER);
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
		} catch (ClassNotFoundException | SQLException e) {
			//throw new SQLException(e.getMessage());
			throw new RuntimeException("Erro na conex√£o: ", e);
		}
	}
	
	//fecha conex„o
	public static void fechaConexao(Connection con) {
		try {
            if (con != null) {
                con.close();
                System.out.println("Conex„o fechada!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	
	public static void main(String[] args) throws SQLException {
		Connection conexao = new ConnectionFactory().createConnectionToPostgreSQL();
		fechaConexao(conexao);
		
	}
	
	
	
	
}
