package ar.edu.unlam.dominio;

import ar.edu.unlam.interfaces.IntCalcularCostoPlan;

public class PlanPremium extends Plan implements IntCalcularCostoPlan {

	private double valorBase;
	private double porcentajeRecargoServicioPremium;
	private double precioPorCanalPremium;

	public PlanPremium(Integer idPlan, String nombre) {
		super(idPlan, nombre);
		this.valorBase = 5000.0;
		this.porcentajeRecargoServicioPremium = 0.2;
		this.precioPorCanalPremium = 180.0;
	}

	public Double getValorBase() {
		return this.valorBase + (this.valorBase * this.porcentajeRecargoServicioPremium);
	}

	public Double getPrecioPorCanal() {
		return this.precioPorCanalPremium;
	}

	@Override
	public Double obtenerCostoPlan() {
		return this.valorBase + this.valorBase * this.porcentajeRecargoServicioPremium;
	}
}
