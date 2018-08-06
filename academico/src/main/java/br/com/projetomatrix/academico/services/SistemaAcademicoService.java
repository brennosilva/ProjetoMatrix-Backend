package br.com.projetomatrix.academico.services;

import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Avaliacao;
import br.com.projetomatrix.academico.Boletim;
import br.com.projetomatrix.academico.Coordenador;
import br.com.projetomatrix.academico.Curso;
import br.com.projetomatrix.academico.Disciplina;
import br.com.projetomatrix.academico.Horario;
import br.com.projetomatrix.academico.Professor;
import br.com.projetomatrix.academico.Turma;

public class SistemaAcademicoService {
	// CRUD DO ALUNO
	private AlunoService alunoService = new AlunoService();

	public Aluno cadastrarAluno(Aluno aluno) {
		return alunoService.cadastrarAluno(aluno);
	}

	public Aluno recuperarAluno(String matricula) {
		return alunoService.recuperarAluno(matricula);
	}

	public void removerAluno(String matricula) {
		alunoService.removerAluno(matricula);
	}

	public Aluno atualizarAluno(Aluno alunoNovo) {
		return alunoService.atualizarAluno(alunoNovo);
	}

	public String gerarMatricula(Aluno aluno) {
		return alunoService.gerarMatricula();
	}
	// FIM CRUD DO ALUNO

	// CRUD DO PROFESSOR
	ProfessorService professorService = new ProfessorService();

	public Professor cadastrarProfessor(Professor professor) {
		return professorService.cadastrarProfessor(professor);
	}

	public Professor recuperarProfessor(String matricula) {
		return professorService.recuperarProfessor(matricula);
	}

	public void removerProfessor(String matricula) {
		professorService.removerProfessor(matricula);
	}

	public Professor atualizarProfessor(Professor professorNovo) {
		return professorService.atualizarProfessor(professorNovo);
	}

	public String gerarMatricula(Professor professor) {
		return professorService.gerarMatricula();
	}
	// FIM CRUD DO PROFESSOR

	// CRUD COORDENADOR
	CoordenadorService coordenadorService = new CoordenadorService();

	public Coordenador cadastrarCoordenador(Coordenador coordenador) {
		return coordenadorService.cadastrarCoordenador(coordenador);
	}

	public Coordenador recuperarCoordenador(String matricula) {
		return coordenadorService.recuperarCoordenador(matricula);
	}

	public void removerCoordenador(String matricula) {
		coordenadorService.removerCoordenador(matricula);
	}

	public Coordenador atualizarAluno(Coordenador coordenadorNovo) {
		return coordenadorService.atualizarCoordenador(coordenadorNovo);
	}

	public String gerarMatricula() {
		return coordenadorService.gerarMatricula();
	}
	// FIM CRUD COORDENADOR

	// CRUD CURSO
	CursoService cursoService = new CursoService();

	public Curso cadastrarCurso(Curso curso) {
		return cursoService.cadastrarCurso(curso);
	}

	public Curso recuperarCurso(String codigo) {
		return cursoService.recuperarCurso(codigo);
	}

	public void removerCurso(String codigo) {
		cursoService.removerCurso(codigo);
	}

	public Curso atualizarCuso(Curso cursoNovo) {
		return cursoService.atualizarCurso(cursoNovo);
	}
	// FIM CRUD CURSO

	// CRUD DISCIPLINA
	DisciplinaService disciplinaService = new DisciplinaService();

	public Disciplina cadastrarDisciplina(Disciplina disciplina) {
		return disciplinaService.cadastrarDisciplina(disciplina);
	}

	public Disciplina recuperarDisciplina(String codigo) {
		return disciplinaService.recuperarDisciplina(codigo);
	}

	public void removerDisciplina(String codigo) {
		disciplinaService.removerDisciplina(codigo);
	}

	public Disciplina atualizarDisciplina(Disciplina disciplinaNova) {
		return disciplinaService.atualizarDisciplina(disciplinaNova);
	}
	// FIM CRUD DISCIPLINA

	// CRUD TURMA
	TurmaService turmaService = new TurmaService();

	public Turma cadastrarTurma(Turma turma) {
		return turmaService.cadastrarTurma(turma);
	}

	public Turma recuperarTurma(String codigo) {
		return turmaService.recuperarTurma(codigo);
	}

	public void removerTurma(String codigo) {
		turmaService.removerTurma(codigo);
	}

	public Turma atualizarTurma(Turma turmaNova) {
		return turmaService.atualizarTurma(turmaNova);
	}
	// FIM CRUD TURMA

	// CRUD HORARIO
	HorarioService horarioService = new HorarioService();
	public Horario cadastrarHorario(Horario horario) {
		return horarioService.cadastrarHorario(horario);
	}
	public Horario recuperarHorario(String codigo) {
		return horarioService.recuperarHorario(codigo);
	}

	public void removerHorario(String codigo) {
		horarioService.removerHorario(codigo);
	}

	public Horario atualizarHorario(Horario novoHorario) {
		return horarioService.atualizarHorario(novoHorario);
	}

	// FIM CRUD HORARIO

	// CRUD AVALIACAO
	AvaliacaoService avaliacaoService = new AvaliacaoService();

	public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao) {
		return avaliacaoService.cadastrarAvaliacao(avaliacao);
	}

	public Avaliacao recuperarAvaliacao(String codigo) {
		return avaliacaoService.recuperarAvaliacao(codigo);
	}

	public void removerAvaliacao(String codigo) {
		avaliacaoService.removerAvaliacao(codigo);
	}

	public Avaliacao atualizarAvaliacao(Avaliacao avaliacaoNova) {
		return avaliacaoService.atualizarAvaliacao(avaliacaoNova);
	}
	// FIM CRUD AVALIACAO
	
	//CRUD BOLETIM
	BoletimService boletimService = new BoletimService();
	
	public Boletim cadastrarBoletim(Boletim boletim) {
		return boletimService.cadastrarBoletim(boletim);
	}
	public Boletim recuperarBoletim(String codigo) {
		return boletimService.recuperarBoletim(codigo);
	}
	public void removerBoletim(String codigo) {
		boletimService.removerBoletim(codigo);
	}
	public Boletim atualizarAluno(Boletim BoletimNovo) {
		return boletimService.atualizarAluno(BoletimNovo);
	}
	//FIM CRUD BOLETIM
}
