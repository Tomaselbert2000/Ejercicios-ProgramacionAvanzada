package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GimnasioTest {
	
	/*
	 * Esta es una clase de testeo para probar el funcionamiento
	 * de una clase productiva Gimnasio, la cual se encontrará dentro del paquete src
	 */
	
	// a fin de refactorizar el codigo usamos un atributo de la clase gimnasio
	private Gimnasio eclipse;
	
	/*
	 * Adentro de la anotacion del Before lo que hacemos es especificar
	 * que se cree un objeto para poder permitir que se corran los tests
	 * A esa instancia le damos el nombre de la instancia que vamos a usar
	 * y dentro de cada test nos referimos usando "this"
	 */
	
	@Before
	public void inicializacionGimnasio() {
		this.eclipse = new Gimnasio();
	}
	
	// a partir de aca escribimos las pruebas, TODAS SON VOID, no deben retornar nada
	
	@Test // con la anotacion indicamos que esto es una prueba, solo se ejecuta junto con las pruebas
	public void dadoQueExisteUnGimnasioConNombreCuandoConsultoSuNombreObtengoEclipseGym() {
		
		/*
		 * Para la preparacion vamos a necesitar tener un objeto gimnasio
		 * creado de antemano, al cual le podamos pedir el nombre a traves
		 * de un getter y obtener una respuesta
		 */
		
		/*
		 * Este test implica agregar un setter a la clase Gimnasio, es decir, se agrega
		 * la menor cantidad de codigo productivo posible (productivo ya que se encuentra
		 * en la clase Gimnasio)
		 */
		
		eclipse.setNombre("Eclipse Gym");
		
		// ahora pasamos a la ejecucion de un metodo
		String nombreDelGimnasioObtenido = this.eclipse.getNombre();
		
		String nombreDelGimnasioEsperado = "Eclipse Gym"; 
		
		// y por ultimo verificamos que se obtenga el resultado esperado
		
		/*
		 * Para poder realizar la comprobacion con assertEquals tenemos dos valores
		 * de entrada, el primero es el valor que se espera que retorne la prueba
		 * si fue correcta, y el otro es el valor obtenido
		 * 
		 * Es necesario realizar todos los asserts que garantizen que la prueba es
		 * correcta y confiable.
		 */
		
		assertEquals(nombreDelGimnasioEsperado, nombreDelGimnasioObtenido);
	}
	
	@Test
	public void dadoQueExisteUnGimnasioCuandoInstancioUnObjetoConSuNombreYConsultoElNombreObtengoEclipseGym() {
		
		/*
		 * Dentro de este segundo test lo que buscamos es verificar que
		 * se use de manera correcta el constructor de la clase el cual
		 * tambien fue añadido al momento de generar este test, otro caso
		 * en el cual agregamos la minima cantidad de codigo productivo
		 */
		this.eclipse.setNombre("Eclipse Gym2");
		String nombreDelGimnasioEsperado = "Eclipse Gym2";
		String nombreDelGimnasioObtenido = this.eclipse.getNombre();
		
		assertEquals(nombreDelGimnasioEsperado, nombreDelGimnasioObtenido);
	}
	
	@Test
	public void dadoQueExisteUnGimnasioConNombreYCapacidadCuandoConsultoSuCapacidadObtengo50() {
		this.eclipse.setNombre("Mi nuevo Gimnasio");
		
		/*
		 * Muy importante recordar que NO SE USAN DATOS PRIMITIVOS
		 * Siempre hay que referirse a la clases wrapper
		 */
		
		/*
		 * La minima cantidad de codigo productivo posible que se agrego
		 * a la clase gimnasio fue un getter que retorna el valor de la capacidad
		 */
		Integer capacidadDelGimnasioEsperada = 50;
		Integer capacidadDelGimnasioObtenida = this.eclipse.getCapacidad();
		
		assertEquals(capacidadDelGimnasioObtenida, capacidadDelGimnasioEsperada);
	}
}
