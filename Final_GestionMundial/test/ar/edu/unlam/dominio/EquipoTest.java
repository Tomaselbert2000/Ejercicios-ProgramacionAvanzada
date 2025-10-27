package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ar.edu.unlam.enums.NombreSeleccion;

public class EquipoTest {

	@Test
	public void dadoQueExisteUnEquipoObtengoQuePuedoConsultarSusAtributos() {
		NombreSeleccion nombreSeleccion = NombreSeleccion.Argentina;
		Equipo nuevoEquipo = new Equipo(nombreSeleccion);
		Integer golesAFavorEsperado = 0;
		Integer golesAFavorObtenido = nuevoEquipo.getGolesAFavor();
		Integer golesEnContraEsperado = 0;
		Integer golesEnContraObtenido = nuevoEquipo.getGolesEnContra();

		assertEquals(nombreSeleccion, nuevoEquipo.getNombreSeleccion());
		assertEquals(golesAFavorEsperado, golesAFavorObtenido);
		assertEquals(golesEnContraEsperado, golesEnContraObtenido);
	}

	@Test
	public void dadoQueNoExisteUnEquipoAlCrearloObtengoQueSuPuntajeActualEsCero() {
		Equipo nuevoEquipo = new Equipo(NombreSeleccion.Argentina);
		Integer cantidadPuntosActualEsperada = 0;
		Integer cantidadPuntosActualObtenida = nuevoEquipo.getPuntajeActual();

		assertEquals(cantidadPuntosActualEsperada, cantidadPuntosActualObtenida);
	}
}
