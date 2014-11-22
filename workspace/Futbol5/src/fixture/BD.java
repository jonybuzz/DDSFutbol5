package fixture;

import java.util.ArrayList;
import java.util.HashMap;

import utils.FutbolException;
import negocio.*;

public class BD {
	
	private static Administrador mario;
	private static HashMap<String, Jugador> jug;
	private static HashMap<String, Jugador> pendientes;
	private static HashMap<String, Rechazo> rechazos;
	private static ArrayList<Partido> partidos;
	
	public static void init() throws FutbolException{
		
		jug = new HashMap<String, Jugador>();
		pendientes= new HashMap<String, Jugador>();
		rechazos  = new HashMap<String, Rechazo>();
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

	public static Jugador get(String nombre){
		return jug.get(nombre);
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
	
	public static void rechazarJugadorPendiente(String nombre, String motivo) {
		rechazos.put(nombre,
				new Rechazo(pendientes.get(nombre), motivo));
		pendientes.remove(nombre);
	}
	
	public static boolean estaEntreLosJugadores(String nombre){
		return jug.containsKey(nombre);
	}
	
	public static Jugador getPendiente(String nombre){
		return pendientes.get(nombre);
	}
	
	public static void agregarPartido(Partido partido){
		partido.id = partidos.size();
		partidos.add(partido);
	}

	public static ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public static Partido getPartido(int id){
		//return (Partido) partidos.get(Collections.binarySearch(partidos, partido));
		return partidos.get(id);   //partidos identificados por numero (ID)
	}

	public static ArrayList<Partido> partidosConEstado(Class<?> clase) {
		ArrayList<Partido> partidosEstado = new ArrayList<Partido>();
		for(Partido p : partidos){
			if(p.getEstado().getClass() == clase){
				partidosEstado.add(p);
			}
		}
		return partidosEstado;
	}

	public static void aceptarJugador(String nombre) {
		agregarJugador(getPendiente(nombre));
		pendientes.remove(nombre);
	}

	public static String[] tiposInsc() {
		String[] tiposInsc = { "Estandar", "Condicional", "Solidaria" };
		return  tiposInsc;
	}

}
