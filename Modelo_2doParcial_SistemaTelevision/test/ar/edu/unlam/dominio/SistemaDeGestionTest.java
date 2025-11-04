package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.junit.Before;
import org.junit.Test;
import ar.edu.unlam.enums.CategoriaCanalEnums;
import ar.edu.unlam.enums.ClasificacionCanalEnums;
import ar.edu.unlam.exceptions.CanalExistenteException;
import ar.edu.unlam.exceptions.ClienteExistenteException;
import ar.edu.unlam.exceptions.PlanExistenteException;
import ar.edu.unlam.exceptions.SuscripcionExistenteException;

public class SistemaDeGestionTest {

	private SistemaDeGestion gestion;
	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	private Cliente cliente1Repetido;
	private Canal canal1;
	private Canal canal2;
	private Canal canalRepetido;
	private PlanBasico planBasico;
	private PlanBasico planConIdRepetido;
	private PlanPremium planPremium;
	private Suscripcion suscripcionCliente1;
	private Suscripcion suscripcionCliente2;
	private Suscripcion suscripcionCliente1Repetida;

	@Before
	public void init() {
		gestion = new SistemaDeGestion();
		cliente1 = new Cliente(112233, "Tomas", "Elbert", 24);
		cliente2 = new Cliente(334455, "Martin", "Martinez", 55);
		cliente3 = new Cliente(4487322, "Usuario", "Usuario", 21);
		cliente1Repetido = new Cliente(112233, "Juan", "Perez", 32);
		canal1 = new Canal((short) 1, "TyC", CategoriaCanalEnums.Deportes, ClasificacionCanalEnums.Basico);
		canal2 = new Canal((short) 2, "History Channel", CategoriaCanalEnums.Varios, ClasificacionCanalEnums.Basico);
		canalRepetido = new Canal((short) 1, "MTv", CategoriaCanalEnums.Varios, ClasificacionCanalEnums.Basico);
		planBasico = new PlanBasico(1, "Plan Basico Residencial");
		planConIdRepetido = new PlanBasico(1, "Plan Basico Repetido");
		planPremium = new PlanPremium(2, "Plan Premium Residencial");
		suscripcionCliente1 = new Suscripcion(1, this.cliente1.getDni(), this.planBasico.getIdPlan(),
				new HashSet<>(Arrays.asList(this.canal1)));
		suscripcionCliente1Repetida = new Suscripcion(1, this.cliente2.getDni(), this.planPremium.getIdPlan(),
				new HashSet<>(Arrays.asList(this.canal1, this.canal2)));
		suscripcionCliente2 = new Suscripcion(2, this.cliente2.getDni(), this.planBasico.getIdPlan(),
				new HashSet<>(Arrays.asList(this.canal1)));
	}

	@Test
	public void dadoQueExisteUnaCompaniaSePuedeAgregarUnCliente() throws ClienteExistenteException {
		Boolean seAgregoElCliente = this.gestion.registrarNuevoCliente(this.cliente1);
		assertTrue(seAgregoElCliente);
	}

	@Test(expected = ClienteExistenteException.class)
	public void dadoQueExisteUnaCompaniaAlAgregarUnClienteExistenteSeLanzaUnaClienteExistenteException()
			throws ClienteExistenteException {
		this.gestion.registrarNuevoCliente(this.cliente1);
		this.gestion.registrarNuevoCliente(this.cliente1Repetido);
	}

	@Test
	public void dadoQueExisteUnaCompaniaSePuedeAgregarUnCanal() throws CanalExistenteException {
		Boolean seRegistroElCanal = this.gestion.registrarNuevoCanal(this.canal1);
		assertTrue(seRegistroElCanal);
	}

	@Test(expected = CanalExistenteException.class)
	public void dadoQueExisteUnaCompaniaAlAgregarUnCanalExistenteSeLanzaUnaCanalExistenteException()
			throws CanalExistenteException {
		this.gestion.registrarNuevoCanal(this.canal1);
		this.gestion.registrarNuevoCanal(this.canalRepetido);
	}

