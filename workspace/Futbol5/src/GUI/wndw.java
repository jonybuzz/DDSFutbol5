package GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import negocio.inscripcion.*;

import java.awt.Window.Type;
import java.util.Collection;

import fixture.BD;

public class wndw {

	private JFrame frmAppFutbol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wndw window = new wndw();
					window.frmAppFutbol.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public wndw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppFutbol = new JFrame();
		frmAppFutbol.setTitle("Futbol5 - Inscripcion");
		frmAppFutbol.setBounds(100, 100, 450, 300);
		frmAppFutbol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmAppFutbol.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		frmAppFutbol.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		frmAppFutbol.getContentPane().add(panel_2, BorderLayout.CENTER);
		
		String[] tiposInsc = { "Estandar", "Condicional", "Solidaria" };
		
		JLabel lblTipoDeInscripcion = new JLabel("Tipo de Inscripcion");
		panel_2.add(lblTipoDeInscripcion);
		JComboBox comboBoxTipoInsc = new JComboBox(tiposInsc);
		comboBoxTipoInsc.setSelectedIndex(0);
		panel_2.add(comboBoxTipoInsc);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JLabel lblSelleccionarPartido = new JLabel("Selleccionar partido:");
		panel_3.add(lblSelleccionarPartido);
		
		JComboBox comboBoxPartidos = new JComboBox(toStringArray(BD.partidosConEstado(Abierto.class)));
		panel_3.add(comboBoxPartidos);
	}
	
	private String[] toStringArray(Collection coll){
		String[] strarr = new String[coll.size()];
		for (Object el : coll){
			strarr[strarr.length] = el.toString();
		}
		return strarr;
	}

}
