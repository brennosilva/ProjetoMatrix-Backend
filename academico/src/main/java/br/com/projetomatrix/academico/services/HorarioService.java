package br.com.projetomatrix.academico.services;

import java.util.HashMap;
import java.util.Map;
import br.com.projetomatrix.academico.Horario;

public class HorarioService {
	private int sequencial = new Integer(0);
	private Map<String, Horario> hashHorarios = new HashMap<>();

	public String gerarCodigo() {
		return String.valueOf(sequencial++);
	}

	public Horario cadastrarHorario(Horario horario) {
		if (horario == null || hashHorarios.containsKey(horario.getCodigo()))
			return horario;

		horario.setCodigo(gerarCodigo());
		hashHorarios.put(horario.getCodigo(), horario);

		return horario;
	}

	public Horario recuperarHorario(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();
		return hashHorarios.get(codigo);
	}

	public void removerHorario(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		hashHorarios.remove(codigo);
	}

	public Horario atualizarHorario(Horario novoHorario) {
		if (novoHorario == null || novoHorario.getCodigo() == null || novoHorario.getCodigo().length() == 0)
			throw new IllegalArgumentException();

		removerHorario(novoHorario.getCodigo());
		cadastrarHorario(novoHorario);
		return novoHorario;
	}
}
