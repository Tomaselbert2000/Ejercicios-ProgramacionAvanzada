package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ar.edu.unlam.enums.ColorAtrilEnum;
import ar.edu.unlam.enums.MaterialEnum;

public class CopaDelMundoTest {
	
	@Test
	public void dadoQueExisteUnaClaseCopaDelMundoObtengoQuePuedoConsultarSusAtributos() {
		Integer idCopa = 1;
		MaterialEnum materialFabricacion = MaterialEnum.PLASTICO;
		CopaDelMundo copa = new CopaDelMundo(idCopa, materialFabricacion);
		assertEquals(idCopa, copa.getId());
		assertEquals(materialFabricacion, copa.getMaterialFabricacion());
	}
	
	@Test
	public void dadoQueExisteUnaCopaDelMundoEstandarPorHerenciaObtengoQuePuedoConsultarSusAtributos() {
		Integer idCopa = 1;
		Double costoFabricacion = 5500.0;
		MaterialEnum materialFabricacion = MaterialEnum.PLASTICO;
		CopaDelMundoEstandar copa = new CopaDelMundoEstandar(idCopa, costoFabricacion, materialFabricacion);
		assertEquals(idCopa, copa.getId());
		assertEquals(costoFabricacion, copa.getCostoFabricacion());
		assertEquals(materialFabricacion, copa.getMaterialFabricacion());
	}
	
	@Test
	public void dadoQueExisteUnaCopaDelMundoPersonalizadaPorHerenciaObtengoQuePuedoConsultarSusAtributos() {
		Integer idCopa = 1;
		Double costoFabricacion = 5500.0;
		MaterialEnum materialFabricacion = MaterialEnum.PLASTICO;
		ColorAtrilEnum colorAtrilElegido = ColorAtrilEnum.CEDRO;
		CopaDelMundoPersonalizada copaPersonalizada = new CopaDelMundoPersonalizada(idCopa, costoFabricacion, materialFabricacion, colorAtrilElegido);
		assertEquals(idCopa, copaPersonalizada.getId());
		assertEquals(costoFabricacion, copaPersonalizada.getCostoFabricacion());
		assertEquals(materialFabricacion, copaPersonalizada.getMaterialFabricacion());
		assertEquals(colorAtrilElegido, copaPersonalizada.getColorAtrilElegido());
	}
	
	@Test
	public void dadoQueExisteUnaCopaDelMundoEstandarCuyoPrecioEs5000ObtengoQueSuCostoTotalEs6000() {
		CopaDelMundoEstandar copaEstandar = new CopaDelMundoEstandar(1, 5000.0, MaterialEnum.YESO);
		Double precioTotalEsperado = 6000.0;
		Double precioTotalObtenido = copaEstandar.obtenerPrecioTotal();
		assertEquals(precioTotalEsperado, precioTotalObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaCopaDelMundoPersonalizdaCuyoPrecioEs5000YcolorDeAtrilCaobaObtengoQuesSuCostoTotalEs6000() {
		CopaDelMundoPersonalizada copaPersonalizada = new CopaDelMundoPersonalizada(1, 5000.0, MaterialEnum.PLASTICO, ColorAtrilEnum.CAOBA);
		Double precioTotalCaobaEsperado = 6000.0;
		Double precioTotalCaobaObtenido = copaPersonalizada.obtenerPrecioTotal();
		assertEquals(precioTotalCaobaEsperado, precioTotalCaobaObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaCopaDelMundoPersonalizdaCuyoPrecioEs5000YcolorDeAtrilCedroObtengoQuesSuCostoTotalEs6250() {
		CopaDelMundoPersonalizada copaPersonalizada = new CopaDelMundoPersonalizada(1, 5000.0, MaterialEnum.PLASTICO, ColorAtrilEnum.CEDRO);
		Double precioTotalCaobaEsperado = 6250.0;
		Double precioTotalCaobaObtenido = copaPersonalizada.obtenerPrecioTotal();
		assertEquals(precioTotalCaobaEsperado, precioTotalCaobaObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaCopaDelMundoPersonalizdaCuyoPrecioEs5000YcolorDeAtrilRobleOscuroObtengoQuesSuCostoTotalEs6500() {
		CopaDelMundoPersonalizada copaPersonalizada = new CopaDelMundoPersonalizada(1, 5000.0, MaterialEnum.PLASTICO, ColorAtrilEnum.ROBLE_OSCURO);
		Double precioTotalCaobaEsperado = 6500.0;
		Double precioTotalCaobaObtenido = copaPersonalizada.obtenerPrecioTotal();
		assertEquals(precioTotalCaobaEsperado, precioTotalCaobaObtenido);
	}
}
