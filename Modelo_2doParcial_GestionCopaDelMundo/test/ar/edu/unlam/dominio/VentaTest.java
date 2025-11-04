package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import java.util.HashSet;
import org.junit.Test;
import ar.edu.unlam.enums.ColorAtrilEnum;
import ar.edu.unlam.enums.MaterialEnum;

public class VentaTest {

	@Test
	public void dadoQueExisteUnaVentaObtengoQuePuedoConsultarSusAtributos() {
		Cliente clienteQueRealizaLaCompra = new Cliente(203040, "Tomas", "Elbert");
		CopaDelMundoEstandar copaEstandarComprada = new CopaDelMundoEstandar(100, 200.0, MaterialEnum.PLASTICO);
		CopaDelMundoPersonalizada copaPersonalizadaComprada = new CopaDelMundoPersonalizada(200, 4500.0,
				MaterialEnum.RESINA, ColorAtrilEnum.CAOBA);
		HashSet<CopaDelMundo> copasDelMundoCompradas = new HashSet<>();
		copasDelMundoCompradas.add(copaEstandarComprada);
		copasDelMundoCompradas.add(copaPersonalizadaComprada);
		Venta venta = new Venta(clienteQueRealizaLaCompra, copasDelMundoCompradas);
		assertEquals(clienteQueRealizaLaCompra, venta.getClienteQueRealizoLaCompra());
		assertEquals(copasDelMundoCompradas, venta.getCopasCompradas());
	}
}
