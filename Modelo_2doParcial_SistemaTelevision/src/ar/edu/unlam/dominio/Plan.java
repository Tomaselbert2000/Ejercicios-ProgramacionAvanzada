package ar.edu.unlam.dominio;

import java.util.Objects;

public abstract class Plan{

	private Integer idPlan;
	private String nombre;

	public Plan(Integer idPlan, String nombre) {
		this.idPlan = idPlan;
		this.nombre = nombre;
	}

	public Integer getIdPlan() {
		return this.idPlan;
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPlan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plan other = (Plan) obj;
		return Objects.equals(idPlan, other.idPlan);
	}
}
