package br.com.projetomatrix.academico.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.Coordenador;

public class CoordenadorService {
private Long sequencial = new Long(0);
	
	private Map<String, Coordenador> hashCoordenadores = new HashMap<>();
	
	public Coordenador cadastrarCoordenador(Coordenador coordenador)
	{
		if(coordenador == null || hashCoordenadores.containsKey(coordenador.getMatricula()))
			return coordenador;
		
		coordenador.setMatricula(gerarMatricula());
		
		hashCoordenadores.put(coordenador.getMatricula(), coordenador);
		
		return coordenador;
	}
	
	public Coordenador recuperarCoordenador(String matricula)
	{
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		return hashCoordenadores.get(matricula);
	}
	
	public void removerCoordenador(String matricula)
	{
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		hashCoordenadores.remove(matricula);
	}
	
	public Coordenador atualizarCoordenador(Coordenador coordenadorNovo)
	{
		if(coordenadorNovo == null || coordenadorNovo.getMatricula() == null ||
				coordenadorNovo.getMatricula().length() == 0)
			throw new IllegalArgumentException();
		
		removerCoordenador(coordenadorNovo.getMatricula());
		cadastrarCoordenador(coordenadorNovo);
		
		return coordenadorNovo;
	}

	public String gerarMatricula() {
		
		int ano = LocalDateTime.now().getYear();
		String anoConvertido = Integer.toString(ano);
		
		int mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1":"2";
		
		sequencial.sum(sequencial, 1);
		
		String matricula = anoConvertido + semestre + sequencial.intValue();
		
		return matricula;
	}
	
}
