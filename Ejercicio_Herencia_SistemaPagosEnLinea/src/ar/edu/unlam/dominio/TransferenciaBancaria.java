package ar.edu.unlam.dominio;

public class TransferenciaBancaria extends MetodoDePago implements IntProcesamientoPagos{

	@Override
	public Double procesarPago(Double monto) {
		if(monto > 100000.0) {
			Double costoTransaccion = (monto * 1.0)/100;
			return monto + costoTransaccion;
		}
		return monto;
	}
}
