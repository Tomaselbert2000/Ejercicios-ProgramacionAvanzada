package ar.edu.unlam.dominio;

public class Persona implements Operaciones{ // aca tenemos la superclase Persona
	
	// todos estos atributos son comunes a cualquier instancia de Persona, incluyendo a las clases que hereden de esta
	private Integer dni;
	private String nombre;
	private Integer edad;

	public Persona(Integer dni, String nombre, Integer edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}

	public Integer getDni() {
		return this.dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Integer getEdad() {
		return this.edad;
	}

	@Override
	public String toString() {
		return "Soy una persona";
	}

	@Override
	public String ayudar() {
		return "Soy una persona y estoy ayudando";
	}
}
