package br.com.projetomatrix.academico.services;
import java.util.List;
import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Avaliacao;
import br.com.projetomatrix.academico.Boletim;
import br.com.projetomatrix.academico.Disciplina;
import br.com.projetomatrix.academico.Turma;

public class BoletimService {

	//private Map<Aluno, List<Boletim>> hashBoletins = new HashMap<>();
	
	public Boletim buscarBoletimDisciplina(Aluno aluno, Disciplina disciplina, List<Turma> turmasAluno) {
		
		Turma turma = new Turma();
		
		for (Turma t : turmasAluno) {
			if (t.getDisciplina() == disciplina) 
				turma = t;	
		}
		if(turma.getCodigo() == null)
			throw new IllegalArgumentException("O aluno não tem essa disciplina");
		
		List<Avaliacao> avsAluno = aluno.getAvaliacoes();
		List<Avaliacao> avsDisciplina = aluno.getAvaliacoes();
		for (Avaliacao av : avsAluno) {
			if (av.getTurma() == turma) 
				avsDisciplina.add(av);
		}
		
		Boletim boletim = new Boletim();
		boletim.setAluno(aluno);
		boletim.setTurma(turma);
		boletim.setAvaliacoes(avsDisciplina);
		
		return boletim;
	}
	
}
