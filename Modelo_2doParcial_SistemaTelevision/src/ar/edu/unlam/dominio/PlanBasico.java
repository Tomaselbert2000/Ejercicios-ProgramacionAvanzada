package ar.edu.unlam.dominio;

import ar.edu.unlam.interfaces.IntCalcularCostoPlan;

public class PlanBasico extends Plan implements IntCalcularCostoPlan {

	private Double valorBase;
	private double precioPorCanal;

	public PlanBasico(Integer idPlan, String nombre) {
		super(idPlan, nombre);
		this.valorBase = 5000.0;
		this.precioPorCanal = 150.0;
	}

	public Double getValorBase() {
		return this.valorBase;
	}

	public Double getPrecioPorCanal() {
		return this.precioPorCanal;
	}

	@Override
	public Double obtenerCostoPlan() {
		return this.valorBase;
	}
}
