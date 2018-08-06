package br.com.projetomatrix.academico.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.Professor;

public class ProfessorService {
	private Long sequencial = new Long(0);

	private Map<String, Professor> hashProfessores = new HashMap<>();

	public Professor cadastrarProfessor(Professor professor) {
		if (professor == null || hashProfessores.containsKey(professor.getMatricula()))
			return professor;

		professor.setMatricula(gerarMatricula());

		hashProfessores.put(professor.getMatricula(), professor);

		return professor;
	}

	public Professor recuperarProfessor(String matricula) {
		if (matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();

		return hashProfessores.get(matricula);
	}

	public void removerProfessor(String matricula) {
		if (matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();

		hashProfessores.remove(matricula);
	}

	public Professor atualizarProfessor(Professor professorNovo) {
		if (professorNovo == null || professorNovo.getMatricula() == null || professorNovo.getMatricula().length() == 0)
			throw new IllegalArgumentException();

		removerProfessor(professorNovo.getMatricula());
		cadastrarProfessor(professorNovo);

		return professorNovo;
	}

	public String gerarMatricula() {

		int ano = LocalDateTime.now().getYear();
		String anoConvertido = Integer.toString(ano);

		int mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1" : "2";

		sequencial.sum(sequencial, 1);

		String matricula = anoConvertido + semestre + sequencial.intValue();

		return matricula;
	}

}
