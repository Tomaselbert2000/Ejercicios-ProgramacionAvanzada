package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ClaseTest {
	
	
	private Gestor gestorProductos;
	private Producto producto;
	private Producto productoElectronico;
	
	@Before
	public void inicializarObjetos() {
		gestorProductos = new Gestor();
		producto = new Producto("Producto A", 2000.0, "Producto de Test");
		productoElectronico = new ProductoElectronico("Producto Electronico 1", 10000.0, "Producto de Prueba");
	}
	
	@Test
	public void dadoQueExisteUnGestorDeProductosSiRegistroUnoObtengoTrue() {
		Boolean fueRegistrado = this.gestorProductos.registrarProducto(this.producto);
		assertTrue(fueRegistrado);
	}
	
	@Test
	public void dadoQueExisteProductoObtengoQueSuNombreEsProductoA() {
		String nombreEsperado = "Producto A";
		String nombreObtenido = this.producto.obtenerNombre();
		assertEquals(nombreEsperado, nombreObtenido);
	}
	
	@Test
	public void dadoQueExisteUnProductoObtengoQueSuPrecioEs2000() {
		Double precioEsperado = 2000.0;
		Double precioObtenido = this.producto.obtenerPrecio();
		assertEquals(precioEsperado, precioObtenido);
	}
	
	@Test
	public void dadoQueExisteUnProductoObtengoQueSuDescripcionEsProductoDeTest() {
		String descripcionEsperada = "Producto de Test";
		String descripcionObtenida = this.producto.obtenerDescripcion();
		assertEquals(descripcionEsperada, descripcionObtenida);
	}
	
	@Test
	public void dadoQueNoPuedoTenerProductosRepetidosAl2doIntentoNoLoRegistra() {
		Boolean seRegistro = this.gestorProductos.registrarProducto(this.producto);
		Boolean seRegistroDeNuevo = this.gestorProductos.registrarProducto(this.producto);
		assertTrue(seRegistro);
		assertFalse(seRegistroDeNuevo);
	}
	
	@Test
	public void dadoQueTengoDosProductosConIgualesDatosAl2doNoLoRegistra() {
		Producto producto1 = new Producto("Producto A", 1000.0, "Producto de Test");
		Producto producto2 = new Producto("Producto A", 1000.0, "Producto de Test");
		Boolean producto1Registrado = this.gestorProductos.registrarProducto(producto1);
		Boolean producto2Registrado = this.gestorProductos.registrarProducto(producto2);
		// cuando se registra un producto se valida el hashcode, si ya hay uno con ese hashcode, el repetido no se guarda
		assertTrue(producto1Registrado);
		assertFalse(producto2Registrado);
	}
	
	@Test
	public void dadoQueExisteUnaClaseProductoSiCreoUnSubProducto_ProductoElectronicoObtengoTrue() {
		Boolean productoElectronicoRegistrado = this.gestorProductos.registrarProducto(this.productoElectronico);
		assertTrue(productoElectronicoRegistrado);
	}
	
	@Test
	public void dadoQueExisteUnProductoElectronicoPorHerenciaObtengoQueSuNombreEsProductoElectronico1() {
		String nombreEsperado = "Producto Electronico 1";
		String nombreObtenido = this.productoElectronico.obtenerNombre();
		assertEquals(nombreEsperado, nombreObtenido);
	}
	
	@Test
	public void dadoQueExisteUnProductoElectronicoPorHerenciaObtengoQueSuPrecioEs10000() {
		Double precioEsperado = 10000.0;
		Double precioObtenido = this.productoElectronico.obtenerPrecio();
		assertEquals(precioEsperado, precioObtenido);
	}
	
	@Test
	public void dadoQueExisteUnProductoElectronicoPorHerenciaObtengoQueSuDescripcionEsProductoDePrueba() {
		String descripcionEsperada = "Producto de Prueba";
		String descripcionObtenida = this.productoElectronico.obtenerDescripcion();
		assertEquals(descripcionEsperada, descripcionObtenida);
	}
}
