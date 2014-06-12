package utils;

public class MailSender {
	
	protected class Mail{
		private String subject;
		private String message;
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

	public void send(){
		//TODO
	}
}
