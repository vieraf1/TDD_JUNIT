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
			throw new NullPointerException("O desempenho n�o foi definido para o usu�rio: " + funcionario.getNome());
		}
		if(funcionario.getSalario() == null) {
			throw new NullPointerException("O sal�rio n�o foi preenchido para o usu�rio: " + funcionario.getNome());
		}
		if(funcionario.getSalario().doubleValue() >= new BigDecimal(10000).doubleValue()) {
			throw new IllegalArgumentException("O usu�rio " + funcionario.getNome() + " recebe mais que o limite e n�o tem direito a ganhar b�nus!");
		}
		return true;
	}

}
