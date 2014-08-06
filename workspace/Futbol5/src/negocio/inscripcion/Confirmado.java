package negocio.inscripcion;

import utils.FutbolException;
import utils.Mail;
import negocio.Jugador;
import negocio.Partido;

public class Confirmado implements EstadoPartido {
	
	private Partido partido;

	public Confirmado(Partido partido){
		this.partido = partido;
	}

	public void agregarJugador(Jugador jugador, int pos) throws FutbolException {
		throw new FutbolException("No se pudo inscribir a " + jugador + ". El partido ya esta confirmado");
	}

	public void darDeBaja(Jugador jugador) throws FutbolException {
		throw new FutbolException("No se pudo dar de baja a " + jugador + ". El partido ya esta confirmado");
	}
	
	public Mail mailDeNotificacion(){
		return null;		
	}
	
	public void EquipoConfirmadoA(Jugador... jugadores){
		if (this.partido.equipoA.size() < 5)
			for(Jugador jug : jugadores){
				this.partido.equipoA.add(jug);
			}
	}

	public void EquipoConfirmadoB(Jugador... jugadores){
		if (this.partido.equipoB.size() < 5)
			for(Jugador jug : jugadores){
				this.partido.equipoB.add(jug);
			}
	}

	public void calificar(Jugador jugador, Jugador calificado, int nota, String comentario) throws FutbolException {
		if(!partido.inscriptos.contains(jugador))  //TODO deberia chequearse con los equipos ya confirmados
			throw new FutbolException(jugador + " no jugo " + partido+".");
		if(!partido.inscriptos.contains(calificado))  //TODO deberia chequearse con los equipos ya confirmados
			throw new FutbolException(calificado + "no esta en inscripto.");
		if(jugador.hashCode() == calificado.hashCode())
			throw new FutbolException(calificado + ": no puede calificarse a si mismo.");

		calificado.recibirNota(jugador, nota, comentario, partido.id);
	}

}
