package ar.edu.unlam.exceptions;

public class PartidoJugadoException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String message = "Este partido ya fue jugado";

	@Override
	public String getMessage() {
		return message;
	}
}
