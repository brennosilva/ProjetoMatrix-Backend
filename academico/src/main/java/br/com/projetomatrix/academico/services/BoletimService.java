package br.com.projetomatrix.academico.services;

import java.util.HashMap;
import java.util.Map;
import br.com.projetomatrix.academico.Boletim;

public class BoletimService {
	private Long sequencial = new Long(0);

	private Map<String, Boletim> hashBoletins = new HashMap<>();

	public Boletim cadastrarBoletim(Boletim boletim) {
		if (boletim == null || hashBoletins.containsKey(boletim.getCodigo()))
			return boletim;

		boletim.setCodigo(gerarcodigo());

		hashBoletins.put(boletim.getCodigo(), boletim);

		return boletim;
	}

	public Boletim recuperarBoletim(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		return hashBoletins.get(codigo);
	}

	public void removerBoletim(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();

		hashBoletins.remove(codigo);
	}

	public Boletim atualizarAluno(Boletim BoletimNovo) {
		if (BoletimNovo == null || BoletimNovo.getCodigo() == null || BoletimNovo.getCodigo().length() == 0)
			throw new IllegalArgumentException();

		removerBoletim(BoletimNovo.getCodigo());
		cadastrarBoletim(BoletimNovo);

		return BoletimNovo;
	}

	public String gerarcodigo() {
		return "B" + sequencial++;
	}
}
