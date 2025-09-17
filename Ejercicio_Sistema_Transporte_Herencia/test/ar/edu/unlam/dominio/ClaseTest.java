package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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
		auto = new Auto("AAA111", 500.0, 5);
	}
	
	@Test
	public void dadoQueExisteUnGestorDeTransporteSiCreoUnVehiculoObtengoTrue() {
		Boolean fueCreado = this.gestor.agregarVehiculo(this.vehiculo);
		assertTrue(fueCreado);
	}
	
	@Test
	public void dadoQueExisteUnVehiculoObtengoQueSuPatenteEsABC123() {
		String patenteEsperada = "ABC123";
		String patenteObtenida = this.vehiculo.obtenerPatente();
		assertEquals(patenteEsperada, patenteObtenida);
	}
	
	@Test
	public void dadoQueExisteUnVehiculoObtengoQueSuPesoMaximoEs16000() {
		Double pesoMaximoEsperado = 16000.0;
		Double pesoMaximoObtenido = this.vehiculo.obtenerPesoMaximo();
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
		Integer cantidadPasajerosObtenida = this.vehiculo.obtenerCantidadPasajerosActual();
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
		String patenteObtenida = this.camion.obtenerPatente();
		assertEquals(patenteEsperada, patenteObtenida);
	}
	
	@Test
	public void dadoQueExisteUnCamionPorHerenciaObtengoQueSuPesoMaximoEs25000Kilos() {
		Double pesoMaximoEsperado = 25000.0;
		Double pesoMaximoObtenido = this.camion.obtenerPesoMaximo();
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
		String patenteObtenida = this.colectivo.obtenerPatente();
		assertEquals(patenteEsperada, patenteObtenida);
	}
	
	@Test
	public void dadoQueExisteUnColectivoPorHerenciaObtengoQueSuPesoMaximoEs3000() {
		Double pesoMaximoEsperado = 3000.0;
		Double pesoMaximoObtenido = this.colectivo.obtenerPesoMaximo();
		assertEquals(pesoMaximoEsperado, pesoMaximoObtenido);
	}
	
	@Test
	public void dadoQueExisteUnColectivoPorHerenciaObtengoQueSuCapacidadDePasajerosMaximaEs40() {
		Integer cantidadPasajerosEsperada = 40;
		Integer cantidadPasajerosObtenida = this.colectivo.obtenerCapacidadMaximaPasajeros();
		assertEquals(cantidadPasajerosEsperada, cantidadPasajerosObtenida);
	}
	
	@Test
	public void dadoQueExisteUnColectivoVacioSiSeSuben20PasajerosObtengoQueSuCantidadActualSera20() {
		Integer cantidadDePasajeros = 20;
		this.colectivo.cargarPasajeros(cantidadDePasajeros);
		Integer cantidadPasajerosActual = this.colectivo.obtenerCantidadPasajerosActual();
		assertEquals(cantidadDePasajeros, cantidadPasajerosActual);
	}
	
	@Test
	public void dadoQueExisteUnAutoSiLoRegistroObtengoTrue() {
		Boolean seAgrego = this.gestor.agregarVehiculo(this.auto);
		assertTrue(seAgrego);
	}
	
	@Test
	public void dadoQueExisteUnAutoPorHerenciaObtengoQueSuPatenteEsAAA111() {
		String patenteEsperada = "AAA111";
		String patenteObtenida = this.auto.obtenerPatente();
		assertEquals(patenteEsperada, patenteObtenida);
	}
	
	@Test
	public void dadoQueExisteUnAutoPorHerenciaObtengoQueSuPesoMaximoEs500() {
		Double pesoMaximoEsperado = 500.0;
		Double pesoMaximoObtenido = this.auto.obtenerPesoMaximo();
		assertEquals(pesoMaximoEsperado, pesoMaximoObtenido);
	}
	
	@Test
	public void dadoQueExisteUnAutoPorHerenciaObtengoQueCarga5PasajerosMaximo() {
		Integer cantidadPasajerosEsperada = 5;
		Integer cantidadPasajerosObtenida = this.auto.obtenerCapacidadMaximaPasajeros();
		assertEquals(cantidadPasajerosEsperada, cantidadPasajerosObtenida);
	}
	
	@Test
	public void dadoQueExisteUnGestorDeTransporteTodosLosVehiculosSeGuardanEnLaMismaColeccion() {
		this.gestor.agregarVehiculo(this.vehiculo);
		this.gestor.agregarVehiculo(this.camion);
		this.gestor.agregarVehiculo(this.colectivo);
		this.gestor.agregarVehiculo(this.auto);
		Integer cantidadVehiculosEsperada = 4;
		Integer cantidadVehiculosObtenida = this.gestor.cantidadVehiculosRegistrados();
		assertEquals(cantidadVehiculosEsperada, cantidadVehiculosObtenida);
	}
	
	@Test
	public void dadoQueNoPuedoTenerDosVehiculosConIgualPatenteAl2doNoLoRegistra() {
		Vehiculo vehiculo = new Vehiculo("ABC123", 2000.0, 5);
		Auto auto = new Auto("ABC123", 500.0, 5);
		Boolean seAgregoVehiculo = this.gestor.agregarVehiculo(vehiculo);
		Boolean seAgregoAuto = this.gestor.agregarVehiculo(auto);
		/*
		 * Para que este test pase de manera correcta sobreescribimos el metodo
		 * Equals dentro de la clase Vehiculo para que tome como valor no solo
		 * si es el mismo objeto (misma posicion de memoria), sino que tambien
		 * evalue si la patente es la misma.
		 */
		assertNotEquals(seAgregoVehiculo, seAgregoAuto);
	}
	
	@Test
	public void dadoQueUnAutoCargaComoMaximo5PasajerosSiIntentoCargar6ObtengoFalse() {
		Integer cantidadPasajeros = 6;
		Boolean subieronAlAuto = this.auto.cargarPasajeros(cantidadPasajeros);
		assertFalse(subieronAlAuto);
	}
}
