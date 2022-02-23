package tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		
		service.reajustarSalario(funcionario);
		assertEquals(new BigDecimal(1000).doubleValue(), funcionario.getSalario().doubleValue());
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Lucas", LocalDate.now(), new BigDecimal(1000), DesempenhoEnum.A_DESEJAR);
		
		service.reajustarSalario(funcionario);
		assertEquals(new BigDecimal(1030).doubleValue(), funcionario.getSalario().doubleValue());
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
