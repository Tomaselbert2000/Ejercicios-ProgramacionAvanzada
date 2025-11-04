package ar.edu.unlam.dominio;

import java.util.Objects;

import ar.edu.unlam.enums.CategoriaCanalEnums;
import ar.edu.unlam.enums.ClasificacionCanalEnums;

public class Canal {

	private Short numeroCanal;
	private String nombre;
	private CategoriaCanalEnums categoria;
	private ClasificacionCanalEnums clasificacion;

	public Canal(Short numeroCanal, String nombre, CategoriaCanalEnums categoria,
			ClasificacionCanalEnums clasificacion) {
		this.numeroCanal = numeroCanal;
		this.nombre = nombre;
		this.categoria = categoria;
		this.clasificacion = clasificacion;
	}

	public Short getNumero() {
		return this.numeroCanal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public CategoriaCanalEnums getCategoria() {
		return this.categoria;
	}

	public ClasificacionCanalEnums getClasificacion() {
		return this.clasificacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroCanal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Canal other = (Canal) obj;
		return Objects.equals(numeroCanal, other.numeroCanal);
	}
}
