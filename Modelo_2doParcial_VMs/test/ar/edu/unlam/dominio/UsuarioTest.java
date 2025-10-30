package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UsuarioTest {
	
	@Test
	public void dadoQueExisteUnUsuarioDeVMobtengoQuePuedoConsultarSusAtributos() {
		Integer dniUsuario = 1;
		String correoUsuario = "tomas@gmail.com";
		String password = "123456";
		Usuario nuevoUsuario = new Usuario(dniUsuario, correoUsuario, password);
		
		assertEquals(dniUsuario, nuevoUsuario.getDni());
		assertEquals(correoUsuario, nuevoUsuario.getCorreo());
		assertEquals(password, nuevoUsuario.getPassword());
	}
}
