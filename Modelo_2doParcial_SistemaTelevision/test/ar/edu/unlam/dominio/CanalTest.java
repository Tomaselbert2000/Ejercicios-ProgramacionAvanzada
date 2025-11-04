package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ar.edu.unlam.enums.CategoriaCanalEnums;
import ar.edu.unlam.enums.ClasificacionCanalEnums;

public class CanalTest {

	@Test
	public void dadoQueExisteUnCanalObtengoQuePuedoConsultarSusAtributos() {
		Short numeroCanal = 1;
		String nombre = "MTv";
		CategoriaCanalEnums categoria = CategoriaCanalEnums.Varios;
		ClasificacionCanalEnums clasificacion = ClasificacionCanalEnums.Basico;
		Canal canal = new Canal(numeroCanal, nombre, categoria, clasificacion);
		assertEquals(numeroCanal, canal.getNumero());
		assertEquals(nombre, canal.getNombre());
		assertEquals(categoria, canal.getCategoria());
		assertEquals(clasificacion, canal.getClasificacion());
	}
}
