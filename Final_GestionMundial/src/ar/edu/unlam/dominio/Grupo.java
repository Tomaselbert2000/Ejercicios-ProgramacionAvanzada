package ar.edu.unlam.dominio;

import java.util.ArrayList;
import ar.edu.unlam.enums.LetraGrupo;

public class Grupo {

	private LetraGrupo letraDelGrupo;
	private ArrayList<Equipo> equiposDelGrupo;

	public Grupo(LetraGrupo letraDelGrupo) {
		this.letraDelGrupo = letraDelGrupo;
		this.equiposDelGrupo = new ArrayList<>();
	}

	public LetraGrupo getLetra() {
		return this.letraDelGrupo;
	}

	public ArrayList<Equipo> getEquipos() {
		return this.equiposDelGrupo;
	}

	public void agregarEquipo(Equipo equipo) {
		this.equiposDelGrupo.add(equipo);
	}

	@Override
	public String toString() {
		return "Grupo [equiposDelGrupo=" + equiposDelGrupo + "]";
	}
}
