package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ar.edu.unlam.enums.TipoBicicletaEnum;

public class BicicletaTest {

	@Test
	public void dadoQueExisteUnaBicicletaPorHerenciaObtengoQuePuedoConsultarSusAtributos() {
		Integer idBici = 5;
		String nombreBici = "Bicicleta";
		Boolean estadoBici = true;
		TipoBicicletaEnum tipoBicicleta = TipoBicicletaEnum.MONTANIA;
		Boolean poseeFrenosADisco = true;
		Bicicleta bici = new Bicicleta(idBici, nombreBici, estadoBici, tipoBicicleta, poseeFrenosADisco);
		assertEquals(idBici, bici.getId());
		assertEquals(nombreBici, bici.getNombreVehiculo());
		assertEquals(estadoBici, bici.getEstadoDisponibilidad());
		assertEquals(tipoBicicleta, bici.getTipoBicicleta());
		assertEquals(poseeFrenosADisco, bici.getSiTieneFrenosADisco());
	}
}
