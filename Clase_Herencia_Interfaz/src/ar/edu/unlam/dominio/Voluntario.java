package ar.edu.unlam.dominio;

public class Voluntario extends Persona{

	// la clase Voluntario tiene un atributo propio el cual es la cantidad de horas
	private Integer cantidadHoras;

	public Voluntario(Integer dni, String nombre, Integer edad, Integer cantidadHoras) {
		super(dni, nombre, edad);
		this.cantidadHoras = cantidadHoras;
	}
	
	public Integer getCantidadHoras() {
		return this.cantidadHoras;
	}

	@Override
	public String toString() {
		return "Soy un voluntario";
	}
}
