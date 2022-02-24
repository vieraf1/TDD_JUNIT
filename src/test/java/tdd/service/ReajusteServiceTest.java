package tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import tdd.modelo.Funcionario;
import tdd.modelo.enums.DesempenhoEnum;

class ReajusteServiceTest {

	@Test
	public void reajusteNaoDeveSerAjustadoDevidoNaoTerDesempenhoCadastradoNoFuncionario() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Lucas", LocalDate.now(), new BigDecimal(1000));
		
		try {
			service.reajustarSalario(funcionario);
			fail("deveria ter dado erro devido a não ter definido o desempenho");
		} catch(NullPointerException | IllegalArgumentException e) {
		}
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Lucas", LocalDate.now(), new BigDecimal(10000), DesempenhoEnum.A_DESEJAR);
		
		try {
			service.reajustarSalario(funcionario);
			fail("deveria ter dado erro devido ao salário ser igual ou maior a 10.000,00");
		} catch(NullPointerException | IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void reajusteDeveriaSerDeDezPorcentoQuandoDesempenhoForBom() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Lucas", LocalDate.now(), new BigDecimal(1000), DesempenhoEnum.BOM);
		
		service.reajustarSalario(funcionario);
		assertEquals(new BigDecimal(1100).doubleValue(), funcionario.getSalario().doubleValue());
	}
	
	@Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Lucas", LocalDate.now(), new BigDecimal(1000), DesempenhoEnum.OTIMO);
		
		service.reajustarSalario(funcionario);
		assertEquals(new BigDecimal(1200).doubleValue(), funcionario.getSalario().doubleValue());
	}

}
