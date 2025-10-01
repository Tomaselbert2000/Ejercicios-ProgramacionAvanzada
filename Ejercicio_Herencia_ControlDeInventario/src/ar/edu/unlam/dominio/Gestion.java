package ar.edu.unlam.dominio;

import java.util.HashSet;

public class Gestion {

	private HashSet<Producto> listaProductos;
	
	public Gestion() {
		this.listaProductos = new HashSet<>();
	}

	public Boolean registrarNuevoProducto(Producto producto) {
		return this.listaProductos.add(producto);
	}

	public Double obtenerSumaTotalDeTodosLosProductos() {
		Double totalAcumulado = 0.0;
		for(Producto p : this.listaProductos) {
			totalAcumulado += p.obtenerSumaTotal();
		}
		return totalAcumulado;
	}

}
