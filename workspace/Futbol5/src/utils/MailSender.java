package utils;

import negocio.Jugador;
/*
 * Clase que simula el envio de mails. Para testear, cada jugador tiene una "casilla"
 */
public class MailSender {
		
	@SuppressWarnings("unused")
	private String from;
	@SuppressWarnings("unused")
	private String to;
	private Mail mail;
	
	public MailSender() {
		}

	public void compose(String from, String to, String subject, String message) {
		this.mail = new Mail(subject, message);
		this.from = from;
		this.to = to;
		}

	public void send(Jugador receptor){
		receptor.recibirMail(this.mail);
		receptor.recibiMail = true;
	}
	public void send(Jugador receptor, Mail mail){
		receptor.recibirMail(mail);
		receptor.recibiMail = true;
	}

}
