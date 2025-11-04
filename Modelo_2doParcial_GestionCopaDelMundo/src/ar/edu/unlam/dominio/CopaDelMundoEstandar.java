package ar.edu.unlam.dominio;

import ar.edu.unlam.enums.MaterialEnum;
import ar.edu.unlam.interfaces.IntCalcularCostoTotal;

public class CopaDelMundoEstandar extends CopaDelMundo implements IntCalcularCostoTotal{

	private Double costoFabricacion;
	private Double costoManoDeObra;
	

	public CopaDelMundoEstandar(Integer idCopa, Double costoFabricacion, MaterialEnum materialFabricacion) {
		super(idCopa, materialFabricacion);
		this.costoFabricacion = costoFabricacion;
		this.costoManoDeObra = 0.20;
	}

	public Double getCostoFabricacion() {
		return this.costoFabricacion;
	}

	@Override
	public Double obtenerPrecioTotal() {
		return this.costoFabricacion + (this.costoFabricacion * this.costoManoDeObra);
	}
}
