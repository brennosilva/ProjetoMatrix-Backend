package br.com.projetomatrix.academico;

public class Boletim {
	private Aluno aluno;
	private Turma turma;
	private Avaliacao Avaliacoes[];
	
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Avaliacao[] getAvaliacoes() {
		return Avaliacoes;
	}
	public void setAvaliacoes(Avaliacao[] avaliacoes) {
		Avaliacoes = avaliacoes;
	}

	
}
