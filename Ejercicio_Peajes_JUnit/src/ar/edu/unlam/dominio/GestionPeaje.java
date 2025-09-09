package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;

public class GestionPeaje {

	private HashSet<Vehiculo> listaDeVehiculosRegistrados;
	private ArrayList<Pase> listaDeRegistrosDePasadas;
	private HashSet<Tarifa> listaDeTarifas;
	
	public GestionPeaje() {
		this.listaDeVehiculosRegistrados = new HashSet<>();
		this.listaDeRegistrosDePasadas = new ArrayList<>();
		this.listaDeTarifas = new HashSet<>();
	}

	public HashSet<Vehiculo> obtenerListaDeVehiculosRegistrados() {
		return this.listaDeVehiculosRegistrados;
	}

	public Boolean registrarNuevoVehiculo(Vehiculo vehiculo) {
		if(!this.validarPatente(vehiculo.getPatente())) {
			this.listaDeVehiculosRegistrados.add(vehiculo);
			return true;
		}
		return false;
	}
	
	public Boolean validarPatente(String patente) {
		for(Vehiculo vhcl : this.listaDeVehiculosRegistrados) {
			if(vhcl.getPatente().equals(patente)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Pase> obtenerListaDeRegistrosDePasadas() {
		return this.listaDeRegistrosDePasadas;
	}

	public Boolean ingresarNuevoRegistro(Pase registro1) {
		if(this.listaDeRegistrosDePasadas.add(registro1)) {
			return true;
			}
		return false;
	}

	public ArrayList<Pase> obtenerListaRegistrosPorPatente(String patente) {
		ArrayList<Pase> registrosFiltradosPorPatente = new ArrayList<>();
		for(Pase p : this.listaDeRegistrosDePasadas) {
			if(p.getPatenteDeVehiculo().equals(patente)) {
				registrosFiltradosPorPatente.add(p);
			}
		}
		return registrosFiltradosPorPatente;
	}

	public HashSet<Tarifa> getListaTarifas() {
		return this.listaDeTarifas;
	}

	public Boolean registrarNuevaTarifa(Tarifa tarifa) {
		if(this.listaDeTarifas.add(tarifa)) {
			return true;
		}
		return false;
	}

	public Integer getCantidadTarifasRegistradas() {
		return this.listaDeTarifas.size();
	}
}
