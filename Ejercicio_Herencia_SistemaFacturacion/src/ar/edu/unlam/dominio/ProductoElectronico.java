package ar.edu.unlam.dominio;

public class ProductoElectronico extends Producto implements IntOperacionesProductos{

	public ProductoElectronico(String nombre, Double precio, String descripcion) {
		super(nombre, precio, descripcion);
	}

	@Override
	public Double calcularPrecioFinal() {
		Double precioBase = super.getPrecio();
		Double recargo = ((precioBase * 15)/100);
		Double precioFinal = precioBase + recargo;
		return precioFinal;
	}
}
