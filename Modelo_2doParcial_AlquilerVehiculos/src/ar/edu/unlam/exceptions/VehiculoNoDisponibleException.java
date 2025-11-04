package ar.edu.unlam.exceptions;

public class VehiculoNoDisponibleException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String message = "El vehiculo seleccionado no se encuentra disponible.";

	public String getMessage() {
		return message;
	}

}
