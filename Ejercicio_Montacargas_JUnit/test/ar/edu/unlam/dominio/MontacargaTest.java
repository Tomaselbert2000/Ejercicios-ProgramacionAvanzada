package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

// creamos una clase de testeo de Montacargas
public class MontacargaTest {
	
	/*
	 * Muy importante recordar que al momento de correr los tests,
	 * se ejecutan de manera desordenada e independiente unos de
	 * otros, a fin de simular cómo realmente el usuario final
	 * podría interactuar con el programa.
	 */
	
	@Test
	public void dadoQueExisteUnaCargaAlCrearLaMismaSePuedeObtenerSuPeso() {
		
		// definimos los datos que necesitamos para testear peso
		Double peso = 100.0;
		Carga carga = new Carga(peso);
		Double valorEsperado = 100.0;
		Double valorObtenido = carga.getPeso();
		
		// llamamos a assertEquals para comparar los datos
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void dadoQueNoExisteUnMontacargaAlCrearLaMismaSePuedeObtenerSuPesoMaximoPermitido() {
		
		// datos necesarios
		Double pesoMaximoPermitido = 1000.0;
		Montacarga montaCarga = new Montacarga (pesoMaximoPermitido);
		Double valorEsperado = 1000.0;
		Double valorObtenido = montaCarga.getPeso();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void dadoQueExisteUnMontacargaYUnaCargaCuandoSuboLaCargaAlMismoVerificarElPesoCargado() {
		// datos necesarios
		Double peso = 100.0;
		Carga carga = new Carga(peso);
		Double pesoMaximoPermitido = 1000.0;
		Montacarga montaCarga = new Montacarga(pesoMaximoPermitido);
		montaCarga.cargar(carga);
		Double valorEsperado = 100.0;
		Double valorObtenido = montaCarga.obtenerPesoCargado();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void dadoQueExisteUnMontacargasVerificarQueSePuedaSubirUnaCarga() {
		Double peso = 100.0;
		Carga carga = new Carga(peso);
		Double pesoMaximoPermitido = 1000.0;
		Montacarga montaCarga = new Montacarga(pesoMaximoPermitido);
		montaCarga.cargar(carga);
		Integer valorEsperado = 1;
		Integer valorObtenido = montaCarga.obtenerCantidadCargas();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void dadoQueExisteUnMontacargasConVariasCargasAlVaciarloObtengoComoPesoCargadoIgualACero() {
		
		// ahora creamos dos cargas
		Double peso = 200.0;
		Carga carga1 = new Carga(peso);
		Carga carga2 = new Carga(3*peso);
		Double pesoMaximoPermitido = 1000.0;
		Montacarga montacarga = new Montacarga(pesoMaximoPermitido);
		
		// cargamos dos veces
		montacarga.cargar(carga1);
		montacarga.cargar(carga2);
		
		// vaciamos el arraylist de cargas aca
		montacarga.vaciar();
		
		Double valorEsperado = 0.0;
		Double valorObtenido = montacarga.obtenerPesoCargado();
		assertEquals(valorEsperado, valorObtenido);
	}
}
