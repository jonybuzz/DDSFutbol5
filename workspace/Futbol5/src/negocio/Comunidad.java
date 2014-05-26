package negocio;

import java.util.ArrayList;

public class Comunidad {

	private ArrayList<Jugador> jugadores;

	public Comunidad() {
		this.jugadores = new ArrayList<Jugador>();
	}
	
	public void incorporar(Jugador jugador){
		this.jugadores.add(jugador);
	}

}
