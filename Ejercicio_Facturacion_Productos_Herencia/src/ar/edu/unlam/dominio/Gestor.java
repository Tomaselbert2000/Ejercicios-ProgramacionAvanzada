package ar.edu.unlam.dominio;

import java.util.HashSet;

public class Gestor {

	private HashSet<Producto> listaProductos;
	
	public Gestor() {
		this.listaProductos = new HashSet<>();
	}

	public Boolean registrarProducto(Producto producto) {
		if(!this.yaEstaRegistrado(producto) && this.listaProductos.add(producto)) {
			return true;
		}
		return false;
	}
	
	public Boolean yaEstaRegistrado(Producto producto) {
		for(Producto p : this.listaProductos) {
			if (p.hashCode() == producto.hashCode()) {
				return true;
			}
		}
		return false;
	}
}
