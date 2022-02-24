package tdd.service;

import java.math.BigDecimal;

import tdd.modelo.Funcionario;

public class ReajusteService {

	public void reajustarSalario(Funcionario funcionario) {
		if (validarFuncionario(funcionario)) {
			BigDecimal salarioAjustado = funcionario.getSalario().multiply(funcionario.getDesempenho().getTaxaAjuste());
			funcionario.setSalario(salarioAjustado);
		}
	}
	
	private boolean validarFuncionario(Funcionario funcionario) {
		if(funcionario.getDesempenho() == null) {
			throw new NullPointerException("O desempenho não foi definido para o usuário: " + funcionario.getNome());
		}
		if(funcionario.getSalario() == null) {
			throw new NullPointerException("O salário não foi preenchido para o usuário: " + funcionario.getNome());
		}
		if(funcionario.getSalario().doubleValue() >= new BigDecimal(10000).doubleValue()) {
			throw new IllegalArgumentException("O usuário " + funcionario.getNome() + " recebe mais que o limite e não tem direito a ganhar bônus!");
		}
		return true;
	}

}
