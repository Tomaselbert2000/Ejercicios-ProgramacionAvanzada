package ar.edu.unlam.subClasses;

import ar.edu.unlam.dominio.abstractClasses.VirtualMachine;
import ar.edu.unlam.interfaces.IntObtenerCostoExtra;

public class VMBaseDeDatos extends VirtualMachine implements IntObtenerCostoExtra {

	private final static Double precioPorGB = 10.0;
	private final static Double precioPorHoraDeUso = 5.0;
	private final static Double costoInicial = 1000.0;
	private final static Double almacenamientoBase = 20.0;
	private Double limiteMensualHorasDeUso;
	private Double cantidadHorasUsadas;

	public VMBaseDeDatos(Integer idVM, Integer idUsuarioAsociado, Double limiteMensualHorasDeUso) {
		super(idVM, idUsuarioAsociado);
		super.almacenamientoGB = almacenamientoBase;
		super.costoInicial = costoInicial;
		this.cantidadHorasUsadas = 0.0;
		this.limiteMensualHorasDeUso = limiteMensualHorasDeUso;
	}

	public Double getLimiteMensualHorasDeUso() {
		return this.limiteMensualHorasDeUso;
	}

	@Override
	public Double obtenerCostosExtra() {
		return costoInicial + (this.cantidadHorasUsadas * precioPorHoraDeUso) + (super.getAlmacenamientoUsadoActualmente() * precioPorGB);
	}

	public void registrarHorasDeUso(Double cantidadDeHorasQueUseLaVM) {
		this.cantidadHorasUsadas += cantidadDeHorasQueUseLaVM;
	}

	public Double getHorasRestanteHastaLimite() {
		return this.limiteMensualHorasDeUso - this.cantidadHorasUsadas;
	}
	
	@Override
	public String toString() {
		return "DNI Usuario asociado: " + this.getDniUsuarioAsociado() + " Costo total: $" + this.obtenerCostosExtra();
	}
}
