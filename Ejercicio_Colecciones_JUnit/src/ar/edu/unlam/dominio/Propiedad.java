package ar.edu.unlam.dominio;

public class Propiedad {

	private String tipo;
	private Integer codigo;
	private Double precio;
	private String dueño;
	private String ubicacion;

	public Propiedad(int codigo, double precio, String tipo, String ubicacion) {
		this.codigo = codigo;
		this.precio = precio;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombreDueño() {
		return this.dueño;
	}

	public void setNombreDueño(String nombreDueño) {
		this.dueño = nombreDueño;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}
