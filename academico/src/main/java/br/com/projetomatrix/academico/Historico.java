package br.com.projetomatrix.academico;

import java.util.List;

public class Historico {
	private Aluno aluno;
	private List<Boletim> boletins;
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public List<Boletim> getBoletins() {
		return boletins;
	}
	public void setBoletins(List<Boletim> boletins) {
		this.boletins = boletins;
	}

}
