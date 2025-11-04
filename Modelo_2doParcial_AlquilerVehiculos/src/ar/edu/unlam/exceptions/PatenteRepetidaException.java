package ar.edu.unlam.exceptions;

public class PatenteRepetidaException extends Exception{

	private static final long serialVersionUID = 1L;
	private final String message = "Ya existe un vehiculo registrado con la patente ingresada.";

	public String getMessage() {
		return message;
	}
	
}
