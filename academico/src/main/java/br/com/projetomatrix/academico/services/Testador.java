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
		Avaliacao av2 = new Avaliacao();
		Avaliacao av3 = new Avaliacao();
		
		curso.setDescricao("ADS");	
		
		aluno.setNome("João");
		aluno.setStatus(Status.ATIVO);
		aluno.setEndereco("Rua ali virando");
		aluno.setTelefone("999-999");
		aluno.setCurso(curso);
	
		Aluno alunoCadastrado = alunoService.cadastrarAluno(aluno);	
		
		av1.setAluno(alunoCadastrado);
		av1.setNota(BigDecimal.valueOf(7));
		av1.setModo(Modo.ONLINE);
		av1.setDescricao("av1");
		
		av2.setAluno(alunoCadastrado);
		av2.setNota(BigDecimal.valueOf(8));
		av2.setModo(Modo.ONLINE);
		av2.setDescricao("av2");
		
<<<<<<< HEAD
		av3.setAluno(alunoCadastrado);
		av3.setNota(BigDecimal.valueOf(9));
		av3.setModo(Modo.ONLINE);
		av3.setDescricao("av3");
		
		// teste de cadastro de avaliaçãp
		AvaliacaoService avaliacaoService = new AvaliacaoService();
=======
		
		alunoService.adicionarAvaliacao(av);
>>>>>>> 15120c71790ed0140025a9b06ade546e955a79ba
		
		avaliacaoService.cadastrarAvaliacao(av1);
		avaliacaoService.cadastrarAvaliacao(av2);
		avaliacaoService.cadastrarAvaliacao(av3);
		
		// teste de cadastro de avaliacao no aluno
		alunoService.adicionarAvaliacao(avaliacaoService.recuperarAvaliacao("av1"));
		alunoService.adicionarAvaliacao(avaliacaoService.recuperarAvaliacao("av2"));
		alunoService.adicionarAvaliacao(avaliacaoService.recuperarAvaliacao("av3"));
		
<<<<<<< HEAD
		System.out.println(alunoCadastrado.getMatricula() + " " + alunoCadastrado.getNome() + " " + alunoCadastrado.getAvaliacoes().size());
		System.out.println(alunoService.buscarStatusAcademico("201821"));
=======
		
		Aluno alunoRecuperado = alunoService.recuperarAluno(aluno.getMatricula());
		System.out.println(alunoRecuperado.getMatricula() + " " + alunoRecuperado.getNome());
		
>>>>>>> 15120c71790ed0140025a9b06ade546e955a79ba
		
		
	
	}

}