	@Test
	public void dadoQueExisteUnaCompaniaSePuedeAgregarUnPlan() throws PlanExistenteException {
		Boolean planAgregado = this.gestion.registrarNuevoPlan(this.planBasico);
		assertTrue(planAgregado);
	}

	@Test(expected = PlanExistenteException.class)
	public void dadoQueExisteUnaCompaniaAlAgregarUnPlanConIdExistenteObtengoUnaPlanExistenteException()
			throws PlanExistenteException {
		this.gestion.registrarNuevoPlan(this.planBasico);
		this.gestion.registrarNuevoPlan(this.planConIdRepetido);
	}

	@Test
	public void dadoQueExisteUnaCompaniaSePuedeRegistrarUnaSuscripcionDeUnCliente() throws ClienteExistenteException,
			PlanExistenteException, CanalExistenteException, SuscripcionExistenteException {
		this.gestion.registrarNuevoCliente(this.cliente1);
		this.gestion.registrarNuevoPlan(this.planBasico);
		this.gestion.registrarNuevoCanal(this.canal1);
		Boolean seRegistro = this.gestion.registrarNuevaSuscripcion(this.suscripcionCliente1);
		assertTrue(seRegistro);
	}

	@Test(expected = SuscripcionExistenteException.class)
	public void dadoQueExisteUnaCompaniaSiIntentoRegistrarUnaSuscripcionExistenteObtengoUnaSuscripcionExistenteException()
			throws ClienteExistenteException, PlanExistenteException, CanalExistenteException,
			SuscripcionExistenteException {
		this.gestion.registrarNuevoCliente(this.cliente1);
		this.gestion.registrarNuevoCliente(this.cliente2);
		this.gestion.registrarNuevoPlan(this.planBasico);
		this.gestion.registrarNuevoCanal(this.canal1);
		this.gestion.registrarNuevaSuscripcion(this.suscripcionCliente1);
		this.gestion.registrarNuevaSuscripcion(this.suscripcionCliente1Repetida);
	}

	@Test
	public void dadoQueExisteUnaCompaniaConUnPlanBasicoYUnPlanPremiumCuandoSeObtieneElPrecioDeUnPlanPremiumDevuelve6000()
			throws PlanExistenteException {
		this.gestion.registrarNuevoPlan(this.planBasico);
		this.gestion.registrarNuevoPlan(this.planPremium);
		Double precioPlanPremiumEsperado = 6000.0;
		Double precioPlanPremiumObtenido = this.gestion.obtenerPrecioPlan(this.planPremium.getIdPlan());
		assertEquals(precioPlanPremiumEsperado, precioPlanPremiumObtenido);
	}

	@Test
	public void dadoQueExisteUnaCompaniaConClientesSePuedenListarLosClientesOrdenadosDeManeraAscendentePorSuDni()
			throws ClienteExistenteException {
		this.gestion.registrarNuevoCliente(this.cliente1);
		this.gestion.registrarNuevoCliente(this.cliente2);
		this.gestion.registrarNuevoCliente(this.cliente3);
		TreeSet<Cliente> clientesOrdenadosPorDni = this.gestion.reportarClientesOrdenadosPorDniAscendente();

		for (Cliente clnt : clientesOrdenadosPorDni) {
			System.out.println("\n.=== DNI cliente: " + clnt.getDni() + " ===.");
			System.out.println("Nombre: " + clnt.getNombre());
			System.out.println("Apellido: " + clnt.getApellido());
		}
		assertEquals(3, clientesOrdenadosPorDni.size());
	}

