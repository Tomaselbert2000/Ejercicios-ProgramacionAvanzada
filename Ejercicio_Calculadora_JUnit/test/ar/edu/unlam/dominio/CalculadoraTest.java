package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {
	
	private Calculadora calculadora;
	
	@Before
	public void inicializarCalculadora() {
		 calculadora = new Calculadora();
	}
	
	@Test
	public void dadoQueExisteUnaCalculadoraSiLlamoAlMetodoParaSumarDosEnteros5y7Obtengo12() {
		
		this.calculadora.setNum1(5);
		this.calculadora.setNum2(7);
		Integer sumaEsperada = 12;
		Integer sumaObtenida = this.calculadora.sumar();
		assertEquals(sumaEsperada, sumaObtenida);
	}
	
	@Test
	public void dadoQueExisteUnaCalculadoraSiLlamoAlMetodoParaRestarDosEnteros1020y365ResultaEn655(){
		
		this.calculadora.setNum1(1020);
		this.calculadora.setNum2(365);
		Integer restaEsperada = 655;
		Integer restaObtenida = this.calculadora.restar();
		assertEquals(restaEsperada, restaObtenida);
	}
	
	@Test
	public void dadoQueExisteUnaCalculadoraSiLlamoAlMetodoParaMultiplicar5x5ResultaEn25() {
		this.calculadora.setNum1(5);
		this.calculadora.setNum2(5);
		Integer productoEsperado = 25;
		Integer productoObtenido = this.calculadora.multiplicar();
		assertEquals(productoEsperado, productoObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaCalculadoraSiLlamoAlMetodoParaDividir10y10ResultaEn1(){
		this.calculadora.setNum1(10);
		this.calculadora.setNum2(10);
		Integer cocienteEsperado = 1;
		Integer cocienteObtenido = this.calculadora.dividir();
		assertEquals(cocienteEsperado, cocienteObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaCalculadoraSiLlamoAlMetodoParaDividir5y0ResultaEn0() {
		this.calculadora.setNum1(5);
		this.calculadora.setNum2(0);
		Integer cocienteEsperado = 0;
		Integer cocienteObtenido = this.calculadora.dividir();
		assertEquals(cocienteEsperado, cocienteObtenido);
	}
}
