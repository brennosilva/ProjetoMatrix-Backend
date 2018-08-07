package br.com.projetomatrix.academico;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{
	
	private Curso curso;
	private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();

	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
		
}
