package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Keymap;

import entidades.PersonaEntidad;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class FormularioPrincipal02 extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private VentanaPersona ventanaPersona;
	private VentanaCalculadora ventanaCalculadora;
	private ListaPersonasInternalFrame02 ventanaListaPersonas02;

	// CTRL+SHIFT+F

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioPrincipal02 frame = new FormularioPrincipal02();
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
	public FormularioPrincipal02() {
		ventanaPersona = null;
		ventanaCalculadora = null;
		imprimirGUI();
		/*
		 * Graphical User Interface interfaz grafica de usuario
		 */
	}

	public void imprimirGUI() {

		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Ventana Principal 02");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 482);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnOpciones = new JMenu("General");
		mnOpciones.setMnemonic('g');
		menuBar.add(mnOpciones);

		JMenuItem mntmPersona = new JMenuItem("Persona");
		mntmPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verFormPersona();
			}
		});
		mnOpciones.add(mntmPersona);

		JMenuItem mntmListaPersonas = new JMenuItem("Lista Personas");
		mntmListaPersonas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mntmListaPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verFormListaPersonas();

			}
		});
		mnOpciones.add(mntmListaPersonas);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mnOpciones.add(mntmCliente);

		JSeparator separator = new JSeparator();
		mnOpciones.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnOpciones.add(mntmSalir);

		JMenu mnOperaciones = new JMenu("Operaciones");
		menuBar.add(mnOperaciones);

		JMenuItem mntmCalculadora = new JMenuItem("Calculadora");
		mntmCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verFormCalculadora();
			}
		});
		mnOperaciones.add(mntmCalculadora);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.activeCaption);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10).addComponent(desktopPane,
						GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)));

		JButton btnPersona = new JButton("Persona");
		btnPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verFormPersona();
			}
		});
		btnPersona.setFont(new Font("Dialog", Font.PLAIN, 16));
		toolBar.add(btnPersona);

		JButton btnCalculadora = new JButton("Lista Personas");
		btnCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verFormCalculadora();
			}
		});
		btnCalculadora.setFont(new Font("Dialog", Font.PLAIN, 16));
		toolBar.add(btnCalculadora);

		JButton btnListaPersonas = new JButton("Lista Personas");
		btnListaPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verFormListaPersonas();
			}
		});
		btnListaPersonas.setFont(new Font("Dialog", Font.PLAIN, 16));
		toolBar.add(btnListaPersonas);
		contentPane.setLayout(gl_contentPane);
		
	

	}

	public void verFormPersona(PersonaEntidad persona) {
		// evaluacion de los condicionales por circuito corto
		// evaluacion de los condicionales por circuito largo
		if (ventanaPersona == null || ventanaPersona.isClosed()) {
			ventanaPersona = new VentanaPersona(persona);
			desktopPane.add(ventanaPersona);
			Dimension tamVentanaDimension = ventanaPersona.getSize();
			int posX = (int) (desktopPane.getWidth() - tamVentanaDimension.width) / 2;
			ventanaPersona.setLocation(posX, 0);
			ventanaPersona.setVisible(true);
		}
	}

	public void verFormCalculadora() {
		// evaluacion de los condicionales por circuito corto
		// evaluacion de los condicionales por circuito largo
		if (ventanaCalculadora == null || ventanaCalculadora.isClosed()) {
			ventanaCalculadora = new VentanaCalculadora();
			desktopPane.add(ventanaCalculadora);
			Dimension tamVentanaDimension = ventanaCalculadora.getSize();
			int posX = (int) (desktopPane.getWidth() - tamVentanaDimension.width) / 2;
			ventanaCalculadora.setLocation(posX, 0);
			ventanaCalculadora.setVisible(true);
		}
	}

	public void verFormListaPersonas() {
		// evaluacion de los condicionales por circuito corto
		// evaluacion de los condicionales por circuito largo
		if (ventanaListaPersonas02 == null || ventanaListaPersonas02.isClosed()) {
			ventanaListaPersonas02 = new ListaPersonasInternalFrame02(this);
			desktopPane.add(ventanaListaPersonas02);
			Dimension tamVentanaDimension = ventanaListaPersonas02.getSize();
			int posX = (int) (desktopPane.getWidth() - tamVentanaDimension.width) / 2;
			ventanaListaPersonas02.setLocation(posX, 0);
			ventanaListaPersonas02.setVisible(true);
		}
	}// end verFormListaPersonas

	

	
	
	
	
	
	
}
