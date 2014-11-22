package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.FutbolException;
import negocio.*;
import fixture.BD;


public class TestEntrega3 {
	
	public static Partido p = null;
		
	@Test
	public void proponerNuevoJugador() throws FutbolException {

		BD.init();
		
		BD.get("Jose").proponerA(new Jugador("Felipe", 1980, 5, 25));
		BD.get("Beto").proponerA(new Jugador("Fede", 1800, 4,4));

		BD.administrador().aceptar(BD.getPendiente("Felipe")); //lo busca en la BD y deberia ponerlo en "jug"
		BD.administrador().rechazar(BD.getPendiente("Fede"), "Es muy viejo"); //rechazo y motivo
		
		assertTrue(BD.estaEntreLosJugadores("Felipe"));
		assertFalse(BD.estaEntreLosJugadores("Fede"));
	}

	
	@Test
	public void calificarJugadores() throws FutbolException {
		BD.init();
		crearPartido();
		assertTrue(BD.getPartido(0).completo());

		BD.administrador().confirmarPartido(BD.getPartido(0)); //significa que ya se jugo
		
		BD.get("Jose").calificar(0, BD.get("Lucas"), 6, "Bien");
		BD.get("Jose").calificar(0, BD.get("Luis"), 9, "Bien");
		BD.get("Jose").calificar(0, BD.get("Juan"), 6);  //comm opcional
		
		BD.get("Pepe").calificar(0, BD.get("Lucas"), 1, "Mal");
		BD.get("Pepe").calificar(0, BD.get("Luis"), 5);
		BD.get("Pepe").calificar(0, BD.get("Juan"), 2, "Mal");

		assertTrue(BD.get("Lucas").calificacionesPromedio() == 3.5);
		assertTrue(BD.get("Luis").calificacionesPromedio() == 7);
		assertTrue(BD.get("Juan").calificacionesPromedio() == 4);		
	}

	
	@Test (expected = FutbolException.class)
	public void calificacionASiMismo() throws FutbolException {
		BD.init();
		crearPartido();
		BD.administrador().confirmarPartido(BD.getPartido(0));
		
		BD.get("Pepe").calificar(0, BD.get("Pepe"), 10, "Perfecto");
	}

	
	@Test (expected = FutbolException.class)
	public void calificacionDeAlguienQueNoJugo() throws FutbolException {
		BD.init();
		crearPartido();
		BD.administrador().confirmarPartido(BD.getPartido(0));
		
		BD.administrador().calificar(0, BD.get("Pepe"), 10, "Perfecto"); //este si puede
		BD.get("Leo").calificar(0, BD.get("Pepe"), 5, "Bien");
	}

	
	@Test (expected = FutbolException.class)
	public void calificacionParaAlguienQueNoJugo() throws FutbolException {
		BD.init();
		crearPartido();
		BD.administrador().confirmarPartido(BD.getPartido(0));
		
		BD.get("Leo").calificar(0, BD.get("Beto"), 5, "Bien");
	}
	
	
	private void crearPartido() throws FutbolException {
		BD.administrador().organizarNuevoPartido(2015, 1, 3, 14, 30);
		BD.get("Jose").inscribirme(BD.getPartido(0));
		BD.get("Lucas").inscribirme(BD.getPartido(0));
		BD.get("Luis").inscribirme(BD.getPartido(0));
		BD.get("Bender").inscribirme(BD.getPartido(0));
		BD.get("Ale").inscribirme(BD.getPartido(0));
		BD.get("Juan").inscribirme(BD.getPartido(0));
		BD.get("Esteban").inscribirme(BD.getPartido(0));
		BD.get("Diego").inscribirme(BD.getPartido(0));
		BD.get("Ana").inscribirme(BD.getPartido(0));
		BD.get("Pepe").inscribirme(BD.getPartido(0));
	}
		
}
