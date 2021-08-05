package persistencia;

import java.util.ArrayList;

import entidades.PersonaEntidad;

public class Singleton {
	private static Singleton instancia = null;
	private ArrayList<PersonaEntidad> listaPersonas;

	private Singleton() {
		// TODO Auto-generated constructor stub
	}

	public static Singleton getInstancia() {
		if (instancia == null) {
			instancia = new Singleton();
			instancia.listaPersonas = new ArrayList<PersonaEntidad>();
			PersonaEntidad p01 = new PersonaEntidad(1, "juan", 50, 25.6);
			PersonaEntidad p02 = new PersonaEntidad(20, "pedro", 105,-40);
			PersonaEntidad p03 = new PersonaEntidad(44, "susana", 45,50);
			PersonaEntidad p04 = new PersonaEntidad(36, "gabriela", 10,-4520);
			PersonaEntidad p05 = new PersonaEntidad(21, "joaquin", 38, 25.6);
			PersonaEntidad p06 = new PersonaEntidad(12, "sofia", 36,-40);
			PersonaEntidad p07 = new PersonaEntidad(58, "lorena", 50,50);
			PersonaEntidad p08 = new PersonaEntidad(10, "guillermo", 44,-4520);
			instancia.listaPersonas.add(p01);
			instancia.listaPersonas.add(p02);
			instancia.listaPersonas.add(p03);
			instancia.listaPersonas.add(p04);
			instancia.listaPersonas.add(p05);
			instancia.listaPersonas.add(p06);
			instancia.listaPersonas.add(p07);
			instancia.listaPersonas.add(p08);
			instancia.listaPersonas.add(new PersonaEntidad(9, "kevin", 27,-4520));
		}
		return instancia;
	}

	public ArrayList<PersonaEntidad> listarPersonas() {
		return listaPersonas;
	}
}
