package ar.edu.unlam.exceptions;

public class UsuarioDuplicadoException extends Exception {
	private static final long serialVersionUID = -9082704117627173917L;
	private static final String message = "El correo ingresado ya fue usado por otro usuario";
	
	@Override
	public String getMessage() {
		return message;
	}
}
