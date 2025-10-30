package ar.edu.unlam.exceptions;

public class CantidadDeHorasDeUsoExcedidaException extends Exception {

	private static final long serialVersionUID = -4711056111179279041L;
	private static final String message = "Se ha alcanzado el limite de horas de uso de la VM";
	
	@Override
	public String getMessage() {
		return message;
	}
}
