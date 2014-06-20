package fixture;

import java.util.HashMap;
import negocio.*;

public class BD {
	
	private static Administrador mario;
	public static HashMap<String, Jugador> jug;
	public static HashMap<String, Jugador> pendientes;
	
	@SuppressWarnings("unused")
	public static void init() throws Exception{
		
		HashMap<String, Jugador> jugadores = new HashMap<String, Jugador>();
		HashMap<String, Jugador> pendientes = new HashMap<String, Jugador>();
		
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

	private static void agregarJugador(Jugador jugador) {
		jug.put(jugador.nombre, jugador);  //(clave,valor) para accederlos
		
	}

	public static Administrador administrador() {
		return mario;
	}

	public static void agregarPendiente(Jugador jugador){
		pendientes.put(jugador.nombre, jugador);
	}
}
