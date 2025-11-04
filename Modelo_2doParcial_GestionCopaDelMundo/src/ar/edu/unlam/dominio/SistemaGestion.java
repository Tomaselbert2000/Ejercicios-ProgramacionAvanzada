package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import ar.edu.unlam.exceptions.ClienteDuplicadoException;
import ar.edu.unlam.exceptions.CopaDelMundoDuplicadaException;
import ar.edu.unlam.exceptions.CopaDelMundoNoEncontradaException;

public class SistemaGestion {

	private HashSet<CopaDelMundo> hashSetCopas;
	private HashSet<Cliente> hashSetClientes;
	private HashSet<Venta> hashSetVentas;

	public SistemaGestion() {
		this.hashSetCopas = new HashSet<>();
		this.hashSetClientes = new HashSet<>();
		this.hashSetVentas = new HashSet<>();
	}

	public Boolean agregarCopaDelMundo(CopaDelMundo copa) throws CopaDelMundoDuplicadaException {
		if(this.hashSetCopas.add(copa)) {
			return true;
		}else {
			throw new CopaDelMundoDuplicadaException();
		}
	}

	public Boolean agregarCliente(Cliente cliente) throws ClienteDuplicadoException {
		if (this.hashSetClientes.add(cliente)) {
			return true;
		} else {
			throw new ClienteDuplicadoException();
		}
	}

	public HashSet<CopaDelMundoEstandar> obtenerCopasDelMundoEstandar() {
		HashSet<CopaDelMundoEstandar> copasDelMundoEstandar = new HashSet<>();
		for (CopaDelMundo copa : this.hashSetCopas) {
			if (copa instanceof CopaDelMundoEstandar) {
				copasDelMundoEstandar.add((CopaDelMundoEstandar) copa);
			}
		}
		return copasDelMundoEstandar;
	}

	public CopaDelMundo buscarCopaDelMundoPorId(Integer idCopa) throws CopaDelMundoNoEncontradaException {
		for (CopaDelMundo copa : this.hashSetCopas) {
			if (copa.getId().equals(idCopa)) {
				return copa;
			}else {
				throw new CopaDelMundoNoEncontradaException();
			}
		}
		return null;
	}

	public Boolean agregarVenta(Venta ventaRealizada) {
		if(this.clienteRegistrado(ventaRealizada) && this.stockSuficiente(ventaRealizada)) {
			this.actualizarStock(ventaRealizada);
			return this.hashSetVentas.add(ventaRealizada);
		}
		return false;
	}

	private void actualizarStock(Venta ventaRealizada) {
		for(CopaDelMundo copa : ventaRealizada.getCopasCompradas()) {
			this.hashSetCopas.remove(copa);
		}
	}

	private Boolean stockSuficiente(Venta ventaRealizada) {
		for(CopaDelMundo copa : ventaRealizada.getCopasCompradas()) {
			if(!this.hashSetCopas.contains(copa)) {
				return false;
			}
		}
		return true;
	}

	private Boolean clienteRegistrado(Venta ventaRealizada) {
		return this.hashSetClientes.contains(ventaRealizada.getClienteQueRealizoLaCompra());
	}

	public Double obtenerPrecioDeCopaPersonalizada(Integer idCopa) {
		for(CopaDelMundo copa : this.hashSetCopas) {
			if(copa instanceof CopaDelMundoPersonalizada) {
				if(copa.getId().equals(idCopa)) {
					return ((CopaDelMundoPersonalizada) copa).obtenerPrecioTotal();
				}
			}
		}
		return null;
	}

	public HashSet<CopaDelMundo> obtenerCopasDelMundoPersonalizadas() {
		HashSet<CopaDelMundo> copasDelMundoPersonalizadas = new HashSet<>();
		for(CopaDelMundo copa : this.hashSetCopas) {
			if(copa instanceof CopaDelMundoPersonalizada) {
				copasDelMundoPersonalizadas.add(copa);
			}
		}
		return copasDelMundoPersonalizadas;
	}

	public HashMap<Cliente, List<Double>> reporteTotalVentasOrdenadoPorCliente() {
		HashMap<Cliente, List<Double>> reporteCostos = new HashMap<>();
		for(Cliente clnt : this.hashSetClientes) {
			ArrayList<Double> listaDeCostosTotalesPorCliente = new ArrayList<>();
			for(Venta venta : this.hashSetVentas) {
				if(venta.getClienteQueRealizoLaCompra().equals(clnt)) {
					listaDeCostosTotalesPorCliente.add(this.calcularTotalDeVenta(venta));
				}
			}
			reporteCostos.put(clnt, listaDeCostosTotalesPorCliente);
		}
		return reporteCostos;
	}

	private Double calcularTotalDeVenta(Venta venta) {
		Double totalPorVenta = 0.0;
		for(CopaDelMundo copa : venta.getCopasCompradas()) {
			if(copa instanceof CopaDelMundoEstandar) {
				totalPorVenta += ((CopaDelMundoEstandar) copa).obtenerPrecioTotal();
			}else if(copa instanceof CopaDelMundoPersonalizada) {
				totalPorVenta += ((CopaDelMundoPersonalizada) copa).obtenerPrecioTotal();
			}
		}
		return totalPorVenta;
	}
}
