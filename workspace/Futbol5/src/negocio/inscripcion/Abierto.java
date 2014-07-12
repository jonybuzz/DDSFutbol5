package negocio.inscripcion;

import utils.FutbolException;
import utils.Mail;
import negocio.Jugador;
import negocio.Partido;

public class Abierto implements EstadoPartido {

	private Partido partido;

	public Abierto(Partido partido){
		this.partido = partido;
	}

	public void agregarJugador(Jugador jugador, int pos) throws FutbolException {
		if(!partido.estaInscripto(jugador)) {
			partido.inscriptos.add(pos, jugador);
			if(partido.completo()){
				partido.setEstado(new Completo(partido));  //pasar estado a confirmado
				partido.notificarAdministrador();
			}
		}
		else throw new FutbolException(jugador + " ya esta inscripto.");
	}

	public void darDeBaja(Jugador jugador) {
		this.partido.inscriptos.remove(jugador);
	}

	public Mail mailDeNotificacion() {
		Mail mail = new Mail("[Futbol5] Partido Incompleto",
				"El "+ partido +" volvio a estar sin 10 jug confirmados");
		return mail;
	}

	public void calificar(Jugador jugador, Jugador calificado, int nota, String comentario) throws FutbolException {
		throw new FutbolException("Todavia no se puede calificar.");
	}

}