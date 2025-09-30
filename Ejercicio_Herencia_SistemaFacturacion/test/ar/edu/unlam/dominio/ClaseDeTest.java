package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ClaseDeTest {
	
	@Test
	public void dadoQueExisteUnProductoPuedoConsultarSusAtributos() {
		Producto producto = new Producto("Producto 1", 100.0, "Este es un producto de prueba");
		assertEquals("Producto 1", producto.getNombre());
		assertEquals((Double)100.0, producto.getPrecio());
		assertEquals("Este es un producto de prueba", producto.getDescripcion());
	}
	
	@Test
	public void dadoQueExisteUnaClaseProductoElectronicoPorHerenciaPuedoConsultarSusAtributos() {
		
		ProductoElectronico prodElect = new ProductoElectronico("ProdElect1", 150.0, "ProductoElectronico de prueba");
		
		// como hacemos que la clase ProductoElectronico extienda desde la superclase Producto, obtiene automaticamente los getters
		assertEquals("ProdElect1", prodElect.getNombre());
		assertEquals(150.0, prodElect.getPrecio(), 0.0); // agregamos el valor del delta para evitar errores con el metodo
		assertEquals("ProductoElectronico de prueba", prodElect.getDescripcion());
	}
	
	@Test
	public void dadoQueExisteUnProductoElectronicoConPrecioBaseDe150obtengoQueSuPrecioFinalEs172con50() {
		ProductoElectronico prodElect = new ProductoElectronico("ProdElect1", 150.0, "ProductoElectronico de prueba");
		
		Double precioFinalEsperado = 172.50;
		Double precioFinalObtenido = prodElect.calcularPrecioFinal();
		
		assertEquals(precioFinalEsperado, precioFinalObtenido);
	}
	
	@Test
	public void dadoQueExisteUnProductoDeRopaPorHerenciaPuedoConsultarSusAtributos() {
		ProductoRopa prodRopa = new ProductoRopa("ProdRopa", 1500.0, "Producto de indumentaria");
		
		assertEquals("ProdRopa", prodRopa.getNombre());
		assertEquals(1500.0, prodRopa.getPrecio(), 0.0);
		assertEquals("Producto de indumentaria", prodRopa.getDescripcion());
	}
	
	@Test
	public void dadoQueExisteUnProductoAlimenticioQueVale1500ObtengoQueSuPrecioFinalEs1575() {
		ProductoRopa prodRopa = new ProductoRopa("ProdRopa", 1500.0, "Producto de indumentaria");
		
		Double precioFinalEsperado = 1575.0;
		Double precioFinalObtenido = prodRopa.calcularPrecioFinal();
		
		assertEquals(precioFinalEsperado, precioFinalObtenido);
	}
	
	@Test
	public void dadoQueExisteUnProductoAlimenticioPorHerenciaPuedoConsultarSusAtributos() {
		ProductoAlimenticio prodAlim = new ProductoAlimenticio("Producto Alimenticio", 2560.0, "Este es un producto de prueba");
		assertEquals("Producto Alimenticio", prodAlim.getNombre());
		assertEquals(2560.0, prodAlim.getPrecio(), 0.0);
		assertEquals("Este es un producto de prueba", prodAlim.getDescripcion());
	}
	
	@Test
	public void dadoQueExisteUnProductoAlimenticioQueVale2560ObtengoQueSuPrecioFinalEs3827() {
		ProductoAlimenticio prodAlim = new ProductoAlimenticio("Producto Alimenticio", 2560.0, "Este es un producto de prueba");
		
		Double precioFinalEsperado = 3827.0;
		Double precioFinalObtenido = prodAlim.calcularPrecioFinal();
		
		assertEquals(precioFinalEsperado, precioFinalObtenido);
	}
}
