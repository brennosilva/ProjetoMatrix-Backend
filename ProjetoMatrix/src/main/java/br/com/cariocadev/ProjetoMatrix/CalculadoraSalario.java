package br.com.cariocadev.ProjetoMatrix;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraSalario {

	public BigDecimal getSalarioLiquido(BigDecimal salarioBruto, BigDecimal percentualImpostoINSS) {
		// Implementar o código aqui
		if (validarNumero(salarioBruto) && validarNumero(percentualImpostoINSS)) {
			percentualImpostoINSS = percentualImpostoINSS.divide(new BigDecimal("100"));
			BigDecimal desconto = (salarioBruto.multiply(percentualImpostoINSS));
			return salarioBruto.subtract(desconto).setScale(2, RoundingMode.HALF_UP);
		}else {
			throw new IllegalArgumentException();
		}
	}

	public BigDecimal getValorINSS(BigDecimal salarioBruto) {
		// Implementar o código aqui
		if (validarNumero(salarioBruto)) {
			if (salarioBruto.compareTo(new BigDecimal("1693.72")) <= 0) {
				return salarioBruto.multiply(new BigDecimal("0.08")).setScale(2, RoundingMode.HALF_UP);
			} else if (salarioBruto.compareTo(new BigDecimal("1693.73")) >= 0
					&& salarioBruto.compareTo(new BigDecimal("2822.90")) <= 0) {
				return salarioBruto.multiply(new BigDecimal("0.09")).setScale(2, RoundingMode.HALF_UP);
			} else if (salarioBruto.compareTo(new BigDecimal("2822.91")) >= 0) {
				return salarioBruto.multiply(new BigDecimal("0.11")).setScale(2, RoundingMode.HALF_UP);
			}
		}else {
			throw new IllegalArgumentException();
		}
		return salarioBruto;		
	}

	public BigDecimal getValorPlanoDeSaude(Integer idade) {
		// TODO Auto-generated method stub
		if (validarNumero(idade)) {
			if (idade >= 0 && idade <= 9) {
				return new BigDecimal("75.00");
			} else if (idade >= 10 && idade <= 19) {
				return new BigDecimal("112.50");
			} else if (idade >= 20 && idade <= 29) {
				return new BigDecimal("168.75");
			} else if (idade >= 30 && idade <= 39) {
				return new BigDecimal("253.13");
			} else if (idade >= 40 && idade <= 49) {
				return new BigDecimal("379.69");
			} else if (idade >= 50 && idade <= 59) {
				return new BigDecimal("569.54");
			} else {
				return new BigDecimal("854.30");
			}
		}else {
			throw new IllegalArgumentException();
		}
	}

	public Boolean validarNumero(BigDecimal numero) {
		if (numero == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean validarNumero(Integer numero) {
		if (numero == null || numero < 0) {
			return false;
		} else {
			return true;
		}
	}
}
