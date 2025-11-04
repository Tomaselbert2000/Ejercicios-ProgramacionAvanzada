package ar.edu.unlam.dominio;

import ar.edu.unlam.enums.ColorAtrilEnum;
import ar.edu.unlam.enums.MaterialEnum;
import ar.edu.unlam.interfaces.IntCalcularCostoTotal;

public class CopaDelMundoPersonalizada extends CopaDelMundo implements IntCalcularCostoTotal{

	private Double costoFabricacion;
	private ColorAtrilEnum colorAtrilElegido;
	private Double costoManoDeObra;

	public CopaDelMundoPersonalizada(Integer idCopa, Double costoFabricacion, MaterialEnum materialFabricacion, ColorAtrilEnum colorAtrilElegido) {
		super(idCopa, materialFabricacion);
		this.costoFabricacion = costoFabricacion;
		this.colorAtrilElegido = colorAtrilElegido;
		this.costoManoDeObra = 0.15;
	}

	public Double getCostoFabricacion() {
		return this.costoFabricacion;
	}

	public ColorAtrilEnum getColorAtrilElegido() {
		return this.colorAtrilElegido;
	}

	@Override
	public Double obtenerPrecioTotal() {
		Double recargoColor = 0.0;
		switch(this.colorAtrilElegido) {
		case CAOBA:
			recargoColor = this.costoFabricacion * 0.05;
			break;
		case CEDRO:
			recargoColor = this.costoFabricacion * 0.10;
			break;
		case ROBLE_OSCURO:
			recargoColor = this.costoFabricacion * 0.15;
			break;
		}
		return this.costoFabricacion + this.costoFabricacion * this.costoManoDeObra + recargoColor;
	}
}
