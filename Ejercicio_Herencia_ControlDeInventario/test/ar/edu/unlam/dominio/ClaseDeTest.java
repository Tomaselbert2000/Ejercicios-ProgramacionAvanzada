package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class ClaseDeTest {
	
	private Gestion gestorStock;
	
	@Before
	public void init() {
		gestorStock = new Gestion();
	}

	@Test
	public void dadoQueExisteUnProductoObtengoQuePuedoConsultarSusAtributos() {
		Producto producto = new Producto("Nombre del producto", 150, 100.0);
		assertEquals("Nombre del producto", producto.getNombre());
		assertEquals(150, producto.getCantidad(), 0);
		assertEquals(100.0, producto.getPrecioUnitario(), 0.0);
	}
	
	@Test
	public void dadoQueExisteUnGestorDeStockSiRegistroUnProductoObtengoTrue() {
		Producto producto = new Producto("Nombre del producto", 150, 100.0);
		Boolean seAgrego = this.gestorStock.registrarNuevoProducto(producto);
		assertTrue(seAgrego);
	}
	
	@Test
	public void dadoQueExisteUnProductoPerecederoPorHerenciaObtengoQuePuedoConsultarSusAtributos() {
		ProductoPerecedero productoPerecedero = new ProductoPerecedero("Producto perecedero", 100, 55.0, LocalDate.of(2025, 12, 31));
		assertEquals("Producto perecedero", productoPerecedero.getNombre());
		assertEquals(100, productoPerecedero.getCantidad(), 0);
		assertEquals(55.0, productoPerecedero.getPrecioUnitario(), 0.0);
		assertEquals(LocalDate.of(2025, 12, 31), productoPerecedero.getFechaVencimiento());
	}
	
	@Test
	public void dadoQueExisteUnProductoPerecederoPorHerenciaSiLoRegistroObtengoTrue() {
		ProductoPerecedero productoPerecedero = new ProductoPerecedero("Producto perecedero", 100, 55.0, LocalDate.of(2025, 12, 31));
		Boolean seAgrego = this.gestorStock.registrarNuevoProducto(productoPerecedero);
		assertTrue(seAgrego);
	}
	
	@Test
	public void dadoQueExisteUnProductoNoPerecederoPorHerenciaObtengoQuePuedoConsultarSusAtributos() {
		ProductoNoPerecedero productoNoPerecedero = new ProductoNoPerecedero("Producto no perecedero", 100, 55.0, "Azul");
		assertEquals("Producto no perecedero", productoNoPerecedero.getNombre());
		assertEquals(100, productoNoPerecedero.getCantidad(), 0);
		assertEquals(55.0, productoNoPerecedero.getPrecioUnitario(), 0.0);
		assertEquals("Azul", productoNoPerecedero.getColor());
	}
	
	@Test
	public void dadoQueExisteUnGestorPorHerenciaSiRegistroUnProductoNoPerecederoObtengoTrue() {
		ProductoNoPerecedero productoNoPerecedero = new ProductoNoPerecedero("Producto no perecedero", 100, 55.0, "Azul");
		Boolean seAgrego = this.gestorStock.registrarNuevoProducto(productoNoPerecedero);
		assertTrue(seAgrego);
	}
	
	@Test
	public void dadoQueExisteUnProductoNoPerecederoCuyoPrecioUnitarioEs150obtengoQueSuPrecioTotalEs160con50() {
		ProductoNoPerecedero productoNoPerecedero = new ProductoNoPerecedero("Producto no perecedero", 100, 150.0, "Azul");
		Double precioEsperado = 160.50; // este es el precio unitario con el 7% de recargo por el tipo de producto
		Double precioObtenido = productoNoPerecedero.obtenerPrecio();
		assertEquals(precioEsperado, precioObtenido);
	}
	
	@Test
	public void dadoQueExisteUnProductoNoPerecederoCuyoPrecioUnitarioEs250ObtengoQueSuPrecioTotalEs262con50() {
		ProductoPerecedero productoPerecedero = new ProductoPerecedero("Producto perecedero", 50, 250.0, LocalDate.of(2025, 12, 31));
		Double precioEsperado = 262.50;
		Double precioObtenido = productoPerecedero.obtenerPrecio();
		assertEquals(precioEsperado, precioObtenido);
	}
	
	@Test
	public void dadoQueExisteUnGestorConUnProductoRegistradoObtengoElTotalQueSumaEs5000() {
		Producto producto = new Producto("Producto", 100, 50.0);
		// ProductoPerecedero productoPerecedero = new ProductoPerecedero("Producto que si es perecedero", 200, 120.0, LocalDate.of(2025, 12, 31));
		//ProductoNoPerecedero productoNoPerecedero = new ProductoNoPerecedero("Producto que no es perecedero", 200, 185.0, "Rojo");
		
		this.gestorStock.registrarNuevoProducto(producto);
		//this.gestorStock.registrarNuevoProducto(productoPerecedero);
		//this.gestorStock.registrarNuevoProducto(productoNoPerecedero);
		
		Double totalEsperado = 5000.0;
		Double totalObtenido = producto.obtenerSumaTotal();
		
		assertEquals(totalEsperado, totalObtenido);
	}
	
	@Test
	public void dadoQueExisteUnGestorConUnProductoPerecederoRegistradoObtengoQueLaSumaTotalDeSuStockEs26250() {
		ProductoPerecedero productoPerecedero = new ProductoPerecedero("Producto perecedero", 100, 250.0, LocalDate.of(2025, 12, 31));
		this.gestorStock.registrarNuevoProducto(productoPerecedero);
		
		Double sumaTotalEsperado = 26250.0;
		Double sumaTotalObtenido = productoPerecedero.obtenerSumaTotal();
		
		assertEquals(sumaTotalEsperado, sumaTotalObtenido);
	}
	
	@Test
	public void dadoQueExisteUnGestorConUnProductoNoPerecederoRegistradoObtengoQueLaSumaTotalDeSuStockEs26750() {
		ProductoNoPerecedero productoNoPerecedero = new ProductoNoPerecedero("Producto no perecedero", 100, 250.0, "Verde");
		this.gestorStock.registrarNuevoProducto(productoNoPerecedero);
		
		Double sumaTotalEsperada = 26750.0;
		Double sumaTotalObtenida = productoNoPerecedero.obtenerSumaTotal();
		
		assertEquals(sumaTotalEsperada, sumaTotalObtenida);
	}
	
	@Test
	public void dadoQueExisteUnGestorConTresProductosRegistradosObtengoQueElTotalDeTodoElStockEsDe58000() {
		Producto producto = new Producto("Producto", 100, 50.0);
		ProductoPerecedero productoPerecedero = new ProductoPerecedero("Producto perecedero", 100, 250.0, LocalDate.of(2025, 12, 31));
		ProductoNoPerecedero productoNoPerecedero = new ProductoNoPerecedero("Producto no perecedero", 100, 250.0, "Verde");
		
		this.gestorStock.registrarNuevoProducto(producto);
		this.gestorStock.registrarNuevoProducto(productoPerecedero);
		this.gestorStock.registrarNuevoProducto(productoNoPerecedero);
		
		Double sumaTotalDeTodosLosStocksEsperada = 58000.0;
		Double sumaTotalDeTodosLosStocksObtenida = this.gestorStock.obtenerSumaTotalDeTodosLosProductos();
		
		assertEquals(sumaTotalDeTodosLosStocksEsperada, sumaTotalDeTodosLosStocksObtenida);
	}
}
