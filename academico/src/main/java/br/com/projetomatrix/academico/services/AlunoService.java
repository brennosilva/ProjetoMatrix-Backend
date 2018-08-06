package br.com.projetomatrix.academico.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Avaliacao;
import br.com.projetomatrix.academico.Status;

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

	public BigDecimal buscarMedia(Aluno aluno) {
		BigDecimal media = BigDecimal.ZERO;
		List<Avaliacao> notas = aluno.getAvaliacoes();
		for (Avaliacao n : notas) {
			media.add(n.getNota());
		}
		return media.divide(BigDecimal.valueOf(3));
	}
	
	public void adicionarAvaliacao(){
		
	}
	
}
