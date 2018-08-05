package br.com.cariocadev.ProjetoMatrix;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AvaliadorAluno {

	public BigDecimal getMaiorNota(BigDecimal[] notas) {
		// Implementação o código aqui
		if (validarNumero(notas) == false) {
			throw new IllegalArgumentException();
		}
		BigDecimal maior = new BigDecimal("0");
		for (int x = 0; x < notas.length; x++) {
			maior = maior.max(notas[x]);
		}
		return maior;

	}

	public BigDecimal getMedia(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {
		// Implementação o código aqui
		if ((validarNumero(nota1) && validarNumero(nota2) && validarNumero(nota3)) == false) {
			throw new IllegalArgumentException();
		}
		BigDecimal media = new BigDecimal("0");
		media = nota1.add(nota2.add(nota3));
		return media.divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
	}

	public String getStatus(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {
		// Implementação o código aqui
		if ((validarNumero(nota1) && validarNumero(nota2) && validarNumero(nota3)) == false) {
			throw new IllegalArgumentException();
		}
			BigDecimal media = getMedia(nota1, nota2, nota3);
			if (media.compareTo(new BigDecimal("6")) >= 0)
				return "APROVADO";
			else if (media.compareTo(new BigDecimal("4")) < 0)
				return "REPROVADO";
			else if (media.compareTo(new BigDecimal("6")) < 0 && media.compareTo(new BigDecimal("4")) >= 0)
				return "PROVA_FINAL";
			return null;
		}


	public Boolean validarNumero(BigDecimal nota) {
		return (nota == null || nota.compareTo(BigDecimal.ZERO) < 0 || nota.compareTo(new BigDecimal("10")) > 0);
	}

	public Boolean validarNumero(BigDecimal[] nota) {
		return (nota == null);
	}

}
