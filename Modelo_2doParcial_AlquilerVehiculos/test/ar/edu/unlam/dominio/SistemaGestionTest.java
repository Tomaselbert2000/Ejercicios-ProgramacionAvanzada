package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import ar.edu.unlam.enums.TipoBicicletaEnum;
import ar.edu.unlam.exceptions.ClienteNoRegistradoException;
import ar.edu.unlam.exceptions.DniDuplicadoException;
import ar.edu.unlam.exceptions.IdDeVehiculoRepetidoException;
import ar.edu.unlam.exceptions.PatenteRepetidaException;
import ar.edu.unlam.exceptions.VehiculoNoDisponibleException;

public class SistemaGestionTest {

	private SistemaGestion gestionAlquiler;
	private Cliente cliente1;
	private Cliente cliente1Duplicado;
	private Cliente cliente2;
	private Bicicleta bici1;
	private Bicicleta bici1Repetida;
	private Bicicleta bici2;
	private Bicicleta bici3;
	private Bicicleta biciNoDisponible;
	private Motocicleta moto1;
	private Motocicleta moto1Repetida;
	private Motocicleta moto2;
	private Motocicleta moto3;

	@Before
	public void init() {
		gestionAlquiler = new SistemaGestion();
		cliente1 = new Cliente(112233, "Tomas", "Elbert");
		cliente1Duplicado = new Cliente(112233, "Juan", "Perez");
		cliente2 = new Cliente(192134, "Juan", "Perez");
		bici1 = new Bicicleta(10, "Bicicleta 1", true, TipoBicicletaEnum.PASEO, false);
		bici1Repetida = new Bicicleta(10, "Bicicleta repetida", true, TipoBicicletaEnum.MONTANIA, true);
		bici2 = new Bicicleta(20, "Bicicleta 2", true, TipoBicicletaEnum.PASEO, false);
		bici3 = new Bicicleta(25, "Bici de montaña 20", true, TipoBicicletaEnum.MONTANIA, true);
		biciNoDisponible = new Bicicleta(45, "Bici no disponible", false, TipoBicicletaEnum.PASEO, false);
		moto1 = new Motocicleta(30, "Motocicleta 1", true, "AAA111", 12.5, 125.0);
		moto1Repetida = new Motocicleta(100, "Motocicleta con patente repetida", true, "AAA111", 10.5, 110.0);
		moto2 = new Motocicleta(40, "Motocicleta 2", true, "BBB222", 14.5, 150.0);
		moto3 = new Motocicleta(50, "Motocicleta 3", true, "CCC333", 16.5, 195.0);
	}

	@Test
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosCuandoRegistroUnClienteInexistenteObtengoUnResultadoExitoso()
			throws DniDuplicadoException {
		Boolean seAgregoElCliente = this.gestionAlquiler.agregarCliente(this.cliente1);
		assertTrue(seAgregoElCliente);
	}

	@Test(expected = DniDuplicadoException.class)
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosCuandoRegistroUnOtroClienteConElMismoDNIObtengoUnaExcepcionDniDuplicadoException()
			throws DniDuplicadoException {
		this.gestionAlquiler.agregarCliente(this.cliente1);
		this.gestionAlquiler.agregarCliente(this.cliente1Duplicado);
	}

	@Test
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosCuandoRegistroUnaBicicletaObtengoUnResultadoExitoso()
			throws PatenteRepetidaException, IdDeVehiculoRepetidoException {
		Boolean seAgregoLaBicicleta = this.gestionAlquiler.agregarVehiculo(this.bici1);
		assertTrue(seAgregoLaBicicleta);
	}

	@Test(expected = IdDeVehiculoRepetidoException.class)
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosCuandoRegistroUnaBicicletaConIdRepetidoObtengoUnaIdDeVehiculoRepetidoException()
			throws PatenteRepetidaException, IdDeVehiculoRepetidoException {
		this.gestionAlquiler.agregarVehiculo(this.bici1);
		this.gestionAlquiler.agregarVehiculo(this.bici1Repetida);
	}

