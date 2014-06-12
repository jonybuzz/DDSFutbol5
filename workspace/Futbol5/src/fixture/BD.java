package fixture;

import java.util.ArrayList;

import negocio.Administrador;
import negocio.Jugador;
//import negocio.Partido;

public class BD {
	
	public static Jugador mario;
	public static Jugador jose;
	public static Jugador lucas;
	public static Jugador luis;
	public static Jugador bender;
	public static Jugador ale;
	public static Jugador juan;
	public static Jugador esteban;
	public static Jugador diego;
	public static Jugador ana;
	public static Jugador pepe;
	public static Jugador lionel;
	public static Jugador leo;
	public static Jugador beto;
	public static ArrayList<Administrador> admins;
	
	public static void init() throws Exception{
				
		mario = new Administrador("Mario", 1985, 5, 20);		
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
		beto = new Jugador("Beto", 1976, 8, 12);


	}

	public static void addAdmin (Jugador jugador) {
		admins.add((Administrador)jugador);
	}
}
