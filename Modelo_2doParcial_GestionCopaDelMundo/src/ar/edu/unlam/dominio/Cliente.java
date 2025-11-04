package ar.edu.unlam.dominio;

import java.util.Objects;

public class Cliente implements Comparable<Cliente>{

	private Integer dni;
	private String nombre;
	private String apellido;

	public Cliente(Integer dniCliente, String nombre, String apellido) {
		this.dni = dniCliente;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Integer getDni() {
		return this.dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public int compareTo(Cliente o) {
		if(this.dni > o.dni) {
			return 1;
		}else if(this.dni < o.dni) {
			return -1;
		}else {
			return 0;
		}
	}
}
