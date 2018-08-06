package br.com.projetomatrix.academico.services;

import java.util.HashMap;
import java.util.Map;
import br.com.projetomatrix.academico.Disciplina;

public class DisciplinaService {
	private Long sequencial = new Long(0);

	private Map<String, Disciplina> hashDisciplinas = new HashMap<>();

	public Disciplina cadastrarDisciplina(Disciplina disciplina) {
		if (disciplina == null || hashDisciplinas.containsKey(disciplina.getCodigo()))
			return disciplina;

		disciplina.setCodigo(disciplina.getCodigo());
		hashDisciplinas.put(disciplina.getCodigo(), disciplina);
		return disciplina;
	}
	
	public Disciplina recuperarDisciplina(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		return hashDisciplinas.get(codigo);
	}

	public void removerDisciplina(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		hashDisciplinas.remove(codigo);
	}

	public Disciplina atualizarDisciplina(Disciplina disciplinaNova) {
		if (disciplinaNova == null || disciplinaNova.getCodigo() == null || disciplinaNova.getCodigo().length() == 0)
			throw new IllegalArgumentException();

		removerDisciplina(disciplinaNova.getCodigo());
		cadastrarDisciplina(disciplinaNova);

		return disciplinaNova;
	}

	public String gerarCodigo() {
		return String.valueOf(sequencial++);
	}
}
