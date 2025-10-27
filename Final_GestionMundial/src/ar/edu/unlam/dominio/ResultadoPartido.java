package ar.edu.unlam.dominio;

import ar.edu.unlam.enums.ResultadoPartidoEnum;

public class ResultadoPartido {

	private Integer idPartidoAsociado;
	private Integer golesLocal;
	private Integer golesVisitante;
	private Integer penalesConvertidosLocal;
	private Integer penalesConvertidosVisitante;

	public ResultadoPartido(Integer idPartidoAsociado, Integer golesLocal, Integer golesVisitante) {
		this.idPartidoAsociado = idPartidoAsociado;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}

	public ResultadoPartido(Integer idPartidoAsociado, Integer golesLocal, Integer golesVisitante,
			Integer penalesConvertidosLocal, Integer penalesConvertidosVisitante) {
		this.idPartidoAsociado = idPartidoAsociado;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.penalesConvertidosLocal = penalesConvertidosLocal;
		this.penalesConvertidosVisitante = penalesConvertidosVisitante;
	}

	public Integer getId() {
		return this.idPartidoAsociado;
	}

	public Integer getGolesAnotadosLocal() {
		return this.golesLocal;
	}

	public Integer getGolesAnotadosVisitante() {
		return this.golesVisitante;
	}

	public Integer getPenalesConvertidosLocal() {
		return this.penalesConvertidosLocal;
	}

	public Integer getPenalesConvertidosVisitante() {
		return this.penalesConvertidosVisitante;
	}

	public ResultadoPartidoEnum getResultado() {
		if (this.penalesConvertidosLocal != null && this.penalesConvertidosVisitante != null) {
			if (this.penalesConvertidosLocal > this.penalesConvertidosVisitante) {
				return ResultadoPartidoEnum.GANA_LOCAL;
			} else {
				return ResultadoPartidoEnum.GANA_VISITANTE;
			}
		} else {
			if (this.golesLocal > this.golesVisitante) {
				return ResultadoPartidoEnum.GANA_LOCAL;
			} else if (this.golesLocal < this.golesVisitante) {
				return ResultadoPartidoEnum.GANA_VISITANTE;
			} else {
				return ResultadoPartidoEnum.EMPATE;
			}
		}
	}
}
