package ar.edu.unlam.dominio;

import java.util.Objects;

public class Partido {

	private Integer idPartido;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;

	public Partido(Integer idPartido, Equipo equipoLocal, Equipo equipoVisitante) {
		this.idPartido = idPartido;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
	}

	public Integer getId() {
		return this.idPartido;
	}

	public Equipo getEquipoLocal() {
		return this.equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return this.equipoVisitante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipoLocal, equipoVisitante);
	}

	/*
	 * Para poder cumplir con la consigna del test que arroja una
	 * PartidoJugadoException es necesario poder diferenciar a los partidos por sus
	 * equipos participantes, por lo tanto aca sobreescribimos hashCode() e equals()
	 * para reflejar ese criterio
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(equipoLocal, other.equipoLocal) && Objects.equals(equipoVisitante, other.equipoVisitante);
	}
}
