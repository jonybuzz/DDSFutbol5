package negocio;

import fixture.BD;
import negocio.inscripcion.Confirmado;
import utils.Mail;
import utils.MailSender;
//import utils.Observer;

public class Administrador extends Jugador {

	public Administrador(String nombre, int anio, int mes, int dia) throws Exception {
		super(nombre, anio, mes, dia);
		this.mailsender = new MailSender();
	}
	
	public Administrador(String nombre, String mail, int anio, int mes, int dia) throws Exception {
		super(nombre, anio, mes, dia);
		this.mail = mail;
	}
	
	public Partido organizarNuevoPartido(int anio, int mes, int dia, int hora, int minutos) throws Exception{
		return new Partido(this, anio, mes, dia, hora, minutos);
	}

	public void updateFromPartido(Mail mail) {
		mailsender.send(this, mail);
	}

	public void confirmarPartido(Partido partido) {
		partido.setEstado(new Confirmado(partido));
	}

	public void aceptar(Jugador jugador) {	
		BD.agregarJugador(BD.pendientes.get(jugador.nombre));
	}

	public void rechazar(Jugador jugador, String string) {
		BD.pendientes.remove(jugador.nombre);
	}

}
