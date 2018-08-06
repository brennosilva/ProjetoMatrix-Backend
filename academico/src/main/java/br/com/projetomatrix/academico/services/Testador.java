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
		AvaliacaoService avService = new AvaliacaoService();
		Aluno aluno = new Aluno();		
		Curso curso = new Curso();
		Avaliacao av = new Avaliacao();
		Avaliacao av2 = new Avaliacao();
		Avaliacao av3 = new Avaliacao();

		
		curso.setDescricao("ADS");	
		
		aluno.setNome("João");
		aluno.setStatus(Status.ATIVO);
		aluno.setEndereco("Rua ali virando");
		aluno.setTelefone("999-999");
		aluno.setCurso(curso);
	
		alunoService.cadastrarAluno(aluno);	
		
		av.setAluno(aluno);
		av.setNota(BigDecimal.valueOf(7));
		av.setModo(Modo.ONLINE);
		
		
		avService.cadastrarAvaliacao(av);		
		
		
		
		
		
		System.out.println(aluno.getMatricula());
		
		
	
	}

}
