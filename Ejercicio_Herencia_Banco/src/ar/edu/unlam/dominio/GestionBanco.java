package ar.edu.unlam.dominio;

import java.util.HashSet;

public class GestionBanco {

	private HashSet<Cliente> listaClientes;
	private HashSet<Cuenta> listaCuentas;
	
	public GestionBanco() {
		this.listaClientes = new HashSet<>();
		this.listaCuentas = new HashSet<>();
	}

	public Boolean registrarCliente(Cliente cliente) {
		return this.listaClientes.add(cliente);
	}

	public Boolean registrarCuenta(Cuenta nuevaCuenta) {
		for(Cliente cliente : this.listaClientes) {
			if(cliente.getDni().equals(nuevaCuenta.getCliente().getDni())) {
				return this.listaCuentas.add(nuevaCuenta);
			}
		}
		return false;
	}

	public Boolean procesarTransferencia(
			Integer dniDelClienteQueEnviaDinero, 
			Integer cbuBuscado,
			Double dineroATransferir) {
		// obtenemos los objetos involucrados en la transferencia
		Cuenta cuentaEmisora = this.buscarCuentaPorDniCliente(dniDelClienteQueEnviaDinero);
		Cuenta cuentaReceptora = this.buscarCuentaPorCbu(cbuBuscado);
		
		if(cuentaEmisora.getSaldo() >= dineroATransferir) { // validamos que tenga suficiente saldo
			cuentaEmisora.setSaldo(cuentaEmisora.getSaldo() - dineroATransferir);
			cuentaReceptora.depositarEnCuenta(dineroATransferir);
			return true;
		}
		return false;
	}

	public Cuenta buscarCuentaPorCbu(Integer cbuBuscado) {
		for(Cuenta cuenta : this.listaCuentas) {
			if(cuenta.getCbu().equals(cbuBuscado)) {
				return cuenta;
			}
		}
		return null;
	}

	public Cuenta buscarCuentaPorDniCliente(Integer dniDelClienteQueEnviaDinero) {
		for(Cuenta cuenta : this.listaCuentas) {
			if(cuenta.getCliente().getDni().equals(dniDelClienteQueEnviaDinero)) {
				return cuenta;
			}
		}
		return null;
	}
}
