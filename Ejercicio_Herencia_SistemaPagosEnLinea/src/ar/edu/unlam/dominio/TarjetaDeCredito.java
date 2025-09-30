package ar.edu.unlam.dominio;

public class TarjetaDeCredito extends MetodoDePago implements IntProcesamientoPagos{

	private Double limiteCredito;

	public TarjetaDeCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	@Override
	public Double procesarPago(Double monto) {
		Double recargoTarjeta = ((monto * 22.7)/100);
		Double total = monto + recargoTarjeta;
		if(this.limiteCredito >= total) {
			return total;
		}
		return -1.0;
	}
}
