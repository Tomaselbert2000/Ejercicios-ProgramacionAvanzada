package ar.edu.unlam.dominio;

import java.util.ArrayList;

public class Montacarga {
	
	private Double pesoMaximoPermitido;
	
	// creamos un atributo de tipo ArrayList
	private ArrayList<Carga> cargas; // tenemos un tipificador para indicar que esta lista es de cargas
	
	public Montacarga(Double pesoMaximoPermitido) {
		this.pesoMaximoPermitido = pesoMaximoPermitido;
		this.cargas = new ArrayList<Carga>();
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
}
