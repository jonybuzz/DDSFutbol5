package negocio.inscripcion;

import java.util.Iterator;

import negocio.Jugador;
import negocio.Partido;


public abstract class Inscripcion {

	public int prioridad;

	public void inscribir(Jugador jugador, Partido partido) throws Exception {

		Iterator<Jugador> it = partido.inscriptos.iterator();
		int pos=0;
		while (it.hasNext()) {
			if (it.next().getPrioridad() < jugador.getPrioridad())	pos++;
		}
		partido.agregarJugador(jugador, pos);
		
	}
}
