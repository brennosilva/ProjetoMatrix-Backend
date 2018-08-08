package br.com.projetomatrix.academico.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Avaliacao;
import br.com.projetomatrix.academico.Professor;
import br.com.projetomatrix.academico.Turma;

class TurmaService {
	private int sequencial = new Integer(0);
	private Map<String, Turma> hashTurmas = new HashMap<>();

	public String gerarCodigo() {
		return String.valueOf(sequencial++);
	}

	public Turma cadastrarTurma(Turma turma) {
		if (turma == null || hashTurmas.containsKey(turma.getCodigo()))
			return turma;

		turma.setCodigo(gerarCodigo());
		hashTurmas.put(turma.getCodigo(), turma);

		return turma;
	}

	public Turma recuperarTurma(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();
		return hashTurmas.get(codigo);
	}

	public void removerTurma(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		hashTurmas.remove(codigo);
	}

	public Turma atualizarTurma(Turma turmaNova) {
		if (turmaNova == null || turmaNova.getCodigo() == null || turmaNova.getCodigo().length() == 0)
			throw new IllegalArgumentException();

		removerTurma(turmaNova.getCodigo());
		cadastrarTurma(turmaNova);
		return turmaNova;
	}

	public List<Turma> buscarTurmasAluno(Aluno aluno) {
		List<Turma> turmasAluno = new ArrayList<Turma>();
		for (Map.Entry<String, Turma> hash : hashTurmas.entrySet()) {
			if (alunoEstaTurma(hash.getValue(), aluno)) {
				turmasAluno.add(hash.getValue());
			}
		}
		return turmasAluno;
	}

	public boolean alunoEstaTurma(Turma turma, Aluno aluno) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos = turma.getAlunos();
		for (Aluno a : alunos) {
			if (a == aluno)
				return true;
		}
		return false;
	}
	
	public List<Turma> buscarProfessor(Professor professor){
		List<Turma> turmasProfessor = new ArrayList<Turma>();
		for (Map.Entry<String, Turma> hash : hashTurmas.entrySet()) {
			if (hash.getValue().getProfessor() == professor) {
				turmasProfessor.add(hash.getValue());
			}
		}
		return turmasProfessor;
	}
}