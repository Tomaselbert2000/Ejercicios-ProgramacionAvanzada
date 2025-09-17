package ar.edu.unlam.dominio;

public class Camion extends Vehiculo{

	private Double pesoCargadoActual;

	public Camion(String patente, Double pesoMaximo, Integer capacidadMaximaPasajeros) {
		super(patente, pesoMaximo, capacidadMaximaPasajeros);
		this.pesoCargadoActual = 0.0;
	}

	public Boolean cargarPeso(Double pesoACargar) {
		if((this.pesoCargadoActual+pesoACargar) <= this.obtenerPesoMaximo()) {
			this.pesoCargadoActual += pesoACargar;
			return true;
		}
		return false;
	}

}
