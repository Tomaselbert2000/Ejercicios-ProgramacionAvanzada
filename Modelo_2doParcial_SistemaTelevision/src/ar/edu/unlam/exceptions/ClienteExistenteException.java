package ar.edu.unlam.exceptions;

public class ClienteExistenteException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String message = "Ya existe un cliente con el DNI proporcionado.";

	public String getMessage() {
		return message;
	}
}
