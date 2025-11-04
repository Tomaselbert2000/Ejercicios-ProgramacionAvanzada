package ar.edu.unlam.dominio;

import ar.edu.unlam.interfaces.IntCalcularValorTotalAlquiler;

public class Motocicleta extends Vehiculo implements IntCalcularValorTotalAlquiler {

	private String patente;
	private Double capacidadCombustible;
	private Double cilindrada;
	private Double precioPorHoraAlquiler;

	public Motocicleta(Integer idVehiculo, String nombre, Boolean estadoDisponibilidad, String patente,
			Double capacidadCombustible, Double cilindrada) {
		super(idVehiculo, nombre, estadoDisponibilidad);
		this.patente = patente;
		this.capacidadCombustible = capacidadCombustible;
		this.cilindrada = cilindrada;
		this.precioPorHoraAlquiler = 10000.0;
	}

	public String getPatente() {
		return this.patente;
	}

	public Double getCapacidadCombustible() {
		return this.capacidadCombustible;
	}

	public Double getCilindrada() {
		return this.cilindrada;
	}

	@Override
	public Double calcularValorTotalDeAlquiler(Double cantidadHorasAlquiler) {
		return this.precioPorHoraAlquiler * cantidadHorasAlquiler;
	}

	@Override
	public String toString() {
		String superToString = super.toString();
		String subclassToString = "\nTipo de vehiculo: Motocicleta" + "\nPatente: " + patente
				+ "\nCapacidad de combustible: " + capacidadCombustible + " litros" + "\nCilindrada: " + cilindrada
				+ " cc" + "\nPrecio por hora de alquiler: $" + precioPorHoraAlquiler;
		return superToString + subclassToString;
	}
}
