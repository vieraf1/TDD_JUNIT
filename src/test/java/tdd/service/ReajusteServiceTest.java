package tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import tdd.modelo.Funcionario;
import tdd.modelo.enums.DesempenhoEnum;

class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	private void inicializar(BigDecimal salario, DesempenhoEnum desempenho) {
		service = new ReajusteService();
		funcionario = new Funcionario("Lucas", LocalDate.now(), salario, desempenho);
	}

	@Test
	public void reajusteNaoDeveSerAjustadoDevidoNaoTerDesempenhoCadastradoNoFuncionario() {
		inicializar(new BigDecimal(1000), null);
		
		try {
			service.reajustarSalario(funcionario);
			fail("deveria ter dado erro devido a não ter definido o desempenho");
		} catch(NullPointerException | IllegalArgumentException e) {
		}
	}
	
	@Test
	public void reajusteNaoDeveSerAjustadoDevidoValorDeSalarioExcederLimite() {
		inicializar(new BigDecimal(10000), DesempenhoEnum.A_DESEJAR);
		
		try {
			service.reajustarSalario(funcionario);
			fail("deveria ter dado erro devido ao salário ser igual ou maior a 10.000,00");
		} catch(NullPointerException | IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		inicializar(new BigDecimal(1000), DesempenhoEnum.A_DESEJAR);
		
		service.reajustarSalario(funcionario);
		assertEquals(new BigDecimal(1030).doubleValue(), funcionario.getSalario().doubleValue());
	}
	
	@Test
	public void reajusteDeveriaSerDeDezPorcentoQuandoDesempenhoForBom() {
		inicializar(new BigDecimal(1000), DesempenhoEnum.BOM);
		
		service.reajustarSalario(funcionario);
		assertEquals(new BigDecimal(1100).doubleValue(), funcionario.getSalario().doubleValue());
	}
	
	@Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
		inicializar(new BigDecimal(1000), DesempenhoEnum.OTIMO);
		
		service.reajustarSalario(funcionario);
		assertEquals(new BigDecimal(1200).doubleValue(), funcionario.getSalario().doubleValue());
	}

}
