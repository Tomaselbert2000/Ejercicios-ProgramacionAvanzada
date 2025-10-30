package ar.edu.unlam.subClasses;

import ar.edu.unlam.dominio.abstractClasses.VirtualMachine;
import ar.edu.unlam.interfaces.IntObtenerCostoExtra;

public class VMAlmacenamientoDeImagenes extends VirtualMachine implements IntObtenerCostoExtra{

	private final Integer limiteOperacionesDeLectura;
	private final Integer limiteOperacionesDeEscritura;
	private Integer operacionesDeLecturaRealizadas;
	private Integer operacionesDeEscrituraRealizadas;

	public VMAlmacenamientoDeImagenes(Integer idVM, Integer idUsuarioAsociado, Integer limiteOperacionesDeLectura, Integer limiteOperacionesDeEscritura) {
		super(idVM, idUsuarioAsociado);
		super.almacenamientoGB = 5.0;
		super.costoInicial = 500.0;
		this.limiteOperacionesDeLectura = limiteOperacionesDeLectura;
		this.limiteOperacionesDeEscritura = limiteOperacionesDeEscritura;
		this.operacionesDeLecturaRealizadas = 0;
		this.operacionesDeEscrituraRealizadas = 0;
	}

	public Integer getLimiteOperacionesDeLectura() {
		return this.limiteOperacionesDeLectura;
	}

	public Integer getLimiteOperacionesEscritura() {
		return this.limiteOperacionesDeEscritura;
	}

	@Override
	public Double obtenerCostosExtra() {
		return this.costoInicial + this.operacionesDeLecturaRealizadas + (this.operacionesDeEscrituraRealizadas * 2);
	}

	public void registrarOperacionesDeLectura(Integer operacionesLecturaRealizadas) {
		this.operacionesDeLecturaRealizadas += operacionesLecturaRealizadas;
	}

	public void registrarOperacionesDeEscritura(Integer operacionesEscrituraRealizadas) {
		this.operacionesDeEscrituraRealizadas += operacionesEscrituraRealizadas;
	}

	public Integer obtenerCantidadDeLecturasRealizadas() {
		return this.operacionesDeLecturaRealizadas;
	}
	
	public Integer obtenerCantidadDeEscriturasRealizadas() {
		return this.operacionesDeEscrituraRealizadas;
	}

	public Integer obtenerEscriturasRestantes() {
		return this.limiteOperacionesDeEscritura - this.operacionesDeEscrituraRealizadas;
	}

	public Integer obtenerLecturasRestantes() {
		return this.limiteOperacionesDeLectura - this.operacionesDeLecturaRealizadas;
	}

	@Override
	public String toString() {
		return "DNI Usuario asociado: " + this.getDniUsuarioAsociado() + " Costo total: $" + this.obtenerCostosExtra();
	}
}
