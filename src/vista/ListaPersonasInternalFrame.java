package vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidades.PersonaEntidad;
import modelo.Persona;

public class ListaPersonasInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPersonasInternalFrame frame = new ListaPersonasInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaPersonasInternalFrame() {
		setTitle("ListaPersonas");
		setClosable(true);
		setBounds(100, 100, 791, 500);
		getContentPane().setLayout(null);

		Persona persona = new Persona();
		ArrayList<PersonaEntidad> lista = persona.listarPersonas();

		String[][] data = new String[lista.size()][3];
		for (int i = 0; i < lista.size(); i++) {
			PersonaEntidad p = lista.get(i);
			data[i][0] = Integer.toString(p.getId());
			data[i][1] = p.getNombre();
			data[i][2] = Integer.toString(p.getEdad());
		}
		// String data[][] = { { "101", "Amit", "66" }, { "102", "Jai", "88" }, { "101",
		// "Sachin", "90" } };
		String column[] = { "ID", "Nombre", "Edad" };
		JTable jt = new JTable(data, column);
		jt.setBounds(30, 40, 200, 300);

		JScrollPane scrollPane = new JScrollPane(jt);
		scrollPane.setBounds(43, 11, 600, 300);
		getContentPane().add(scrollPane);

	}
}
