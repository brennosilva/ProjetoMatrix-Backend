package br.com.projetomatrix.academico;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AlunoService {

private Long sequencial = new Long(0);
	
	private Map<String, Aluno> hashAlunos = new HashMap<>();
	
	public Aluno cadastrarAluno(Aluno aluno)
	{
		if(aluno == null || hashAlunos.containsKey(aluno.getMatricula()))
			return aluno;
		
		aluno.setMatricula(gerarMatricula(aluno));
		
		hashAlunos.put(aluno.getMatricula(), aluno);
		
		return aluno;
	}
	
	public Aluno recuperarAluno(String matricula)
	{
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		return hashAlunos.get(matricula);
	}
	
	public void removerAluno(String matricula)
	{
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		hashAlunos.remove(matricula);
	}
	
	public Aluno atualizarAluno(Aluno alunoNovo)
	{
		if(alunoNovo == null || alunoNovo.getMatricula() == null ||
				alunoNovo.getMatricula().length() == 0)
			throw new IllegalArgumentException();
		
		removerAluno(alunoNovo.getMatricula());
		cadastrarAluno(alunoNovo);
		
		return alunoNovo;
	}

	public String gerarMatricula(Aluno aluno) {
		
		int ano = LocalDateTime.now().getYear();
		String anoConvertido = Integer.toString(ano);
		
		int mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1":"2";
		
		sequencial.sum(sequencial, 1);
		
		String matricula = anoConvertido + semestre + sequencial.intValue();
		
		return matricula;
	}
}
