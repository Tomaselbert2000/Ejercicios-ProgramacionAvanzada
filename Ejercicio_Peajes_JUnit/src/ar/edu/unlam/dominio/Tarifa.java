package ar.edu.unlam.dominio;

import java.time.LocalDateTime;

public class Tarifa {
	
	
	private Integer id;
	private LocalDateTime desde;
	private LocalDateTime hasta;
	private Double valor;
	
	public Tarifa(Integer id, double valor) {
		this.id = id;
		this.valor = valor;
	}
	
	public Integer getId() {
		return this.id;
	}

	public Double getValor() {
		return this.valor;
	}
	
	/*
	 * Desde		Hasta
	 * 1/7/2025		31/7/2025		Valor 1000.0
	 * 1/8/2025		2/9/2025		Valor 1100.0
	 * 3/9/2025		null			Valor 
	 */
}
