package ar.edu.unlam.dominio;

import java.util.Objects;

import ar.edu.unlam.enums.NombreSeleccion;

public class Equipo {

	private NombreSeleccion nombreSeleccion;
	private Integer puntajeActual;
	private Integer golesAfavor;
	private Integer golesEnContra;

	public Equipo(NombreSeleccion nombreSeleccion) {
		this.nombreSeleccion = nombreSeleccion;
		this.puntajeActual = 0;
		this.golesAfavor = 0;
		this.golesEnContra = 0;
	}

	public NombreSeleccion getNombreSeleccion() {
		return this.nombreSeleccion;
	}

	public Integer getPuntajeActual() {
		return this.puntajeActual;
	}

	public Integer getGolesAFavor() {
		return this.golesAfavor;
	}

	public Integer getGolesEnContra() {
		return this.golesEnContra;
	}

	public void sumarVictoria() {
		this.puntajeActual += 3;
	}

	public void sumarEmpate() {
		this.puntajeActual += 1;
	}

	public void actualizarGolesAfavorYenContra(Integer golesAnotados, Integer golesRecibidos) {
		this.golesAfavor += golesAnotados;
		this.golesEnContra += golesRecibidos;
	}

	@Override
	public String toString() {
		return "Equipo [nombreSeleccion=" + nombreSeleccion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreSeleccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return nombreSeleccion == other.nombreSeleccion;
	}

}
