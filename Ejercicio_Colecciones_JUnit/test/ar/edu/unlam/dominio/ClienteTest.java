package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ClienteTest {

	@Test
	public void dadoQueNoExisteUnClienteSiLoCreoYPreguntoSuNombreObtengoTomas() {
		Cliente cliente = new Cliente("Tomas", null);
		String nombreEsperado = "Tomas";
		String nombreObtenido = cliente.getNombre();
		assertEquals(nombreEsperado, nombreObtenido);
	}

	@Test
	public void dadoQueNoExisteUnClienteSiLoCreoYPreguntoSuApellidoObtengoElbert() {
		Cliente cliente = new Cliente("Tomas", "Elbert");
		String apellidoEsperado = "Elbert";
		String apellidoObtenido = cliente.getApellido();
		assertEquals(apellidoEsperado, apellidoObtenido);
	}

	@Test
	public void dadoQueExisteUnClienteDeNombreTomasElbertDeboPoderModificarSusDatosYObtengoJuanManuelGonzalez() {
		Cliente cliente = new Cliente("Tomas", "Elbert");
		cliente.setNombre("Juan Manuel");
		cliente.setApellido("Gonzalez");
		String nombreEsperado = "Juan Manuel";
		String nombreObtenido = cliente.getNombre();
		String apellidoEsperado = "Gonzalez";
		String apellidoObtenido = cliente.getApellido();

		assertEquals(nombreEsperado, nombreObtenido);
		assertEquals(apellidoEsperado, apellidoObtenido);
	}

	@Test
	public void dadoQueExisteUnClienteYUnaPropiedadSiLaCompraSuListaDePropiedadesSeIncrementaEn1() {
		Cliente cliente = new Cliente("Tomas", "Elbert");
		Propiedad prop = new Propiedad(1, 2000.0, "PH", "Gonzalez Catan");
		cliente.comprarPropiedad(prop);
		Integer cantidadDePropiedadesEsperada = 1;
		Integer cantidadDePropiedadesObtenida = cliente.getCantidadPropiedades();
		assertEquals(cantidadDePropiedadesEsperada, cantidadDePropiedadesObtenida);
	}
}
