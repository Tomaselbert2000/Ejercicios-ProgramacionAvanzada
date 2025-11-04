package ar.edu.unlam.exceptions;

public class PlanExistenteException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String message = "Ya existe un plan con el ID especificado.";

	@Override
	public String getMessage() {
		return message;
	}

}
