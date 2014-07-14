package fixture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import negocio.*;
import negocio.inscripcion.Confirmado;

public class BD {
	
	private static Administrador mario;
	public static HashMap<String, Jugador> jug;
	public static HashMap<String, Jugador> pendientes;
	public static HashMap<String, String> rechazos;
	public static ArrayList<Partido> partidos;
	
	public static void init() throws Exception{
		
		jug = new HashMap<String, Jugador>();
		pendientes= new HashMap<String, Jugador>();
		rechazos  = new HashMap<String, String>();
		partidos = new ArrayList<Partido>();
		
		mario = new Administrador("Mario", 1985, 5, 20);
		agregarJugador((Jugador)mario);
		agregarJugador(new Jugador("Jose", 1989, 6, 20));
		agregarJugador(new Jugador("Lucas", 1994, 5, 20));
		agregarJugador(new Jugador("Luis", 1900, 5, 20));
		agregarJugador(new Jugador("Bender", 2010, 5, 20));
		agregarJugador(new Jugador("Ale", 1995, 5, 20));
		agregarJugador(new Jugador("Juan", 1987, 5, 20));
		agregarJugador(new Jugador("Esteban", 1985, 5, 20));
		agregarJugador(new Jugador("Diego", 1980, 5, 20));
		agregarJugador(new Jugador("Ana", 1989, 5, 20));
		agregarJugador(new Jugador("Pepe", 1994, 1, 10));
		agregarJugador(new Jugador("Pepe", 1994, 1, 10));
		agregarJugador(new Jugador("Lionel", 1999, 5, 20));
		agregarJugador(new Jugador("Leo", 1996, 5, 20));
		agregarJugador(new Jugador("Beto", 1976, 8, 12));
		agregarJugador(new Jugador("Gero", 1960, 12, 31));

	}

	public static void agregarJugador(Jugador jugador) {
		jug.put(jugador.nombre, jugador);  //(clave,valor) para accederlos
	}

	public static Administrador administrador() {
		return mario;
	}

	public static void agregarPendiente(Jugador jugador){
		pendientes.put(jugador.nombre, jugador);
	}
	
	public static void rechazarPendiente(String nombre, String motivo){
		rechazos.put(nombre, motivo);
	}
	
	public static void agregarPartido(Partido partido){
		partidos.add(partido);
	}

	public static Partido getPartido(Partido partido){
		return (Partido) partidos.get(Collections.binarySearch(partidos, partido));
	}

	public static ArrayList<Partido> partidosConEstado(Class clase) {
		ArrayList<Partido> partidosEstado = new ArrayList<Partido>();
		for(Partido p : partidos){
			if(p.getEstado().getClass() == clase){
				partidosEstado.add(p);
			}
		}
		return partidosEstado;
	}

}
