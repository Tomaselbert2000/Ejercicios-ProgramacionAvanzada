package ar.edu.unlam.exceptions;

public class CantidadLecturasSuperadaException extends Exception {
	
	private static final long serialVersionUID = -5551806197251714144L;
	private static final String message = "Limite de operaciones de lectura alcanzado.";
	
	public String getMessage() {
		return message;
	}
}
