package teste;

import com.consulmedic.dao.RepositorioFuncionario;
import com.consulmedic.dao.RepositorioPaciente;
import com.consulmedic.model.Administrador;
import com.consulmedic.model.Funcionario;
import com.consulmedic.model.Paciente;

public class TesteClinica {

	public static void main(String[] args) {
		RepositorioPaciente pacientes = new RepositorioPaciente();
		RepositorioFuncionario funcionarios = new RepositorioFuncionario();
		
		Funcionario f1 = new Administrador();
		Funcionario f2 = new Funcionario();
		
		System.out.println(f1.getTipoPessoa());
	}
	
	public static void listarPacientes(RepositorioPaciente rp) {
		for (Paciente p : rp.listarPacientes()) {
			System.out.println(p.toString());
			System.out.println("---------------------------------------");
		}
	}

}
