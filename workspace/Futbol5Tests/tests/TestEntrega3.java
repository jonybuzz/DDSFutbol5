package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.FutbolException;
import negocio.*;
import fixture.BD;


public class TestEntrega3 {
	
	public static Partido partidoPrueba;
		
	@Test
	public void proponerNuevoJugador() throws Exception {

		BD.init();
		
		BD.jug.get("Jose").proponerA(new Jugador("Felipe", 1980, 5, 25));
		BD.jug.get("Beto").proponerA(new Jugador("Fede", 1800, 4,4));

		BD.administrador().aceptar(BD.pendientes.get("Felipe")); //lo busca en la BD y deberia ponerlo en "jug"
		BD.administrador().rechazar(BD.pendientes.get("Fede"), "Es muy viejo"); //rechazo y motivo
		
		assertTrue(BD.jug.containsKey("Felipe"));
		assertFalse(BD.jug.containsKey("Fede"));
	}

	
	@Test
	public void calificarJugadores() throws Exception {
		BD.init();
		partidoPrueba = crearPartido();
		assertTrue(partidoPrueba.completo());

		BD.administrador().confirmarPartido(partidoPrueba); //significa que ya se jugo
		
		BD.jug.get("Jose").calificar(partidoPrueba, BD.jug.get("Lucas"), 6, "Bien");
		BD.jug.get("Jose").calificar(partidoPrueba, BD.jug.get("Luis"), 9, "Bien");
		BD.jug.get("Jose").calificar(partidoPrueba, BD.jug.get("Juan"), 6);  //comm opcional
		
		BD.jug.get("Pepe").calificar(partidoPrueba, BD.jug.get("Lucas"), 1, "Mal");
		BD.jug.get("Pepe").calificar(partidoPrueba, BD.jug.get("Luis"), 5);
		BD.jug.get("Pepe").calificar(partidoPrueba, BD.jug.get("Juan"), 2, "Mal");

		assertTrue(BD.jug.get("Lucas").calificacionesPromedio() == 3.5);
		assertTrue(BD.jug.get("Luis").calificacionesPromedio() == 7);
		assertTrue(BD.jug.get("Juan").calificacionesPromedio() == 4);		
	}

	
	@Test (expected = FutbolException.class)
	public void calificacionASiMismo() throws Exception {
		BD.init();
		partidoPrueba = crearPartido();
		BD.administrador().confirmarPartido(partidoPrueba);
		
		BD.jug.get("Pepe").calificar(partidoPrueba, BD.jug.get("Pepe"), 10, "Perfecto");
	}

	
	@Test (expected = FutbolException.class)
	public void calificacionDeAlguienQueNoJugo() throws Exception {
		BD.init();
		partidoPrueba = crearPartido();
		BD.administrador().confirmarPartido(partidoPrueba);
		
		BD.administrador().calificar(partidoPrueba, BD.jug.get("Pepe"), 10, "Perfecto"); //este si puede
		BD.jug.get("Leo").calificar(partidoPrueba, BD.jug.get("Pepe"), 5, "Bien");
	}

	
	@Test (expected = FutbolException.class)
	public void calificacionParaAlguienQueNoJugo() throws Exception {
		BD.init();
		partidoPrueba = crearPartido();
		BD.administrador().confirmarPartido(partidoPrueba);
		
		BD.jug.get("Leo").calificar(partidoPrueba, BD.jug.get("Beto"), 5, "Bien");
	}
	
	
	private Partido crearPartido() throws Exception {
		partidoPrueba = BD.administrador().organizarNuevoPartido(2015, 1, 3, 14, 30);
		BD.jug.get("Jose").inscribirme(partidoPrueba);
		BD.jug.get("Lucas").inscribirme(partidoPrueba);
		BD.jug.get("Luis").inscribirme(partidoPrueba);
		BD.jug.get("Bender").inscribirme(partidoPrueba);
		BD.jug.get("Ale").inscribirme(partidoPrueba);
		BD.jug.get("Juan").inscribirme(partidoPrueba);
		BD.jug.get("Esteban").inscribirme(partidoPrueba);
		BD.jug.get("Diego").inscribirme(partidoPrueba);
		BD.jug.get("Ana").inscribirme(partidoPrueba);
		BD.jug.get("Pepe").inscribirme(partidoPrueba);
		return partidoPrueba;
	}
		
}
