package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ar.edu.unlam.subClasses.VMBaseDeDatos;
import ar.edu.unlam.subClasses.VMAlmacenamientoDeImagenes;

public class VirtualMachineTest {

	@Test
	public void dadoQueExisteUnaVMdeBaseDeDatosPorHerenciaObtengoQuePuedoConsultarSusAtributos() {
		Integer idVM = 1;
		Integer dniUsuarioAsociado = 1;
		Double limiteMensualHorasDeUso = 250.0;
		VMBaseDeDatos vmDB = new VMBaseDeDatos(idVM, dniUsuarioAsociado, limiteMensualHorasDeUso);
		
		assertEquals(idVM, vmDB.getId());
		assertEquals(0.0, vmDB.getAlmacenamientoUsadoActualmente(), 0.0);
		assertEquals(1000.0, vmDB.getCostoInicial(), 0.0);
		assertEquals(dniUsuarioAsociado, vmDB.getDniUsuarioAsociado());
		assertEquals(limiteMensualHorasDeUso, vmDB.getLimiteMensualHorasDeUso());
	}
	
	@Test
	public void dadoQueExisteUnaVMdeImagenesPorHerenciaObtengoQuePuedoConsultarSusAtributos() {
		Integer idVM = 1;
		Integer dniUsuarioAsociado = 1;
		Integer limiteOperacionesDeLectura = 10000;
		Integer limiteOperacionesDeEscritura = 7000;
		VMAlmacenamientoDeImagenes vmImg = new VMAlmacenamientoDeImagenes(idVM, dniUsuarioAsociado, limiteOperacionesDeLectura, limiteOperacionesDeEscritura);
		
		assertEquals(idVM, vmImg.getId());
		assertEquals(0.0, vmImg.getAlmacenamientoUsadoActualmente(), 0.0);
		assertEquals(500.0, vmImg.getCostoInicial(), 0.0);
		assertEquals(dniUsuarioAsociado, vmImg.getDniUsuarioAsociado());
		assertEquals(limiteOperacionesDeLectura, vmImg.getLimiteOperacionesDeLectura());
		assertEquals(limiteOperacionesDeEscritura, vmImg.getLimiteOperacionesEscritura());
	}
	
	@Test
	public void dadoQueExisteUnaVirtualMachineDBConAlmacenamientoDe20GbSiUso15GbObtengoQueMeQuedan5Gb() {
		VMBaseDeDatos vmDB = new VMBaseDeDatos(1, 1, 250.0);
		Double almacenamientoQueVoyAUsar = 15.0;
		vmDB.usarAlmacenamiento(almacenamientoQueVoyAUsar);
		Double almacenamientoUsadoEsperado = 15.0;
		Double almacenamientoUsadoObtenido = vmDB.getAlmacenamientoUsadoActualmente();
		
		assertEquals(almacenamientoUsadoEsperado, almacenamientoUsadoObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaVirtualMachineDBConUnLimiteDeHorasMensualDe250SiLaUso150HorasObtengoQueMeQuedan100Disponibles() {
		VMBaseDeDatos vmDB = new VMBaseDeDatos(1, 1, 250.0);
		Double cantidadDeHorasQueUseLaVM = 150.0;
		vmDB.registrarHorasDeUso(cantidadDeHorasQueUseLaVM);
		Double cantidadDeHorasRestantesEsperada = 100.0;
		Double cantidadDeHorasRestantesObtenida = vmDB.getHorasRestanteHastaLimite();
		
		assertEquals(cantidadDeHorasRestantesEsperada, cantidadDeHorasRestantesObtenida);
	}
	
	@Test
	public void dadoQueExisteUnaVirtualMachineDeImagenesSiUso2GbObtengoQueMeQuedan3GbDisponibles() {
		VMAlmacenamientoDeImagenes vmImg = new VMAlmacenamientoDeImagenes(1, 1, 10000, 7000);
		Double almacenamientoQueVoyAUsar = 2.0;
		vmImg.usarAlmacenamiento(almacenamientoQueVoyAUsar);
		Double almacenamientoUsadoEsperado = 2.0;
		Double almacenamientoUsadoObtenido = vmImg.getAlmacenamientoUsadoActualmente();
		
		assertEquals(almacenamientoUsadoEsperado, almacenamientoUsadoObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaVirtualMachineDeImagenesSiRealizoMilOperacionesDeLecturaObtengoQueSume1000operaciones() {
		VMAlmacenamientoDeImagenes vmImg = new VMAlmacenamientoDeImagenes(1, 1, 10000, 7000);
		Integer operacionesLecturaARealizar = 1000;
		vmImg.registrarOperacionesDeLectura(operacionesLecturaARealizar);
		Integer cantidadOperacionesRealizadasEsperada = 1000;
		Integer cantidadOperacionesRealizadasObtenidas = vmImg.obtenerCantidadDeLecturasRealizadas();
		
		assertEquals(cantidadOperacionesRealizadasEsperada, cantidadOperacionesRealizadasObtenidas);
	}
	
	@Test
	public void dadoQueExisteUnaVirtualMachineDeImagenesSiRealizo1000OperacionesDeEscrituraObtengoQueSume1000operaciones() {
		VMAlmacenamientoDeImagenes vmImg = new VMAlmacenamientoDeImagenes(1, 1, 10000, 7000);
		Integer operacionesEscrituraRealizadas = 1000;
		vmImg.registrarOperacionesDeEscritura(operacionesEscrituraRealizadas);
		Integer cantidadOperacionesRealizadasEsperada = 1000;
		Integer cantidadOperacionesRestantesObtenidas = vmImg.obtenerCantidadDeEscriturasRealizadas();
		
		assertEquals(cantidadOperacionesRealizadasEsperada, cantidadOperacionesRestantesObtenidas);
	}
}
