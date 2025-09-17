package ar.edu.unlam.dominio;

import java.util.Objects;

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

	public String obtenerPatente() {
		return this.patente;
	}

	public Double obtenerPesoMaximo() {
		return this.pesoMaximo;
	}

	public Integer obtenerCapacidadMaximaPasajeros() {
		return this.capacidadDeCarga;
	}

	public Integer obtenerCantidadPasajerosActual() {
		return this.cargaActual;
	}

	public Boolean cargarPasajeros(Integer cantidadPasajeros) {
		if(cantidadPasajeros+this.cargaActual <= this.capacidadDeCarga) {
			this.cargaActual += cantidadPasajeros;
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(patente);
	}

	@Override
	public boolean equals(Object obj) {
		Vehiculo other = (Vehiculo) obj;
		if(this.obtenerPatente().equals(other.obtenerPatente())) {
			return true;
		}
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return Objects.equals(patente, other.patente);
	}
}
