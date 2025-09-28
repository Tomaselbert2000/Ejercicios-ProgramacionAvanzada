package ar.edu.unlam.dominio;

public class Asalariado extends Persona{
	
	// la clase Asalariado tiene un atributo propio el cual es el salario
	private Double salario;

	public Asalariado(Integer dni, String nombre, Integer edad, Double salario) {
		super(dni, nombre, edad);
		this.salario = salario;
	}
	
	public Double getSalario() {
		return this.salario;
	}

	@Override
	public String toString() {
		return "Soy un asalariado";
	}
}
