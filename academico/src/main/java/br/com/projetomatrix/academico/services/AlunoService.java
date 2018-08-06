package br.com.projetomatrix.academico.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Avaliacao;
import br.com.projetomatrix.academico.StatusAcademico;

public class AlunoService {

	private Long sequencial = new Long(0);

	private Map<String, Aluno> hashAlunos = new HashMap<>();

	public Aluno cadastrarAluno(Aluno aluno) {
		if (aluno == null || hashAlunos.containsKey(aluno.getMatricula()))
			return aluno;

		aluno.setMatricula(gerarMatricula());

		hashAlunos.put(aluno.getMatricula(), aluno);

		return aluno;
	}

	public Aluno recuperarAluno(String matricula) {
		if (matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();

		return hashAlunos.get(matricula);
	}

	public void removerAluno(String matricula) {
		if (matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();

		hashAlunos.remove(matricula);
	}

	public Aluno atualizarAluno(Aluno alunoNovo) {
		if (alunoNovo == null || alunoNovo.getMatricula() == null || alunoNovo.getMatricula().length() == 0)
			throw new IllegalArgumentException();

		removerAluno(alunoNovo.getMatricula());
		cadastrarAluno(alunoNovo);

		return alunoNovo;
	}

	public String gerarMatricula() {

		int ano = LocalDateTime.now().getYear();
		String anoConvertido = Integer.toString(ano);

		int mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1" : "2";

		sequencial++;

		String matricula = anoConvertido + semestre + sequencial.intValue();

		return matricula;
	}

	
	public BigDecimal buscarMedia(String matricula) {
		Aluno aluno = hashAlunos.get(matricula);
		List<Avaliacao> avaliacoes = aluno.getAvaliacoes();			
		BigDecimal media = BigDecimal.ZERO;		
	
		for (Avaliacao n : avaliacoes) {
			media.add(n.getNota());
		}
		return media.divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);
		
	}
	
	public void adicionarAvaliacao(Avaliacao avaliacao){
		AvaliacaoService avaliacaoService = new AvaliacaoService();
		Aluno aluno = hashAlunos.get((avaliacao.getAluno().getMatricula()));
		aluno.getAvaliacoes().add(avaliacaoService.cadastrarAvaliacao(avaliacao));
		atualizarAluno(aluno);
	}
	
	
	public StatusAcademico buscarStatusAcademico(String matricula){
		
		Aluno aluno = hashAlunos.get(matricula);
		List<Avaliacao> avaliacoes = aluno.getAvaliacoes();

		if (avaliacoes.size() < 3)
			return StatusAcademico.REPROVADO;
		else if (buscarMedia(matricula).compareTo(BigDecimal.valueOf(6)) >= 0)
			return StatusAcademico.APROVADO;
		else if (buscarMedia(matricula).compareTo(BigDecimal.valueOf(4)) >= 0)
			return StatusAcademico.PROVA_FINAL;
		else
			return StatusAcademico.REPROVADO;	
	}
	
}
