package ar.edu.unlam.exceptions;

public class CanalExistenteException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String message = "Ya existe un canal con el numero proporcionado.";

	public String getMessage() {
		return message;
	}
}
