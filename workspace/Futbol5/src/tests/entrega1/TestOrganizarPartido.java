package tests.entrega1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import negocio.*;
import negocio.inscripcion.*;

/**
 *
 */
public class TestOrganizarPartido {
	
	static Jugador mario;
	static Jugador jose;
	static Jugador lucas;
	static Jugador luis;
	static Jugador bender;
	static Jugador ale;
	static Jugador juan;
	static Jugador esteban;
	static Jugador diego;
	static Jugador ana;
	static Jugador pepe;
	static Jugador lionel;
	static Jugador leo;

	public TestOrganizarPartido() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void inicializacionFixture() throws Exception {
		
		mario = new Jugador("Mario", 1985, 5, 20);
		jose = new Jugador("Jose", 1989, 6, 20);
		lucas = new Jugador("Lucas", 1994, 5, 20);
		luis = new Jugador("Luis", 1900, 5, 20);
		bender = new Jugador("Bender", 2010, 5, 20);
		ale = new Jugador("Ale", 1995, 5, 20);
		juan = new Jugador("Juan", 1987, 5, 20);
		esteban = new Jugador("Esteban", 1985, 5, 20);
		diego = new Jugador("Diego", 1980, 5, 20);
		ana = new Jugador("Ana", 1989, 5, 20);
		pepe = new Jugador("Pepe", 1994, 1, 10);
		lionel = new Jugador("Lionel", 1999, 5, 20);
		leo = new Jugador("Leo", 1996, 5, 20);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
/*
	@Test
	public void crearPartido() throws Exception {
		
		//fail("Not yet implemented");
		Partido partidoPrueba = new Partido(2014, 6, 18, 15, 30);
		assertFalse(partidoPrueba.listo());
		
		partidoPrueba.agregarJugador(mario, 1);
		partidoPrueba.agregarJugador(jose, 1);
		partidoPrueba.agregarJugador(lucas, 1);
		partidoPrueba.agregarJugador(luis, 1);
		partidoPrueba.agregarJugador(bender, 1);
		partidoPrueba.agregarJugador(ale, 1);
		partidoPrueba.agregarJugador(juan, 1);
		partidoPrueba.agregarJugador(esteban, 1);
		partidoPrueba.agregarJugador(diego, 1);
		partidoPrueba.agregarJugador(ana, 1);
		
		assertTrue(partidoPrueba.listo());

	}
*/
	
	@Test
	public void inscripcion() throws Exception {
		
		Partido partidoPrueba = new Partido(2014, 6, 18, 15, 30);
		
		mario.inscribirme(partidoPrueba);
		jose.inscribirme(partidoPrueba);
		lucas.inscribirme(partidoPrueba);
		luis.modoDeInscrpcion(new Condicional("juego si esta nublado"));
		luis.inscribirme(partidoPrueba);
		bender.inscribirme(partidoPrueba);
		ale.inscribirme(partidoPrueba);
		juan.modoDeInscrpcion(new Condicional("juego si hace frio"));
		assertTrue(juan.getModoDeInscripcion().prioridad==2);
		juan.inscribirme(partidoPrueba);
		esteban.inscribirme(partidoPrueba);
		diego.inscribirme(partidoPrueba);
		ana.inscribirme(partidoPrueba);
		
		assertFalse(partidoPrueba.estaCompleto());

		pepe.modoDeInscrpcion(new Condicional("juego si hay alguno de mi edad"));
		pepe.inscribirme(partidoPrueba);
		assertTrue(pepe.edad() == lucas.edad());

		lionel.inscribirme(partidoPrueba);
		lionel.inscribirme(partidoPrueba);

		assertTrue(partidoPrueba.estaCompleto());

	}

}
