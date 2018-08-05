package br.com.projetomatrix.academico;

public class SistemaAcademicoService {
	
	private AlunoService alunoService = new AlunoService();
	
	public Aluno cadastrarAluno(Aluno aluno)
	{	
		return alunoService.cadastrarAluno(aluno);
	}
	
	public Aluno recuperarAluno(String matricula)
	{
		return alunoService.recuperarAluno(matricula);
	}
	
	public void removerAluno(String matricula)
	{
		alunoService.removerAluno(matricula);
	}
	
	public Aluno atualizarAluno(Aluno alunoNovo)
	{
		return alunoService.atualizarAluno(alunoNovo);
	}

	public String gerarMatricula(Aluno aluno) {
		
		return alunoService.gerarMatricula(aluno);
	}
}
