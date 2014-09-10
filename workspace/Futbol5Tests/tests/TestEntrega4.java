package tests;

//import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import ordenamiento.*;
import org.junit.Test;
import utils.FutbolException;
import negocio.*;
import fixture.BD;


public class TestEntrega4 {
	
	public static Partido p = null;
		
	
	@Test
	public void ordenarPorHandicap() throws FutbolException {
		BD.init();
		crearPartido();
		BD.administrador().confirmarPartido(BD.getPartido(0));
		
		ArrayList<Jugador> lista = BD.getPartido(0).inscriptos;
		System.out.print("\nLista inscriptos: " + lista);

		System.out.print("\nLista de Handic: ");
		for(Jugador jug : lista){
			Random rnd = new Random();
			int nota = rnd.nextInt(10)+1;		//num aleatorio [1;10]
			BD.administrador().setHandicap(jug, nota);
			System.out.print(jug + " " + nota + "* ");
		}
		
		
		BD.administrador().ordenar(lista, new CritHandicap());
		BD.administrador().generarEquipos(BD.getPartido(0), new Division1(lista));
		
		System.out.print("\nLista ordenada:  " + lista);
		//System.out.print(lista.get(9).handicap + "\n");

		System.out.print("\nEquipo A : " + BD.getPartido(0).equipoA);
		System.out.print("\nEquipo B : " + BD.getPartido(0).equipoB);

	}

	
	@Test
	public void ordenarPorUltimas2Calificaciones() throws FutbolException {
	
	}
	
	
	@Test
	public void ordenarPorCalificacionesUltimoPartido() throws FutbolException {
	
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
