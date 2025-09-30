package ar.edu.unlam.dominio;

public class ProductoAlimenticio extends Producto implements IntOperacionesProductos{

	public ProductoAlimenticio(String nombre, Double precio, String descripcion) {
		super(nombre, precio, descripcion);
	}

	@Override
	public Double calcularPrecioFinal() {
		Double precioBase = super.getPrecio();
		Double valorFijoAgregado = 1000.0;
		Double comisionAgregada = (((precioBase + valorFijoAgregado) * 7.5)/100);
		Double precioFinal = precioBase + valorFijoAgregado + comisionAgregada;
		return precioFinal;
	}

}
