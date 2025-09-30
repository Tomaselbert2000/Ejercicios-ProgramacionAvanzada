package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ClaseDeTest {
	
	private SistemaPagos gestion;
	
	@Before
	public void inicializarObjetos() {
		gestion = new SistemaPagos();
	}

	@Test
	public void dadoQueExisteUnMetodoDePagoSiLoRegistroObtengoTrue() {
		MetodoDePago metodo = new MetodoDePago();
		Boolean seRegistro = this.gestion.registrarMetodoDePago(metodo);
		assertTrue(seRegistro);
	}
	
	@Test
	public void dadoQueExisteUnaClaseTransferenciaBancariaPorHerenciaSiLaRegistroObtengoTrue() {
		TransferenciaBancaria transferencia = new TransferenciaBancaria();
		Boolean seRegistro = this.gestion.registrarMetodoDePago(transferencia);
		assertTrue(seRegistro);
	}
	
	@Test
	public void dadoQueExisteUnMetodoTransferenciaBancariaSiPagoMasDe100KobtengoQueElTotalEs151500() {
		// creamos el metodo de pago y lo registramos
		TransferenciaBancaria transferencia = new TransferenciaBancaria();
		this.gestion.registrarMetodoDePago(transferencia);
		
		Double montoOriginal = 150000.0;
		Double montoDePagoFinalEsperado = 151500.0;
		Double montoDePagoFinalObtenido = transferencia.procesarPago(montoOriginal);
		
		assertEquals(montoDePagoFinalEsperado, montoDePagoFinalObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaClaseMercadoPagoPorHerenciaSiLaRegistroObtengoTrue() {
		MercadoPago mercadopago = new MercadoPago();
		Boolean seRegistro = this.gestion.registrarMetodoDePago(mercadopago);
		assertTrue(seRegistro);
	}
	
	@Test
	public void dadoQueExisteUnMetodoMercadoPagoYPagoDiezMilObtengoQueElTotalEsOnceMilDoscientos() {
		MercadoPago mercadopago = new MercadoPago();
		this.gestion.registrarMetodoDePago(mercadopago);
		
		Double montoOriginal = 10000.0;
		Double montoFinalEsperado = 11200.0;
		Double montoFinalObtenido = mercadopago.procesarPago(montoOriginal);
		
		assertEquals(montoFinalEsperado, montoFinalObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaClaseTarjetaDeCreditoPorHerenciaSiLaRegistroObtengoTrue() {
		Double limiteCredito = 500000.0;
		TarjetaDeCredito tarjeta = new TarjetaDeCredito(limiteCredito); // agregamos el limite de credito en el constructor
		Boolean seRegistro = this.gestion.registrarMetodoDePago(tarjeta);
		assertTrue(seRegistro);
	}
	
	@Test
	public void dadoQueExisteUnaClaseTarjetaDeCreditoConLimite100KyQuieroPagar120KobtengoQueNoMeLoPermite() {
		Double limiteCredito = 100000.0;
		TarjetaDeCredito tarjeta = new TarjetaDeCredito(limiteCredito); // agregamos el limite de credito en el constructor
		this.gestion.registrarMetodoDePago(tarjeta);
		
		Double montoQueQuieroPagar = 120000.0;
		Double montoFinalEsperado = -1.0; // si el limite es insuficiente, el metodo va a retornar -1 para indicarlo
		Double montoFinalObtenido = tarjeta.procesarPago(montoQueQuieroPagar);
		
		assertEquals(montoFinalEsperado, montoFinalObtenido);
	}
}
