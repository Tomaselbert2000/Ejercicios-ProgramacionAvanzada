package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		Carga carga = new Carga(1L, peso);
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
		Carga carga = new Carga(1L, peso);
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
		Carga carga = new Carga(1L, peso);
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
		Carga carga1 = new Carga(1L, peso);
		Carga carga2 = new Carga(2L, 3*peso);
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
	
	// ¿por que es tan importante el uso correcto de assertEquals()?
	@Test
	public void testEquals() {
		String valorEsperado = "Algo";
		String valorObtenido = new String("Algo");
		assertTrue(valorEsperado.equals(valorObtenido));
		
		Carga carga = new Carga(1L, 1D);
		Carga otraCarga = new Carga(1L, 1D);
		assertTrue(carga.equals(otraCarga));
		
		/*
		 * Para que este metodo funcione lo que hicimos fue hacer un Override
		 * del metodo equals, para modificar el criterio que toma para comparar
		 * los objetos ya que evaluamos si son la misma instancia, si no es nulo
		 * y ademas si son de la misma clase. Esto lo hacemos dentro de la misma
		 * clase Carga con un metodo de nombre equals anotado con @Override
		 * 
		 * Sin esa modificacion, al correr este metodo el test va a devolver en
		 * ROJO, porque AssertTrue evalua un boolean, y aunque tengan el mismo
		 * contenido, son dos instancias diferentes, por lo cual falla
		 * 
		 * Cuando hacemos el Override, el criterio cambia, y dos instancias
		 * diferentes pero con exactamente el mismo contenido devuelven VERDE
		 * al momento de correr el test.
		 */
	}
	
	@Test
	public void testHashCode() {
		Carga carga = new Carga(1L, 1000D);
		Integer hashCarga = carga.hashCode();
		Carga otraCarga = new Carga(1L, 1000D);
		Integer hashOtraCarga = otraCarga.hashCode();
		
		/*
		 * Para que este metodo retorne VERDE, hacemos lo mismo
		 * que en el anterior con el metodo hashCode dentro de 
		 * la clase Carga. Al hacer @Override, se usa el metodo
		 * hashCode de la clase Carga, el cual va a devolver el
		 * hash calculado en base al contenido, es decir, el id
		 * y el peso de la carga.
		 */
		assertTrue(hashCarga.equals(hashOtraCarga));
	}
	
	@Test
	public void dadoQueExisteUnMontacargasQueNoAdmiteCargasDuplicadasCuandoAgregoUnaCargaDuplicadaObtengoFalso() {
		Double pesoMaximoPermitido = 1000.0;
		Montacarga montacarga = new Montacarga(pesoMaximoPermitido);
		Carga carga1 = new Carga(1L, 10D);
		boolean cargaAgregada = montacarga.agregarCarga(carga1); // realizo la primera carga con esta instancia
		boolean segundaCargaAgregada = montacarga.agregarCarga(carga1); // ¿que pasa si intento cargar de nuevo lo mismo?
		
		assertTrue(cargaAgregada); // esta linea va a dar verde al ser la primera vez que agregamos la instancia al hashset
		//assertTrue(segundaCargaAgregada); // y aca da rojo porque no acepta duplicados, haciendo que todo este test de ROJO
	}
}