	@Test
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosCuandoRegistroUnaMotocicletaObtengoUnResultadoExitoso()
			throws PatenteRepetidaException, IdDeVehiculoRepetidoException {
		Boolean seAgregoLaMoto = this.gestionAlquiler.agregarVehiculo(this.moto1);
		assertTrue(seAgregoLaMoto);
	}

	@Test(expected = PatenteRepetidaException.class)
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosCuandoRegistroUnaMotocicletaConPatenteRepetidaObtengoUnaPatenteRepetidaException()
			throws PatenteRepetidaException, IdDeVehiculoRepetidoException {
		this.gestionAlquiler.agregarVehiculo(this.moto1);
		this.gestionAlquiler.agregarVehiculo(this.moto1Repetida);
	}

	@Test
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosCuandoObtengoLosVehiculosBicicletaDePaseoObtengoUnaColeccionCon2Bicicletas()
			throws PatenteRepetidaException, IdDeVehiculoRepetidoException {
		this.gestionAlquiler.agregarVehiculo(this.bici1);
		this.gestionAlquiler.agregarVehiculo(this.bici2);
		Integer cantidadBicicletasEsperada = 2;
		Integer cantidadBicicletasObtenida = this.gestionAlquiler.obtenerBicicletas().size();
		assertEquals(cantidadBicicletasEsperada, cantidadBicicletasObtenida);
	}

	@Test
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosCuandoObtengoLosVehiculosMotoObtengoUnaColeccionCon3MotosOrdenadosPorPatenteAscendente()
			throws PatenteRepetidaException, IdDeVehiculoRepetidoException {
		this.gestionAlquiler.agregarVehiculo(this.moto1);
		this.gestionAlquiler.agregarVehiculo(this.moto2);
		this.gestionAlquiler.agregarVehiculo(this.moto3);
		Integer cantidadMotocicletasEsperada = 3;
		Integer cantidadMotocicletasObtenida = this.gestionAlquiler.obtenerMotocicletas().size();
		assertEquals(cantidadMotocicletasEsperada, cantidadMotocicletasObtenida);
	}

	@Test
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosCuandoConsultoLosDatosDeUnVehiculoPorSuIdObtengoElVehiculo()
			throws PatenteRepetidaException, IdDeVehiculoRepetidoException {
		this.gestionAlquiler.agregarVehiculo(this.moto1);
		Vehiculo vehiculoBuscado = this.gestionAlquiler.obtenerVehiculoPorId(30);
		assertEquals(this.moto1, vehiculoBuscado);
	}

	@Test
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosCuandoConsultoElPrecioDeAlquilerDeUnVehiculoBicicletaDeMontaniaPorOchoHorasObtengo48000()
			throws PatenteRepetidaException, IdDeVehiculoRepetidoException {
		this.gestionAlquiler.agregarVehiculo(this.bici3);
		Double precioDeAlquilerBiciMontaña8HorasEsperado = 48000.0;
		Double precioDeAlquilerBiciMontaña8HorasObtenido = this.gestionAlquiler
				.obtenerPrecioTotalAlquiler(this.bici3.getId(), 8.0);
		assertEquals(precioDeAlquilerBiciMontaña8HorasEsperado, precioDeAlquilerBiciMontaña8HorasObtenido);
	}

	@Test
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosYClientesCuandoAlquiloUnVehiculoMotoObtengoUnResultadoExitoso()
			throws DniDuplicadoException, VehiculoNoDisponibleException, ClienteNoRegistradoException,
			PatenteRepetidaException, IdDeVehiculoRepetidoException {
		this.gestionAlquiler.agregarCliente(this.cliente1);
		this.gestionAlquiler.agregarVehiculo(this.moto1);
		Alquiler alquiler = new Alquiler(1, this.cliente1.getDni(), this.moto1.getId(), 8.0);
		this.gestionAlquiler.agregarAlquiler(alquiler);
	}

