package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import java.util.HashSet;
import org.junit.Test;

public class SuscripcionTest {

	@Test
	public void dadoQueExisteUnaSuscripcionObtengoQuePuedoConsultarSusAtributos() {
		Integer idSuscripcion = 1;
		Integer dniCliente = 10;
		Integer idPlanAdquirido = 1;
		HashSet<Canal> canalesIncluidos = new HashSet<>();
		Suscripcion nuevaSuscripcion = new Suscripcion(idSuscripcion, dniCliente, idPlanAdquirido, canalesIncluidos);
		assertEquals(idSuscripcion, nuevaSuscripcion.getId());
		assertEquals(dniCliente, nuevaSuscripcion.getDniClienteAsociado());
		assertEquals(idPlanAdquirido, nuevaSuscripcion.getIdPlanAdquirido());
		assertEquals(canalesIncluidos, nuevaSuscripcion.getCanalesIncluidos());
	}
}
