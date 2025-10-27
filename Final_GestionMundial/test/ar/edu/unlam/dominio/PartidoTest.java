package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ar.edu.unlam.enums.NombreSeleccion;

public class PartidoTest {
	
	@Test
	public void dadoQueExisteUnPartidoObtengoQuePuedoConsultarSusAtributos() {
		Integer idPartido = 1;
		Equipo equipoLocal = new Equipo(NombreSeleccion.Alemania);
		Equipo equipoVisitante = new Equipo(NombreSeleccion.Canada);
		
		Partido nuevoPartido = new Partido(idPartido, equipoLocal, equipoVisitante);
		assertEquals(idPartido, nuevoPartido.getId());
		assertEquals(equipoLocal, nuevoPartido.getEquipoLocal());
		assertEquals(equipoVisitante, nuevoPartido.getEquipoVisitante());
	}
}