	@Test(expected = VehiculoNoDisponibleException.class)
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosYClientesCuandoQuieroAlquilarUnVehiculoMotoYaAlquiladoObtengoUnaExcepcionVehiculoNoDisponibleException()
			throws DniDuplicadoException, VehiculoNoDisponibleException, ClienteNoRegistradoException,
			PatenteRepetidaException, IdDeVehiculoRepetidoException {
		this.gestionAlquiler.agregarCliente(this.cliente1);
		this.gestionAlquiler.agregarVehiculo(this.biciNoDisponible);
		Alquiler alquilerDeBiciNoDisponible = new Alquiler(2, this.cliente1.getDni(), this.biciNoDisponible.getId(),
				6.0);
		this.gestionAlquiler.agregarAlquiler(alquilerDeBiciNoDisponible);
	}

	@Test(expected = ClienteNoRegistradoException.class)
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosCuandoQuieroAlquilarUnVehiculoMotoConUnDNIdeClienteNoRegistradoObtengoUnaClienteNoRegistradoException()
			throws VehiculoNoDisponibleException, ClienteNoRegistradoException, PatenteRepetidaException,
			IdDeVehiculoRepetidoException {
		this.gestionAlquiler.agregarVehiculo(this.bici1);
		Alquiler alquilerSinCliente = new Alquiler(1, -1, this.bici1.getId(), 6.5);
		this.gestionAlquiler.agregarAlquiler(alquilerSinCliente);
	}

	@Test
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosYClientesCuandoConsultoLosAlquileresDeClientesObtengoUnMapaDeClaveClienteYComoValorUnaColeccionConLosVehiculosAlquiladosPorElCliente()
			throws DniDuplicadoException, VehiculoNoDisponibleException, ClienteNoRegistradoException,
			PatenteRepetidaException, IdDeVehiculoRepetidoException {
		this.gestionAlquiler.agregarCliente(this.cliente1);
		this.gestionAlquiler.agregarCliente(this.cliente2);
		this.gestionAlquiler.agregarVehiculo(this.bici1);
		this.gestionAlquiler.agregarVehiculo(this.bici2);
		this.gestionAlquiler.agregarVehiculo(this.bici3);
		this.gestionAlquiler.agregarVehiculo(this.moto1);
		this.gestionAlquiler.agregarVehiculo(this.moto2);
		this.gestionAlquiler.agregarVehiculo(this.moto3);
		Alquiler alquiler1Cliente1 = new Alquiler(1, this.cliente1.getDni(), this.bici1.getId(), 2.0);
		Alquiler alquiler2Cliente1 = new Alquiler(2, this.cliente1.getDni(), this.bici2.getId(), 4.0);
		Alquiler alquiler3Cliente1 = new Alquiler(3, this.cliente1.getDni(), this.bici3.getId(), 6.0);
		Alquiler alquiler1Cliente2 = new Alquiler(4, this.cliente2.getDni(), this.moto1.getId(), 1.0);
		Alquiler alquiler2Cliente2 = new Alquiler(5, this.cliente2.getDni(), this.moto2.getId(), 3.0);
		Alquiler alquiler3Cliente2 = new Alquiler(6, this.cliente2.getDni(), this.moto3.getId(), 5.0);
		this.gestionAlquiler.agregarAlquiler(alquiler1Cliente1);
		this.gestionAlquiler.agregarAlquiler(alquiler2Cliente1);
		this.gestionAlquiler.agregarAlquiler(alquiler3Cliente1);
		this.gestionAlquiler.agregarAlquiler(alquiler1Cliente2);
		this.gestionAlquiler.agregarAlquiler(alquiler2Cliente2);
		this.gestionAlquiler.agregarAlquiler(alquiler3Cliente2);
		HashMap<Cliente, ArrayList<Vehiculo>> reporteOrdenadoDeAlquileres = this.gestionAlquiler
				.obtenerReporteDeVehiculosAlquiladosPorCliente();
		for (Map.Entry<Cliente, ArrayList<Vehiculo>> entry : reporteOrdenadoDeAlquileres.entrySet()) {
			Cliente key = entry.getKey();
			ArrayList<Vehiculo> val = entry.getValue();
			System.out.println("--------------------------------------------------------------");
			System.out.println("Historial de vehiculos alquilados para el DNI: " + key.getDni());
			System.out.println("--------------------------------------------------------------");
			for (Vehiculo v : val) {
				System.out.println(v.toString() + "\n");
			}
			System.out.println("\n");
		}
	}
}
