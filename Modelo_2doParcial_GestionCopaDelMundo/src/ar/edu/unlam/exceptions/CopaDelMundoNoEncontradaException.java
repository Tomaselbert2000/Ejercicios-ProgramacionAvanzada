package ar.edu.unlam.exceptions;

public class CopaDelMundoNoEncontradaException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String message = "No se encontraron objetos con el ID especificado.";

	public String getMessage() {
		return message;
	}

}
