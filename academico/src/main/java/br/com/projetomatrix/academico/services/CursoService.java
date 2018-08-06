package br.com.projetomatrix.academico.services;

import java.util.HashMap;
import java.util.Map;
import br.com.projetomatrix.academico.Curso;

public class CursoService {
	private int sequencial = new Integer(00);
	private Map<String, Curso> hashCursos = new HashMap<>();

	public String gerarCodigo() {
		return String.valueOf(sequencial++);
	}

	public Curso cadastrarCurso(Curso curso) {
		if (curso == null || hashCursos.containsKey(curso.getCodigo()))
			return curso;

		curso.setCodigo(gerarCodigo());
		hashCursos.put(curso.getCodigo(), curso);

		return curso;
	}

	public Curso recuperarCurso(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		return hashCursos.get(codigo);
	}

	public void removerCurso(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		hashCursos.remove(codigo);
	}

	public Curso atualizarCurso(Curso cursoNovo) {
		if (cursoNovo == null || cursoNovo.getCodigo() == null || cursoNovo.getCodigo().length() == 0)
			throw new IllegalArgumentException();

		removerCurso(cursoNovo.getCodigo());
		cadastrarCurso(cursoNovo);
		return cursoNovo;
	}

}
