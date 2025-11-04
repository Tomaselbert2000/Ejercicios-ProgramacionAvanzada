package ar.edu.unlam.exceptions;

public class ClienteNoRegistradoException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String message = "No existe cliente con el DNI especificado.";

	public String getMessage() {
		return message;
	}

}
