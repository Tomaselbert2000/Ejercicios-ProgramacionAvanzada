package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class InmobiliariaTest {

	private Propiedad prop;
	private Inmobiliaria inmb;

	@Before
	public void inicializarPropiedad() {
		prop = new Propiedad(1, 50000.0, "PH", "CABA");
		inmb = new Inmobiliaria();
	}
	
	@Test
	public void dadoQueNoExisteUnaInmobiliariaAlCrearlaExisteUnaListaDePropiedadesYUnaListaDeClientes() {
		
	}

	@Test
	public void dadoQueExisteUnaInmobiliariaYUnaPropiedadaAlAgregarlaALaListaSuTamañoDevuelve1() {
		Propiedad prop = new Propiedad(1, 2000.0, "Departamento", null);
		inmb.registrarPropiedad(prop);
		Integer cantidadPropiedadesRegistradasEsperada = 1;
		Integer cantidadPropiedadesRegistradasObtenida = this.inmb.getCantidadPropiedadesRegistradas();
		assertEquals(cantidadPropiedadesRegistradasEsperada, cantidadPropiedadesRegistradasObtenida);
	}

	@Test
	public void dadoQueExisteUnaInmobiliariaYUnClienteAlAgregarloALaListaRetornaSuTamañoRetorna1() {
		Cliente cliente = new Cliente("Tomas", "Elbert");
		this.inmb.registrarCliente(cliente);
		Integer cantidadClientesEsperada = 1;
		Integer cantidadClientesObtenida = this.inmb.getCantidadClientesRegistrados();
		assertEquals(cantidadClientesEsperada, cantidadClientesObtenida);
	}

	@Test
	public void dadoQueExistenUnaPropiedadSiTresVendedoresLaCarganAlSistemaLaListaRetornaTamaño3() {
		this.inmb.registrarPropiedad(this.prop);
		this.inmb.registrarPropiedad(this.prop);
		this.inmb.registrarPropiedad(this.prop);
		Integer cantidadPropiedadesEsperada = 3;
		Integer cantidadPropiedadesObtenida = this.inmb.getCantidadPropiedadesRegistradas();
		assertEquals(cantidadPropiedadesEsperada, cantidadPropiedadesObtenida);
	}

	@Test
	public void dadoQueExisteUnaListaDePropiedadesSiFiltroPorPrecio25000ObtengoUnaListaDeSize2() {
		Propiedad prop1 = new Propiedad(1, 25000.0, "Casa", "Gonzalez Catan");
		Propiedad prop2 = new Propiedad(2, 9999.9, "PH", "Ramos Mejia");
		Propiedad prop3 = new Propiedad(3, 25000.0, "Terreno", "San Justo");
		this.inmb.registrarPropiedad(prop1);
		this.inmb.registrarPropiedad(prop2);
		this.inmb.registrarPropiedad(prop3);
		Integer cantidadPropiedadesEsperada = 2;
		Integer cantidadPropiedadesObtenida = this.inmb.getListaPropiedadesPorPrecio(25000.0).size();
		assertEquals(cantidadPropiedadesEsperada, cantidadPropiedadesObtenida);
	}

	@Test
	public void dadoQueExistenCincoPropiedadesSiFiltroPorTipoCasaObtengoUnaListaDe3Elementos() {
		Propiedad prop1 = new Propiedad(1, 0, "Casa", null);
		Propiedad prop2 = new Propiedad(2, 0, "PH", null);
		Propiedad prop3 = new Propiedad(3, 0, "Casa", null);
		Propiedad prop4 = new Propiedad(4, 0, "Casa", null);
		Propiedad prop5 = new Propiedad(5, 0, "Departamento", null);
		this.inmb.registrarPropiedad(prop1);
		this.inmb.registrarPropiedad(prop2);
		this.inmb.registrarPropiedad(prop3);
		this.inmb.registrarPropiedad(prop4);
		this.inmb.registrarPropiedad(prop5);
		Integer cantidadPropiedadesEsperada = 3;
		Integer cantidadPropiedadesObtenida = this.inmb.getListaPropiedadesPorTipo("Casa").size();
		assertEquals(cantidadPropiedadesEsperada, cantidadPropiedadesObtenida);
	}

	@Test
	public void dadoQueExisteUnaListaDePropiedadesRegistradasSiFiltroPorUbicacionCABARetornaUnaPropiedad() {
		Propiedad prop1 = new Propiedad(1, 1000.0, "Casa", "CABA");
		Propiedad prop2 = new Propiedad(2, 2000.0, "PH", "Parque Chacabuco");
		Propiedad prop3 = new Propiedad(3, 3000.0, "Departamento", "Gonzalez Catan");
		this.inmb.registrarPropiedad(prop1);
		this.inmb.registrarPropiedad(prop2);
		this.inmb.registrarPropiedad(prop3);
		Integer cantidadPropiedadesCabaEsperada = 1;
		Integer cantidadPropiedadesCabaObtenida = this.inmb.getListaPropiedadesPorUbicacion("CABA").size();
		assertEquals(cantidadPropiedadesCabaEsperada, cantidadPropiedadesCabaObtenida);
	}

	@Test
	public void dadoExisteUnClienteYRegistrarloAlVerificarSiEstaRegistradoRetornaTrue() {
		Cliente cliente = new Cliente("Tomas", "Elbert");
		Boolean valorRetornoEsperado = true;
		this.inmb.registrarCliente(cliente);
		Boolean valorRetornoObtenido = this.inmb.verificarRegistroCliente(cliente);
		assertTrue(valorRetornoEsperado.equals(valorRetornoObtenido));
	}

	@Test
	public void dadoQueNoPuedoTenerClientesRepetidosSiIntentoAgregarElMismoClienteRetornaFalse() {
		Cliente cliente1 = new Cliente("Tomas", "Elbert");
		Cliente cliente2 = new Cliente("Tomas", "Elbert");
		this.inmb.registrarCliente(cliente1);
		this.inmb.registrarCliente(cliente2);
		Boolean cliente2RegistroEsperado = false;
		Boolean cliente2RegistradoObtenido = this.inmb.verificarRegistroCliente(cliente2);
		assertFalse(cliente2RegistroEsperado.equals(cliente2RegistradoObtenido));
	}

	@Test
	public void dadoQueExisteUnaPropiedadOfertadaSiSeVendeSeEliminaDeLaListaDePropiedadesEnVenta() {
		this.inmb.registrarPropiedad(this.prop);
		Integer cantidadPropiedadesOfertadasEsperada = 1;
		Integer cantidadPropiedadesOfertadasObtenida = this.inmb.getCantidadPropiedadesRegistradas();
		assertEquals(cantidadPropiedadesOfertadasEsperada, cantidadPropiedadesOfertadasObtenida);
		inmb.venderPropiedad(this.prop);
		Integer nuevaCantidadPropiedadesOfertadasEsperada = 0;
		Integer nuevaCantidadPropiedadesOfertadasObtenida = this.inmb.getCantidadPropiedadesRegistradas();
		assertEquals(nuevaCantidadPropiedadesOfertadasEsperada, nuevaCantidadPropiedadesOfertadasObtenida);
	}
}
