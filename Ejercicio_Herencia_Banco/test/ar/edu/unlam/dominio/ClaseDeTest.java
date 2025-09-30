package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ClaseDeTest {
	
	/*
	 * Para este ejercicio planteamos un banco:
	 * Caja de ahorro --> id, saldo, cbu, propietario
	 * Caja CC --> id, saldo, cbu, propietario, limiteDescubierto
	 * 
	 * CA --> depositos, consultar saldo, extraer (no puedo extraer mas de lo que tengo en saldo)
	 * CC --> depositos, consultar saldo, extraer (puedo extraer solo hasta el limite del descubierto de la cuenta)
	 * 
	 * Importante, estos dos objetos anteriores comparten comportamientos, podemos usar herencia e interfaz
	 */
	
	// se debe realizar un test acorde a cada funcionalidad que se plantea
	
	//+--- Casos de test para la caja de ahorro ---+
	@Test
	public void dadoQueExisteUnaCajaDeAhorroPuedoConsultarSuSaldoActual() {
		String nombre = "Tomas";
		String apellido = "Elbert";
		Integer dni = 1234567;
		
		Cliente cliente = new Cliente(nombre, apellido, dni);
		
		Integer cbu = 112233;
		CajaDeAhorro cajaAhorro = new CajaDeAhorro(cliente, cbu); // para el id vamos a generar un valor autoincremental
		
		Double saldoEsperado = 0.0;
		Double saldoObtenido = cajaAhorro.getSaldo();
		assertEquals(saldoEsperado, saldoObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaCajaDeAhorroSiRealizoUnDepositoDeMilPesosAlConsultarSuSaldoObtengoQueEsMil() {
		String nombre = "Tomas";
		String apellido = "Elbert";
		Integer dni = 1234567;
		
		Cliente cliente = new Cliente(nombre, apellido, dni);
		
		Integer cbu = 112233;
		CajaDeAhorro cajaAhorro = new CajaDeAhorro(cliente, cbu);
		
		Double montoParaDepositar = 1000.0;
		cajaAhorro.depositarEnCuenta(montoParaDepositar); // creamos aca el metodo para poder depositar
		
		Double saldoEsperado = 1000.0;
		Double saldoObtenido = cajaAhorro.getSaldo();
		
		assertEquals(saldoEsperado, saldoObtenido); // aca aseguramos que el saldo si paso a 1000
	}
	
	@Test
	public void dadoQueExisteUnaCajaDeAhorroConUnSaldoDe1000YExtraigo400ObtengoQueElSaldoEs600() {
		String nombre = "Tomas";
		String apellido = "Elbert";
		Integer dni = 1234567;
		
		Cliente cliente = new Cliente(nombre, apellido, dni);
		
		Integer cbu = 112233;
		CajaDeAhorro cajaAhorro = new CajaDeAhorro(cliente, cbu);
		
		Double montoParaDepositar = 1000.0;
		cajaAhorro.depositarEnCuenta(montoParaDepositar);
		
		Double montoParaExtraer = 400.0;
		cajaAhorro.extraerDeCuenta(montoParaExtraer); // creamos el metodo para extraer de la cuenta, luego lo refactorizamos
		
		Double saldoEsperado = 600.0;
		Double saldoObtenido = cajaAhorro.getSaldo();
		
		assertEquals(saldoEsperado, saldoObtenido); // validamos que se puede restar saldo correctamente
	}
	
	@Test
	public void dadoQueExisteUnaCajaDeAhorroCon1000SiIntentoExtraer1400NoMePermite() {
		String nombre = "Tomas";
		String apellido = "Elbert";
		Integer dni = 1234567;
		
		Cliente cliente = new Cliente(nombre, apellido, dni);
		
		Integer cbu = 112233;
		CajaDeAhorro cajaAhorro = new CajaDeAhorro(cliente, cbu);
		
		Double montoParaDepositar = 1000.0; // depositaremos 1000 en cuenta
		cajaAhorro.depositarEnCuenta(montoParaDepositar);
		
		Double montoParaExtraer = 1400.0; // vamos a intentar sacar mas que lo que hay en cuenta
		
		assertFalse(cajaAhorro.extraerDeCuenta(montoParaExtraer)); // y aca validamos que no lo permite porque supera el saldo en cuenta
	}
	
	//+--- Casos de test para la clase Cuenta Corriente ---+
	
	@Test
	public void dadoQueExisteUnaCuentaCorrienteConSaldo1000YunDescubiertoDe500AlExtraer1400ObtengoUnDescubiertoDe400() {
		// creamos el cliente para la CC
		String nombre = "Tomas";
		String apellido = "Elbert";
		Integer dni = 1234567;
		
		// lo instanciamos para pasarlo por parametro
		Cliente cliente = new Cliente(nombre, apellido, dni);
		
		// otros datos de la CC
		Integer cbu = 112233;
		Double limiteDescubierto = 500.0; // aca ponemos el limite de descubierto maximo para la CC, permitira extraer hasta saldo + descubierto
		CuentaCorriente cc = new CuentaCorriente(cliente, cbu, limiteDescubierto);
		
		// probamos intentar depositar
		Double montoParaDepositar = 1000.0;
		cc.depositarEnCuenta(montoParaDepositar);
		
		// hasta este punto la cuenta tiene 1000 de saldo cargado
		
		// ahora pasamos a intentar extraer
		Double montoParaExtraer = 1400.0; // la cuenta corriente en total nos va a permitir sacar hasta 1500 porque suma el descubierto
		cc.extraerDeCuenta(montoParaExtraer);
		
		Double descubiertoEsperado = -400.0; // si mi total es 1000 de saldo + 500 de descubierto, si saco 1400 le debo 400 al banco
		Double descubiertoObtenido = cc.getSaldo(); // comparamos en cuanto quedo el valor del saldo, si refleja este cambio
		
		assertEquals(descubiertoEsperado, descubiertoObtenido);
	}
	
	// a partir de aca creamos una clase Cuenta que funcione como superclase y que luego CuentaCorriente y CajaDeAhorro hereden de ella
}
