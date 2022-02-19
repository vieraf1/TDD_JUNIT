package tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioSalarioAlto() {
		BonusService bonus = new BonusService();
		BigDecimal valorBonus = bonus.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal(12000)));
		
		assertEquals(BigDecimal.ZERO.doubleValue(), valorBonus.doubleValue());
	}
	
	@Test
	void bonusDeveriaSerMilParaFuncionarioSalarioBaixo() {
		BonusService bonus = new BonusService();
		BigDecimal valorBonus = bonus.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal(7000)));
		
		assertEquals(new BigDecimal(700).doubleValue(), valorBonus.doubleValue());
	}
	
	@Test
	void bonusDeveSerDezProcentoDeSalariosAteDezMil() {
		BonusService bonus = new BonusService();
		BigDecimal valorBonus = bonus.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal(10000)));
		
		assertEquals(new BigDecimal(1000).doubleValue(), valorBonus.doubleValue());
	}

}
