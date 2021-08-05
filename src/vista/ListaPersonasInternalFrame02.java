package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
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
import ordenar.OrdenarPersonaEdad;
import ordenar.OrdenarPersonaEdadId;
import utilidades.GestionCeldas;
import utilidades.GestionCeldas02;

import utilidades.GestionEncabezadoTabla;
import utilidades.ModeloTabla;
import utilidades.Utilidades;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class ListaPersonasInternalFrame02 extends JInternalFrame implements MouseListener {
	// private JTable table;

	private DefaultTableModel dft;
	private JTable tablaPersonas;
	ArrayList<PersonaEntidad> listaPersonas;// lista que simula la información de la BD

	ModeloTabla modelo;// modelo definido en la clase ModeloTabla
	private int filasTabla;
	private int columnasTabla;
	private JScrollPane scrollPane;// tabla
	private FormularioPrincipal02 formularioPrincipal02;

	/**
	 * Launch the application.
	 */

	/**
	 * 
	 * Create the frame.
	 * 
	 * @param formularioPrincipal02
	 */

	public ListaPersonasInternalFrame02(FormularioPrincipal02 formularioPrincipal02) {
		this.formularioPrincipal02 = formularioPrincipal02;
		setMaximizable(true);
		setIconifiable(true);
		dibujarGUI();
		construirTabla();
	}

	private void dibujarGUI() {
		setTitle("Lista personas02");
		setClosable(true);
		setBounds(100, 100, 791, 500);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 37, 700, 241);
		getContentPane().add(scrollPane);

		tablaPersonas = new JTable();

		scrollPane.setViewportView(tablaPersonas);
		tablaPersonas.addMouseListener(this);
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
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPersona();
			}

		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModificar.setBounds(183, 37, 136, 43);
		panel.add(btnModificar);
	}

	public void cargarTablaPersonasAux() {

	}

	/*
	 * private void cargarTablaPersonas() { Persona persona = new Persona();
	 * listaPersonas = persona.listarPersonas(); String[][] data = new
	 * String[listaPersonas.size()][3]; for (int i = 0; i < listaPersonas.size();
	 * i++) { PersonaEntidad p = listaPersonas.get(i); data[i][0] =
	 * Integer.toString(p.getId()); data[i][1] = p.getNombre(); data[i][2] =
	 * Integer.toString(p.getEdad()); }
	 * 
	 * }
	 */

	private void construirTabla() {
		// llamamos
		Persona persona = new Persona();
		listaPersonas = persona.listarPersonas();
		// utiliza el metodo compareTo implementado en personaEntidad
		//listaPersonas.sort(null);
		listaPersonas.sort(new OrdenarPersonaEdad());
		//listaPersonas.sort(new OrdenarPersonaEdadId());
		/*listaPersonas.sort((p1, p2) -> {
			int valor = 0;
			if (p1.getEdad() < p2.getEdad()) {
				valor = -1;
			} else if (p1.getEdad() > p1.getEdad()) {
				valor = 1;
			} else if (p1.getId() < p1.getId()) {
				valor = -1;
			} else if (p1.getId() > p1.getId()) {
				valor = 1;
			} else {
				valor = 0;
			}
			return valor;
		});*/
		
		//listaPersonas.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
		
		ArrayList<String> titulosList = new ArrayList<>();

		titulosList.add("ID");
		titulosList.add("Nombre");
		titulosList.add("Edad");
		titulosList.add("Saldo");
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
			informacion[x][Utilidades.SALDO] = listaPersonas.get(x).getSaldo() + "";
		}
		return informacion;
	}

	private void construirTabla(String[] titulos, Object[][] data) {
		modelo = new ModeloTabla(data, titulos);
		// se asigna el modelo a la tabla
		tablaPersonas.setModel(modelo);

		// filasTabla=tablaPersonas.getRowCount();
		// columnasTabla=tablaPersonas.getColumnCount();

		// se asigna el tipo de dato que tendrán las celdas de cada columna definida
		// respectivamente para validar su personalización

		// tablaPersonas.getColumnModel().getColumn(Utilidades.ID).setCellRenderer(new
		// GestionCeldas02("texto"));
		// tablaPersonas.getColumnModel().getColumn(Utilidades.NOMBRE).setCellRenderer(new
		// GestionCeldas02("texto"));
		for (int i = 0; i < titulos.length - 1; i++) {// se resta 7 porque las ultimas 7 columnas se definen arriba
			// System.out.println(i);
			tablaPersonas.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas02("texto"));
		}
		tablaPersonas.getColumnModel().getColumn(Utilidades.SALDO).setCellRenderer(new GestionCeldas02("numerico"));

		// se recorre y asigna el resto de celdas que serian las que almacenen datos de
		// tipo texto

		tablaPersonas.getTableHeader().setReorderingAllowed(false);
		tablaPersonas.setRowHeight(25);// tamaño de las celdas
		tablaPersonas.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tamaño de largo para cada columna y su contenido
		tablaPersonas.getColumnModel().getColumn(Utilidades.ID).setPreferredWidth(100);// documento
		tablaPersonas.getColumnModel().getColumn(Utilidades.NOMBRE).setPreferredWidth(200);// nombre
		tablaPersonas.getColumnModel().getColumn(Utilidades.EDAD).setPreferredWidth(200);// direccion
		tablaPersonas.getColumnModel().getColumn(Utilidades.SALDO).setPreferredWidth(100);// direccion

		// personaliza el encabezado
		JTableHeader jtableHeader = tablaPersonas.getTableHeader();
		jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
		tablaPersonas.setTableHeader(jtableHeader);

		// limitar seleccion a una fila
		tablaPersonas.setRowSelectionAllowed(true);
		tablaPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// se asigna la tabla al scrollPane
		scrollPane.setViewportView(tablaPersonas);

		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int fila = tablaPersonas.rowAtPoint(e.getPoint());
		int columna = tablaPersonas.columnAtPoint(e.getPoint());
		Utilidades.filaSeleccionada = fila;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void modificarPersona() {
		// TODO Auto-generated method stub
		// llamar a la persona
		int fila = Utilidades.filaSeleccionada;
		if (fila >= 0) {
			PersonaEntidad persona = listaPersonas.get(fila);
			String info = "INFO PERSONA\n";
			info += "ID: " + persona.getId() + "\n";
			info += "Nombre: " + persona.getNombre() + "\n";
			info += "Edad: " + persona.getEdad() + "\n";
			// JOptionPane.showMessageDialog(null, info);
			formularioPrincipal02.verFormPersona(persona);
			this.dispose();
		}

	}
}
