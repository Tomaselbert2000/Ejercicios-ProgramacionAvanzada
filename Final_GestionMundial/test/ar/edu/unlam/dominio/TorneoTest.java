package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ar.edu.unlam.enums.LetraGrupo;
import ar.edu.unlam.enums.NombreSeleccion;
import ar.edu.unlam.enums.ResultadoPartidoEnum;
import ar.edu.unlam.exceptions.EquipoDuplicadoException;
import ar.edu.unlam.exceptions.PartidoJugadoException;

public class TorneoTest {

	private Torneo torneo;

	@Before
	public void init() {
		torneo = new Torneo();
	}

	@Test // test en la consigna
	public void queSePuedaCrearUnTorneoCon32Equipos() {
		Integer cantidadEquiposEsperada = 32;
		Integer cantidadEquiposObtenida = this.torneo.getCantidadEquiposActual();
		assertEquals(cantidadEquiposEsperada, cantidadEquiposObtenida);
	}

	@Test
	public void dadoQueExisteUnTorneoObtengoQueTiene8GruposDeLaAhastaLaH() {
		Integer cantidadGruposEsperada = 8;
		Integer cantidadGruposObtenida = this.torneo.getCantidadGruposActual();
		assertEquals(cantidadGruposEsperada, cantidadGruposObtenida);
	}

	@Test
	public void dadoQueExisteUnTorneoObtengoQueTiene4EquiposPorGrupo() {
		Integer cantidadEquiposPorGrupoEsperada = 4;
		for (LetraGrupo letra : LetraGrupo.values()) {
			Grupo grupoBuscadoPorLetra = torneo.getGrupoPorLetra(letra);
			assertEquals(cantidadEquiposPorGrupoEsperada, grupoBuscadoPorLetra.getEquipos().size(), 0);
		}
	}

	@Test // test pedido por la consigna
	public void dadoQueExisteUnTorneoSiRegistroUnPartidoObtengoTrue()
			throws EquipoDuplicadoException, PartidoJugadoException {
		Equipo local = new Equipo(NombreSeleccion.Arabia_Saudita);
		Equipo visitante = new Equipo(NombreSeleccion.Argentina);
		Partido nuevoPartido = new Partido(1, local, visitante);

		Boolean seRegistroElPartido = this.torneo.registrarPartido(nuevoPartido);
		assertTrue(seRegistroElPartido);
	}

	@Test(expected = EquipoDuplicadoException.class) // excepcion pedida por la consigna
	public void dadoQueExisteUnTorneoSiIntentoRegistrarUnPartidoConEquiposDuplicadosObtengoUnaEquipoDuplicadoException()
			throws EquipoDuplicadoException, PartidoJugadoException {
		Equipo local = new Equipo(NombreSeleccion.Alemania);
		Equipo visitante = new Equipo(NombreSeleccion.Alemania);
		Partido nuevoPartido = new Partido(1, local, visitante);
		this.torneo.registrarPartido(nuevoPartido);
	}

	@Test
	public void queSePuedaCrearUnPartidoEntreDosEquiposDelMismoGrupo()
			throws EquipoDuplicadoException, PartidoJugadoException {
		Equipo local = new Equipo(NombreSeleccion.Alemania);
		Equipo visitante = new Equipo(NombreSeleccion.Francia);
		this.torneo.getGrupoPorLetra(LetraGrupo.A).agregarEquipo(local);
		this.torneo.getGrupoPorLetra(LetraGrupo.A).agregarEquipo(visitante);
		Partido nuevoPartidoConEquiposDelMismoGrupo = new Partido(1, local, visitante);
		Boolean seRegistroElPartido = this.torneo.registrarPartido(nuevoPartidoConEquiposDelMismoGrupo);
		assertTrue(seRegistroElPartido);
	}

	@Test
	public void dadoQueExisteUnPartidoDeFaseDeGruposRegistradoPuedoRegistrarSuResultadoFinal()
			throws EquipoDuplicadoException, PartidoJugadoException {
		Equipo local = new Equipo(NombreSeleccion.Alemania);
		Equipo visitante = new Equipo(NombreSeleccion.Francia);
		this.torneo.getGrupoPorLetra(LetraGrupo.A).agregarEquipo(local);
		this.torneo.getGrupoPorLetra(LetraGrupo.A).agregarEquipo(visitante);
		Partido nuevoPartidoConEquiposDelMismoGrupo = new Partido(1, local, visitante);
		this.torneo.registrarPartido(nuevoPartidoConEquiposDelMismoGrupo);
		ResultadoPartido resultado = new ResultadoPartido(nuevoPartidoConEquiposDelMismoGrupo.getId(), 3, 0);

		Boolean seRegistroElResultado = this.torneo.registrarResultado(resultado);
		assertTrue(seRegistroElResultado);
	}

	@Test
	public void queAlObtenerElResultadoDeUnPartidoDeGruposSeaElElementoEmpateDelEnum() // test pedido en la consigna
			throws EquipoDuplicadoException, PartidoJugadoException {
		Equipo local = new Equipo(NombreSeleccion.Alemania);
		Equipo visitante = new Equipo(NombreSeleccion.Francia);
		this.torneo.getGrupoPorLetra(LetraGrupo.A).agregarEquipo(local);
		this.torneo.getGrupoPorLetra(LetraGrupo.A).agregarEquipo(visitante);
		Partido nuevoPartido = new Partido(1, local, visitante);
		this.torneo.registrarPartido(nuevoPartido);
		ResultadoPartido resultado = new ResultadoPartido(nuevoPartido.getId(), 4, 4);
		this.torneo.registrarResultado(resultado);

		ResultadoPartidoEnum enumEsperado = ResultadoPartidoEnum.EMPATE;
		ResultadoPartidoEnum enumObtenido = this.torneo.obtenerResultadoPartido(nuevoPartido.getId());

		assertEquals(enumEsperado, enumObtenido);
	}

