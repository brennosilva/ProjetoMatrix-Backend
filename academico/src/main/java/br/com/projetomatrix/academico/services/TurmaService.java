package br.com.projetomatrix.academico.services;
import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.Turma;

class TurmaService {
	private int sequencial = new Integer(0);
	private Map<String, Turma> hashTurmas = new HashMap<>();

	public String gerarCodigo() {
		return String.valueOf(sequencial++);
	}

	public Turma cadastrarTurma(Turma turma) {
		if (turma == null || hashTurmas.containsKey(turma.getCodigo()))
			return turma;

		turma.setCodigo(gerarCodigo());
		hashTurmas.put(turma.getCodigo(), turma);

		return turma;
	}

	public Turma recuperarTurma(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();
		return hashTurmas.get(codigo);
	}

	public void removerTurma(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		hashTurmas.remove(codigo);
	}

	public Turma atualizarTurma(Turma turmaNova) {
		if (turmaNova == null || turmaNova.getCodigo() == null || turmaNova.getCodigo().length() == 0)
			throw new IllegalArgumentException();

		removerTurma(turmaNova.getCodigo());
		cadastrarTurma(turmaNova);
		return turmaNova;
	}

}