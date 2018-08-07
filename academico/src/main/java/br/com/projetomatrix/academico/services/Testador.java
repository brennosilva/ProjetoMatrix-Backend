package br.com.projetomatrix.academico.services;

import java.math.BigDecimal;

import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Avaliacao;
import br.com.projetomatrix.academico.Curso;
import br.com.projetomatrix.academico.Modo;
import br.com.projetomatrix.academico.Status;

public class Testador {

	public static void main(String[] args) {
		AlunoService alunoService = new AlunoService();

		Aluno aluno = new Aluno();		
		Curso curso = new Curso();
		Avaliacao av1 = new Avaliacao();
		
		curso.setDescricao("ADS");	
		
		aluno.setNome("João");
		aluno.setStatus(Status.ATIVO);
		aluno.setEndereco("Rua ali virando");
		aluno.setTelefone("999-999");
		aluno.setCurso(curso);
	
		alunoService.cadastrarAluno(aluno);	
		
		av1.setAluno(aluno);
		av1.setNota(BigDecimal.valueOf(7));
		av1.setModo(Modo.ONLINE);
		av1.setDescricao("teste");
		
		
		AvaliacaoService avaliacaoService = new AvaliacaoService();
		
		avaliacaoService.cadastrarAvaliacao(av1);
		alunoService.adicionarAvaliacao(avaliacaoService.recuperarAvaliacao("av0"));
		
		System.out.println(aluno.getMatricula() + " " + aluno.getNome() + " " + aluno.getAvaliacoes().size());
		System.out.println(av1.getCodigo());
		
		
	
	}

}
