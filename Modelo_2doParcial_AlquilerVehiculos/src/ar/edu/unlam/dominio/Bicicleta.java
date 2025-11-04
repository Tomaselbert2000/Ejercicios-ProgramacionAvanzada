package ar.edu.unlam.dominio;

import ar.edu.unlam.enums.TipoBicicletaEnum;
import ar.edu.unlam.interfaces.IntCalcularValorTotalAlquiler;

public class Bicicleta extends Vehiculo implements IntCalcularValorTotalAlquiler {

	private TipoBicicletaEnum tipoDeBicicleta;
	private Boolean poseeFrenosADisco;
	private Double precioPorHoraAlquiler = 5000.0;

	public Bicicleta(Integer idVehiculo, String nombre, Boolean estadoDisponibilidad, TipoBicicletaEnum tipoBicicleta,
			Boolean poseeFrenosADisco) {
		super(idVehiculo, nombre, estadoDisponibilidad);
		this.tipoDeBicicleta = tipoBicicleta;
		this.poseeFrenosADisco = poseeFrenosADisco;
		this.precioPorHoraAlquiler = this.cargarPrecioDeAlquilerPorHora();
	}

	private Double cargarPrecioDeAlquilerPorHora() {
		if(this.tipoDeBicicleta.equals(TipoBicicletaEnum.MONTANIA)) {
			return (this.precioPorHoraAlquiler * 0.20) + this.precioPorHoraAlquiler;
		}else {
			return this.precioPorHoraAlquiler;
		}
	}

	public TipoBicicletaEnum getTipoBicicleta() {
		return this.tipoDeBicicleta;
	}

	public Boolean getSiTieneFrenosADisco() {
		return this.poseeFrenosADisco;
	}

	@Override
	public Double calcularValorTotalDeAlquiler(Double cantidadHorasAlquiler) {
		return this.precioPorHoraAlquiler * cantidadHorasAlquiler;
	}

	@Override
	public String toString() {
		String superToString = super.toString();
		String subclassToString = "\nTipo de bicicleta: " + tipoDeBicicleta + "\n¿Posee frenos a disco?: "
				+ poseeFrenosADisco + "\nPrecio de alquiler por hora: $" + precioPorHoraAlquiler;
		return superToString + subclassToString;
	}

}
