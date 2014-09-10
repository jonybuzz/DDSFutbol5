package negocio;

import java.util.ArrayList;

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

	public void confirmarPartido(Partido partido) {
		partido.setEstado(new Confirmado(partido));
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
	
	public ArrayList<Jugador> ordenar(ArrayList<Jugador> jugadores,
										Criterio...criterios) throws FutbolException {
				
		for (int i=0; i<jugadores.size(); i++){
			
			Jugador j = jugadores.get(i);
			double valor = 0;
			
			for (Criterio algoritmo : criterios){
				valor += algoritmo.valuarJugador(j);		//por cada criterio suma el puntaje
			}
			valor /= criterios.length;						//promedia
			
			j.valorDeOrdenamiento = valor;					//asigna un valor al jugador
		}
				
		jugadores.sort(Criterio.JugadorComparator);
		return jugadores;
	}

	public void generarEquipos(Partido partido, DivisionEquipos division) {
		
		partido.equipoA = division.generarEquipoA();
		partido.equipoB = division.generarEquipoB();
	}

}
