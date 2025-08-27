package ar.edu.unlam.dominio;

public class Calculadora {
	
	/*
	 * Esta clase Calculadora contiene el código
	 * que consideramos productivo, el cual luego
	 * vamos a testear con JUnit
	 */
	
	private Integer num1;
	private Integer num2;
	
	public Calculadora() {}
	
	public Integer sumar() {
		return (num1+num2);
	}
	
	public Integer restar() {
		return (num1-num2);
	}
	
	public Integer multiplicar() {
		return (num1*num2);
	}
	
	public Integer dividir() {
		if(num2 != 0) {
			return (num1/num2);
		}else {
			return 0;
		}
	}
	
	public void setNum1(Integer num1) {
		this.num1 = num1;
	}
	
	public void setNum2(Integer num2) {
		this.num2 = num2;
	}
}
