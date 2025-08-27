package ar.edu.unlam.dominio;

public class Gimnasio {
	
	private String nombre;
	
	public Gimnasio() {}
	
	public Gimnasio(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCapacidad() {
		// TODO Auto-generated method stub
		return 50;
	}
}
