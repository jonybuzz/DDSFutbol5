package tests.entrega1;

import static org.junit.Assert.*;
import org.junit.Test;
/*
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
*/
import negocio.*;
import negocio.inscripcion.*;
import fixture.BaseDatos;

/**
 *
 */
public class TestOrganizarPartido {

	public static BaseDatos bd;
	Partido partidoPrueba;

	public TestOrganizarPartido() {
	}
	
	
	@Test(expected = Exception.class)
	public void partidoPasado() throws Exception {
		bd = new BaseDatos();

		@SuppressWarnings("unused")
		Partido partidoMalo = ((Administrador) bd.mario).organizarNuevoPartido(2004, 6, 18, 15, 30);
	}
	
	@Test(expected = Exception.class)
	public void nacimientoFuturo() throws Exception {
		
		@SuppressWarnings("unused")
		Jugador jugadorMalo = new Jugador("Terminator", 2100, 5, 1);
	}


	@Test
	public void inscripcion() throws Exception {

		bd = new BaseDatos();

		partidoPrueba = ((Administrador) bd.mario).organizarNuevoPartido(2014, 6, 18, 15, 30);
		
		bd.mario.inscribirme(partidoPrueba);
		bd.jose.inscribirme(partidoPrueba);
		bd.lucas.inscribirme(partidoPrueba);
		bd.luis.modoDeInscrpcion(new Condicional("juego si esta nublado"));
		bd.luis.inscribirme(partidoPrueba);
		bd.bender.inscribirme(partidoPrueba);
		bd.ale.inscribirme(partidoPrueba);
		
		bd.juan.modoDeInscrpcion(new Condicional("juego si hace frio"));
		assertTrue(bd.juan.getModoDeInscripcion().prioridad==2);
		
		assertFalse(partidoPrueba.estaCompleto());
		
		bd.juan.inscribirme(partidoPrueba);
		bd.esteban.inscribirme(partidoPrueba);
		bd.diego.inscribirme(partidoPrueba);
		bd.ana.inscribirme(partidoPrueba);
		
		assertFalse(partidoPrueba.estaCompleto());

		bd.pepe.modoDeInscrpcion(new Condicional("juego si hay alguno de mi edad"));
		bd.pepe.inscribirme(partidoPrueba);
		assertTrue(bd.pepe.edad() == bd.lucas.edad());

		bd.lionel.inscribirme(partidoPrueba);
		bd.leo.inscribirme(partidoPrueba);

		assertTrue(partidoPrueba.estaCompleto());

	}

}
