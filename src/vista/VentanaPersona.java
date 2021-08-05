package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import entidades.PersonaEntidad;
import modelo.Persona;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPersona extends JInternalFrame {
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textEdad;

	/**
	 * 
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaPersona() {
		dibujarGUI();
	}

	private void dibujarGUI() {
		// TODO Auto-generated method stub
		setClosable(true);
		setTitle("Ventana Persona");
		setBounds(100, 100, 1011, 480);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 25, 949, 383);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblId.setBounds(55, 44, 120, 50);
		panel.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNombre.setBounds(55, 134, 120, 50);
		panel.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEdad.setBounds(55, 222, 120, 50);
		panel.add(lblEdad);
		
		textId = new JTextField();
		textId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textId.setBounds(225, 49, 100, 50);
		panel.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textNombre.setColumns(10);
		textNombre.setBounds(225, 139, 600, 50);
		panel.add(textNombre);
		
		textEdad = new JTextField();
		textEdad.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textEdad.setColumns(10);
		textEdad.setBounds(225, 227, 600, 50);
		panel.add(textEdad);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id= Integer.parseInt(textId.getText());
					String nombre=  textNombre.getText();
					int edad= Integer.parseInt(textEdad.getText());
					Persona persona = new Persona(id, nombre, edad);
					persona.modificarPersona(persona.obtenerPersonaData());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(55, 307, 218, 50);
		panel.add(btnNewButton);


	}

	public VentanaPersona(PersonaEntidad persona) {
		// TODO Auto-generated constructor stub	
		dibujarGUI();
		textId.setText( String.valueOf(persona.getId()));
		//deshablito la escritura
		textId.setEditable(false);
		textNombre.setText(persona.getNombre());
		textEdad.setText(persona.getEdad()+"");
	}
}
