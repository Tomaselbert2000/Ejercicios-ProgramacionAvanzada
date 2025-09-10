package ar.edu.unlam.dominio;

public class TipoVehiculo {
	
	private Integer id;
	private String descripcion;
	
	public TipoVehiculo(Integer id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public Integer getId() {
		return this.id;
	}

}
