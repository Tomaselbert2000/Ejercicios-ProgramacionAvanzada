package ar.edu.unlam.exceptions;

public class CantidadDeEscriturasSuperadaException extends Exception {

	private static final long serialVersionUID = -8523590547189517193L;
	private static final String message = "Limite de operaciones de escritura alcanzado.";
	
	@Override
	public String getMessage() {
		return message;
	}
}
