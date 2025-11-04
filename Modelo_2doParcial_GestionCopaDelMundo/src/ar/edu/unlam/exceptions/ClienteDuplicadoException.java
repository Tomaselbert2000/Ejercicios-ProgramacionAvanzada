package ar.edu.unlam.exceptions;

public class ClienteDuplicadoException extends Exception{

	private static final long serialVersionUID = 1L;
	private final String message = "Ya existe un cliente con el DNI ingresado.";

	public String getMessage() {
		return message;
	}

}
