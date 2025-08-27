package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;

public class Montacarga {
	
	private Double pesoMaximoPermitido;
	
	// creamos un atributo de tipo ArrayList
	private ArrayList<Carga> cargas; // tenemos un tipificador para indicar que esta lista es de cargas
	private HashSet<Carga> cargasSinDuplicados;
	
	public Montacarga(Double pesoMaximoPermitido) {
		this.pesoMaximoPermitido = pesoMaximoPermitido;
		this.cargas = new ArrayList<Carga>();
		this.cargasSinDuplicados = new HashSet<Carga>();
	}

	public Double getPeso() {
		return this.pesoMaximoPermitido;
	}
	
	public void cargar(Carga carga) {
		this.cargas.add(carga); // con el metodo add agregamos la carga
	}

	public Integer obtenerCantidadCargas() {
		return this.cargas.size();
	}
	
	public Double obtenerPesoCargado() {
		Double totalCargado = 0.0;
		for(Carga carga : this.cargas) {
			totalCargado += carga.getPeso();
		}
		return totalCargado;
	}
	
	public void vaciar() {
		this.cargas.clear();
	}
	
	// aca creamos un metodo que agrega una carga la cual NO PUEDE SER DUPLICADA
	public boolean agregarCarga(Carga carga) {
		boolean cargaAgregada = this.cargasSinDuplicados.add(carga);
		return cargaAgregada;
	}
}
