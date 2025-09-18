package ar.edu.unlam.dominio;

import java.util.Objects;

public class Producto {

	private String nombre;
	private Double precio;
	private String descripcion;

	public Producto(String nombre, double precio, String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public String obtenerNombre() {
		return this.nombre;
	}

	public Double obtenerPrecio() {
		return this.precio;
	}

	public String obtenerDescripcion() {
		return this.descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, nombre);
	}
	
	public void calcularPrecioFinal() {
		
	}
}
