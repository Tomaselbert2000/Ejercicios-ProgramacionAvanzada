package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ar.edu.unlam.exceptions.CantidadDeEscriturasSuperadaException;
import ar.edu.unlam.exceptions.CantidadDeHorasDeUsoExcedidaException;
import ar.edu.unlam.exceptions.CantidadLecturasSuperadaException;
import ar.edu.unlam.exceptions.UsuarioDuplicadoException;
import ar.edu.unlam.subClasses.VMBaseDeDatos;
import ar.edu.unlam.subClasses.VMAlmacenamientoDeImagenes;

public class GestionSistemaTest {

	private GestionSistema gestionSistema;
	private Usuario nuevoUsuario;
	private Usuario nuevoUsuarioCorreoRepetido;
	private Usuario otroUsuarioMas;
	private VMBaseDeDatos vmBD;
	private VMAlmacenamientoDeImagenes vmImg;

	@Before
	public void init() {
		gestionSistema = new GestionSistema();
		nuevoUsuario = new Usuario(1, "tomas@gmail.com", "123456");
		otroUsuarioMas = new Usuario(5, "otroUsuario@gmail.com", "112233");
		nuevoUsuarioCorreoRepetido = new Usuario(2, "tomas@gmail.com", "09876");
		vmBD = new VMBaseDeDatos(1, 1, 350.0);
		vmImg = new VMAlmacenamientoDeImagenes(2, 1, 10000, 7000);
	}

	@Test
	public void dadoQueExisteUnSistemaDeGestionDeVMsSiRegistroUnUsuarioObtengoTrue() throws UsuarioDuplicadoException {
		Boolean seRegistroElUsuario = this.gestionSistema.registrarNuevoUsuario(this.nuevoUsuario);
		assertTrue(seRegistroElUsuario);
	}

	@Test(expected = UsuarioDuplicadoException.class)
	public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesCuandoAgregoUnUsuarioConUnCorreoExistenteObtengoUnaUsuarioDuplicadoException()
			throws UsuarioDuplicadoException {
		this.gestionSistema.registrarNuevoUsuario(this.nuevoUsuario);
		this.gestionSistema.registrarNuevoUsuario(this.nuevoUsuarioCorreoRepetido);
	}

	@Test
	public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConAlMenosUnUsuarioCuandoAgregoUnaVMBaseDeDatosObtengoUnResultadoExitoso()
			throws UsuarioDuplicadoException {
		this.gestionSistema.registrarNuevoUsuario(this.nuevoUsuario);
		Boolean fueRegistrada = this.gestionSistema.registrarNuevaVirtualMachine(this.vmBD);
		assertTrue(fueRegistrada);
	}

	@Test
	public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConAlMenosUnUsuarioCuandoAgregoUnaVMAlmacenamientoDeImagenesObtengoUnResultadoExitoso()
			throws UsuarioDuplicadoException {
		this.gestionSistema.registrarNuevoUsuario(this.nuevoUsuario);
		Boolean fueRegistrada = this.gestionSistema.registrarNuevaVirtualMachine(this.vmImg);
		assertTrue(fueRegistrada);
	}

	@Test
	public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConAlMenosUnUsuarioYUnaVMBaseDeDatosUsadaCuandoObtengoElCostoFinalPor10GBY5HorasRecibo1125()
			throws UsuarioDuplicadoException, CantidadDeHorasDeUsoExcedidaException {
		this.gestionSistema.registrarNuevoUsuario(this.nuevoUsuario);
		this.gestionSistema.registrarNuevaVirtualMachine(this.vmBD);
		this.gestionSistema.registrarGBsEnVM(this.vmBD, 10.0);
		this.gestionSistema.registrarHorasEnVM(this.vmBD, 5.0);
		Double costoExtraEsperado = 1125.0;
		Double costoExtraObtenido = this.gestionSistema.obtenerCostoExtraDeLaVM(this.vmBD.getId());

		assertEquals(costoExtraEsperado, costoExtraObtenido);
	}

	@Test
	public void dadoQueExisteUnaVirtualMachineDeImagenesConUnAlmacenamientoDe5Gb10000LecturasY7000EscriturasSiUso3Gb5000LecturasY3000EscriturasObtengoQueSuCostoExtraEs11500()
			throws UsuarioDuplicadoException {
		this.gestionSistema.registrarNuevoUsuario(this.nuevoUsuario);
		this.gestionSistema.registrarNuevaVirtualMachine(this.vmImg);
		vmImg.registrarOperacionesDeLectura(5000);
		vmImg.registrarOperacionesDeEscritura(3000);
		Double costoExtraEsperado = 11500.0;
		Double costoExtraObtenido = this.gestionSistema.obtenerCostoExtraDeLaVM(this.vmImg.getId());

		assertEquals(costoExtraEsperado, costoExtraObtenido);
	}

