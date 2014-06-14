package negocio.inscripcion;

import utils.Mail;
import negocio.Jugador;
import negocio.Partido;

public class Confirmado implements EstadoPartido {
	
	private Partido partido;

	public Confirmado(Partido partido){
		this.partido = partido;
	}

	public void agregarJugador(Jugador jugador, int pos) throws Exception {
		throw new Exception("No se pudo inscribir a " + jugador + ". No hay cupos");
	}

	public void darDeBaja(Jugador jugador) {
		partido.inscriptos.remove(jugador);
		if(!partido.confirmado()){
			partido.setEstado(new Abierto(partido));
			partido.notificarAdministrador();
		}
	}
	
	public Mail mailDeNotificacion(){		
		Mail mail = new Mail("[Futbol5] Partido Confirmado",
				"El "+ partido +" ya tiene 10 jugadores confirmados");
		return mail;
	}

}
