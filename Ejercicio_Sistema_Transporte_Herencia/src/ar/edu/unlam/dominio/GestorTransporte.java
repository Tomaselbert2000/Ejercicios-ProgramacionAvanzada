package ar.edu.unlam.dominio;

import java.util.HashSet;

public class GestorTransporte {

	private HashSet<Vehiculo> listaDeVehiculos;
	
	public GestorTransporte() {
		this.listaDeVehiculos = new HashSet<>();
	}

	public Boolean agregarVehiculo(Vehiculo vehiculo) {
		if(!this.existeEnLaColeccion(vehiculo) && this.listaDeVehiculos.add(vehiculo)) {
			return true;
		}
		return false;
	}

	public Integer cantidadVehiculosRegistrados() {
		return this.listaDeVehiculos.size();
	}
	
	public Boolean existeEnLaColeccion(Vehiculo vehiculo) {
		for(Vehiculo v : this.listaDeVehiculos) {
			if(v.equals(vehiculo)) {
				return true;
			}
		}
		return false;
	}
}
