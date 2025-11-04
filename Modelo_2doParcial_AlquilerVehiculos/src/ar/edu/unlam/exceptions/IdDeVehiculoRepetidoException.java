package ar.edu.unlam.exceptions;

public class IdDeVehiculoRepetidoException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String message = "Ya existe un vehiculo con el ID ingresado.";

	public String getMessage() {
		return message;
	}

}
