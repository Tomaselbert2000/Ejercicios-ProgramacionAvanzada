package ar.edu.unlam.dominio;

import java.util.Objects;

public class Carga {
	
	private Long id;
	private Double peso;
	
	public Carga(Long id, Double peso) {
		this.id = id;
		this.peso = peso;
	}
	
	public Long getId() {
		return this.id;
	}
	public Double getPeso() {
		return this.peso;
	}
	
	// sobreescribimos el metodo equals
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true; // si es el mism objeto o instancia
		}
		
		if(obj == null) {
			return false; // compara que exista el parametro
		}
		
		if(getClass() != obj.getClass()) {
			return false; // comprueba que sean de la misma clase
		}
		
		Carga other = (Carga) obj;
		
		return this.id.equals(other.id) && this.peso.equals(other.peso);
	}
	
	/*
	 * Aca sobreescribimos el metodo hashCode para que
	 * retorne el hash calculado a partir del contenido
	 * de la instancia
	 */
	
	@Override
	public int hashCode() {
		return Objects.hash(id, peso);
	}
}
