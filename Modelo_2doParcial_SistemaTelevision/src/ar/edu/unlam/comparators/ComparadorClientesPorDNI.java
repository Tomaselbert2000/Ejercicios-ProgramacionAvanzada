package ar.edu.unlam.comparators;

import java.util.Comparator;

import ar.edu.unlam.dominio.Cliente;

public class ComparadorClientesPorDNI implements Comparator<Cliente>{

	@Override
	public int compare(Cliente arg0, Cliente arg1) {
		return arg0.compareTo(arg1);
	}
}
