package ar.edu.unlam.dominio;

public interface IprocedimientosCuenta {
	
	// con esta interfaz implementamos que cada clase deba hacer override con su propio metodo para extraer
	// basado en las condiciones en las que cada tipo permite extraer dinero
	
	public Boolean extraerDeCuenta(Double montoParaExtraer);
}