	@Test(expected = PartidoJugadoException.class) // test pedido en la consigna
	public void queAlCrearUnPartidoDondeLosEquiposYaJugaronSeLanceUnaPartidoJugadoException()
			throws PartidoJugadoException, EquipoDuplicadoException {
		Equipo catar = new Equipo(NombreSeleccion.Catar);
		Equipo camerun = new Equipo(NombreSeleccion.Camerún);
		Partido partido = new Partido(1, catar, camerun);
		this.torneo.registrarPartido(partido);

		Partido partidoQueYaFueJugado = new Partido(2, catar, camerun);
		this.torneo.registrarPartido(partidoQueYaFueJugado);
	}

	@Test
	public void queAlRegistrarElResultadoDeUnPartidoDeGruposSeAcumulenLosPuntosCorrespondientesACadaEquipo() // test
																												// pedido
																												// en la
																												// consigna
			throws EquipoDuplicadoException, PartidoJugadoException {
		Equipo catar = new Equipo(NombreSeleccion.Catar);
		Equipo camerun = new Equipo(NombreSeleccion.Camerún);
		Partido partido = new Partido(1, catar, camerun);
		ResultadoPartido resultadoCatarCamerun = new ResultadoPartido(partido.getId(), 4, 1);
		this.torneo.registrarPartido(partido);
		this.torneo.registrarResultado(resultadoCatarCamerun);

		Integer cantidadLocalEsperada = 3;
		Integer cantidadLocalObtenida = catar.getPuntajeActual();

		Integer cantidadVisitanteEsperada = 0;
		Integer cantidadVisitanteObtenida = camerun.getPuntajeActual();

		assertEquals(cantidadLocalEsperada, cantidadLocalObtenida);
		assertEquals(cantidadVisitanteEsperada, cantidadVisitanteObtenida);
	}

	@Test
	public void dadoQueExisteUnTorneoConUnPartidoRegistradoObtengoLaCantidadDeGolesAFavorYenContra()
			throws EquipoDuplicadoException, PartidoJugadoException {
		Equipo catar = new Equipo(NombreSeleccion.Catar);
		Equipo camerun = new Equipo(NombreSeleccion.Camerún);
		Partido partido = new Partido(1, catar, camerun);
		ResultadoPartido resultadoCatarCamerun = new ResultadoPartido(partido.getId(), 4, 1);
		this.torneo.registrarPartido(partido);
		this.torneo.registrarResultado(resultadoCatarCamerun);

		Integer golesAFavorCatarEsperado = 4;
		Integer golesAFavorCatarObtenido = catar.getGolesAFavor();
		Integer golesEnContraCatarEsperado = 1;
		Integer golesEnContraCatarObtenido = catar.getGolesEnContra();

		Integer golesAFavorCamerunEsperado = 1;
		Integer golesAFavorCamerunObtenido = camerun.getGolesAFavor();
		Integer golesEnContraCamerunEsperado = 4;
		Integer golesEnContraCamerunObtenido = camerun.getGolesEnContra();

		assertEquals(golesAFavorCatarEsperado, golesAFavorCatarObtenido);
		assertEquals(golesEnContraCatarEsperado, golesEnContraCatarObtenido);
		assertEquals(golesAFavorCamerunEsperado, golesAFavorCamerunObtenido);
		assertEquals(golesEnContraCamerunEsperado, golesEnContraCamerunObtenido);
	}

	@Test // test pedido en la consigna
	public void queAlObtenerElResultadoDeUnPartidoDeEliminatoriasEnCasoDeEmpateSeObtengaElEnumDelGanadorPorPenales()
			throws EquipoDuplicadoException, PartidoJugadoException {
		Equipo arg = new Equipo(NombreSeleccion.Argentina);
		Equipo mex = new Equipo(NombreSeleccion.México);

		Partido partidoEliminatoria = new Partido(1, arg, mex);
		this.torneo.registrarPartido(partidoEliminatoria);
		ResultadoPartido resultadoPartidoEliminatoria = new ResultadoPartido(partidoEliminatoria.getId(), 2, 2, 5, 2);
		this.torneo.registrarResultado(resultadoPartidoEliminatoria);

		ResultadoPartidoEnum resultadoEsperado = ResultadoPartidoEnum.GANA_LOCAL;
		ResultadoPartidoEnum resultadoObtenido = this.torneo.obtenerResultadoPartido(partidoEliminatoria.getId());

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void queAlConsultarPuntajeDeEquiposDeLosGrupoSeObtenganLosEquiposOrdenadosPorGrupoAscendenteYPorPuntosDescendentemente() {
		
	}

	@Test
	public void queAlFinalizarLaFaseDeGruposSeAgreguenLosMejores2EquiposDeCadaGrupoALaColeccionDeEquiposEnEliminatorias() {
		
	}
}
