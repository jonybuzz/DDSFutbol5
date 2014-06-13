package tests;

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
import fixture.BD;


public class TestEntrega2 {

	public static BD bd;
	public static Partido partidoPrueba;

	public TestEntrega2() {
	}
	

	@Test
	public void bajaYMails() throws Exception {

		BD.init();

		partidoPrueba = BD.mario.organizarNuevoPartido(2014, 6, 18, 15, 30);
		
		BD.mario.inscribirme(partidoPrueba);					//1
		BD.jose.inscribirme(partidoPrueba);						//2
		BD.lucas.inscribirme(partidoPrueba);					//3
		BD.luis.modoDeInscrpcion(new Condicional("juego si esta nublado"));
		BD.luis.inscribirme(partidoPrueba);
		BD.bender.inscribirme(partidoPrueba);					//4
		BD.ale.inscribirme(partidoPrueba);						//5
		BD.juan.modoDeInscrpcion(new Solidaria());
		BD.juan.inscribirme(partidoPrueba);		
		BD.esteban.inscribirme(partidoPrueba);					//6
		BD.diego.inscribirme(partidoPrueba);					//7
		BD.ana.inscribirme(partidoPrueba);						//8
		BD.pepe.modoDeInscrpcion(new Condicional("juego si hay alguno de mi edad"));
		BD.pepe.inscribirme(partidoPrueba);

		assertFalse(BD.mario.recibiMail);

		BD.lionel.inscribirme(partidoPrueba);					//9
		BD.leo.inscribirme(partidoPrueba);						//10
		
		assertTrue(BD.mario.recibiMail);
		System.out.print("====MAIL DE CONFIRMACION====\n");
		System.out.print(BD.mario.casilla.message+"\n");
		assertTrue(BD.mario.casilla.subject == "[Futbol5] Partido Confirmado");
		
		BD.esteban.darmeDeBaja("estoy enfermo");				//9 otra vez
		
		assertFalse(partidoPrueba.confirmado());
		System.out.print("====MAIL DE BAJA====\n");
		System.out.print(BD.mario.casilla.message+"\n");
		assertTrue(BD.mario.casilla.subject == "[Futbol5] Partido Incompleto");
		
		BD.gero.inscribirme(partidoPrueba);						//10
		assertTrue(partidoPrueba.confirmado());
		
		BD.jose.darmeDeBaja("");								//9
		assertFalse(partidoPrueba.confirmado());
		BD.diego.darmeDeBaja(BD.esteban);						//todavia 9
		assertFalse(partidoPrueba.confirmado());

	}
	
	@Test
	public void testInfraccion() throws Exception {
		BD.init();

		partidoPrueba = BD.mario.organizarNuevoPartido(2014, 6, 25, 17, 0);
		
		BD.mario.inscribirme(partidoPrueba);					//1
		BD.jose.inscribirme(partidoPrueba);						//2
		BD.lucas.inscribirme(partidoPrueba);					//3
		BD.luis.modoDeInscrpcion(new Condicional("juego si esta nublado"));
		BD.luis.inscribirme(partidoPrueba);
		BD.bender.inscribirme(partidoPrueba);					//4
		BD.ale.inscribirme(partidoPrueba);						//5
		BD.juan.modoDeInscrpcion(new Solidaria());
		BD.juan.inscribirme(partidoPrueba);		
		BD.esteban.inscribirme(partidoPrueba);					//6
		BD.diego.inscribirme(partidoPrueba);					//7
		BD.ana.inscribirme(partidoPrueba);						//8
		BD.pepe.inscribirme(partidoPrueba);						//9
		
		BD.esteban.darmeDeBaja("estoy enfermo");				//8
		assertTrue(BD.esteban.infracciones.size() == 1);
						
		BD.jose.darmeDeBaja(BD.gero);							//8
		assertTrue(BD.jose.infracciones.isEmpty());

		BD.diego.darmeDeBaja(BD.esteban);						//8
		assertTrue(BD.diego.infracciones.isEmpty());

	}
	
	@Test
	public void testNotificarAmigos() throws Exception {
		BD.init();
		partidoPrueba = BD.mario.organizarNuevoPartido(2014, 6, 27, 17, 0);
		
		BD.mario.agregarAmigos(BD.ale, BD.ana,BD.bender);
		assertTrue(BD.mario.amigos.size() == 3);
		assertTrue(BD.ana.amigos.size() == 1);
		
		BD.mario.inscribirme(partidoPrueba);
		
		System.out.print(BD.ana.casilla.subject);
		assertTrue(BD.ana.casilla.subject == "[Futbol5] Amigo Inscripto");
		assertTrue(BD.ale.casilla.subject == "[Futbol5] Amigo Inscripto");
		assertFalse(BD.ale.recibiMail);
	}
	
}
