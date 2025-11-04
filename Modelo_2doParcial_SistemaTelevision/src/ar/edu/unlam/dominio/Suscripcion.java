package ar.edu.unlam.dominio;

import java.util.HashSet;
import java.util.Objects;

public class Suscripcion {

	private Integer idSuscripcion;
	private Integer dniClienteAsociado;
	private Integer idPlanAdquirido;
	private HashSet<Canal> canalesIncluidos;

	public Suscripcion(Integer idSuscripcion, Integer dniClienteAsociado, Integer idPlanAdquirido,
			HashSet<Canal> canalesIncluidos) {
		this.idSuscripcion = idSuscripcion;
		this.dniClienteAsociado = dniClienteAsociado;
		this.idPlanAdquirido = idPlanAdquirido;
		this.canalesIncluidos = canalesIncluidos;
	}

	public Integer getId() {
		return this.idSuscripcion;
	}

	public Integer getDniClienteAsociado() {
		return this.dniClienteAsociado;
	}

	public Integer getIdPlanAdquirido() {
		return this.idPlanAdquirido;
	}

	public HashSet<Canal> getCanalesIncluidos() {
		return this.canalesIncluidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSuscripcion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suscripcion other = (Suscripcion) obj;
		return Objects.equals(idSuscripcion, other.idSuscripcion);
	}
}
