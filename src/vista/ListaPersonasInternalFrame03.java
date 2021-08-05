package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import entidades.PersonaEntidad;
import modelo.Persona;
import utilidades.GestionCeldas;
import utilidades.GestionEncabezadoTabla;
import utilidades.ModeloTabla;
import utilidades.Utilidades;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaPersonasInternalFrame03 extends JInternalFrame {
	// private JTable table;
	private DefaultTableModel dft;
	private JTable tablaPersonas;
	ArrayList<PersonaEntidad> listaPersonas;// lista que simula la información de la BD

	ModeloTabla modelo;// modelo definido en la clase ModeloTabla
	private int filasTabla;
	private int columnasTabla;
	private JScrollPane scrollPane;// tabla

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPersonasInternalFrame03 frame = new ListaPersonasInternalFrame03();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the frame.
	 */

	public ListaPersonasInternalFrame03() {
		dibujarGUI();
		//cargarTablaPersonas();
		construirTabla();
	}

	private void dibujarGUI() {
		setTitle("Lista personas02");
		setClosable(true);
		setBounds(100, 100, 791, 500);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 37, 700, 241);
		getContentPane().add(scrollPane);

		tablaPersonas = new JTable();

		scrollPane.setViewportView(tablaPersonas);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Botones",
				TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel.setBounds(30, 312, 700, 120);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTablaPersonasAux();
			}
		});
		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCargar.setBounds(21, 37, 136, 43);
		panel.add(btnCargar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModificar.setBounds(183, 37, 136, 43);
		panel.add(btnModificar);
	}

	public void cargarTablaPersonasAux() {
		String data[][] = { { "101", "Amit", "66" }, { "102", "Jai", "88" }, { "101", "Sachin", "90" } };
		String column[] = { "ID", "Nombre", "Edad" };
		dft = new DefaultTableModel(data, column);
		tablaPersonas.setModel(dft);
	}

	// CTRL+SHIFT+F
	private void cargarTablaPersonas() {
		Persona persona = new Persona();
		listaPersonas = persona.listarPersonas();
		String[][] data = new String[listaPersonas.size()][3];
		for (int i = 0; i < listaPersonas.size(); i++) {
			PersonaEntidad p = listaPersonas.get(i);
			data[i][0] = Integer.toString(p.getId());
			data[i][1] = p.getNombre();
			data[i][2] = Integer.toString(p.getEdad());
		}
		// String data[][] = { { "101", "Amit", "66" }, { "102", "Jai", "88" }, { "101",
		// "Sachin", "90" } };
		String column[] = { "ID", "Nombre", "Edad" };

		dft = new DefaultTableModel(data, column);
		tablaPersonas.setModel(dft);
	}

	private void construirTabla() {
		// llamamos

		Persona persona = new Persona();
		listaPersonas = persona.listarPersonas();

		ArrayList<String> titulosList = new ArrayList<>();

		titulosList.add("ID");
		titulosList.add("Nombre");
		titulosList.add("Edad");
		// se asignan las columnas al arreglo para enviarse al momento de construir la
		// tabla
		String titulos[] = new String[titulosList.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = titulosList.get(i);
		}
		/*
		 * obtenemos los datos de la lista y los guardamos en la matriz que luego se
		 * manda a construir la tabla
		 */
		Object[][] data = obtenerMatrizDatos(titulosList);
		construirTabla(titulos, data);
	}

	private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

		/*
		 * se crea la matriz donde las filas son dinamicas pues corresponde a todos los
		 * usuarios, mientras que las columnas son estaticas correspondiendo a las
		 * columnas definidas por defecto
		 */
		String informacion[][] = new String[listaPersonas.size()][titulosList.size()];

		for (int x = 0; x < informacion.length; x++) {
			informacion[x][Utilidades.ID] = listaPersonas.get(x).getId() + "";
			informacion[x][Utilidades.NOMBRE] = listaPersonas.get(x).getNombre() + "";
			informacion[x][Utilidades.EDAD] = listaPersonas.get(x).getEdad() + "";
		}
		return informacion;
	}
	
	private void construirTabla(String[] titulos, Object[][] data) {
		modelo=new ModeloTabla(data, titulos);
		//se asigna el modelo a la tabla
		tablaPersonas.setModel(modelo);
		
		filasTabla=tablaPersonas.getRowCount();
		columnasTabla=tablaPersonas.getColumnCount();
		
		//se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización
		tablaPersonas.getColumnModel().getColumn(Utilidades.ID).setCellRenderer(new GestionCeldas("text"));
		tablaPersonas.getColumnModel().getColumn(Utilidades.NOMBRE).setCellRenderer(new GestionCeldas("text"));
		tablaPersonas.getColumnModel().getColumn(Utilidades.EDAD).setCellRenderer(new GestionCeldas("text"));
		
		
		//se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
				
		tablaPersonas.getTableHeader().setReorderingAllowed(false);
		tablaPersonas.setRowHeight(25);//tamaño de las celdas
		tablaPersonas.setGridColor(new java.awt.Color(0, 0, 0)); 
		//Se define el tamaño de largo para cada columna y su contenido
		tablaPersonas.getColumnModel().getColumn(Utilidades.ID).setPreferredWidth(130);//documento
		tablaPersonas.getColumnModel().getColumn(Utilidades.NOMBRE).setPreferredWidth(350);//nombre
		tablaPersonas.getColumnModel().getColumn(Utilidades.EDAD).setPreferredWidth(350);//direccion
		
		//personaliza el encabezado
		JTableHeader jtableHeader = tablaPersonas.getTableHeader();
	    jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
	    tablaPersonas.setTableHeader(jtableHeader);
	    
	    //se asigna la tabla al scrollPane
	    scrollPane.setViewportView(tablaPersonas);

	}

}
