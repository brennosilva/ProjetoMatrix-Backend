package br.com.projetomatrix.academico.services;

import java.util.ArrayList;
import java.util.List;

import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Boletim;
import br.com.projetomatrix.academico.Historico;
import br.com.projetomatrix.academico.Turma;

public class HistoricoService {
	
	public Historico buscarHistorico(Aluno aluno) {
		BoletimService boletimService = new BoletimService();
		TurmaService turmaService = new TurmaService();
		List<Boletim> boletins = new ArrayList<Boletim>();
		List<Turma> turmas = turmaService.buscarTurmasAluno(aluno);
		
		turmas.forEach(t-> boletins.add(boletimService.buscarBoletimDisciplina(aluno, t.getDisciplina(), turmas)));
		
		Historico historico = new Historico();
		historico.setAluno(aluno);
		historico.setBoletins(boletins);
		return historico;
	}

}
