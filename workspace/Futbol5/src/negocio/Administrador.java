package negocio;

import utils.MailSender;
import utils.Observer;

public class Administrador extends Jugador {

	private Partido partido;

	public Administrador(String nombre, int anio, int mes, int dia) throws Exception {
		super(nombre, anio, mes, dia);
		this.mailsender = new MailSender();
	}
	
	public Administrador(String nombre, String mail, int anio, int mes, int dia) throws Exception {
		super(nombre, anio, mes, dia);
		this.mail = mail;
	}
	
	public Partido organizarNuevoPartido(int anio, int mes, int dia, int hora, int minutos) throws Exception{
		this.partido = new Partido(this, anio, mes, dia, hora, minutos);
		return partido;
	}

	public void updatePartido(Partido partido) {
		if(this.partido.confirmado())
			mailsender.compose("System.Mail", this.mail, "[Futbol5] Partido Confirmado", "El "+ partido +" ya tiene 10 jugadores confirmados");
		else
			mailsender.compose("System.Mail", this.mail, "[Futbol5] Partido Incompleto", "El "+ partido +" no esta listo");
		mailsender.send(this);
	}

}
