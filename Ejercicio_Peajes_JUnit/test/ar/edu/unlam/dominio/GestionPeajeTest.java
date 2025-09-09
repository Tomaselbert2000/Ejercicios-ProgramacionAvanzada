package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

public class GestionPeajeTest {
	
	private GestionPeaje gestionPeaje;
	
	@Before
	public void inicializarGestionDePeaje() {
		this.gestionPeaje = new GestionPeaje();
	}
	
	@Test
	public void dadoQueExisteUnPeajeObtengoUnHashSetDeVehiculosRegistradosDistintaANull() {
		assertNotNull(this.gestionPeaje.obtenerListaDeVehiculosRegistrados());
	}
	
	@Test
	public void dadoQueExisteUnPeajeObtengoUnaColeccionDeRegistrosDePasadasDistintaANull() {
		assertNotNull(this.gestionPeaje.obtenerListaDeRegistrosDePasadas());
	}
	
	@Test
	public void dadoQueExisteUnPeajeYExisteUnVehiculoPuedoRegistrarloYRetornaTrue() {
		Vehiculo vehiculo1 = new Vehiculo("ABC123", "Fiat", "Cronos");
		Boolean registroDeVehiculoEsperado = true;
		Boolean registroDeVehiculoObtenido = this.gestionPeaje.registrarNuevoVehiculo(vehiculo1);
		assertEquals(registroDeVehiculoEsperado, registroDeVehiculoObtenido);
	}
	
	@Test
	public void dadoQueNoPuedoTenerUnVehiculoRepetidoSiLoCargoDosVecesAl2doRetornaFalse() {
		Vehiculo vehiculo1 = new Vehiculo("ABC123", "Fiat", "Cronos");
		Boolean fueAgregadoEsperado = true;
		Boolean fueAgregadoObtenido = this.gestionPeaje.registrarNuevoVehiculo(vehiculo1);
		assertEquals(fueAgregadoEsperado, fueAgregadoObtenido);
		Boolean fueAgregadoDeNuevoEsperado = false; // esperamos que NO SE AGREGUE NUEVAMENTE
		Boolean fueAgregadoDeNuevoObtenido = this.gestionPeaje.registrarNuevoVehiculo(vehiculo1); // intentamos cargar de nuevo
		assertEquals(fueAgregadoDeNuevoEsperado, fueAgregadoDeNuevoObtenido);
	}
	
	@Test
	public void dadoQueNoPuedoTenerDosVehiculosConIgualPatenteSiCargoDosVehiculosConIgualPatenteAl2doNoLoRegistra() {
		Vehiculo vehiculo1 = new Vehiculo("ABC123", "Fiat", "Cronos");
		Vehiculo vehiculo2 = new Vehiculo("ABC123", "Volkswagen", "Gol Trend");
		Boolean vehiculo1Agregado = this.gestionPeaje.registrarNuevoVehiculo(vehiculo1);
		Boolean vehiculo2Agregado = this.gestionPeaje.registrarNuevoVehiculo(vehiculo2);
		assertTrue(vehiculo1Agregado);
		assertFalse(vehiculo2Agregado);
	}
	
	@Test
	public void dadoQueExisteUnPeajeYUnVehiculoSiPasaDosVecesDistintasPorElPeajeLoRegistra2Veces() {
		Vehiculo vehiculo = new Vehiculo("ABC123", "Fiat", "Cronos");
		Pase registro1 = new Pase(vehiculo, LocalDateTime.of(2025,9,3,15,56));
		Pase registro2 = new Pase(vehiculo, LocalDateTime.of(2025,9,3,19,45));
		Boolean registro1CompletadoEsperado = true;
		Boolean registro1CompletadoObtenido = this.gestionPeaje.ingresarNuevoRegistro(registro1);
		
		Boolean registro2CompletadoEsperado = true;
		Boolean registro2CompletadoObtenido = this.gestionPeaje.ingresarNuevoRegistro(registro2);
		
		assertEquals(registro1CompletadoEsperado, registro1CompletadoObtenido);
		assertEquals(registro2CompletadoEsperado, registro2CompletadoObtenido);
		
	}
	
	@Test
	public void dadoQueExisteUnPeajeSiUnVehiculoPasaDosVecesAlBuscarPorPatenteObtengoUnArrayListDeSize2() {
		Vehiculo vehiculo = new Vehiculo("ABC123", "Fiat", "Cronos");
		Pase registro1 = new Pase(vehiculo, LocalDateTime.of(2025,9,3,16,19));
		Pase registro2 = new Pase(vehiculo, LocalDateTime.of(2025,9,3,20,30));
		this.gestionPeaje.ingresarNuevoRegistro(registro1);
		this.gestionPeaje.ingresarNuevoRegistro(registro2);
		Integer sizeEsperado = 2;
		Integer sizeObtenido = this.gestionPeaje.obtenerListaRegistrosPorPatente(vehiculo.getPatente()).size();
		assertEquals(sizeEsperado, sizeObtenido);
	}
	
	@Test
	public void dadoQueExisteUnPeajeEntoncesExisteUnArrayDeTarifasNoNulo() {
		assertNotNull(this.gestionPeaje.getListaTarifas());
	}
	
	@Test
	public void dadoQueExisteUnPeajeYUnaListaDeTarifasSiAgregoUnaTarifaObtengo1() {
		Tarifa tarifa1 = new Tarifa(1, 0);
		this.gestionPeaje.registrarNuevaTarifa(tarifa1);
		Integer cantidadTarifasEsperada = 1;
		Integer cantidadTarifasObtenida = this.gestionPeaje.getCantidadTarifasRegistradas();
		assertEquals(cantidadTarifasEsperada, cantidadTarifasObtenida);
	}
	
	@Test
	public void dadoQueExisteUnaTarifaConUnIdObtengo1() {
		Tarifa tarifa1 = new Tarifa(1, 0);
		Integer codigoTarifaEsperado = 1;
		Integer codigoTarifaObtenido = tarifa1.getId();
		assertEquals(codigoTarifaEsperado, codigoTarifaObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaTarifaConUnValorObtengo1000() {
		Tarifa tarifa1 = new Tarifa(1, 1000.0);
		Double precioEsperado = 1000.0;
		Double precioObtenido = tarifa1.getValor();
		assertEquals(precioEsperado, precioObtenido);
	}
	
	@Test
	public void dadoQueExisteUnPeajeSiGuardoDosTarifasIgualesLa2daNoSeGuarda() {
		Tarifa tarifa1 = new Tarifa(1, 1000.0);
		Boolean fueAgregada = this.gestionPeaje.registrarNuevaTarifa(tarifa1);
		Boolean fueAgregadaDeNuevo = this.gestionPeaje.registrarNuevaTarifa(tarifa1);
		assertTrue(fueAgregada); // aca vemos que si da true la primera vez
		assertFalse(fueAgregadaDeNuevo); // y verificamos que a partir de la 2da vez ya devuelve false
	}
}
