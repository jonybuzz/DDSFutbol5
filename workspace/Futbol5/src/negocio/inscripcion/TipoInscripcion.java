package negocio.inscripcion;

import java.util.Iterator;

import utils.FutbolException;
import negocio.Jugador;
import negocio.Partido;


public abstract class TipoInscripcion {

	public int prioridad;

	public void inscribir(Jugador jugador, Partido partido) throws FutbolException {

		Iterator<Jugador> it = partido.inscriptos.iterator();
		int pos=0;
		while (it.hasNext()) {
			if (it.next().getPrioridad() < jugador.getPrioridad())	pos++;
		}
		try {
			partido.agregarJugador(jugador, pos);
		} catch (Exception e) {
			throw new FutbolException(e.getMessage());
		}
		
	}
}
