package ar.edu.unlam.dominio;

public class Producto{

	private String nombre;
	private Double precio;
	private String descripcion;

	public Producto(String nombre, Double precio, String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
}
