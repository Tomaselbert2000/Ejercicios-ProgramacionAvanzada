package ar.edu.unlam.dominio;

import java.util.Objects;

public class Vehiculo {

	private Integer idVehiculo;
	private String nombre;
	private Boolean estadoDisponibilidad;

	public Vehiculo(Integer idVehiculo, String nombre, Boolean estadoDisponibilidad) {
		this.idVehiculo = idVehiculo;
		this.nombre = nombre;
		this.estadoDisponibilidad = estadoDisponibilidad;
	}

	public Integer getId() {
		return this.idVehiculo;
	}

	public String getNombreVehiculo() {
		return this.nombre;
	}

	public Boolean getEstadoDisponibilidad() {
		return this.estadoDisponibilidad;
	}

	@Override
	public String toString() {
		return "ID de Vehiculo: " + idVehiculo + "\nNombre registrado: " + nombre
				+ "\n¿Se encuentra disponible actualmente?: " + estadoDisponibilidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idVehiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(idVehiculo, other.idVehiculo);
	}
}
