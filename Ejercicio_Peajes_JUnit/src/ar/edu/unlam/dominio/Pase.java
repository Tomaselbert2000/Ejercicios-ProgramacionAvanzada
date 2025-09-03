package ar.edu.unlam.dominio;

import java.time.LocalDateTime;

public class Pase {

	private Vehiculo vehiculoAsociado;
	private LocalDateTime fechaYhoraDePasada;

	public Pase(Vehiculo vehiculo, LocalDateTime fechaYhora) {
		this.vehiculoAsociado = vehiculo;
		this.fechaYhoraDePasada = fechaYhora;
	}

	public String getPatenteDeVehiculo() {
		return this.vehiculoAsociado.getPatente();
	}

	public LocalDateTime obtenerFechaYhoraDelRegistro() {
		return this.fechaYhoraDePasada;
	}

}
