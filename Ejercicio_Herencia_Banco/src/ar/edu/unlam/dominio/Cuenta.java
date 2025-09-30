package ar.edu.unlam.dominio;

public abstract class Cuenta { // dado que en ningun momento instanciamos esta clase, directamente podemos hacerla abstracta
	
	// creamos una superclase Cuenta de la cual van a heredar tanto CuentaCorriente como CajaDeAhorro
	
	private Cliente cliente;
	private Integer cbu;
	private Double saldo;

	public Cuenta(Cliente cliente, Integer cbu) {
		this.cliente = cliente;
		this.cbu = cbu;
		this.saldo = 0.0; // para cada cuenta nueva el saldo se debe inicializar como 0.0
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void depositarEnCuenta(Double montoParaDepositar) {
		this.saldo += montoParaDepositar;
	}

	public abstract Boolean extraerDeCuenta(Double montoParaExtraer); // como este metodo es abstracto, cada clase lo implementa como sea mejor

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
