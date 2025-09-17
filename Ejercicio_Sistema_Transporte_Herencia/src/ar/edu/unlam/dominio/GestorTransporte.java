package ar.edu.unlam.dominio;

import java.util.HashSet;

public class GestorTransporte {

	private HashSet<Vehiculo> listaDeVehiculos;
	
	public GestorTransporte() {
		this.listaDeVehiculos = new HashSet<>();
	}

	public Boolean agregarVehiculo(Vehiculo vehiculo) {
		if(this.listaDeVehiculos.add(vehiculo)) {
			return true;
		}
		return false;
	}

	public Integer cantidadVehiculosRegistrados() {
		return this.listaDeVehiculos.size();
	}

}
