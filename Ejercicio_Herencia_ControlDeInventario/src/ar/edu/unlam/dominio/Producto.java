package ar.edu.unlam.dominio;

public class Producto {

	private String nombre;
	private Integer cantidad;
	private Double precioUnitario;

	public Producto(String nombre, Integer cantidad, Double precioUnitario) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public Double getPrecioUnitario() {
		return this.precioUnitario;
	}

	public Double obtenerSumaTotal() {
		return this.precioUnitario * this.cantidad;
	}
}
