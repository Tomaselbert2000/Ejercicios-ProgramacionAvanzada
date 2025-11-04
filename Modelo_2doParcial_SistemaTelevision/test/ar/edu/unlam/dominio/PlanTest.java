package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlanTest {

	@Test
	public void dadoQueExisteUnPlanBasicoDeTelevisionPorHerenciaObtengoQuePuedoConsultarSusAtributos() {
		Integer idPlan = 1;
		String nombre = "Plan Basico 1";
		PlanBasico nuevoPlanBasico = new PlanBasico(idPlan, nombre);
		assertEquals(idPlan, nuevoPlanBasico.getIdPlan());
		assertEquals(nombre, nuevoPlanBasico.getNombre());
		assertEquals(5000.0, nuevoPlanBasico.getValorBase(), 0.0);
		assertEquals(150.0, nuevoPlanBasico.getPrecioPorCanal(), 0.0);
	}
	
	@Test
	public void dadoQueExisteUnPlanPremiumDeTelevisionPorHerenciaObtengoQuePuedoConsultarSusAtributos() {
		Integer idPlan = 2;
		String nombre = "Plan Premium 1";
		PlanPremium nuevoPlanPremium = new PlanPremium(idPlan, nombre);
		assertEquals(idPlan, nuevoPlanPremium.getIdPlan());
		assertEquals(nombre, nuevoPlanPremium.getNombre());
		assertEquals(6000.0, nuevoPlanPremium.getValorBase(), 0.0);
		assertEquals(180.0, nuevoPlanPremium.getPrecioPorCanal(), 0.0);
	}
}
