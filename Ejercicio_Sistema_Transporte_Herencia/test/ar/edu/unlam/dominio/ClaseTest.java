package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ClaseTest {
	
	private Vehiculo vehiculo;
	private Camion camion;
	private GestorTransporte gestor;
	private Vehiculo colectivo;
	private Vehiculo auto;
	
	@Before
	public void inicializarVehiculo() {
		gestor = new GestorTransporte();
		vehiculo = new Vehiculo("ABC123", 16000.0, 8);
		camion = new Camion("DEF456", 25000.0, 3);
		colectivo = new Colectivo("XYZ789", 3000.0, 40);
		auto = new Auto(null, null, null);
	}
	
	@Test
	public void dadoQueExisteUnGestorDeTransporteSiCreoUnVehiculoObtengoTrue() {
		Boolean fueCreado = this.gestor.agregarVehiculo(this.vehiculo);
		assertTrue(fueCreado);
	}
	
	@Test
	public void dadoQueExisteUnVehiculoObtengoQueSuPatenteEsABC123() {
		String patenteEsperada = "ABC123";
		String patenteObtenida = this.vehiculo.getPatente();
		assertEquals(patenteEsperada, patenteObtenida);
	}
	
	@Test
	public void dadoQueExisteUnVehiculoObtengoQueSuPesoMaximoEs16000() {
		Double pesoMaximoEsperado = 16000.0;
		Double pesoMaximoObtenido = this.vehiculo.getPesoMaximo();
		assertEquals(pesoMaximoEsperado, pesoMaximoObtenido);
	}
	
	@Test
	public void dadoQueExisteUnVehiculoObtengoQueSuCapacidadMaximaEsDe8Pasajeros() {
		Integer capacidadPasajerosEsperada = 8;
		Integer capacidadPasajerosObtenida = this.vehiculo.obtenerCapacidadMaximaPasajeros();
		assertEquals(capacidadPasajerosEsperada, capacidadPasajerosObtenida);
	}
	
	@Test
	public void dadoQueExisteUnVehiculoSiSeSuben3PersonasObtengoQueLaCantidadActualDePasajerosEs3() {
		Integer cantidadPasajerosEsperada = 3;
		this.vehiculo.cargarPasajeros(cantidadPasajerosEsperada);
		Integer cantidadPasajerosObtenida = this.vehiculo.getCantidadPasajerosActual();
		assertEquals(cantidadPasajerosEsperada, cantidadPasajerosObtenida);
	}
	
	@Test
	public void dadoQueExisteUnVehiculoQueComoMaximoPuedeLlevar8PasajerosSiIntentoCargar10RetornaFalse() {
		Integer cantidadPasajeros = 10;
		Boolean subieronTodos = this.vehiculo.cargarPasajeros(cantidadPasajeros);
		assertFalse(subieronTodos);
	}
	
	@Test
	public void dadoQueExisteUnGestorDeTransporteYUnaSubclaseCamionAlCrearloObtengoTrue() {
		Boolean fueCreadoElCamion = this.gestor.agregarVehiculo(this.camion);
		assertTrue(fueCreadoElCamion);
	}
	
	@Test
	public void dadoQueExisteUnCamionPorHerenciaObtengoQueSuPatenteEsDEF456() {
		String patenteEsperada = "DEF456";
		String patenteObtenida = this.camion.getPatente();
		assertEquals(patenteEsperada, patenteObtenida);
	}
	
	@Test
	public void dadoQueExisteUnCamionPorHerenciaObtengoQueSuPesoMaximoEs25000Kilos() {
		Double pesoMaximoEsperado = 25000.0;
		Double pesoMaximoObtenido = this.camion.getPesoMaximo();
		assertEquals(pesoMaximoEsperado, pesoMaximoObtenido);
	}
	
	@Test
	public void dadoQueExisteUnCamionPorHerenciaObtengoQueSuCapacidadMaximaDePasajerosEs3() {
		Integer cantidadPasajerosMaximaEsperada = 3;
		Integer cantidadPasajerosMaximaObtenida = this.camion.obtenerCapacidadMaximaPasajeros();
		assertEquals(cantidadPasajerosMaximaEsperada, cantidadPasajerosMaximaObtenida);
	}
	
	@Test
	public void dadoQueExisteUnCamionQueComoMaximoPuedeLlevar3PasajerosPorHerenciaSiIntentanSubir5ObtengoFalse() {
		Integer cantidadPasajerosParaSubir = 5;
		Boolean pudieronSubir = this.camion.cargarPasajeros(cantidadPasajerosParaSubir);
		assertFalse(pudieronSubir);
	}
	
	@Test
	public void dadoQueExisteUnCamionQueSuPesoMaximoEs25000PorHerenciaSiIntentoCargar30000ObtengoFalse() {
		Double pesoACargar = 30000.0;
		Boolean sePudoCargar = this.camion.cargarPeso(pesoACargar);
		assertFalse(sePudoCargar);
	}
	
	@Test
	public void dadoQueExisteUnGestorDeTransporteYCreoUnColectivoObtengoTrue() {
		Boolean fueCreado = this.gestor.agregarVehiculo(this.colectivo);
		assertTrue(fueCreado);
	}
	
	@Test
	public void dadoQueExisteUnColectivoPorHerenciaObtengoQueSuPatenteEsXYZ789() {
		String patenteEsperada = "XYZ789";
		String patenteObtenida = this.colectivo.getPatente();
		assertEquals(patenteEsperada, patenteObtenida);
	}
	
	@Test
	public void dadoQueExisteUnColectivoPorHerenciaObtengoQueSuPesoMaximoEs3000() {
		Double pesoMaximoEsperado = 3000.0;
		Double pesoMaximoObtenido = this.colectivo.getPesoMaximo();
		assertEquals(pesoMaximoEsperado, pesoMaximoObtenido);
	}
	
	@Test
	public void dadoQueExisteUnColectivoPorHerenciaObtengoQueSuCapacidadDePasajerosMaximaEs40() {
		Integer cantidadPasajerosEsperada = 40;
		Integer cantidadPasajerosObtenida = this.colectivo.obtenerCapacidadMaximaPasajeros();
		assertEquals(cantidadPasajerosEsperada, cantidadPasajerosObtenida);
	}
	
	@Test
	public void dadoQueExisteUnAutoSiLoRegistroObtengoTrue() {
		Boolean seAgrego = this.gestor.agregarVehiculo(this.auto);
		assertTrue(seAgrego);
	}
	
	@Test
	public void dadoQueExisteUnGestorDeTransporteTodosLosVehiculosSeGuardanEnLaMismaColeccion() {
		this.gestor.agregarVehiculo(this.vehiculo);
		this.gestor.agregarVehiculo(camion);
		this.gestor.agregarVehiculo(colectivo);
		Integer cantidadVehiculosEsperada = 3;
		Integer cantidadVehiculosObtenida = this.gestor.cantidadVehiculosRegistrados();
		assertEquals(cantidadVehiculosEsperada, cantidadVehiculosObtenida);
	}
}
