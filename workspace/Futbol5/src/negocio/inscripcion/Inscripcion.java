package negocio.inscripcion;

import java.util.Iterator;

import negocio.Jugador;
import negocio.Partido;


public abstract class Inscripcion {

	public int prioridad;

	public boolean inscribir(Jugador jugador, Partido partido) throws Exception {

		if(!partido.estaCompleto() && !partido.estaInscripto(jugador)){
			
			Iterator<Jugador> it = partido.inscriptos.iterator();
			while(it.hasNext()){
				
				Jugador jug = it.next();
				if(jug.getModoDeInscripcion().prioridad > jugador.getModoDeInscripcion().prioridad){
					//it.remove();
				}				
			}
			
			partido.agregarJugador(jugador);
			return true;			
		}
		return false;
	}
	
}
