package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import ar.edu.unlam.exceptions.ClienteNoRegistradoException;
import ar.edu.unlam.exceptions.DniDuplicadoException;
import ar.edu.unlam.exceptions.IdDeVehiculoRepetidoException;
import ar.edu.unlam.exceptions.PatenteRepetidaException;
import ar.edu.unlam.exceptions.VehiculoNoDisponibleException;

public class SistemaGestion {

	private HashSet<Cliente> hashSetClientes;
	private HashSet<Vehiculo> hashSetVehiculos;
	private HashSet<Alquiler> hashSetAlquileres;

	public SistemaGestion() {
		this.hashSetClientes = new HashSet<>();
		this.hashSetVehiculos = new HashSet<>();
		this.hashSetAlquileres = new HashSet<>();
	}

	public Boolean agregarCliente(Cliente cliente) throws DniDuplicadoException {
		if (this.hashSetClientes.add(cliente)) {
			return true;
		} else {
			throw new DniDuplicadoException();
		}
	}

	public Boolean agregarVehiculo(Vehiculo nuevoVehiculo) throws PatenteRepetidaException, IdDeVehiculoRepetidoException {
		if(nuevoVehiculo instanceof Motocicleta) {
			if(!this.patenteRepetida(nuevoVehiculo)) {
				return this.hashSetVehiculos.add(nuevoVehiculo);
			}else {
				throw new PatenteRepetidaException();
			}
		}else {
			if(this.hashSetVehiculos.add(nuevoVehiculo)) {
				return true;
			}else {
				throw new IdDeVehiculoRepetidoException();
			}
		}
		
	}

	private Boolean patenteRepetida(Vehiculo nuevoVehiculo) {
		for(Vehiculo v : this.hashSetVehiculos) {
			if(v instanceof Motocicleta) {
				if(((Motocicleta) v).getPatente().equals(((Motocicleta) nuevoVehiculo).getPatente())) {
					return true;
				}
			}
		}
		return false;
	}

	public HashSet<Bicicleta> obtenerBicicletas() {
		HashSet<Bicicleta> coleccionBicicletasRegistradas = new HashSet<>();
		for (Vehiculo b : this.hashSetVehiculos) {
			if (b instanceof Bicicleta) {
				coleccionBicicletasRegistradas.add((Bicicleta) b);
			}
		}
		return coleccionBicicletasRegistradas;
	}

	public HashSet<Motocicleta> obtenerMotocicletas() {
		HashSet<Motocicleta> coleccionMotocicletasRegistradas = new HashSet<>();
		for (Vehiculo m : this.hashSetVehiculos) {
			if (m instanceof Motocicleta) {
				coleccionMotocicletasRegistradas.add((Motocicleta) m);
			}
		}
		return coleccionMotocicletasRegistradas;
	}

	public Vehiculo obtenerVehiculoPorId(Integer idVehiculo) {
		for (Vehiculo v : this.hashSetVehiculos) {
			if (v.getId().equals(idVehiculo)) {
				return v;
			}
		}
		return null;
	}

	public Double obtenerPrecioTotalAlquiler(Integer idVehiculo, Double cantidadDeHoras) {
		for (Vehiculo v : this.hashSetVehiculos) {
			if (v instanceof Bicicleta) {
				return ((Bicicleta) v).calcularValorTotalDeAlquiler(cantidadDeHoras);
			} else if (v instanceof Motocicleta) {
				return ((Motocicleta) v).calcularValorTotalDeAlquiler(cantidadDeHoras);
			}
		}
		return 0.0;
	}

	public Boolean agregarAlquiler(Alquiler alquiler)
			throws VehiculoNoDisponibleException, ClienteNoRegistradoException {
		Vehiculo vehiculoAlquilado = this.obtenerVehiculoPorId(alquiler.getIdVehiculoAlquilado());
		if (!this.clienteRegistrado(alquiler)) {
			throw new ClienteNoRegistradoException();
		} else if (!vehiculoAlquilado.getEstadoDisponibilidad()) {
			throw new VehiculoNoDisponibleException();
		} else {
			Double precioTotal = obtenerPrecioTotalAlquiler(vehiculoAlquilado.getId(),
					alquiler.getCantidadHorasAlquiladas());
			alquiler.setPrecioTotal(precioTotal);
			return this.hashSetAlquileres.add(alquiler);
		}
	}

	private Boolean clienteRegistrado(Alquiler alquiler) {
		return this.hashSetClientes.contains(this.buscarClientePorDni(alquiler.getDniClienteAsociado()));
	}

	private Cliente buscarClientePorDni(Integer dniClienteBuscado) {
		for (Cliente clnt : this.hashSetClientes) {
			if (clnt.getDni().equals(dniClienteBuscado)) {
				return clnt;
			}
		}
		return null;
	}

	public HashMap<Cliente, ArrayList<Vehiculo>> obtenerReporteDeVehiculosAlquiladosPorCliente() {
		HashMap<Cliente, ArrayList<Vehiculo>> reporteAlquileresDeVehiculosPorCliente = new HashMap<>();
		for (Cliente clnt : this.hashSetClientes) {
			ArrayList<Vehiculo> vehiculosAlquilados = new ArrayList<>();
			for (Alquiler alq : this.hashSetAlquileres) {
				if (clnt.getDni().equals(alq.getDniClienteAsociado())) {
					vehiculosAlquilados.add(this.obtenerVehiculoPorId(alq.getIdVehiculoAlquilado()));
				}
			}
			reporteAlquileresDeVehiculosPorCliente.put(clnt, vehiculosAlquilados);
		}
		return reporteAlquileresDeVehiculosPorCliente;
	}
}
