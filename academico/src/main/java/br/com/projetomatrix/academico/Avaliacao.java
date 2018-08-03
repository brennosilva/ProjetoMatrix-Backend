package br.com.projetomatrix.academico;

import java.util.Date;

public class Avaliacao {
	private Aluno aluno;
	private Turma turma;
	private int codigo;
	private Date dataRealizacao;
	private String descricao;
	private String modo;
	private Professor responsavel;
	
	
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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getModo() {
		return modo;
	}
	public void setModo(String modo) {
		this.modo = modo;
	}
	public Professor getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Professor responsavel) {
		this.responsavel = responsavel;
	}
	
	
}
