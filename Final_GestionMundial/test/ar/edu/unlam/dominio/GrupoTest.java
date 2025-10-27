package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ar.edu.unlam.enums.LetraGrupo;
import ar.edu.unlam.enums.NombreSeleccion;

public class GrupoTest {
	
	@Test
	public void dadoQueExisteUnGrupoDeMundialObtengoQuePuedoConsultarSusAtributos() {
		LetraGrupo letraDelGrupo = LetraGrupo.F;
		Equipo arg = new Equipo(NombreSeleccion.Argentina);
		Equipo cat = new Equipo(NombreSeleccion.Catar);
		Equipo ale = new Equipo(NombreSeleccion.Alemania);
		Equipo fra = new Equipo(NombreSeleccion.Francia);

		Grupo grupoF = new Grupo(letraDelGrupo);
		grupoF.agregarEquipo(fra);
		grupoF.agregarEquipo(ale);
		grupoF.agregarEquipo(cat);
		grupoF.agregarEquipo(arg);
		
		Integer cantidadDeEquiposDelGrupoEsperada = 4;
		
		assertEquals(letraDelGrupo, grupoF.getLetra());
		assertEquals(cantidadDeEquiposDelGrupoEsperada, grupoF.getEquipos().size(), 0);
	}
}
