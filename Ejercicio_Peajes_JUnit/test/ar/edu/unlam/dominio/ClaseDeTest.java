package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.Test;

public class ClaseDeTest {

	@Test
	public void dadoQueExisteUnGestorDePeajeAlRegistrarUnPaseObtengoTrue() {
		// requiero de un telepase, un pase y un vehiculo para registrar
		GestorPeaje telepase = new GestorPeaje();
		
		// inicializamos los valores en null para que compile
		String patente = "ABC123";
		String marca = "Fiat";
		String modelo = "Cronos";
		
		Vehiculo vehiculo = new Vehiculo(patente, marca, modelo);
		LocalDateTime fechaYhora = LocalDateTime.of(2025,9,10,12,5);
		Pase pase = new Pase(vehiculo , fechaYhora);
		Boolean paseAgregado = telepase.registrarPase(pase); // si el metodo registra el pase deberia retornar true
		assertTrue(paseAgregado); // aca vemos si realmente es True
	}
	
	@Test
	public void dadoQueNoPuedoTenerDosPasesRepetidosAl2doNoLoRegistra() {
		GestorPeaje telepase = new GestorPeaje();
		String patente = "DEF456";
		String marca = "Volkswagen";
		String modelo = "Gol Trend";
		Vehiculo vehiculo = new Vehiculo(patente, marca, modelo);
		LocalDateTime fechaYhora = LocalDateTime.of(2025,9,10,12,5);
		Pase pase = new Pase(vehiculo, fechaYhora);
		// vemos que pasa si intentamos guardar el mismo pase dos veces
		Boolean fueAgregado = telepase.registrarPase(pase); // si lo agrego la 1era vez, esto tiene que retornar true
		Boolean fueAgregadoDeNuevo = telepase.registrarPase(pase); // y aca si lo vuelvo a hacer tiene que devolver false
		assertTrue(fueAgregado); // verificamos que el 1ero si da true
		assertFalse(fueAgregadoDeNuevo); // y el 2do si o si tiene que dar false
		
		// ¿Y que pasa al crear dos pases con los mismos datos?
		Pase pase2 = new Pase(vehiculo, fechaYhora);
		Boolean pase2FueAgregadoObtenido = telepase.registrarPase(pase2);
		assertFalse(pase2FueAgregadoObtenido);
		
		/*
		 * En la linea anterior el test falla porque tengo dos instancias
		 * de pase pero con los mismos datos, por lo tanto son dos direcciones
		 * en memoria diferentes.
		 * Como al momento de registrar el pase se revisa la direccion en memoria
		 * hay que revisar como se validan que sean iguales, para lo cual
		 * vamos a usar hashCode y Equals()
		 * 
		 * Una vez implementados ambos metodos tanto en la clase Vehiculo
		 * como en la clase Pase, efectivamente este test pasa sin problemas
		 */
	}
	
	@Test
	public void dadoQueExisteUnTelepaseYunVehiculoSiPasaDosVecesEnDosHorariosDiferentesObtengoTrue() {
		GestorPeaje telepase = new GestorPeaje();
		
		Vehiculo vehiculo = new Vehiculo("ABC123", "Fiat", "Cronos");
		
		Pase pase1 = new Pase(vehiculo, LocalDateTime.of(2025, 9, 10, 14, 30));
		Pase pase2 = new Pase(vehiculo, LocalDateTime.of(2025, 9,10, 19, 20));
		
		Boolean pasada1registrada = telepase.registrarPase(pase1);
		Boolean pasada2registrada = telepase.registrarPase(pase2);
		
		// pese a que los pases tienen el mismo vehiculo, tienen diferentes fechas
		// por lo tanto apuntan a diferentes posiciones de memoria
		assertTrue(pasada1registrada); // esto tiene que dar true
		assertTrue(pasada2registrada); // y esto tambien debe dar true
	}
	
	@Test
	public void dadoQueExisteUnPeajeObtengoUnaColeccionDeVehiculos() {
		GestorPeaje telepase = new GestorPeaje();
		
		Vehiculo vehiculo = new Vehiculo("ABC123", "Fiat", "Cronos");
		
		// hacemos que el vehiculo pase en 3 ocasiones
		Pase pase1 = new Pase(vehiculo, LocalDateTime.of(2025, 8, 6, 15, 30));
		Pase pase2 = new Pase(vehiculo, LocalDateTime.of(2025, 8, 16, 18, 32));
		Pase pase3 = new Pase(vehiculo, LocalDateTime.of(2025, 9, 17, 12, 41));
		
		// las registramos
		telepase.registrarPase(pase1);
		telepase.registrarPase(pase2);
		telepase.registrarPase(pase3);
		
		// aca creamos un objeto que tenga como valor lo que retorne el metodo
		ArrayList<Vehiculo> listadoVehiculos = telepase.obtenerListadoDeVehiculos();
		
		Integer cantidadVehiculosEsperada = 3;
		Integer cantidadVehiculosObtenida = listadoVehiculos.size(); // si todo sale bien, el tamaño del array debe ser 3
		
		// y finalmente comparamos
		assertEquals(cantidadVehiculosEsperada, cantidadVehiculosObtenida);
	}
	
