package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

public class PaseTest {
	
	private Pase registroPase;
	
	@Before
	public void inicializarRegistroPase() {
		this.registroPase = new Pase(new Vehiculo("ABC123", "Fiat", "Cronos"), LocalDateTime.of(2025,9,3,13,37));
	}
	
	@Test
	public void dadoQueExisteUnRegistroDePasadaObtengoLaPatenteDelVehiculoAsociada() {
		String patenteDeVehiculoEsperada = "ABC123";
		String patenteDeVehiculoObtenida = this.registroPase.getPatenteDeVehiculo();
		assertEquals(patenteDeVehiculoEsperada, patenteDeVehiculoObtenida);
	}
	
	@Test
	public void dadoQueExisteUnRegistroDePasadaObtengoLaFechaYhoraALaQuePaso() {
		LocalDateTime fechaYhoraEsperada = LocalDateTime.of(2025,9,3,13,37);
		LocalDateTime fechaYhoraObtenida = this.registroPase.obtenerFechaYhoraDelRegistro();
		assertEquals(fechaYhoraEsperada, fechaYhoraObtenida);
	}
}
