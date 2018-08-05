package br.com.projetomatrix.academico;

public class Aluno extends Pessoa {
	private String graduacao;
	private Avaliacao avaliacoes[];

	public Avaliacao[] getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(Avaliacao[] avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public String getGraduacao() {
		return graduacao;
	}

	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}	

}
