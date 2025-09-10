package ar.edu.unlam.dominio;

import java.time.LocalDateTime;

public class Tarifa {

	private Integer id;
	private LocalDateTime desde;
	private LocalDateTime hasta;
	private Double valor;

	public Tarifa(int id, LocalDateTime desde, LocalDateTime hasta) {
		this.id = id;
		this.desde = desde;
		this.hasta = hasta;
		this.valor = this.obtenerValor();
	}

	private Double obtenerValor() {
		return 1000.0;
	}

	public Integer getId() {
		return this.id;
	}

	public Double getValor() {
		return this.valor;
	}
	
	public LocalDateTime getFechaDesde() {
		return this.desde;
	}
	
	public LocalDateTime getFechaHasta() {
		return this.hasta;
	}
}
