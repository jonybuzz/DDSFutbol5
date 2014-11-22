package GUI;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import negocio.Partido;
import negocio.inscripcion.Abierto;
import utils.FutbolException;
import fixture.BD;

public class WndInscripcion {

	private JFrame frmAppFutbol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WndInscripcion window = new WndInscripcion();
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
	public WndInscripcion() {
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
		frmAppFutbol.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frmAppFutbol.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		frmAppFutbol.getContentPane().add(panel_2);
		
		JLabel lblTipoDeInscripcion = new JLabel("Tipo de Inscripcion");
		panel_2.add(lblTipoDeInscripcion);
		
		JComboBox<String[]> comboBoxTipoInsc = new JComboBox<String[]>();
		comboBoxTipoInsc.setSelectedIndex(0);
		panel_2.add(comboBoxTipoInsc);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JLabel lblSelleccionarPartido = new JLabel("Seleccionar partido:");
		panel_3.add(lblSelleccionarPartido);
		
		try {
			BD.init();
			BD.agregarPartido(new Partido(BD.administrador(), 2014, 12, 5, 15,00));
		} catch (FutbolException e) {

		}
		
		JComboBox<String> comboBoxPartidos = new JComboBox<String>(toStringArray(BD.partidosConEstado(Abierto.class)));
		panel_3.add(comboBoxPartidos);
		
		JPanel panel_1 = new JPanel();
		frmAppFutbol.getContentPane().add(panel_1);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar);
		panel_1.add(btnOk);
		
	}
	
	private String[] toStringArray(Collection<?> coll){
		String[] strarr = new String[coll.size()];
		for (Object el : coll){
			strarr[strarr.length-1] = el.toString();
		}
		return strarr;
	}

}
