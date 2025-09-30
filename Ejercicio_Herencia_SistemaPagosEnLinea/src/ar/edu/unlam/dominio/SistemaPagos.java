package ar.edu.unlam.dominio;

import java.util.HashSet;

public class SistemaPagos {

	private HashSet<MetodoDePago> listaMetodosDePago;
	
	public SistemaPagos() {
		this.listaMetodosDePago = new HashSet<>();
	}

	public Boolean registrarMetodoDePago(MetodoDePago metodo) {
		return this.listaMetodosDePago.add(metodo);
	}

}
