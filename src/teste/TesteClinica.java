package teste;

import com.consulmedic.dao.RepositorioAdministrador;
import com.consulmedic.dao.RepositorioFuncionario;
import com.consulmedic.dao.RepositorioMedico;
import com.consulmedic.dao.RepositorioPaciente;
import com.consulmedic.model.Administrador;
import com.consulmedic.model.Funcionario;
import com.consulmedic.model.Medico;
import com.consulmedic.model.Paciente;

public class TesteClinica {

	public static void main(String[] args) {
		//RepositorioPaciente pacientes = new RepositorioPaciente();
		RepositorioFuncionario funcionarios = new RepositorioFuncionario();
		RepositorioAdministrador administrador = new RepositorioAdministrador();
		RepositorioMedico medicos = new RepositorioMedico();
		
		Medico medico = new Medico();
		Administrador f1 = new Administrador();
		Funcionario f2 = new Funcionario();
		
		f1.setCpf("021083");
		f1.setNome("Gabriel Ramos");
		f1.setSenha("123");
		
		
		funcionarios.salvaFuncionario(f1);
		
		administrador.setAdministrador(f1);
		administrador.inserirInfoClinica("Clinica dos Prazeres da Vida", "Rua dos Amantes", "4002-8922");
		
		f2.setCpf("1234");
		f2.setNome("zunc1");
		f2.setSenha("000");
		funcionarios.salvaFuncionario(f2);
		
		
		medico.setCpf("4567");
		medico.setNome("medico1");
		medico.setSenha("564");
		funcionarios.salvaFuncionario(medico);
		medicos.salvaMedico(medico);
		
		
		funcionarios.listarFuncionarios().sort(null);
		listarFuncionarios(funcionarios);
	}
	
	public static void listarFuncionarios(RepositorioFuncionario rp) {
		for (Funcionario p : rp.listarFuncionarios()) {
			System.out.println(p.toString());
			System.out.println("---------------------------------------");
		}
	}

}
