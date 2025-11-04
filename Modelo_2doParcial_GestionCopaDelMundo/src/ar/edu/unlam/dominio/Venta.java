package ar.edu.unlam.dominio;

import java.util.HashSet;

public class Venta {

	private Cliente clienteQueRealizaLaCompra;
	private HashSet<CopaDelMundo> copasDelMundoCompradas;

	public Venta(Cliente clienteQueRealizaLaCompra, HashSet<CopaDelMundo> copasDelMundoCompradas) {
		this.clienteQueRealizaLaCompra = clienteQueRealizaLaCompra;
		this.copasDelMundoCompradas = copasDelMundoCompradas;
	}

	public Cliente getClienteQueRealizoLaCompra() {
		return this.clienteQueRealizaLaCompra;
	}

	public HashSet<CopaDelMundo> getCopasCompradas() {
		return this.copasDelMundoCompradas;
	}

}
