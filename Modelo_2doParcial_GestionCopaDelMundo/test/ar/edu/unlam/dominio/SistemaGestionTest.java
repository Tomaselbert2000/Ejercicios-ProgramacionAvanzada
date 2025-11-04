package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import org.junit.Before;
import org.junit.Test;
import ar.edu.unlam.enums.ColorAtrilEnum;
import ar.edu.unlam.enums.MaterialEnum;
import ar.edu.unlam.exceptions.ClienteDuplicadoException;
import ar.edu.unlam.exceptions.CopaDelMundoDuplicadaException;
import ar.edu.unlam.exceptions.CopaDelMundoNoEncontradaException;

public class SistemaGestionTest {

	private SistemaGestion gestion;
	private CopaDelMundoEstandar copaEstandar1;
	private CopaDelMundoEstandar copaEstandar2;
	private CopaDelMundoPersonalizada copaPersonalizada10;
	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente clienteQueYaExiste;

	@Before
	public void init() {
		gestion = new SistemaGestion();
		copaEstandar1 = new CopaDelMundoEstandar(1, 4500.0, MaterialEnum.RESINA);
		copaEstandar2 = new CopaDelMundoEstandar(2, 3850.0, MaterialEnum.PLASTICO);
		copaPersonalizada10 = new CopaDelMundoPersonalizada(2, 6200.0, MaterialEnum.YESO, ColorAtrilEnum.ROBLE_OSCURO);
		cliente1 = new Cliente(112233, "Tomas", "Elbert");
		cliente2 = new Cliente(998877, "Juan", "Perez");
		clienteQueYaExiste = new Cliente(112233, "Juan", "Perez");
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoSePuedeAgregarUnaCopaDelMundoEstandar()
			throws CopaDelMundoDuplicadaException {
		Boolean seAgrego = this.gestion.agregarCopaDelMundo(this.copaEstandar1);
		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoSePuedeAgregarUnaCopaDelMundoPersonalizada()
			throws CopaDelMundoDuplicadaException {
		Boolean seAgrego = this.gestion.agregarCopaDelMundo(this.copaPersonalizada10);
		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoSePuedeAgregarUnCliente() throws ClienteDuplicadoException {
		Boolean seAgrego = this.gestion.agregarCliente(this.cliente1);
		assertTrue(seAgrego);
	}

	@Test(expected = ClienteDuplicadoException.class)
	public void dadoQueExisteUnaFabricaDeCopasDelMundoAlAgregarUnClienteExistenteSeLanzaUnaClienteDuplicadoException()
			throws ClienteDuplicadoException {
		this.gestion.agregarCliente(this.cliente1);
		this.gestion.agregarCliente(this.clienteQueYaExiste);
	}

	@Test
	public void dadoQueExisteUnaFabricaQuePoseeCopasDelMundoSePuedenObtenerLasCopasDelMundoEstandar()
			throws CopaDelMundoDuplicadaException {
		this.gestion.agregarCopaDelMundo(this.copaEstandar1);
		this.gestion.agregarCopaDelMundo(this.copaEstandar2);
		this.gestion.agregarCopaDelMundo(this.copaPersonalizada10);
		Integer cantidadCopasDelMundoEstandarEsperada = 2;
		Integer cantidadCopasDelMundoEstandarObtenida = this.gestion.obtenerCopasDelMundoEstandar().size();
		assertEquals(cantidadCopasDelMundoEstandarEsperada, cantidadCopasDelMundoEstandarObtenida);
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConCopasDelMundoPuedoObtenerUnaCopaDelMundoPorSuId()
			throws CopaDelMundoNoEncontradaException, CopaDelMundoDuplicadaException {
		CopaDelMundoPersonalizada copaParaBuscarPorIdCreada = new CopaDelMundoPersonalizada(20, 8600.0,
				MaterialEnum.YESO, ColorAtrilEnum.ROBLE_OSCURO);
		this.gestion.agregarCopaDelMundo(copaParaBuscarPorIdCreada);
		CopaDelMundo copaEncontradaPorId = this.gestion.buscarCopaDelMundoPorId(20);
		assertEquals(copaParaBuscarPorIdCreada, copaEncontradaPorId);
	}

	@Test(expected = CopaDelMundoNoEncontradaException.class)
	public void dadoQueExisteUnaFabricaDeCopasDelMundoSiIntentoBuscarUnaCopaDelMundoQueNoExisteSeLanzaUnaCopaDelMundoNoEncontradaException()
			throws CopaDelMundoNoEncontradaException, CopaDelMundoDuplicadaException {
		this.gestion.agregarCopaDelMundo(this.copaEstandar1);
		this.gestion.agregarCopaDelMundo(this.copaEstandar2);
		this.gestion.agregarCopaDelMundo(this.copaPersonalizada10);
		this.gestion.buscarCopaDelMundoPorId(1000);
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConCopasDelMundoAlAgregarCincoCopasDelMundoAUnaVentaDeCopasDelMundoEstandarParaUnClienteSeDescuentanCincoUnidadesDelStockDeCopasDelMundoEstandar()
			throws ClienteDuplicadoException, CopaDelMundoDuplicadaException {
		this.gestion.agregarCliente(this.cliente1);
		CopaDelMundoEstandar copa1 = new CopaDelMundoEstandar(100, 1000.0, MaterialEnum.PLASTICO);
		CopaDelMundoEstandar copa2 = new CopaDelMundoEstandar(200, 2000.0, MaterialEnum.PLASTICO);
		CopaDelMundoEstandar copa3 = new CopaDelMundoEstandar(300, 3000.0, MaterialEnum.PLASTICO);
		CopaDelMundoEstandar copa4 = new CopaDelMundoEstandar(400, 4000.0, MaterialEnum.PLASTICO);
		CopaDelMundoEstandar copa5 = new CopaDelMundoEstandar(500, 5000.0, MaterialEnum.PLASTICO);
		this.gestion.agregarCopaDelMundo(copa1);
		this.gestion.agregarCopaDelMundo(copa2);
		this.gestion.agregarCopaDelMundo(copa3);
		this.gestion.agregarCopaDelMundo(copa4);
		this.gestion.agregarCopaDelMundo(copa5);
		Integer cantidadCopasEstandarEnStockEsperada = 5;
		Integer cantidadCopasEstandarEnStockObtenida = this.gestion.obtenerCopasDelMundoEstandar().size();
		assertEquals(cantidadCopasEstandarEnStockEsperada, cantidadCopasEstandarEnStockObtenida);
		Venta ventaRealizada = new Venta(this.cliente1,
				new HashSet<>(Arrays.asList(copa1, copa2, copa3, copa4, copa5)));
		this.gestion.agregarVenta(ventaRealizada);
		Integer cantidadCopasEstandarEnStockActualizadaEsperada = 0;
		Integer cantidadCopasEstandarEnStockActualizadaObtenida = this.gestion.obtenerCopasDelMundoEstandar().size();
		assertEquals(cantidadCopasEstandarEnStockActualizadaEsperada, cantidadCopasEstandarEnStockActualizadaObtenida);
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConCopasDelMundoAlAgregarUnaVentaDeCopasDelMundoPersonalizadaParaUnClienteSeRemueveLaCopaDelMundoPersonalizadaDeLaFabrica()
			throws ClienteDuplicadoException, CopaDelMundoDuplicadaException {
		this.gestion.agregarCliente(this.cliente1);
		this.gestion.agregarCopaDelMundo(this.copaPersonalizada10);
		Integer cantidadDeCopasDelMundoPersonalizadasEnStockEsperada = 1;
		Integer cantidadDeCopasDelMundoPersonalizadasEnStockObtenida = this.gestion.obtenerCopasDelMundoPersonalizadas()
				.size();
		assertEquals(cantidadDeCopasDelMundoPersonalizadasEnStockEsperada,
				cantidadDeCopasDelMundoPersonalizadasEnStockObtenida);
		Venta nuevaVenta = new Venta(this.cliente1, new HashSet<>(Arrays.asList(this.copaPersonalizada10)));
		this.gestion.agregarVenta(nuevaVenta);
		Integer cantidadDeCopasPersonalizdasActualizadasEsperada = 0;
		Integer cantidadDeCopasPersonalizdasActualizadasObtenida = this.gestion.obtenerCopasDelMundoPersonalizadas()
				.size();
		assertEquals(cantidadDeCopasPersonalizdasActualizadasEsperada,
				cantidadDeCopasPersonalizdasActualizadasObtenida);
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConCopasDelMundoPersonalizadasSePuedeObtenerElPrecioDeUnaCopaDelMundoPersonalizada()
			throws CopaDelMundoDuplicadaException {
		this.gestion.agregarCopaDelMundo(this.copaPersonalizada10);
		Double precioDeCopaPersonalizada = this.gestion
				.obtenerPrecioDeCopaPersonalizada(this.copaPersonalizada10.getId());
		System.out.println("Valor obtenido: $" + precioDeCopaPersonalizada);
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConVentasDeCopasDelMundoEstandarYPersonalizadasVendidasAClientesSePuedeObtenerUnMapaConClaveClienteYTotalDeVentasDeCopasEstandarOrdenadoPorCliente()
			throws ClienteDuplicadoException, CopaDelMundoDuplicadaException {
		this.gestion.agregarCliente(this.cliente1);
		this.gestion.agregarCliente(this.cliente2);
		CopaDelMundoEstandar copa1 = new CopaDelMundoEstandar(100, 1000.0, MaterialEnum.PLASTICO);
		CopaDelMundoEstandar copa2 = new CopaDelMundoEstandar(200, 2000.0, MaterialEnum.PLASTICO);
		CopaDelMundoEstandar copa3 = new CopaDelMundoEstandar(300, 3000.0, MaterialEnum.PLASTICO);
		CopaDelMundoEstandar copa4 = new CopaDelMundoEstandar(400, 4000.0, MaterialEnum.PLASTICO);
		CopaDelMundoEstandar copa5 = new CopaDelMundoEstandar(500, 5000.0, MaterialEnum.PLASTICO);
		this.gestion.agregarCopaDelMundo(this.copaEstandar1);
		this.gestion.agregarCopaDelMundo(this.copaEstandar2);
		this.gestion.agregarCopaDelMundo(copa1);
		this.gestion.agregarCopaDelMundo(copa2);
		this.gestion.agregarCopaDelMundo(copa3);
		this.gestion.agregarCopaDelMundo(copa4);
		this.gestion.agregarCopaDelMundo(copa5);
		Venta ventaCliente1 = new Venta(this.cliente1,
				new HashSet<>(Arrays.asList(this.copaEstandar1, this.copaEstandar2)));
		Venta ventaCliente2 = new Venta(this.cliente2, new HashSet<>(Arrays.asList(copa1, copa2)));
		Venta otraVentaCliente2 = new Venta(this.cliente2, new HashSet<>(Arrays.asList(copa3, copa4, copa5)));
		this.gestion.agregarVenta(ventaCliente1);
		this.gestion.agregarVenta(ventaCliente2);
		this.gestion.agregarVenta(otraVentaCliente2);
		HashMap<Cliente, List<Double>> reporteTotalVentasOrdenadoPorCliente = this.gestion
				.reporteTotalVentasOrdenadoPorCliente();

		for (Entry<Cliente, List<Double>> entry : reporteTotalVentasOrdenadoPorCliente.entrySet()) {
			Cliente key = entry.getKey();
			ArrayList<Double> val = (ArrayList<Double>) entry.getValue();
			System.out.println("DNI Cliente: " + key.getDni());
			System.out.println("Total acumulado --> " + val + "\n");
		}
	}
}
