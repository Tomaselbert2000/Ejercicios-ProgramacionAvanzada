package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void dadoQueExisteUnClienteObtengoQuePuedoConsultarSusAtributos() {
		Integer dni = 112233;
		String nombre = "Tomas";
		String apellido = "Elbert";
		Integer edad = 24;
		Cliente cliente = new Cliente(dni, nombre, apellido, edad);
		assertEquals(dni, cliente.getDni());
		assertEquals(nombre, cliente.getNombre());
		assertEquals(apellido, cliente.getApellido());
		assertEquals(edad, cliente.getEdad());
	}
}
