package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Persona;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaLogin extends JFrame {

	/*
	 * CTRL+SHIFT+S CTRL+SHIFT+F
	 */
	private JPanel contentPane;
	private JTextField textNombre;
	private JPasswordField textPass;
	private JLabel lblmensaje;
	private JFrame ventanalogin;

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		// login frame guarda la ventana login
		ventanalogin = this;
		setTitle("Ventana Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(51, 62, 675, 475);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNombre.setBounds(38, 52, 156, 60);
		panel.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Dialog", Font.PLAIN, 30));
		textNombre.setBounds(250, 62, 400, 50);
		panel.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblPass = new JLabel("Password:");
		lblPass.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblPass.setBounds(38, 181, 156, 60);
		panel.add(lblPass);

		/* no usar keytyped para esto */
		textPass = new JPasswordField();
		textPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ingresar();
				}
			}
		});

		textPass.setFont(new Font("Dialog", Font.PLAIN, 30));
		textPass.setBounds(250, 194, 400, 50);
		panel.add(textPass);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// accion del boton
				ingresar();
			}
		});

		btnIngresar.setFont(new Font("Dialog", Font.PLAIN, 30));
		btnIngresar.setBounds(38, 289, 200, 50);
		panel.add(btnIngresar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Dialog", Font.PLAIN, 30));
		btnLimpiar.setBounds(450, 289, 200, 50);
		panel.add(btnLimpiar);

		lblmensaje = new JLabel("Pendiente");
		lblmensaje.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblmensaje.setBounds(38, 370, 156, 60);
		panel.add(lblmensaje);
	}

	private void ingresar() {
		String nombreString = textNombre.getText();
		char[] passChar = textPass.getPassword();
		String passString = new String(passChar);
		boolean resultadoLogin = false;
		resultadoLogin = Persona.ingresar(nombreString, passString);
		if (resultadoLogin) {
			limpiar();
			lblmensaje.setText("Exitoso");
			FormularioPrincipal02 ventanaPrincipal = new FormularioPrincipal02();
			ventanaPrincipal.setVisible(true);
			ventanalogin.setVisible(false);
		} else {
			lblmensaje.setText("No Exitoso");
		}
	}

	private void limpiar() {
		textNombre.setText("");
		textPass.setText("");
		lblmensaje.setText("Pendiente");
	}
}
