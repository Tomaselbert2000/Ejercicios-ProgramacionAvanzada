package ar.edu.unlam.dominio;

import java.util.ArrayList;

public class Cliente {

	private String nombre;
	private String apellido;
	private ArrayList<Propiedad> listaDePropiedadesCompradas;

	public Cliente(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.listaDePropiedadesCompradas = new ArrayList<Propiedad>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void comprarPropiedad(Propiedad prop) {
		this.listaDePropiedadesCompradas.add(prop);
		prop.setNombreDueño(this.getNombre()+this.getApellido());
	}

	public Integer getCantidadPropiedades() {
		return this.listaDePropiedadesCompradas.size();
	}
}
