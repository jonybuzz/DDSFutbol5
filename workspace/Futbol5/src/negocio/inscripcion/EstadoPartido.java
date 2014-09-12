package negocio.inscripcion;

import java.util.ArrayList;

import utils.FutbolException;
import utils.Mail;
import negocio.Jugador;

public interface EstadoPartido {
	
	public void agregarJugador(Jugador jugador, int pos) throws FutbolException;
	
	public void darDeBaja(Jugador jugador) throws FutbolException;
	
	public Mail mailDeNotificacion();

	public void calificar(Jugador jugador, Jugador calificado, int nota, String comentario) throws FutbolException;

	public void setEquipos(ArrayList<Jugador> equipoA, ArrayList<Jugador> equipoB) throws FutbolException;
	
}
