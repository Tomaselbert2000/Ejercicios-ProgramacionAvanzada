package ar.edu.unlam.dominio.abstractClasses;

public abstract class VirtualMachine{
	private Integer idVM;
	protected Double almacenamientoGB;
	protected Double costoInicial;
	private Integer dniUsuarioAsociado;
	private Double almacenamientoUsadoEnTotal;

	public VirtualMachine(Integer idVM, Integer idUsuarioAsociado) {
		this.idVM = idVM;
		this.dniUsuarioAsociado = idUsuarioAsociado;
		this.almacenamientoUsadoEnTotal = 0.0;
	}

	public Integer getId() {
		return this.idVM;
	}

	public Double getAlmacenamientoUsadoActualmente() {
		return this.almacenamientoUsadoEnTotal;
	}

	public Double getCostoInicial() {
		return this.costoInicial;
	}

	public Integer getDniUsuarioAsociado() {
		return this.dniUsuarioAsociado;
	}

	public void usarAlmacenamiento(Double almacenamientoQueVoyAUsar) {
		this.almacenamientoUsadoEnTotal += almacenamientoQueVoyAUsar;
	}
}