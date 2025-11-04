package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VehiculoTest {
	
	@Test
	public void dadoQueExisteUnVehiculoObtengoQuePuedoConsultarSusAtributos() {
		Integer idVehiculo = 1;
		String nombre = "Vehiculo";
		Boolean estadoDisponibilidad = true;
		Vehiculo vehiculo = new Vehiculo(idVehiculo, nombre, estadoDisponibilidad);
		assertEquals(idVehiculo, vehiculo.getId());
		assertEquals(nombre, vehiculo.getNombreVehiculo());
		assertEquals(estadoDisponibilidad, vehiculo.getEstadoDisponibilidad());
	}
}
