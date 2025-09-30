package ar.edu.unlam.dominio;

public interface IntProcesamientoPagos {
	
	// todos los metodos de pago deben implementar esto
	public Double procesarPago(Double monto);
}
