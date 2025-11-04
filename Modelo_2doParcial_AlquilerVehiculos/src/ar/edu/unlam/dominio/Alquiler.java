package ar.edu.unlam.dominio;

public class Alquiler {

	private Integer nroAlquiler;
	private Integer dniClienteAsociado;
	private Integer idVehiculoAlquilado;
	private Double cantidadHorasAlquiladas;
	private Double precioTotal;

	public Alquiler(Integer nroAlquiler, Integer dniClienteAsociado, Integer idVehiculoAlquilado,
			Double cantidadDeHorasAlquiladas) {
		this.nroAlquiler = nroAlquiler;
		this.dniClienteAsociado = dniClienteAsociado;
		this.idVehiculoAlquilado = idVehiculoAlquilado;
		this.cantidadHorasAlquiladas = cantidadDeHorasAlquiladas;
	}

	public Integer getNroAlquiler() {
		return this.nroAlquiler;
	}

	public Integer getDniClienteAsociado() {
		return this.dniClienteAsociado;
	}

	public Integer getIdVehiculoAlquilado() {
		return this.idVehiculoAlquilado;
	}

	public Double getCantidadHorasAlquiladas() {
		return this.cantidadHorasAlquiladas;
	}

	public Double getPrecioTotalAlquiler() {
		return this.precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

}
