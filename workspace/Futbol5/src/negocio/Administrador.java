package negocio;

import ordenamiento.Criterio;
import ordenamiento.DivisionEquipos;
import fixture.BD;
import negocio.inscripcion.Confirmado;
import utils.FutbolException;
import utils.Mail;
import utils.MailSender;
//import utils.Observer;

public class Administrador extends Jugador {

	public Administrador(String nombre, int anio, int mes, int dia) throws FutbolException {
		super(nombre, anio, mes, dia);
		this.mailsender = new MailSender();
	}
	
	public Administrador(String nombre, String mail, int anio, int mes, int dia) throws FutbolException {
		super(nombre, anio, mes, dia);
		this.mail = mail;
	}
	
	public Partido organizarNuevoPartido(int anio, int mes, int dia, int hora, int minutos) throws FutbolException{
		Partido p = new Partido(this, anio, mes, dia, hora, minutos);
		BD.agregarPartido(p);
		return p;
	}

	public void updateFromPartido(Mail mail) {
		mailsender.send(this, mail);
	}

	public void confirmarPartido(Partido partido) throws FutbolException {
		if(partido.equipoA!=null && partido.equipoB!=null)
			partido.setEstado(new Confirmado(partido));
		else throw new FutbolException("Para confirmar deben formarse los equipos");
	}

	public void aceptar(Jugador jugador) {	
		BD.aceptarJugador(jugador.nombre);
	}

	public void rechazar(Jugador jugador, String motivo) {
		BD.rechazarJugadorPendiente(jugador.nombre, motivo);
	}
	
	public void setHandicap(Jugador jugador, int n){
		jugador.handicap = n;
	}
	
	public void ordenar(Partido partido, Criterio...criterios) throws FutbolException {
		partido.ordenar(criterios);		
	}

	public void generarEquipos(Partido partido, DivisionEquipos division) throws FutbolException {
		
		division.setLista(partido.inscriptos);
		partido.setEquipos(division.generarEquipoA(), division.generarEquipoB());
		//asigna los equipos resultantes del algoritmo. Division chequea que sean al menos 10 jug
	}

}
