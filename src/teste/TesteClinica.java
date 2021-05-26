package teste;

import com.consulmedic.dao.RepositorioPaciente;
import com.consulmedic.model.Paciente;

public class TesteClinica {

	public static void main(String[] args) {
		RepositorioPaciente pacientes = new RepositorioPaciente();
		Paciente p = new Paciente("Gabriel","Av. Mario Andreaza",
									"993728956","021083","16/07/1999",21,"0123456789","21/05/2021");
		
		pacientes.salvaPaciente(p);
		Paciente p1 = new Paciente("Ana", "Rua dos prazeres","4002-8922","01230","12/12/1951",48,"1235","21/05/2021");
		pacientes.salvaPaciente(p1);
		listarPacientes(pacientes);
		System.out.println();
		System.out.println();
		pacientes.deletarPacientePorCPF("021083");
		listarPacientes(pacientes);
		System.out.println();
		System.out.println();
		Paciente p2 = new Paciente("Ana", "Rua dos prazeres","4002-8922","01230","12/12/1951",48,"1235","21/05/2021");
		System.out.println(pacientes.salvaPaciente(p2));
		pacientes.salvaPaciente(p);
		listarPacientes(pacientes);
		System.out.println();
		System.out.println();
		pacientes.salvaPaciente(p);
		listarPacientes(pacientes);
		System.out.println();
		System.out.println();
		pacientes.salvaPaciente(p2);
		listarPacientes(pacientes);
		Paciente p3 = new Paciente("Ana3", "Rua dos prazeres","4002-8922","555555","12/12/1951",48,"1235","21/05/2021");
		System.out.println(pacientes.salvaPaciente(p3));
		System.out.println();
		System.out.println();
		listarPacientes(pacientes);
		
	}
	
	public static void listarPacientes(RepositorioPaciente rp) {
		for (Paciente p : rp.listarPacientes()) {
			System.out.println(p.toString());
			System.out.println("---------------------------------------");
		}
	}

}
