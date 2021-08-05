package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.plaf.basic.BasicSplitPaneUI.BasicHorizontalLayoutManager;
import javax.swing.text.Keymap;

import excepciones.OperacionRetiroInvalida;
import modelo.Cuenta;
import modelo.Persona;

import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class VentanaCalculadora extends JInternalFrame {
	private JTextField textValor01;
	private JTextField textValor02;
	private JTextField textResultado; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCalculadora frame = new VentanaCalculadora();
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
	public VentanaCalculadora() {
		setTitle("Calculadora");
		setClosable(true);
		setBounds(100, 100, 791, 399);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 49, 761, 295);
		getContentPane().add(panel);
		panel.setLayout(null);

		textValor01 = new JTextField();
		textValor01.setFont(new Font("Dialog", Font.PLAIN, 18));
		textValor01.setBounds(77, 11, 490, 50);
		panel.add(textValor01);
		textValor01.setColumns(10);

		textValor02 = new JTextField();
		textValor02.setFont(new Font("Dialog", Font.PLAIN, 18));
		textValor02.setBounds(77, 86, 490, 50);
		panel.add(textValor02);
		textValor02.setColumns(10);

		textResultado = new JTextField();
		textResultado.setFont(new Font("Dialog", Font.PLAIN, 18));
		textResultado.setBounds(77, 159, 490, 50);
		panel.add(textResultado);
		textResultado.setColumns(10);

		JButton btnMultiplicar = new JButton("Resultado");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Cuenta cuenta = new Cuenta("pedro",500);
					// cuenta.retirar(600);
					String valor01 = textValor01.getText().trim();
					String valor02 = textValor02.getText().trim();
					double num01 = Double.parseDouble(valor01);
					double num02 = Double.parseDouble(valor02);
					double resultado = num01 / num02;
					if (Double.isInfinite(resultado)) {
						throw new ArithmeticException("no se puede dividir por cero");
					}
					textResultado.setText(Double.toString(resultado));
				} catch (NullPointerException e2) {
					// TODO: handle exception
					textResultado.setText("error de puntero nulo");
				} catch (NumberFormatException e2) {
					textResultado.setText("error al convertir");
				} // catch (OperacionRetiroInvalida e2) {
					// textResultado.setText(e2.getMessage());
					// }
			}
		});
		btnMultiplicar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnMultiplicar.setBounds(77, 234, 490, 50);
		panel.add(btnMultiplicar);

	}
	
	

}
