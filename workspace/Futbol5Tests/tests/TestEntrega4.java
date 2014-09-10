package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import ordenamiento.CrHandicap;

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
		System.out.print("\n" + lista + "\n");

		
		for(Jugador jug : lista){
			Random rnd = new Random();
			int nota = rnd.nextInt(10)+1;		//num aleatorio [1;10]
			BD.administrador().setHandicap(jug, nota);
			System.out.print(jug + " " + nota);
		}
		
		ArrayList<Jugador> listaOrdenada = BD.administrador().ordenar(lista, new CrHandicap());  //TODO def sort
		
		System.out.print("\n" + lista + "\n");
		//System.out.print(lista.get(9).handicap + "\n");

		System.out.print(listaOrdenada + "\n");
		//System.out.print(listaOrdenada.get(9).handicap + "\n");

		
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
