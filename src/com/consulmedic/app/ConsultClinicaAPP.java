package com.consulmedic.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
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
	public static final RepositorioAdministrador repoAdm = new RepositorioAdministrador();
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		Funcionario adm = new Administrador();
		boolean continua = true;

		if (repoFunc.listarFuncionarios().isEmpty())
			inicializaSistema();
		do {
			if (repoFunc.buscaFuncPorCpf("00000000000")) {
				alteraDadosAdm();
			}
		} while (continua);
	}

	public static void inicializaSistema() throws SQLException {
		System.out.println("Inicializando Sistema");
		// inicializando sistema cadastrando administrador
		Administrador adm = new Administrador();

		adm.setNome("admin");
		adm.setCpf("00000000000");
		adm.setSenha("admin");

		repoFunc.salvaFuncionario(adm);
	}

	public static void listarFuncionarios(RepositorioFuncionario rp) {
		rp.listarFuncionarios();
		for (Funcionario p : rp.listarFuncionarios()) {
			System.out.println(p.toString());
			System.out.println("---------------------------------------");
		}
	}

	public static void limpaConsole() throws InterruptedException, IOException {
		// Limpa a tela no windows, no linux e no MacOS
		if (System.getProperty("os.name").contains("Windows"))
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		else
			Runtime.getRuntime().exec("clear");
	}

	public static void menuPrincipalAdm() {
		int op = 1;
		do {
			do {
				System.out.println("SISTEMA DE CONSULTAS");
				System.out.println("1 - Gerenciar Funcionarios");
				System.out.println("2 - Gerenciar Pacientes");
				System.out.println("3 - Gerenciar Consultas");
				System.out.println("4 - Deslogar");
				System.out.println("5 - Sair do sistema");
				System.out.println("Insira sua opção: ");
				op = scanner.nextInt();
			} while (op <= 1 && op > 5);

			switch (op) {
			case 1:
				gerenciaFuncionarios();
				break;
			}
		} while (op != 4);
	}

	public static void gerenciaFuncionarios() {
		int op = 1;
		do {
			do {
				System.out.println("FUNCIONARIOS");
				System.out.println("1 - Listar Funcionarios");
				System.out.println("2 - Cadastrar Funcionarios");
				System.out.println("3 - Deletar Funcionario");
				System.out.println("4 - Alterar Funcionario");
				System.out.println("5 - Voltar ao menu principal");
				System.out.println("Insira sua opção: ");
				op = scanner.nextInt();
			} while (op <= 1 && op > 5);

			switch (op) {
			case 1:
				System.out.println("\n\nLISTANDO FUNCIONARIOS\n");
				listarFuncionarios(repoFunc);
				break;
			case 2:
				Funcionario func = new Funcionario();
				System.out.println("CADASTRAR NOVO FUNCIONARIO");

				break;
			}
		} while (op != 5);
	}

	public static void alteraDadosAdmInicio() {
		Administrador adm = new Administrador();
		System.out.println("INSIRA OS DADOS DO ADMINISTRADOR DA CLINICA");
		System.out.println("Nome: ");
		adm.setNome(scanner.nextLine());

		do {
			System.out.println("CPF: ");
			adm.setCpf(scanner.nextLine());
		} while (!somenteNumeros(adm.getCpf()));

		System.out.println("Endereço: ");
		adm.setEndereco(scanner.nextLine());
		System.out.println("Telefone: ");
		adm.setTelefone(scanner.nextLine());
		System.out.println("Data de Nascimento: ");
		System.out.println("\tDia: ");
		int dia = scanner.nextInt();
		System.out.println("Mes: ");
		int mes = scanner.nextInt();
		System.out.println("Ano: ");
		int ano = scanner.nextInt();
		adm.setDataNascimento(mes + "-" + dia + "-" + ano);
		System.out.println("Idade: ");
		adm.setIdade(scanner.nextInt());
		System.out.println("\nDADOS DA CLINICA\n");
		System.out.println("Nome da CLinica: ");
		adm.setNomeClinica(scanner.nextLine());
		System.out.println("Endereço: ");
		adm.setEnderecoClinica(scanner.nextLine());
		System.out.println("Telefone: ");
		adm.setTelefoneClinica(scanner.nextLine());
		
		repoAdm.alteraAdm(adm, "0000000000");
		
	}

	public static boolean somenteNumeros(String cpf) {
		boolean numero = false;
		char[] cpfArray = new char[cpf.length()];

		for (char letra : cpfArray) {
			if (letra >= 48 && letra <= 57)
				numero = true;
			else {
				numero = false;
				break;
			}
		}
		return numero;
	}
}
