package tdd.service;

import java.math.BigDecimal;

import tdd.modelo.Funcionario;

public class ReajusteService {

	public void reajustarSalario(Funcionario funcionario) {
		if (funcionario.realizarAjusteSalarial()) {
			BigDecimal salarioAjustado = funcionario.getSalario().multiply(funcionario.getDesempenho().getTaxaAjuste());
			funcionario.setSalario(salarioAjustado);
		}
	}

}
