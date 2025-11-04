package ar.edu.unlam.dominio;

import ar.edu.unlam.enums.MaterialEnum;

public class CopaDelMundo {

	private Integer idCopa;
	private MaterialEnum materialFabricacion;

	public CopaDelMundo(Integer idCopa, MaterialEnum materialFabricacion) {
		this.idCopa = idCopa;
		this.materialFabricacion = materialFabricacion;
	}

	public Integer getId() {
		return this.idCopa;
	}

	public MaterialEnum getMaterialFabricacion() {
		return this.materialFabricacion;
	}
}
