package ar.edu.unlam.dominio;

public class MercadoPago extends MetodoDePago implements IntProcesamientoPagos{

	@Override
	public Double procesarPago(Double monto) {
		Double recargo = ((monto * 12.0)/100);
		return (monto + recargo);
	}

}
