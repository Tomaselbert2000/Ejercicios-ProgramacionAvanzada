package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

import ar.edu.unlam.comparators.ComparadorClientesPorDNI;
import ar.edu.unlam.exceptions.CanalExistenteException;
import ar.edu.unlam.exceptions.ClienteExistenteException;
import ar.edu.unlam.exceptions.PlanExistenteException;
import ar.edu.unlam.exceptions.SuscripcionExistenteException;

public class SistemaDeGestion {

	private HashSet<Cliente> hashSetClientes;
	private HashSet<Canal> hashSetCanales;
	private HashSet<Plan> hashSetPlanes;
	private HashSet<Suscripcion> hashSetSuscripciones;

	public SistemaDeGestion() {
		this.hashSetClientes = new HashSet<>();
		this.hashSetCanales = new HashSet<>();
		this.hashSetPlanes = new HashSet<>();
		this.hashSetSuscripciones = new HashSet<>();
	}

	public Boolean registrarNuevoCliente(Cliente nuevoCliente) throws ClienteExistenteException {
		if (this.hashSetClientes.add(nuevoCliente)) {
			return true;
		} else {
			throw new ClienteExistenteException();
		}
	}

	public Boolean registrarNuevoCanal(Canal nuevoCanal) throws CanalExistenteException {
		if (this.hashSetCanales.add(nuevoCanal)) {
			return true;
		} else {
			throw new CanalExistenteException();
		}
	}

	public Boolean registrarNuevoPlan(Plan nuevoPlan) throws PlanExistenteException {
		if (this.hashSetPlanes.contains(nuevoPlan)) {
			throw new PlanExistenteException();
		} else {
			return this.hashSetPlanes.add(nuevoPlan);
		}
	}

	public Double obtenerPrecioPlan(Integer idPlan) {
		for (Plan p : this.hashSetPlanes) {
			if (p instanceof PlanBasico) {
				if (p.getIdPlan().equals(idPlan)) {
					return ((PlanBasico) p).obtenerCostoPlan();
				}
			} else if (p instanceof PlanPremium) {
				if (p.getIdPlan().equals(idPlan)) {
					return ((PlanPremium) p).obtenerCostoPlan();
				}
			}
		}
		return 0.0;
	}

	public TreeSet<Cliente> reportarClientesOrdenadosPorDniAscendente() {
		TreeSet<Cliente> clientesOrdenados = new TreeSet<>();
		clientesOrdenados.addAll(this.hashSetClientes);
		return (TreeSet<Cliente>) clientesOrdenados.reversed();
	}

	public Boolean registrarNuevaSuscripcion(Suscripcion nuevaSuscripcion) throws SuscripcionExistenteException {
		if (this.hashSetSuscripciones.add(nuevaSuscripcion)) {
			return true;
		} else {
			throw new SuscripcionExistenteException();
		}
	}

	public ArrayList<Cliente> obtenerClientesSuscriptosPlanesBasicos() {
		ArrayList<Suscripcion> suscripcionesPlanBasico = this.obtenerSuscripcionesPlanBasico();
		ArrayList<Cliente> clientesPlanesBasicos = new ArrayList<>();
		for (Suscripcion sub : suscripcionesPlanBasico) {
			for (Cliente clnt : this.hashSetClientes) {
				if (clnt.getDni().equals(sub.getDniClienteAsociado())) {
					clientesPlanesBasicos.add(clnt);
				}
			}
		}
		return clientesPlanesBasicos;
	}

	public ArrayList<Cliente> obtenerClientesSuscriptosPlanesPremium() {
		ArrayList<Suscripcion> suscripcionesPlanPremium = this.obtenerSuscripcionesPlanPremium();
		ArrayList<Cliente> clientesPlanesPremium = new ArrayList<>();
		for (Suscripcion sub : suscripcionesPlanPremium) {
			for (Cliente clnt : this.hashSetClientes) {
				if (clnt.getDni().equals(sub.getDniClienteAsociado())) {
					clientesPlanesPremium.add(clnt);
				}
			}
		}
		return clientesPlanesPremium;
	}

	private ArrayList<Suscripcion> obtenerSuscripcionesPlanPremium() {
		ArrayList<Suscripcion> suscripcionesPlanPremium = new ArrayList<>();
		for (Suscripcion sub : this.hashSetSuscripciones) {
			for (Plan p : this.hashSetPlanes) {
				if (p instanceof PlanPremium && sub.getIdPlanAdquirido().equals(p.getIdPlan())) {
					suscripcionesPlanPremium.add(sub);
				}
			}
		}
		return suscripcionesPlanPremium;
	}

	private ArrayList<Suscripcion> obtenerSuscripcionesPlanBasico() {
		ArrayList<Suscripcion> suscripcionesPlanBasico = new ArrayList<>();
		for (Suscripcion sub : this.hashSetSuscripciones) {
			for (Plan p : this.hashSetPlanes) {
				if (p instanceof PlanBasico && sub.getIdPlanAdquirido().equals(p.getIdPlan())) {
					suscripcionesPlanBasico.add(sub);
				}
			}
		}
		return suscripcionesPlanBasico;
	}

	public TreeMap<Plan, TreeSet<Cliente>> reporteClientesPorPlan() {
		for (Plan p : this.hashSetPlanes) {
			TreeSet<Cliente> clientesAsociadosAlPlan = new TreeSet<>(new ComparadorClientesPorDNI());
		}
		return null;
	}
}
