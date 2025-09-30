package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	
	// implementamos poder crear cuentas, crear clientes, los clientes
	
	// no podemos tener 2 clientes con el mismo DNI, vamos a usar un hashset para evitar duplicados
	
	// no se puede crear una cuenta si el cliente no fue dado de alta en el sistema
	// para crear una cuenta se debe pasar por parametro el dni del cliente que fue dado de alta
	
	// poder hacer transferencias entre cuentas (id de origen --> cbu de destino)
	
	// realizar una transferencia si de la cuenta origen no hay suficiente dinero
	
	@Test
	public void dadoQueExisteUnBancoSiRegistroUnClienteObtengoTrue() {
		GestionBanco gestion = new GestionBanco();
		
		Cliente cliente = new Cliente("Tomas", "Elbert", 1234567);
		
		Boolean seRegistro = gestion.registrarCliente(cliente);
		
		assertTrue(seRegistro);
	}
	
	@Test
	public void dadoQueExisteUnBancoConUnaColeccionDeClientesSiIntentoRegistrarUnConDniRepetidoObtengoFalse() {
		GestionBanco gestion = new GestionBanco();
		
		Cliente cliente1 = new Cliente("Tomas", "Elbert", 1234567);
		Cliente cliente2 = new Cliente("Juan", "Perez", 1234567);
		
		Boolean seRegistroElPrimero = gestion.registrarCliente(cliente1);
		Boolean seRegistroElSegundo = gestion.registrarCliente(cliente2);
		
		// para hacer que este test pase sobreescribimos el metodo hashCode para que tome en cuenta tambien el dni del cliente
		// entonces al tener dos objetos en memoria con el mismo valor de dni al 2do no lo va a dejar pasar
		assertTrue(seRegistroElPrimero);
		assertFalse(seRegistroElSegundo);
	}
	
	@Test
	public void dadoQueExisteUnBancoSiIntentoRegistrarUnaCuentaConUnClienteNoRegistradoObtengoFalse() {
		GestionBanco gestion = new GestionBanco();
		
		Cliente clienteSinRegistrar = new Cliente("Tomas", "Elbert", 1234567); // aca creamos un cliente pero no lo registramos en gestion
		
		CuentaCorriente nuevaCuenta = new CuentaCorriente(clienteSinRegistrar, 112233, 1000.0); // creamos la cuenta y asignamos el cliente
		
		// cuando registramos la cuenta vamos a validar el ID del cliente que se manda como parametro en el constructor de cuenta
		Boolean seRegistroLaCuenta = gestion.registrarCuenta(nuevaCuenta);
		assertFalse(seRegistroLaCuenta); // vemos que efectivamente da false y el test pasa
	}
	
	@Test
	public void dadoQueExisteUnBancoConUnClienteRegistradoSiInstancioUnaCuentaConSuDniYlaRegistroObtengoTrue() {
		GestionBanco gestion = new GestionBanco();
		
		Cliente cliente = new Cliente("Tomas", "Elbert", 1234567); // creamos el cliente y lo registramos primero en el sistema
		gestion.registrarCliente(cliente);
		
		CuentaCorriente nuevaCuenta = new CuentaCorriente(cliente, 11223344, 1000.0);
		Boolean seRegistroLaCuenta = gestion.registrarCuenta(nuevaCuenta); // una vez registramos el cliente podemos probar registrar la cuenta
		
		assertTrue(seRegistroLaCuenta);
	}
	
	@Test
	public void dadoQueTengoUnBancoConDosClientesYCadaUnoTieneUnaCuentaObtengoQuePuedenTransferirSaldoEntreSi() {
		GestionBanco gestion = new GestionBanco();
		
		// creamos los clientes y los registramos en el sistema
		Cliente cliente1 = new Cliente("Tomas", "Elbert", 12345678);
		Cliente cliente2 = new Cliente("Juan", "Perez", 987654321);
		
		gestion.registrarCliente(cliente1);
		gestion.registrarCliente(cliente2);
		
		// creamos las cuentas y las asociamos a los clientes
		CuentaCorriente cuentaCliente1 = new CuentaCorriente(cliente1, 112233, 1000.0);
		CuentaCorriente cuentaCliente2 = new CuentaCorriente(cliente2, 445566, 500.0);
		
		gestion.registrarCuenta(cuentaCliente1);
		gestion.registrarCuenta(cuentaCliente2);
		
		// el cliente 1 ingresa dinero en su cuenta para poder realizar transferencias
		Double valorQueDepositaElCliente1 = 1000.0;
		cuentaCliente1.depositarEnCuenta(valorQueDepositaElCliente1);
		
		assertEquals(valorQueDepositaElCliente1, cuentaCliente1.getSaldo()); // verificamos que se haya cargado el saldo en la cuenta
		
		Integer dniDelClienteQueEnviaDinero = cliente1.getDni();
		Integer cbuDestino = 445566;
		Double dineroATransferir = 600.0;
		
		// realizamos la transferencia usando como parametros el dni del cliente que debe recibir dinero
		gestion.procesarTransferencia(dniDelClienteQueEnviaDinero,cbuDestino, dineroATransferir);
		
		// Validamos que se hayan reflejado los cambios en las distintas cuentas
		
		Double saldoEsperadoCliente1 = 400.0; // luego de transferir 600, a la cuena del cliente 1 le tienen que quedar 400
		Double saldoObtenidoCliente1 = cuentaCliente1.getSaldo();
		
		Double saldoEsperadoCliente2 = 600.0; // los 600 transferidos por el cliente 1 se suman al saldo del cliente 2, que como estaba en 0, es igual a 600
		Double saldoObtenidoCliente2 = cuentaCliente2.getSaldo();
		
		assertEquals(saldoEsperadoCliente1, saldoObtenidoCliente1);
		assertEquals(saldoEsperadoCliente2, saldoObtenidoCliente2);
	}
	
	@Test
	public void dadoQueExisteUnBancoConDosClientesConCuentasSiElPrimerClienteTieneSaldoInsuficienteParaTransferirAlCliente2ObtengoFalse() {
		GestionBanco gestion = new GestionBanco();
		
		// creamos los clientes y los registramos en el sistema
		Cliente cliente1 = new Cliente("Tomas", "Elbert", 12345678);
		Cliente cliente2 = new Cliente("Juan", "Perez", 987654321);
		
		gestion.registrarCliente(cliente1);
		gestion.registrarCliente(cliente2);
		
		// creamos las cuentas y las asociamos a los clientes
		CuentaCorriente cuentaCliente1 = new CuentaCorriente(cliente1, 112233, 1000.0);
		CuentaCorriente cuentaCliente2 = new CuentaCorriente(cliente2, 445566, 500.0);
		
		gestion.registrarCuenta(cuentaCliente1);
		gestion.registrarCuenta(cuentaCliente2);
		
		// dado que ninguno de los clientes registra depositos, entonces sabemos que el saldo de ambos es $0
		
		Integer dniDelClienteQueEnviaDinero = cliente1.getDni();
		Integer cbuDestino = 445566;
		Double dineroATransferir = 600.0;
		
		Boolean seRealizoLaTransferencia = gestion.procesarTransferencia(dniDelClienteQueEnviaDinero, cbuDestino, dineroATransferir);
		
		assertFalse(seRealizoLaTransferencia);
	}
}
