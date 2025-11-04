package ar.edu.unlam.exceptions;

public class CopaDelMundoDuplicadaException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String message = "Ya existe una copa del mundo con el ID ingresado.";

	public String getMessage() {
		return message;
	}

}
