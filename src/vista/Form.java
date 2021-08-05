package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;

public class Form extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
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
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 423);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);

		JMenuItem mntmNewMenuItem = new JMenuItem("Persona");
		mnOpciones.add(mntmNewMenuItem);

		JSeparator separator = new JSeparator();
		mnOpciones.add(separator);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mnOpciones.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();

		JDesktopPane desktopPane = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
						.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE).addGap(20)
						.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE).addGap(33)));
		contentPane.setLayout(gl_contentPane);
	}

}
