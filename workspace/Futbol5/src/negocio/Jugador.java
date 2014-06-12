package negocio;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import negocio.inscripcion.*;

import org.joda.time.*;

import utils.MailSender;

public class Jugador extends Observable implements Observer {
	
	public DateTime nacimiento;
	private Inscripcion modo;
	private String nombre;
	protected String mail;
	protected MailSender mailsender;
	private ArrayList<Jugador> amigos;
	private Partido partidoActual;
	private ArrayList<Infraccion> infracciones;

	public Jugador(String nombre, int anio, int mes, int dia) throws Exception{
		this.nombre = nombre;
		DateTime nac = new DateTime(anio, mes, dia, 0, 0);
		if (nac.isAfterNow())
			throw new Exception("Nacimiento Invalido!");
		else
			this.nacimiento = nac;
		this.modo = new Estandar();
		this.amigos = new ArrayList<Jugador>();
		this.mailsender = new MailSender();
	}
	
	public Jugador(String nombre, String mail, int anio, int mes, int dia) {
		super();
		this.mail = mail;
	}

	public int edad(){
		return new Interval(nacimiento, DateTime.now()).toPeriod().getYears();
	}
	
	public Inscripcion getModoDeInscripcion() {
		return modo;
	}

	public void modoDeInscrpcion(Inscripcion modo) {
		this.modo = modo;
	}

	public int getPrioridad(){
		return getModoDeInscripcion().prioridad;
	}
	
	public void inscribirme(Partido partido) throws Exception{		
		this.modo.inscribir(this, partido);
		this.partidoActual = partido;
		this.setChanged();
		this.notifyObservers(this.partidoActual);
	}
	
	public void darmeDeBaja(String motivo) {
		partidoActual.darDeBaja(this);
		this.infracciones.add(new Infraccion(DateTime.now(), motivo));
	}

	public void darmeDeBaja(Jugador reemplazo) throws Exception {
		partidoActual.darDeBaja(this);
		reemplazo.modoDeInscrpcion(this.getModoDeInscripcion());   //lo inscribe con el mismo modo
		reemplazo.inscribirme(partidoActual);
	}
		
	public void agregarAmigo(Jugador amigo) {
		this.addObserver(amigo);
	}

	public void update(Observable amigo, Object part) {
		mailsender.compose("System.Mail", this.mail, "[Futbol5] Amigo Inscripto", amigo + " se inscribio al partido "+ part);
	}	

	public String toString() {
		return "(" + this.modo.prioridad +")"+ this.nombre;
	}
	
}
