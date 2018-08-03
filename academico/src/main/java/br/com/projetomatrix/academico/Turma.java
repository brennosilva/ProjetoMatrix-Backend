package br.com.projetomatrix.academico;

import java.util.Date;

public class Turma {
	private Disciplina disciplina;
	private Professor professorResponsavel;
	private Aluno alunos;
	private int codigo;
	private String anoLetivo;
	private String semestre;
	private Date dataAbertura;
	private Date dataEncerramento;
	private Horario horariosAulas;
	
	
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Professor getProfessorResponsavel() {
		return professorResponsavel;
	}
	public void setProfessorResponsavel(Professor professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}
	public Aluno getAlunos() {
		return alunos;
	}
	public void setAlunos(Aluno alunos) {
		this.alunos = alunos;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(String anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataEncerramento() {
		return dataEncerramento;
	}
	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	public Horario getHorariosAulas() {
		return horariosAulas;
	}
	public void setHorariosAulas(Horario horariosAulas) {
		this.horariosAulas = horariosAulas;
	}
	
	

}
