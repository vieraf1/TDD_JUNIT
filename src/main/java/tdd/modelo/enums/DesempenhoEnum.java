package tdd.modelo.enums;

import java.math.BigDecimal;

public enum DesempenhoEnum {
	A_DESEJAR(new BigDecimal(1.03)),
	BOM(new BigDecimal(1.10)),
	OTIMO(new BigDecimal(1.20));
	
	private BigDecimal taxaAjuste;
	
	DesempenhoEnum(BigDecimal taxaAjuste) {
		this.taxaAjuste = taxaAjuste;
	}
	
	public BigDecimal getTaxaAjuste() {
		return taxaAjuste;
	}

}