package ar.edu.unlam.dominio;

public class Vehiculo {

	private String patente;
	private Double pesoMaximo;
	private Integer capacidadDeCarga;
	private Integer cargaActual;
	
	public Vehiculo(String patente, Double pesoMaximo, Integer capacidadMaximaPasajeros) {
		this.patente = patente;
		this.pesoMaximo = pesoMaximo;
		this.capacidadDeCarga = capacidadMaximaPasajeros;
		this.cargaActual = 0;
	}

	public String getPatente() {
		return this.patente;
	}

	public Double getPesoMaximo() {
		return this.pesoMaximo;
	}

	public Integer obtenerCapacidadMaximaPasajeros() {
		return this.capacidadDeCarga;
	}

	public Integer getCantidadPasajerosActual() {
		return this.cargaActual;
	}

	public Boolean cargarPasajeros(Integer cantidadPasajeros) {
		if(cantidadPasajeros+this.cargaActual <= this.capacidadDeCarga) {
			this.cargaActual += cantidadPasajeros;
			return true;
		}
		return false;
	}
}
