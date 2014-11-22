package utils;

import java.awt.Component;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class FutbolException extends Exception {

	private static final long serialVersionUID = 1L;

	public FutbolException() {
		// TODO Auto-generated constructor stub
	}
	
	public FutbolException(String arg0) {
		Component frame = new JDialog();
		frame.setName("Futbol5 error");
		JOptionPane.showMessageDialog(frame, arg0, "Futbol5", JOptionPane.ERROR_MESSAGE);
		//super("Futbol5 Error: " + arg0);
	}

	public FutbolException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public FutbolException(String arg0, Throwable arg1) {
		super("Futbol5 Error: " + arg0, arg1);
	}

	public FutbolException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super("Futbol5 Error: " + arg0, arg1, arg2, arg3);
	}

}
