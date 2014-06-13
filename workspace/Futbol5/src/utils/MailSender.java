package utils;

import negocio.Jugador;
/*
 * Clase que simula el envio de mails. Para testear, cada jugador tiene una "casilla"
 */
public class MailSender {
	
	public class Mail{
		public String subject;
		public String message;
		protected Mail(String sub, String msg){
			subject = sub;
			message = msg;
		}
	}
	
	private String from;
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
}
