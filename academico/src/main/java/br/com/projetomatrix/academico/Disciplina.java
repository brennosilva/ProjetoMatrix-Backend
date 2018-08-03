package br.com.projetomatrix.academico;

public class Disciplina {
	private Curso curso;
	private Professor professores;
	private String descricao;
	private int codigo;
	private Disciplina preRequisitos;
	
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Professor getProfessores() {
		return professores;
	}
	public void setProfessores(Professor professores) {
		this.professores = professores;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Disciplina getPreRequisitos() {
		return preRequisitos;
	}
	public void setPreRequisitos(Disciplina preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	
	
}
