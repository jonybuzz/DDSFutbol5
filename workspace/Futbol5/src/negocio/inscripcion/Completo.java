package negocio.inscripcion;

import java.util.ArrayList;

import utils.FutbolException;
import utils.Mail;
import negocio.Jugador;
import negocio.Partido;

public class Completo implements EstadoPartido {
	
	private Partido partido;

	public Completo(Partido partido){
		this.partido = partido;
	}

	public void agregarJugador(Jugador jugador, int pos) throws FutbolException {
		throw new FutbolException("No se pudo inscribir a " + jugador + ". No hay cupos");
	}

	public void darDeBaja(Jugador jugador) {
		partido.inscriptos.remove(jugador);
		if(!partido.completo()){
			partido.setEstado(new Abierto(partido));
			partido.notificarAdministrador();
		}
	}
	
	public Mail mailDeNotificacion(){		
		Mail mail = new Mail("[Futbol5] Partido Completo",
				"El "+ partido +" ya tiene 10 jugadores confirmados");
		return mail;
	}
	
	public void calificar(Jugador jugador, Jugador calificado, int nota, String comentario) throws FutbolException {
		throw new FutbolException("Todavia no se puede calificar.");
	}

	public void setEquipos(ArrayList<Jugador> equipoA,
			ArrayList<Jugador> equipoB) throws FutbolException {

		partido.equipoA = equipoA;
		partido.equipoB = equipoB;
	}

}
