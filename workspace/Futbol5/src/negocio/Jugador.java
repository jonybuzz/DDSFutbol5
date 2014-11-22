package negocio;

import java.util.ArrayList;
//import java.util.Observable;
//import java.util.Observer;
import java.util.TreeSet;

import org.joda.time.*;

import fixture.BD;
import negocio.inscripcion.*;
import utils.*;

public class Jugador /*extends Observable implements Observer*/ {
	
	public DateTime nacimiento;
	private TipoInscripcion modo;
	public String nombre;
	public String mail;
	protected MailSender mailsender;
	public ArrayList<Infraccion> infracciones;
	public boolean recibiMail = false;
	public Mail casilla;
	public TreeSet<Jugador> amigos;
	public ArrayList<Calificacion> calificaciones;
	public int handicap;
	public double valorDeOrdenamiento;

	public Jugador(String nombre, int anio, int mes, int dia) throws FutbolException{
		this.nombre = nombre;
		DateTime nac = new DateTime(anio, mes, dia, 0, 0);
		if (nac.isAfterNow())
			throw new FutbolException("Nacimiento Invalido!");
		else
			this.nacimiento = nac;
		this.modo = new Estandar();
		this.amigos = new TreeSet<Jugador>();
		this.mailsender = new MailSender();
		this.infracciones = new ArrayList<Infraccion>();
		this.calificaciones = new ArrayList<Calificacion>();
	}
	
	public Jugador(String nombre, String mail, int anio, int mes, int dia) throws FutbolException {
		this(nombre, anio, mes, dia);
		this.mail = mail;
	}

	public int edad(){
		return new Interval(nacimiento, DateTime.now()).toPeriod().getYears();
	}
	
	public TipoInscripcion getModoDeInscripcion() {
		return modo;
	}

	public void modoDeInscripcion(TipoInscripcion modo) {
		this.modo = modo;
	}

	public int getPrioridad(){
		return getModoDeInscripcion().prioridad;
	}
	
	public void inscribirme(Partido partido) throws FutbolException{		
		this.modo.inscribir(this, partido);
		this.notificarAmigos(partido);
	}
	
	private void notificarAmigos(Partido partido) {
		for(Jugador amigo : this.amigos){
			amigo.update(this, partido);
		}
	}

	public void darmeDeBaja(Partido partido, String motivo) throws FutbolException {
		partido.darDeBaja(this);
		this.infracciones.add(new Infraccion(DateTime.now(), motivo));
	}

	public void darmeDeBaja(Partido partido, Jugador reemplazo) throws FutbolException {
		partido.darDeBaja(this);
		reemplazo.modoDeInscripcion(this.getModoDeInscripcion());   //lo inscribe con el mismo modo
		reemplazo.inscribirme(partido);
	}
		
	public void agregarAmigos(Jugador... amigos) {
		for(Jugador amigo : amigos){
			this.amigos.add(amigo);
			amigo.agregarAmigos(this);  //doble enlace
		}	
	}

	public void update(Jugador jugador, Partido partido) {
		mailsender.compose("System.Mail", this.mail, "[Futbol5] Amigo Inscripto",
				jugador.toString() + " se inscribio al "+ partido);
		mailsender.send(this);
	}	

	public String toString() {
		return "(" + this.modo +")"+ this.nombre;
	}
	
	//Mock para tests
	public boolean recibirMail(Mail mail) {
		this.casilla = mail;
		return this.recibiMail;
	}

	public void proponerA(Jugador jugador) {
		BD.agregarPendiente(jugador);
	}

	public void calificar(int idPartido, Jugador jugador, int nota, String comentario) throws FutbolException {
		BD.getPartido(idPartido).calificar(this, jugador, nota, comentario);
	}
	public void calificar(int idPartido, Jugador jugador, int nota) throws FutbolException {
		this.calificar(idPartido, jugador, nota, "");
	}

	public void recibirNota(Jugador jugador, int nota, String comentario, int idPartido) {
		calificaciones.add(new Calificacion(jugador, nota, comentario, idPartido));
	}

	public double calificacionesPromedio() throws FutbolException {
		double total = 0, cant = 0;
		
		for(Calificacion calif : this.calificaciones){
			total += calif.getNota();
			cant++;
		}
		if (cant != 0)
			return total/cant;
		else throw new FutbolException("No recibio calificaciones aun.");
	}

}
