package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class ProductoPerecedero extends Producto implements IntFuncionesProductos{

	private LocalDate fechaDeVencimiento;

	public ProductoPerecedero(String nombre, Integer cantidad, Double precioUnitario, LocalDate fechaDeVencimiento) {
		super(nombre, cantidad, precioUnitario);
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public LocalDate getFechaVencimiento() {
		return this.fechaDeVencimiento;
	}

	@Override
	public Double obtenerPrecio() {
		Double recargo = ((super.getPrecioUnitario() * 5.0)/100);
		Double total = super.getPrecioUnitario() + recargo;
		return total;
	}

	@Override
	public Double obtenerSumaTotal() {
		return super.getCantidad() * this.obtenerPrecio();
	}
}