	@Test
	public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedenListarLasSuscripcionesAPlanesPremium()
			throws ClienteExistenteException, PlanExistenteException, CanalExistenteException,
			SuscripcionExistenteException {
		this.gestion.registrarNuevoCliente(this.cliente1);
		this.gestion.registrarNuevoCliente(this.cliente2);
		this.gestion.registrarNuevoPlan(this.planBasico);
		this.gestion.registrarNuevoPlan(this.planPremium);
		this.gestion.registrarNuevoCanal(this.canal1);
		this.gestion.registrarNuevoCanal(this.canal2);
		Suscripcion unaSub = new Suscripcion(10, this.cliente1.getDni(), this.planPremium.getIdPlan(),
				new HashSet<>(Arrays.asList(this.canal1)));
		Suscripcion otraSub = new Suscripcion(20, this.cliente2.getDni(), this.planPremium.getIdPlan(),
				new HashSet<>(Arrays.asList(this.canal1)));
		this.gestion.registrarNuevaSuscripcion(unaSub);
		this.gestion.registrarNuevaSuscripcion(otraSub);
		ArrayList<Cliente> clientesSuscriptosPlanesPremium = this.gestion.obtenerClientesSuscriptosPlanesPremium();
		for (Cliente clnt : clientesSuscriptosPlanesPremium) {
			System.out.println("DNI: " + clnt.getDni());
			System.out.println("Nombre: " + clnt.getNombre());
			System.out.println("Apellido: " + clnt.getApellido());
		}
		assertEquals(2, clientesSuscriptosPlanesPremium.size());
	}

	@Test
	public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedenListarLosClientesSuscritosAPlanesBasicos()
			throws ClienteExistenteException, PlanExistenteException, CanalExistenteException,
			SuscripcionExistenteException {
		this.gestion.registrarNuevoCliente(this.cliente1);
		this.gestion.registrarNuevoCliente(this.cliente2);
		this.gestion.registrarNuevoPlan(this.planBasico);
		this.gestion.registrarNuevoCanal(this.canal1);
		this.gestion.registrarNuevoCanal(this.canal2);
		this.gestion.registrarNuevaSuscripcion(this.suscripcionCliente1);
		this.gestion.registrarNuevaSuscripcion(this.suscripcionCliente2);
		ArrayList<Cliente> clientesSuscriptosAPlanesBasicos = this.gestion.obtenerClientesSuscriptosPlanesBasicos();
		for (Cliente clnt : clientesSuscriptosAPlanesBasicos) {
			System.out.println("DNI: " + clnt.getDni());
			System.out.println("Nombre: " + clnt.getNombre());
			System.out.println("Apellido: " + clnt.getApellido());
		}
		assertEquals(2, clientesSuscriptosAPlanesBasicos.size());
	}

	@Test
	public void dadoQueExisteUnCompaniaConClientesSuscritosAPlanesBasicosOPremiumSePuedeObtnerUnMapaConElPlanComoClaveYUnaListaDeClientesOrdenadosDeManeraDescendentePorDniDelClienteComoValores()
			throws ClienteExistenteException, PlanExistenteException, CanalExistenteException,
			SuscripcionExistenteException {
		this.gestion.registrarNuevoCliente(this.cliente1);
		this.gestion.registrarNuevoCliente(this.cliente2);
		this.gestion.registrarNuevoPlan(this.planBasico);
		this.gestion.registrarNuevoPlan(this.planPremium);
		this.gestion.registrarNuevoCanal(this.canal1);
		this.gestion.registrarNuevoCanal(this.canal2);
		Suscripcion unaSub = new Suscripcion(10, this.cliente1.getDni(), this.planPremium.getIdPlan(),
				new HashSet<>(Arrays.asList(this.canal1)));
		Suscripcion otraSub = new Suscripcion(20, this.cliente2.getDni(), this.planPremium.getIdPlan(),
				new HashSet<>(Arrays.asList(this.canal1)));
		this.gestion.registrarNuevaSuscripcion(unaSub);
		this.gestion.registrarNuevaSuscripcion(otraSub);
		TreeMap<Plan, TreeSet<Cliente>> reporteClientesPorPlan = this.gestion.reporteClientesPorPlan();
	}
}
