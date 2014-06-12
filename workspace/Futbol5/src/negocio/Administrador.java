package negocio;

import utils.MailSender;
import utils.Observer;

public class Administrador extends Jugador implements Observer{

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
		this.partido = new Partido(anio, mes, dia, hora, minutos);
		partido.addObserver(this);
		return partido;
	}

	public void update() {
		if(this.partido.confirmado())
			mailsender.compose("System.Mail", this.mail, "[Futbol5] Aviso", "El partido ya tiene 10 jugadores confirmados");
		else
			mailsender.compose("System.Mail", this.mail, "[Futbol5] Aviso", "El partido no esta listo");
		mailsender.send();

	}

}