	@Test(expected = CantidadDeHorasDeUsoExcedidaException.class)
	public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConAlMenosUnUsuarioYUnaVMBaseDeDatosCuandoSuperoLaCapacidadDeHorasDeUsoObtengoUnaCantidadDeHorasDeUsoExcedidaException()
			throws UsuarioDuplicadoException, CantidadDeHorasDeUsoExcedidaException {
		this.gestionSistema.registrarNuevoUsuario(this.nuevoUsuario);
		this.gestionSistema.registrarNuevaVirtualMachine(this.vmBD);
		Double cantidadDeHorasQueUseLaVM = 400.0;
		this.gestionSistema.registrarHorasEnVM(this.vmBD, cantidadDeHorasQueUseLaVM);
	}

	@Test(expected = CantidadDeEscriturasSuperadaException.class)
	public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConAlMenosUnUsuarioYUnaVMAlmacenamientoDeImagenesCuandoSuperoLaCantidadDeEscriturasObtengoUnaCantidadDeEscriturasSuperadaException()
			throws UsuarioDuplicadoException, CantidadDeEscriturasSuperadaException {
		this.gestionSistema.registrarNuevoUsuario(this.nuevoUsuario);
		this.gestionSistema.registrarNuevaVirtualMachine(this.vmImg);
		Integer operacionesDeEscrituraRealizadas = 11000;
		this.gestionSistema.registrarEscriturasEnVM(this.vmImg, operacionesDeEscrituraRealizadas);
	}

	@Test
	public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConAlMenosUnUsuarioYUnaVMAlmacenamientoDeImagenesUsadaCuandoObtengoElCostoFinalPor20LecturasY10EscriturasRecibo540()
			throws UsuarioDuplicadoException, CantidadDeEscriturasSuperadaException, CantidadLecturasSuperadaException {
		this.gestionSistema.registrarNuevoUsuario(this.nuevoUsuario);
		this.gestionSistema.registrarNuevaVirtualMachine(this.vmImg);
		Integer lecturasRealizadas = 20;
		Integer escriturasRealizadas = 10;
		this.gestionSistema.registrarLecturasEnVM(this.vmImg, lecturasRealizadas);
		this.gestionSistema.registrarEscriturasEnVM(vmImg, escriturasRealizadas);
		Double costoFinalEsperado = 540.0;
		Double costoFinalObtenido = this.gestionSistema.obtenerCostoExtraDeLaVM(this.vmImg.getId());
		assertEquals(costoFinalEsperado, costoFinalObtenido);
	}

	@Test
	public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConUsuariosQuePoseenVMsCuandoConsultoLosCostosAPagarPorCadaClienteObtengoUnMapaConClaveUsuarioYUnaColeccionDeCostosComoValorOrdenadosPorCostoDescendentemente()
			throws UsuarioDuplicadoException, CantidadDeHorasDeUsoExcedidaException,
			CantidadDeEscriturasSuperadaException {
		this.gestionSistema.registrarNuevoUsuario(this.nuevoUsuario);
		this.gestionSistema.registrarNuevoUsuario(this.otroUsuarioMas);
		VMBaseDeDatos vmUsuario1 = new VMBaseDeDatos(1, this.nuevoUsuario.getDni(), 500.0);
		VMAlmacenamientoDeImagenes vmUsuario2 = new VMAlmacenamientoDeImagenes(2, this.otroUsuarioMas.getDni(), 5000,
				3000);
		this.gestionSistema.registrarNuevaVirtualMachine(vmUsuario1);
		this.gestionSistema.registrarNuevaVirtualMachine(vmUsuario2);
		Double cantidadDeHorasUsadasPorUsuario1 = 272.5;
		Integer cantidadDeEscriturasUsuario2 = 1278;
		this.gestionSistema.registrarHorasEnVM(vmUsuario1, cantidadDeHorasUsadasPorUsuario1);
		this.gestionSistema.registrarEscriturasEnVM(vmUsuario2, cantidadDeEscriturasUsuario2);
		
		System.out.println(".=== Reporte de costos ordenados de forma descendente ===.");
		for(Usuario usr : this.gestionSistema.reporteCostosOrdenados().keySet()) {
			System.out.println("DNI de usuario: " + usr.getDni());
			System.out.println("Coleccion de costos asociados: " + "$" + this.gestionSistema.reporteCostosOrdenados().get(usr) + "\n");
		}
	}
}
