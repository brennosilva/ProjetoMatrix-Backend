package br.com.projetomatrix.academico.services;

import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.Avaliacao;

public class AvaliacaoService {

	private int sequencial = 1;

	private Map<String, Avaliacao> hashAvaliacoes = new HashMap<>();

	public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao) {
		if (avaliacao == null || hashAvaliacoes.containsKey(avaliacao.getCodigo()))
			return avaliacao;

		avaliacao.setCodigo(gerarCodigo());
		hashAvaliacoes.put(avaliacao.getCodigo(), avaliacao);	
		return avaliacao;
	}

	public Avaliacao recuperarAvaliacao(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();
		return hashAvaliacoes.get(codigo);
	}

	public void removerAvaliacao(String codigo) {
		if (codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();
		hashAvaliacoes.remove(codigo);
	}

	public Avaliacao atualizarAvaliacao(Avaliacao avaliacaoNova) {
		if (avaliacaoNova == null || avaliacaoNova.getCodigo() == null || avaliacaoNova.getCodigo().length() == 0)
			throw new IllegalArgumentException();

		removerAvaliacao(avaliacaoNova.getCodigo());
		cadastrarAvaliacao(avaliacaoNova);
		return avaliacaoNova;
	}
	public String gerarCodigo() {
		return "av" + String.valueOf(sequencial++);
	}
}
