package ar.edu.unlam.dominio;

public class ProductoRopa extends Producto implements IntOperacionesProductos{

	public ProductoRopa(String nombre, Double precio, String descripcion) {
		super(nombre, precio, descripcion);
	}

	@Override
	public Double calcularPrecioFinal() {
		Double precioBase = super.getPrecio();
		Double comisionAgregada = ((precioBase * 5)/100);
		Double precioFinal = precioBase + comisionAgregada;
		return precioFinal;
	}

}
