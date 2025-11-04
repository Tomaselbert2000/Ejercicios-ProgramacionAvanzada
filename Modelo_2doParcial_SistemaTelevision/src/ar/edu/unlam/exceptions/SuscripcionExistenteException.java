package ar.edu.unlam.exceptions;

public class SuscripcionExistenteException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String message = "Ya existe una suscripcion registrada con el ID proporcionado.";

	public String getMessage() {
		return message;
	}

}
