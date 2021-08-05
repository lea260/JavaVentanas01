package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FormularioPrincipal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private VentanaPersona ventanaPersona;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioPrincipal frame = new FormularioPrincipal();
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
	public FormularioPrincipal() {
		ventanaPersona = null;
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Programa de Gesti\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 438);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);

		JMenuItem mntmPersona = new JMenuItem("Persona");
		mntmPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verFormPersona();
			}
		});
		mnOpciones.add(mntmPersona);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mnOpciones.add(mntmCliente);

		JSeparator separator = new JSeparator();
		mnOpciones.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnOpciones.add(mntmSalir);

		JMenu mnPedidos = new JMenu("Pedidos");
		menuBar.add(mnPedidos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.activeCaption);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
						.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE).addGap(10)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE).addContainerGap()));

		JButton btnNewButton = new JButton("Persona");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verFormPersona();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolBar.add(btnNewButton);
		contentPane.setLayout(gl_contentPane);
	}

	public void verFormPersona() {
		// evaluacion de los condicionales por circuito corto
		// evaluacion de los condicionales por circuito largo
		if (ventanaPersona == null || ventanaPersona.isClosed()) {
			ventanaPersona = new VentanaPersona();
			desktopPane.add(ventanaPersona);
			Dimension tamVentanaDimension = ventanaPersona.getSize();
			int posX = (int) (desktopPane.getWidth() - tamVentanaDimension.width) / 2;
			ventanaPersona.setLocation(posX, 0);
			ventanaPersona.setVisible(true);
		}
	}
}
