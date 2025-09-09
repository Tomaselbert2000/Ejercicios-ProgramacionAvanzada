package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class GestorPeaje {
	
	// aca usamos una coleccion de tipo hashset para que NO permita duplicados
	// los arraylists si permiten duplicados por lo tanto no sirven en este caso
	private HashSet<Pase> listaPases;
	
	public GestorPeaje() {
		this.listaPases = new HashSet<>();
	}
	
	public Boolean registrarPase(Pase pase) {	
		if(this.listaPases.add(pase)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Vehiculo> obtenerListadoDeVehiculos() {
		ArrayList<Vehiculo> listadoDeVehiculos = new ArrayList<>();
		for(Pase p : this.listaPases) {
			listadoDeVehiculos.add(p.getVehiculo());
		}
		return listadoDeVehiculos;
	}

	public Boolean buscarPorPatente(String patente) {
		for(Pase p : this.listaPases) {
			if(p.getVehiculo().getPatente().equals(patente)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Pase> obtenerPasesPorFecha(LocalDateTime fechaYhora) {
		ArrayList<Pase> listaPasesPorFecha = new ArrayList<>();
		for(Pase p : this.listaPases) {
			if(p.getFechaYhora().equals(fechaYhora)) {
				listaPasesPorFecha.add(p);
			}
		}
		return listaPasesPorFecha;
	}
}
