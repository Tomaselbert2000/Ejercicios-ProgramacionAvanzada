package ar.edu.unlam.dominio;

public class CuentaCorriente extends Cuenta implements Iextraible{
	
	private Double limiteDescubierto;
	
	public CuentaCorriente(Cliente cliente, Integer cbu, Double limiteDescubierto) {
		super(cliente, cbu);
		this.limiteDescubierto = limiteDescubierto;
	}

	@Override // implementamos la interfaz y sobreescribimos el metodo
	public Boolean extraerDeCuenta(Double montoParaExtraer) {
		if(super.getSaldo() + this.limiteDescubierto >= montoParaExtraer) {
			Double montoParaActualizar = super.getSaldo() - montoParaExtraer;
			setSaldo(montoParaActualizar);
			return true;
		}
		return false;
	}

	public void setSaldo(Double montoParaActualizar) {
		super.setSaldo(montoParaActualizar);
	}

	public Double getSaldo() {
		return super.getSaldo();
	}

}
