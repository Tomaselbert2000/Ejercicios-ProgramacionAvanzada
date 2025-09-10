package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class GestorPeaje {
	
	// aca usamos una coleccion de tipo hashset para que NO permita duplicados
	// los arraylists si permiten duplicados por lo tanto no sirven en este caso
	private HashSet<Pase> listaPases;
	private HashSet<Tarifa> listaDeTarifas;
	private HashSet<TipoVehiculo> listaDeTiposVehiculos;
	
	public GestorPeaje() {
		this.listaPases = new HashSet<>();
		this.listaDeTarifas = new HashSet<>();
		this.listaDeTiposVehiculos = new HashSet<>();
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

	public Boolean registrarTarifa(Tarifa nuevaTarifa) {
		if(this.listaDeTarifas.add(nuevaTarifa)) {
			return true;
		}
		return false;
	}

	public Double obtenerValorDeTarifaDePase(Pase pase) {
		for (Tarifa t : this.listaDeTarifas) {
			if(pase.getFechaYhora().isAfter(t.getFechaDesde()) && pase.getFechaYhora().isBefore(t.getFechaHasta())) {
					return t.getValor();
				}
			}
		return 0.0;
	}

	public Boolean registrarTipoVehiculo(TipoVehiculo tipo) {
		if(this.listaDeTiposVehiculos.add(tipo)) {
			return true;
		}
		return false;
	}

	public Tarifa obtenerTarifaVigente() {
		for(Tarifa t : this.listaDeTarifas) {
			if(t.getFechaHasta() == null) {
				return t;
			}
		}
		return null;
	}

	public Double obtenerValorTarifaVigente() {
		return this.obtenerTarifaVigente().getValor();
	}
}
