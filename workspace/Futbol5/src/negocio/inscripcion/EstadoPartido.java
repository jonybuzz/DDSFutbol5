package negocio.inscripcion;

import utils.FutbolException;
import utils.Mail;
import negocio.Jugador;

public interface EstadoPartido {
	
	public void agregarJugador(Jugador jugador, int pos) throws FutbolException;
	
	public void darDeBaja(Jugador jugador) throws FutbolException;
	
	public Mail mailDeNotificacion();

	public void calificar(Jugador jugador, Jugador calificado, int nota, String comentario) throws FutbolException;
}
