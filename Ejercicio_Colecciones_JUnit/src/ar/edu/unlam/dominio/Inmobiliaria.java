package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;

public class Inmobiliaria {

	private ArrayList<Propiedad> listaPropiedades;
	private HashSet<Cliente> listaClientes;
	
	public Inmobiliaria() {
		this.listaPropiedades = new ArrayList<Propiedad>();
		this.listaClientes = new HashSet<Cliente>();
	}
	public void registrarPropiedad(Propiedad prop) {
		this.listaPropiedades.add(prop);
	}

	public Integer getCantidadPropiedadesRegistradas() {
		return this.listaPropiedades.size();
	}
	
	public boolean registrarCliente(Cliente cliente) {
		if(!this.verificarRegistroCliente(cliente)) {
			this.listaClientes.add(cliente);
			return true;
		}
		return false;
	}
	
	public Integer getCantidadClientesRegistrados() {
		return this.listaClientes.size();
	}
	
	public ArrayList<Propiedad> getListaPropiedadesPorPrecio(double precio) {
		ArrayList<Propiedad> propiedadesFiltradasPorPrecio = new ArrayList<>();
		for(Propiedad prop : this.listaPropiedades) {
			if(prop.getPrecio() == precio){
				propiedadesFiltradasPorPrecio.add(prop);
			}
		}
		return propiedadesFiltradasPorPrecio;
	}
	
	public ArrayList<Propiedad> getListaPropiedadesPorTipo(String tipo) {
		ArrayList<Propiedad> propiedadesFiltradasPorTipo = new ArrayList<>();
		for(Propiedad prop : this.listaPropiedades) {
			if(prop.getTipo().equals(tipo)) {
				propiedadesFiltradasPorTipo.add(prop);
			}
		}
		return propiedadesFiltradasPorTipo;
	}
	public Boolean verificarRegistroCliente(Cliente cliente) {
		for(Cliente clnt : this.listaClientes) {
			if(clnt.equals(cliente)){
				return true;
			}
		}
		return false;
	}
	public void venderPropiedad(Propiedad prop) {
		this.listaPropiedades.remove(prop);
	}
	public ArrayList<Propiedad> getListaPropiedadesPorUbicacion(String ubicacion) {
		ArrayList<Propiedad> propiedadesFiltradasPorUbicacion = new ArrayList<>();
		for(Propiedad prop : this.listaPropiedades) {
			if(prop.getUbicacion().equals(ubicacion)) {
				propiedadesFiltradasPorUbicacion.add(prop);
			}
		}
		return propiedadesFiltradasPorUbicacion;
	}
}
