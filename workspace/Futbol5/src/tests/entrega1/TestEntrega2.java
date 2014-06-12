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
import fixture.BD;


public class TestEntrega2 {

	public static BD bd;
	public static Partido partidoPrueba;

	public TestEntrega2() {
	}
	

	@Test
	public void inscripcion() throws Exception {

		BD.init();

		partidoPrueba = ((Administrador) BD.mario).organizarNuevoPartido(2014, 6, 18, 15, 30);
		
		BD.mario.inscribirme(partidoPrueba);					//1
		BD.jose.inscribirme(partidoPrueba);						//2
		BD.lucas.inscribirme(partidoPrueba);					//3
		BD.luis.modoDeInscrpcion(new Condicional("juego si esta nublado"));
		assertTrue(BD.luis.getModoDeInscripcion().prioridad==2);
		BD.luis.inscribirme(partidoPrueba);
		BD.bender.inscribirme(partidoPrueba);					//4
		BD.ale.inscribirme(partidoPrueba);						//5
		
		BD.juan.modoDeInscrpcion(new Solidaria());
		assertTrue(BD.juan.getModoDeInscripcion().prioridad==3);
		BD.juan.inscribirme(partidoPrueba);
		
		assertFalse(partidoPrueba.confirmado());
		
		BD.esteban.inscribirme(partidoPrueba);					//6
		BD.diego.inscribirme(partidoPrueba);					//7
		BD.ana.inscribirme(partidoPrueba);						//8
		
		BD.pepe.modoDeInscrpcion(new Condicional("juego si hay alguno de mi edad"));
		BD.pepe.inscribirme(partidoPrueba);
		assertTrue(BD.pepe.edad() == BD.lucas.edad());

		BD.lionel.inscribirme(partidoPrueba);					//9
		BD.leo.inscribirme(partidoPrueba);						//10

		assertTrue(partidoPrueba.confirmado());
		
		BD.esteban.darmeDeBaja("estoy enfermo");
		
		assertFalse(partidoPrueba.confirmado());


	}
	
}
