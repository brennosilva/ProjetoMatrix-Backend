package br.com.projetomatrix.academico;

public class Curso {
	private Disciplina disciplinas[];
	private Coodernador coodernador;
	private String descricao;
	private int codigo;
	private int cargaHoraria;
	private String ementa;
	private String bibliografia;
	
	

	public Disciplina[] getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(Disciplina[] disciplinas) {
		this.disciplinas = disciplinas;
	}
	public Coodernador getCoodernador() {
		return coodernador;
	}
	public void setCoodernador(Coodernador coodernador) {
		this.coodernador = coodernador;
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
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public String getBibliografia() {
		return bibliografia;
	}
	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

}
