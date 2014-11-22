package tests;

//import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Random;

import ordenamiento.*;

import org.junit.Test;

import utils.FutbolException;
import negocio.*;
import negocio.inscripcion.*;
import fixture.BD;

public class TestEntrega4 {
	
	public static Partido p = null;
		
	@Test
	public void ordenarPorHandicap() throws FutbolException {
		System.out.print("\n\nORDENA POR HANDICAP ALEATORIO---------------------");

		BD.init();
		crearPartido();
		Partido partido = BD.getPartido(0);
		Administrador admin = BD.administrador();
		
		ArrayList<Jugador> lista = partido.inscriptos;
		System.out.print("\nLista inscriptos: " + lista);

		System.out.print("\nLista de Handic: ");
		for(Jugador jug : lista){
			Random rnd = new Random();			//generacion de
			int nota = rnd.nextInt(10)+1;		//num aleatorio [1;10]
			admin.setHandicap(jug, nota);
			System.out.print(jug + " " + nota + "* ");
		}
		
		admin.ordenar(partido, new CritHandicap());
		System.out.print("\nLista ordenada:  " + lista);

		admin.generarEquipos(partido, new Division1());
		System.out.print("\n*Division pares/impares");
		printEquipos(BD.getPartido(0));		
		
		admin.generarEquipos(partido, new Division2());
		System.out.print("\n*Division 1°,4°,5°,8°,9° / 2°,3°,6°,7°,10°");
		printEquipos(BD.getPartido(0));		

		admin.confirmarPartido(partido);
		//admin.generarEquipos(partido, new Division2());  //Esto da EXCEPCION como debe ser
	}

	
	@Test
	public void ordenarPorUltimas5Calificaciones() throws FutbolException {
		System.out.print("\n\nORDENA POR ULTIMAS 5 CALIFICACIONES--------------");

		BD.init();
		Administrador admin = BD.administrador();
		
		Partido partido = crearPartido();
		admin.generarEquipos(partido, new Division1());
		admin.confirmarPartido(partido);
		this.simularCalificaciones(partido);
		
		Partido partido2 = crearPartido();
		admin.generarEquipos(partido2, new Division1());
		admin.confirmarPartido(partido2);
		this.simularCalificaciones(partido2);
		System.out.print("\nCalificaciones por jugador: " +
				partido2.inscriptos.get(1).calificaciones.size());
		
		Partido partido3 = crearPartido();
		System.out.print("\nLista inscriptos: " + partido3.inscriptos);
		
		admin.ordenar(partido3, new UltimasCalificaciones(5));	//ACA ESTA LA LOGICA
		System.out.print("\nLista ordenada :  " + partido3.inscriptos);
		
		admin.generarEquipos(partido3, new Division1());
		printEquipos(partido3);
		
	}

	
	@Test
	public void ordenarPorCalificacionesUltimoPartido() throws FutbolException {
		System.out.print("\n\nORDENA POR CALIFICACIONES ULT. PARTIDO-----------");

		BD.init();
		Administrador admin = BD.administrador();
		
		Partido partido = crearPartido();
		admin.generarEquipos(partido, new Division1());
		admin.confirmarPartido(partido);
		this.simularCalificaciones(partido);
		
		Partido partido2 = crearPartido();
		admin.generarEquipos(partido2, new Division1());
		admin.confirmarPartido(partido2);
		this.simularCalificaciones(partido2);
		
		Partido partido3 = crearPartido();
		System.out.print("\nLista inscriptos: " + partido3.inscriptos);
		
		admin.ordenar(partido3, new PromedioUltimoPartido());	//ACA ESTA LA LOGICA
		System.out.print("\nLista ordenada :  " + partido3.inscriptos);
		
		admin.generarEquipos(partido3, new Division1());
		printEquipos(partido3);
	
	}

	@Test
	public void ordenarPorHandicapYUltimas8() throws FutbolException {
		System.out.print("\n\nORDENA POR HANDICAP Y ULT. 8 CALIFICACIONES----");

		BD.init();
		Administrador admin = BD.administrador();
		
		Partido partido = crearPartido();
		admin.generarEquipos(partido, new Division1());
		admin.confirmarPartido(partido);
		this.simularCalificaciones(partido);
		
		Partido partido3 = crearPartido();
		System.out.print("\nCalificaciones por jugador: " +
				partido3.inscriptos.get(1).calificaciones.size());
		
		System.out.print("\nLista inscriptos: " + partido3.inscriptos);

		System.out.print("\nLista de Handic: ");
		for(Jugador jug : partido3.inscriptos){
			Random rnd = new Random();			//generacion de
			int nota = rnd.nextInt(10)+1;		//num aleatorio [1;10]
			admin.setHandicap(jug, nota);
			System.out.print(jug + " " + nota + "* ,");
		}
		
		
		admin.ordenar(partido3, new CritHandicap(), new UltimasCalificaciones(8));	//ACA ESTA LA LOGICA
		System.out.print("\nLista ordenada :  " + partido3.inscriptos);
		
		admin.generarEquipos(partido3, new Division1());
		printEquipos(partido3);
		
	}

	
	private void simularCalificaciones(Partido partido) throws FutbolException {

		Random random = new Random();

		for(Jugador jug1 : partido.equipoA){
			for(Jugador jug2 : partido.equipoA){
				if(jug1 != jug2)
					jug1.calificar(partido.id, jug2, random.nextInt(10)+1);
			}
			for(Jugador jug2 : partido.equipoB){
				jug1.calificar(partido.id, jug2, random.nextInt(10)+1);
			}
		}
		for(Jugador jug1 : partido.equipoB){
			for(Jugador jug2 : partido.equipoA){
				jug1.calificar(partido.id, jug2, random.nextInt(10)+1);
			}
			for(Jugador jug2 : partido.equipoB){
				if(jug1 != jug2)
					jug1.calificar(partido.id, jug2, random.nextInt(10)+1);
			}
		}
	}
	
	
	private Partido crearPartido() throws FutbolException {
		Partido partido = BD.administrador().organizarNuevoPartido(2015, 1, 3, 14, 30);
		BD.get("Jose").modoDeInscripcion(new Solidaria());
		BD.get("Jose").inscribirme(partido);
		BD.get("Lucas").inscribirme(partido);
		BD.get("Luis").inscribirme(partido);
		BD.get("Bender").inscribirme(partido);
		BD.get("Ale").modoDeInscripcion(new Solidaria());
		BD.get("Ale").inscribirme(partido);
		BD.get("Juan").inscribirme(partido);
		BD.get("Esteban").inscribirme(partido);
		BD.get("Diego").inscribirme(partido);
		BD.get("Ana").inscribirme(partido);
		BD.get("Pepe").inscribirme(partido);
		
		return partido;
	}
	
	private void printEquipos(Partido partido) {
		System.out.print("\nEquipo A: " + partido.equipoA);
		System.out.print("\nEquipo B: " + partido.equipoB);
	}
}
