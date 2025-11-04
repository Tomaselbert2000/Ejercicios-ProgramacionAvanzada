package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClienteTest {
	
	@Test
	public void dadoQueExisteUnClienteObtengoQuePuedoConsultarSusAtributos() {
		Integer dniCliente = 112233;
		String nombre = "Tomas";
		String apellido = "Elbert";
		Cliente cliente = new Cliente(dniCliente, nombre, apellido);
		assertEquals(dniCliente, cliente.getDni());
		assertEquals(nombre, cliente.getNombre());
		assertEquals(apellido, cliente.getApellido());
	}
}
