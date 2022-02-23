package tdd.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import tdd.modelo.enums.DesempenhoEnum;

public class Funcionario {

	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;
	private DesempenhoEnum desempenho;

	public Funcionario(String nome, LocalDate dataAdmissao, BigDecimal salario) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}
	
	public Funcionario(String nome, LocalDate dataAdmissao, BigDecimal salario, DesempenhoEnum desempenho) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
		this.desempenho = desempenho;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public DesempenhoEnum getDesempenho() {
		return desempenho;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public boolean realizarAjusteSalarial() {
		return desempenho != null && salario != null;
	}
}
