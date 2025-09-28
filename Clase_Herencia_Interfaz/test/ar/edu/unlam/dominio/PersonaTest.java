package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class PersonaTest {
	
	
	@Test
	public void dadoQueExisteUnaPersonaAlInstanciarlaPuedoConsultarSusAtributos() {
		Persona persona = new Persona(123456, "Tomas", 30);
		
		// para usar los assertEquals aca debemos castear porque da problemas al pasar objetos en lugar de tipos primitivos
		assertEquals(123456, (int)persona.getDni());
		assertEquals("Tomas", persona.getNombre());
		assertEquals(30, (int)persona.getEdad());
		assertEquals("Soy una persona", persona.toString());
	}
	
	@Test
	public void dadoQueExisteUnaPersonaAsalariadoCuandoLoInstancioPorHerenciaPuedoConsultarSusAtributos() {
		Asalariado persona = new Asalariado(123456, "Tomas", 30, 10000.0);
		assertEquals(123456, (int)persona.getDni());
		assertEquals("Tomas", persona.getNombre());
		assertEquals(30, (int)persona.getEdad());
		assertEquals(10000.0, (double)persona.getSalario(), 0.0); // aca agregamos el parámetro delta 0.0
		assertEquals("Soy un asalariado", persona.toString()); // se sobreescribe el toString() de asalariado

	}
	
	@Test
	public void dadoQueExisteUnaPersonaVoluntarioSiLaInstancioPorHerenciaPuedoConsultarSusAtributos() {
		Voluntario persona = new Voluntario(123456, "Tomas", 30, 5);
		assertEquals(123456, (int)persona.getDni());
		assertEquals("Tomas", persona.getNombre());
		assertEquals(30, (int)persona.getEdad());
		assertEquals(5, (int)persona.getCantidadHoras());
		assertEquals("Soy un voluntario", persona.toString()); // y sobreescribimos tambien el toString() de Voluntario
	}
	
	@Test
	public void dadoQueExisteUnArrayDePersonaPorHerenciaPuedoAgregarUnAsalariadoYUnVoluntario() {
		Persona persona = new Persona(1234, "Tomas", 24);
		Asalariado asalariado = new Asalariado(4567, "Asalariado", 28, 1000.0);
		Voluntario voluntario = new Voluntario(12345, "Tomas", 29, 6);
		
		// aca creamos una coleccion cuyo tipo de dato es la superclase Persona
		ArrayList<Persona> listaPersonas = new ArrayList<>();
		
		// y ahora agregamos los objetos, el size tiene que devolver 3 luego de agregar
		listaPersonas.add(persona);
		listaPersonas.add(asalariado);
		listaPersonas.add(voluntario);
		
		Integer tamañoEsperado = 3;
		Integer tamañoObtenido = listaPersonas.size();
		
		// y aca los comparamos
		assertEquals(tamañoEsperado, tamañoObtenido);
	}
	
	@Test
	public void dadoQueLaClasePersonaImplementaLaInterfazOperacionesObtengoQuePuedoConsultarElMetodoAyudar() {
		// la superclase Persona implementa todos los metodos que se definan en la interfaz de Operaciones
		Persona persona = new Persona(12345, "Tomas", 24);
		String mensajeEsperado = "Soy una persona y estoy ayudando";
		String mensajeObtenido = persona.ayudar();
		
		// comparamos el mensaje esperado con lo que realmente devuelve Persona al implementar el metodo
		assertEquals(mensajeEsperado, mensajeObtenido);
	}
}
