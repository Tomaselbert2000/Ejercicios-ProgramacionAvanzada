package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Pase {

	private Vehiculo vehiculo;
	private LocalDateTime fechaYhora;

	public Pase(Vehiculo vehiculo, LocalDateTime fechaYhora) {
		this.vehiculo = vehiculo;
		this.fechaYhora = fechaYhora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaYhora, vehiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pase other = (Pase) obj;
		return Objects.equals(fechaYhora, other.fechaYhora) && Objects.equals(vehiculo, other.vehiculo);
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public LocalDateTime getFechaYhora() {
		return this.fechaYhora;
	}
}
