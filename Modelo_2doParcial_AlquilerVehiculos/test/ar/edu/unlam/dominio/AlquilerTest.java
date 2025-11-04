package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AlquilerTest {
	
	@Test
	public void dadoQueExisteUnAlquilerDeVehiculoObtengoQuePuedoConsultarSusAtributos() {
		Integer nroAlquiler = 1;
		Integer dniClienteAsociado = 1;
		Integer idVehiculoAlquilado = 30;
		Double cantidadDeHorasAlquiladas = 8.0;
		Alquiler alquiler = new Alquiler(nroAlquiler, dniClienteAsociado, idVehiculoAlquilado, cantidadDeHorasAlquiladas);
		assertEquals(nroAlquiler, alquiler.getNroAlquiler());
		assertEquals(dniClienteAsociado, alquiler.getDniClienteAsociado());
		assertEquals(idVehiculoAlquilado, alquiler.getIdVehiculoAlquilado());
		assertEquals(cantidadDeHorasAlquiladas, alquiler.getCantidadHorasAlquiladas());
	}
}