	@Test
	public void dadoQueExisteUnPeajeYUnaColeccionDePasadasSiBuscoPorPatenteObtengoTrue() {
		
		GestorPeaje telepase = new GestorPeaje();
		
		// creamos dos vehiculos con diferentes patentes
		Vehiculo vehiculo1 = new Vehiculo("ABC123", "Fiat", "Cronos");
		Vehiculo vehiculo2 = new Vehiculo("DEF456", "Volkswagen", "Gol Trend");
		
		// creamos dos pasadas para el primer vehiculo
		Pase pase1 = new Pase(vehiculo1, LocalDateTime.of(2025, 9, 10, 16, 52));
		Pase pase2 = new Pase(vehiculo1, LocalDateTime.of(2025, 9, 10, 19, 40));
		
		// registramos las pasadas
		telepase.registrarPase(pase1);
		telepase.registrarPase(pase2);
		
		// si el vehiculo pasó va a devolver true, si no, devuelve false
		// buscamos por los dos vehiculos usando su patente
		Boolean vehiculo1PasoPorElPeaje = telepase.buscarPorPatente(vehiculo1.getPatente());
		Boolean vehiculo2PasoPorElPeaje = telepase.buscarPorPatente(vehiculo2.getPatente());
		
		assertTrue(vehiculo1PasoPorElPeaje); // esto tiene que devolver true porque el auto 1 si pasó
		assertFalse(vehiculo2PasoPorElPeaje); // como el auto 2 no pasó, acá tiene que cumplir que es false
	}
	
	@Test
	public void dadoQueExisteUnPeajeYUnaColeccionDePasesObtengoTodosLosQueTenganLaMismaFecha() {
		GestorPeaje  telepase = new GestorPeaje();
		
		// instanciamos vehiculos
		Vehiculo vehiculo1 = new Vehiculo("ABC123", "Fiat", "Cronos");
		Vehiculo vehiculo2 = new Vehiculo("DEF456", "Volkswagen", "Gol Trend");
		Vehiculo vehiculo3 = new Vehiculo("GHI789", "Peugeout", "208");
		
		// creamos una fecha en comun
		LocalDateTime fechaYhora = LocalDateTime.of(2025, 9, 10, 12, 30);
		
		// instanciamos los pases
		Pase pase1 = new Pase(vehiculo1, fechaYhora);
		Pase pase2 = new Pase(vehiculo2, fechaYhora);
		Pase pase3 = new Pase(vehiculo3, fechaYhora);
		
		telepase.registrarPase(pase1);
		telepase.registrarPase(pase2);
		telepase.registrarPase(pase3);
		
		ArrayList<Pase> listaDePasesPorFechaYhora = telepase.obtenerPasesPorFecha(fechaYhora);
		
		Integer cantidadPasesEsperada = 3;
		Integer cantidadPasesObtenida = listaDePasesPorFechaYhora.size();
		
		assertNotNull(listaDePasesPorFechaYhora); // verificamos que no sea null el objeto
		assertEquals(cantidadPasesEsperada, cantidadPasesObtenida); // y ademas verificamos si el size del array corresponde
	}
	
	@Test
	public void dadoQueExisteUnTelepaseSinTarifasSiCreoUnaTarifaObtengoTrue(){
		GestorPeaje telepase = new GestorPeaje();
		Tarifa tarifa = new Tarifa(1, null, null);
		Boolean tarifaAgregadaEsperada = telepase.registrarTarifa(tarifa);
		assertTrue(tarifaAgregadaEsperada);
	}
	
	@Test
	public void dadoQueExisteLaTarifaDeJulioTodosLosPasesDeEseMesValen1000() {
		Tarifa julio = new Tarifa(1, LocalDateTime.of(2025,  7, 1, 0, 0), LocalDateTime.of(2025, 7, 30, 0, 0));
		
		Vehiculo vehiculo = new Vehiculo("ABC123", "Fiat", "Cronos");
		Pase paseJulio = new Pase(null, null)
	}
}
