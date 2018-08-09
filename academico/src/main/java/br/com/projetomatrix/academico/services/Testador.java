package br.com.projetomatrix.academico.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Avaliacao;
import br.com.projetomatrix.academico.Boletim;
import br.com.projetomatrix.academico.Curso;
import br.com.projetomatrix.academico.Disciplina;
import br.com.projetomatrix.academico.Historico;
import br.com.projetomatrix.academico.Modo;
import br.com.projetomatrix.academico.Professor;
import br.com.projetomatrix.academico.Status;
import br.com.projetomatrix.academico.StatusAcademico;
import br.com.projetomatrix.academico.Turma;

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
		av1.setNota(BigDecimal.valueOf(10.5));
		av1.setModo(Modo.ONLINE);
		av1.setDescricao("av1");
		
		av2.setAluno(alunoCadastrado);
		av2.setNota(BigDecimal.valueOf(10.0));
		av2.setModo(Modo.ONLINE);
		av2.setDescricao("av2");
		

		av3.setAluno(alunoCadastrado);
		av3.setNota(BigDecimal.valueOf(5));
		av3.setModo(Modo.ONLINE);
		av3.setDescricao("av3");
		
		//teste cadastro professor
		Professor professor = new Professor();
		ProfessorService professorService = new ProfessorService();
		professor.setNome("Mario Monteiro");
		professor.setStatus(Status.ATIVO);
		professor.setEndereco("Universo");
		Professor professorCadastrado = professorService.cadastrarProfessor(professor);
		//
		Professor professor2 = new Professor();
		professor2.setNome("Priscila");
		professor2.setStatus(Status.ATIVO);
		professor2.setEndereco("Casa dela");
		Professor professorCadastrado2 = professorService.cadastrarProfessor(professor2);
		
		//teste de cadastro de disciplina
		Disciplina disciplina = new Disciplina();
		DisciplinaService disciplinaService = new DisciplinaService();
		disciplina.setDescricao("Teoria em Grafos");
		Disciplina disciplinaCadastrada = disciplinaService.cadastrarDisciplina(disciplina);
		//
		Disciplina disciplina2 = new Disciplina();		
		disciplina2.setDescricao("Teoria da Computação");
		Disciplina disciplinaCadastrada2 = disciplinaService.cadastrarDisciplina(disciplina2);
		
		// teste de cadastro de avaliaçãp
		AvaliacaoService avaliacaoService = new AvaliacaoService();				
		avaliacaoService.cadastrarAvaliacao(av1);
		avaliacaoService.cadastrarAvaliacao(av2);
		avaliacaoService.cadastrarAvaliacao(av3);		
		// teste de cadastro de avaliacao no aluno
		alunoService.adicionarAvaliacao(avaliacaoService.recuperarAvaliacao("av1"));
		alunoService.adicionarAvaliacao(avaliacaoService.recuperarAvaliacao("av2"));
		alunoService.adicionarAvaliacao(avaliacaoService.recuperarAvaliacao("av3"));
		
		//teste de cadastro de turma
		TurmaService turmaService = new TurmaService();
		Turma turma = new Turma();
		Turma turma2 = new Turma();
		//adc os alunos
		List<Aluno> alunosT = new ArrayList<Aluno>();
		alunosT.add(alunoCadastrado);
		//
		turma.setAlunos(alunosT);
		turma.setAnoLetivo(2);
		turma.setDisciplina(disciplinaCadastrada);
		turma.setProfessor(professorCadastrado);
		turmaService.cadastrarTurma(turma);
		//
		turma2.setAlunos(alunosT);
		turma2.setAnoLetivo(1);
		turma2.setDisciplina(disciplinaCadastrada2);
		turma2.setProfessor(professorCadastrado2);
		turmaService.cadastrarTurma(turma2);
		

		System.out.println(alunoCadastrado.getMatricula() + " " + alunoCadastrado.getNome() + " " + alunoCadastrado.getAvaliacoes().size());
		System.out.println(alunoService.buscarStatusAcademico("201821"));		
		System.out.println("Média = " + alunoService.buscarMedia("201821"));
		
		
		List<Turma> turmas = turmaService.buscarTurmasAluno(alunoCadastrado);		
		System.out.println("\nTurmas do Aluno");
		turmas.forEach(t->System.out.println(t.getDisciplina().getDescricao() +" "+ t.getCodigo() +" "+ t.getAnoLetivo()));
		
		List<Turma> turmasProfessor = turmaService.buscarProfessor(professorCadastrado2);
		System.out.println("\nTurmas do professor");
		turmasProfessor.forEach(p->System.out.println(p.getDisciplina().getDescricao() +" "+ p.getCodigo() +" "+ p.getAnoLetivo() +" "+p.getProfessor().getNome()));
		
		System.out.println("\nBoletim do aluno");
		Boletim boletimAluno = new Boletim();
		BoletimService boletimService = new BoletimService();
		boletimAluno = boletimService.buscarBoletimDisciplina(alunoCadastrado, disciplina, turmas);
		System.out.println(boletimAluno.getAluno().getNome() +" "+ boletimAluno.getTurma().getProfessor().getNome());
		System.out.println(boletimAluno.getTurma().getDisciplina().getDescricao());
		List<Avaliacao> notas = boletimAluno.getAvaliacoes();
		notas.forEach(not->System.out.println(not.getNota()));
		
		System.out.println("\n Historico do Aluno");
		
		
		HistoricoService historicoService = new HistoricoService();
		Historico historico = historicoService.buscarHistorico(alunoCadastrado);
		
		System.out.println(historico.getAluno().getNome());
		List<Boletim> boletinsH = historico.getBoletins();
 		for (Boletim b : boletinsH) {
			System.out.println(b.getTurma().getDisciplina().getDescricao());
			List<Avaliacao> notasH = boletimAluno.getAvaliacoes();
			notasH.forEach(not->System.out.println(not.getNota()));
		}
	}

}
