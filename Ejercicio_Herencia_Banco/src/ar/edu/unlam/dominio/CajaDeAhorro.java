package ar.edu.unlam.dominio;

public class CajaDeAhorro extends Cuenta implements IprocedimientosCuenta{

	public CajaDeAhorro(Cliente cliente, Integer cbu) {
		super(cliente, cbu); // con esta linea apuntamos al constructor de la superclase Cliente
	}

	@Override // implementamos la interfaz y sobreescribimos el metodo aca
	public Boolean extraerDeCuenta(Double montoParaExtraer) {
		if(this.getSaldo() >= montoParaExtraer) {
			super.setSaldo(super.getSaldo() - montoParaExtraer);
			return true;
		}
		return false;
	}
}
