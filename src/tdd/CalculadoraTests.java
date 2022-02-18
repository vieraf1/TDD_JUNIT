package tdd;

public class CalculadoraTests {

	public static void main(String[] args) {
		Calculadora cal = new Calculadora();
		int soma = cal.somar(3, 4);
		System.out.println(soma);
		
		soma = cal.somar(3, 0);
		System.out.println(soma);
		
		soma = cal.somar(0, 0);
		System.out.println(soma);
		
		soma = cal.somar(-3, 1);
		System.out.println(soma);
	}

}
