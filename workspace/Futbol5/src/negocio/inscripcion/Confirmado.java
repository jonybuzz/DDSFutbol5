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
		throw new Exception("No se pudo inscribir a " + jugador + ". El partido ya esta confirmado");
	}

	public void darDeBaja(Jugador jugador) throws Exception {
		throw new Exception("No se pudo inscribir a " + jugador + ". El partido ya esta confirmado");
	}
	
	public Mail mailDeNotificacion(){		
		Mail mail = new Mail("[Futbol5] Partido Completo",
				"El "+ partido +" ya tiene 10 jug confirmados");
		return mail;
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


}
