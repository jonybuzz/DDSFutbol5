package fixture;

import negocio.Administrador;
import negocio.Jugador;
//import negocio.Partido;

public class BaseDatos {
	
	public Jugador mario;
	public Jugador jose;
	public Jugador lucas;
	public Jugador luis;
	public Jugador bender;
	public Jugador ale;
	public Jugador juan;
	public Jugador esteban;
	public Jugador diego;
	public Jugador ana;
	public Jugador pepe;
	public Jugador lionel;
	public Jugador leo;
	
	public BaseDatos() throws Exception{
				
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

	}

}
