package ar.edu.unlam.exceptions;

public class EquipoDuplicadoException extends Exception{

	private static final long serialVersionUID = 1L;
	private static final String message = "No es posible operar con equipos duplicados.";
	
	@Override
	public String getMessage() {
		return message;
	}
}