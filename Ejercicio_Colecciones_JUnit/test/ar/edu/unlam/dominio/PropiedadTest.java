package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PropiedadTest {

	private Propiedad prop;

	@Before
	public void inicializarPropiedad() {
		prop = new Propiedad(1, 20500.0, "Campo", "Buenos Aires");
	}

	@Test
	public void dadoQueExisteUnaPropiedadSiLlamoSuTipoObtengoDepartamento() {
		this.prop = new Propiedad(0, 0, null, null);
		String tipoEsperado = "Departamento";
		this.prop.setTipo("Departamento");
		String tipoObtenido = prop.getTipo();
		assertEquals(tipoEsperado, tipoObtenido);
	}

	@Test
	public void dadoQueExisteUnaPropiedadSiLlamoASuCodigoObtengo5() {
		this.prop = new Propiedad(5, 0, null, null);
		Integer codigoEsperado = 5;
		Integer codigoObtenido = this.prop.getCodigo();
		assertEquals(codigoEsperado, codigoObtenido);
	}

	@Test
	public void dadoQueExisteUnaPropiedadSiLlamoASuPrecioObtengo200000() {
		this.prop = new Propiedad(0, 200000.0, null, null);
		Double precioEsperado = 200000.0;
		Double precioObtenido = this.prop.getPrecio();
		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void dadoQueExisteUnaPropiedadSeTienenQuePoderModificarTodosSusDatos() {
		this.prop = new Propiedad(1, 0.0, null, null);
		this.prop.setCodigo(10);
		this.prop.setPrecio(20000.0);
		this.prop.setTipo("Departamento");
		this.prop.setUbicacion("Buenos Aires");

		Integer codigoEsperado = 10;
		Integer codigoObtenido = this.prop.getCodigo();

		Double precioEsperado = 20000.0;
		Double precioObtenido = this.prop.getPrecio();

		String tipoEsperado = "Departamento";
		String tipoObtenido = this.prop.getTipo();

		assertEquals(codigoEsperado, codigoObtenido);
		assertEquals(precioEsperado, precioObtenido);
		assertEquals(tipoEsperado, tipoObtenido);
	}

	@Test
	public void dadoQueExisteUnaPropiedadSiConsultoSuUbicacionObtengoCABA() {
		this.prop = new Propiedad(1, 1000.0, "Casa", "CABA");
		String ubicacionEsperada = "CABA";
		String ubicacionObtenida = this.prop.getUbicacion();
		assertEquals(ubicacionEsperada, ubicacionObtenida);
	}

	@Test
	public void dadoQueExisteUnaPropiedadSiPreguntoSuDueñoObtengoTomasElbert() {
		this.prop = new Propiedad(1, 100000.0, "Casa", null);
		Cliente cliente = new Cliente("Tomas", "Elbert");
		cliente.comprarPropiedad(this.prop);
		String nombreDueñoEsperado = "Tomas" + "Elbert";
		String nombreDueñoObtenido = this.prop.getNombreDueño();
		assertEquals(nombreDueñoEsperado, nombreDueñoObtenido);
	}
}
