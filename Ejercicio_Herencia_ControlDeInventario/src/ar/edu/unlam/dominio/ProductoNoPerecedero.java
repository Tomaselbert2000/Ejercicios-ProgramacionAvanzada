package ar.edu.unlam.dominio;

public class ProductoNoPerecedero extends Producto implements IntFuncionesProductos{

	private String color;

	public ProductoNoPerecedero(String nombre, Integer cantidad, Double precioUnitario, String color) {
		super(nombre, cantidad, precioUnitario);
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	@Override
	public Double obtenerPrecio() {
		Double recargo = ((super.getPrecioUnitario() * 7.0)/100);
		Double total = super.getPrecioUnitario() + recargo;
		return total;
	}

	@Override
	public Double obtenerSumaTotal() {
		return super.getCantidad() * this.obtenerPrecio();
	}
}
