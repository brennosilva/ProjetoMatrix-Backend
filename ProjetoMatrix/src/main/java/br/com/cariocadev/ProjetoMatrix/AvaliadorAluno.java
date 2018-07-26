package br.com.cariocadev.ProjetoMatrix;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AvaliadorAluno {

	public BigDecimal getMaiorNota(BigDecimal[] notas) {
		// Implementação o código aqui
		if (validarNumero(notas)) {
			BigDecimal maior = new BigDecimal("0");
			maior = notas[0].max(notas[1].add(notas[2]));			
			return maior;
		}
		return null;

	}

	public BigDecimal getMedia(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {
		// Implementação o código aqui
		if (validarNumero(nota1) && validarNumero(nota2) && validarNumero(nota3)) {
			BigDecimal media = new BigDecimal("0");
			media = nota1.add(nota2.add(nota3));
			return media.divide(new BigDecimal("3"),2,RoundingMode.HALF_UP);			
		}
		return null;
	}

	public String getStatus(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {
		// Implementação o código aqui
		if (validarNumero(nota1) && validarNumero(nota2) && validarNumero(nota3)) {
			BigDecimal media = getMedia(nota1, nota2, nota3);
			if (media.compareTo(new BigDecimal("6")) >= 0)
				return "APROVADO";
			else if (media.compareTo(new BigDecimal("4")) < 0)
				return "REPROVADO";
			else if (media.compareTo(new BigDecimal("6")) < 0 && media.compareTo(new BigDecimal("4")) >= 0)
				return "PROVA_FINAL";
		}
		return null;
	}

	public Boolean validarNumero(BigDecimal nota) {
		if (nota == null || nota.compareTo(BigDecimal.ZERO) < 0 || nota.compareTo(new BigDecimal("10")) > 0) {
			throw new IllegalArgumentException();
		}else {
			return true;
		}
	}

	public Boolean validarNumero(BigDecimal[] nota) {
		if (nota == null) {
			throw new IllegalArgumentException();
		} else {
			return true;
		}
	}

}
