package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class VehiculoTest {

	private Vehiculo vehiculo;
	
	@Before
	public void inicializarVehiculo() {
		this.vehiculo = new Vehiculo("ABC123", "Fiat", "Cronos");
	}
	
	@Test
	public void dadoQueExisteUnVehiculoObtengoComoPatenteABC123() {
		String patenteEsperada = "ABC123";
		String patenteObtenida = this.vehiculo.getPatente();
		assertEquals(patenteEsperada, patenteObtenida);
	}
	
	@Test
	public void dadoQueExisteUnVehiculoObtengoComoMarcaFiat() {
		String marcaEsperada = "Fiat";
		String marcaObtenida = this.vehiculo.getMarca();
		assertEquals(marcaEsperada, marcaObtenida);
	}
	
	@Test
	public void dadoQueExisteUnVehiculoObtengoComoModeloCronos() {
		String modeloEsperado = "Cronos";
		String modeloObtenido = this.vehiculo.getModelo();
		assertEquals(modeloEsperado, modeloObtenido);
	}
}
