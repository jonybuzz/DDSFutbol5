package negocio.inscripcion;

import utils.Mail;
import negocio.Jugador;

public interface EstadoPartido {
	
	public void agregarJugador(Jugador jugador, int pos) throws Exception;
	
	public void darDeBaja(Jugador jugador);
	
	public Mail mailDeNotificacion();
}
