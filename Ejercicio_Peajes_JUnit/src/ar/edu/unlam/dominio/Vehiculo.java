package ar.edu.unlam.dominio;

public class Vehiculo {

	
	private String patente;
	private String marca;
	private String modelo;

	public Vehiculo(String patente, String marca, String modelo) {
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getPatente() {
		return this.patente;
	}

	public String getMarca() {
		return this.marca;
	}

	public String getModelo() {
		return this.modelo;
	}

}
