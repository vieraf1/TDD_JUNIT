package tdd.service;

import java.math.BigDecimal;

import tdd.modelo.Funcionario;

public class ReajusteService {

	public void reajustarSalario(Funcionario funcionario) {
		if (funcionario.getDesempenho() != null && funcionario.getSalario() != null) {
			switch (funcionario.getDesempenho()) {
			case A_DESEJAR:
				ajustarTresPorcento(funcionario);
				break;
			case BOM:
				ajustarTresPorcento(funcionario);
				break;
			case OTIMO:
				ajustarTresPorcento(funcionario);
				break;
			}
		}
	}

	private void ajustarTresPorcento(Funcionario funcionario) {
		BigDecimal salarioAjustado = funcionario.getSalario().multiply(new BigDecimal(1.03));
		funcionario.setSalario(salarioAjustado);
	}

}
