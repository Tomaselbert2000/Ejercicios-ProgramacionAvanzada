package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MotocicletaTest {

	@Test
	public void dadoQueExisteUnaMotocicletaPorHerenciaObtengoQuePuedoConsultarSusAtributos() {
		Integer id = 5;
		String nombre = "Motocicleta 150cc";
		Boolean estadoDisponibilidad = true;
		String patente = "ABC123";
		Double capacidadCombustible = 15.0;
		Double cilindrada = 150.0;
		Motocicleta moto = new Motocicleta(id, nombre, estadoDisponibilidad, patente, capacidadCombustible, cilindrada);
		assertEquals(id, moto.getId());
		assertEquals(nombre, moto.getNombreVehiculo());
		assertEquals(estadoDisponibilidad, moto.getEstadoDisponibilidad());
		assertEquals(patente, moto.getPatente());
		assertEquals(capacidadCombustible, moto.getCapacidadCombustible());
		assertEquals(cilindrada, moto.getCilindrada());
	}
}
