package modelo;

import java.util.ArrayList;

import entidades.PersonaEntidad;
import persistencia.PersonaPersistencia;
import persistencia.PersonaRepositorio;

public class Persona {
	private int id;
	private String nombre;
	private int edad;

	public Persona() {

	}

	public Persona(int id, String nombre, int edad) throws Exception {
		super();
		if (edad<0) {
			throw new Exception("la edad no puede ser negativa");
		}
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}

	public static int anioMayor = 18;

	public static boolean ingresar(String nombre, String pass) {
		boolean tieneIngreso = false;
		if (nombre.equals("diego") && pass.equals("1234")) {
			tieneIngreso = true;
		}
		return tieneIngreso;
	}

	public ArrayList<PersonaEntidad> listarPersonas() {
		PersonaRepositorio persistencia = new PersonaPersistencia();
		ArrayList<PersonaEntidad> lista = new ArrayList<PersonaEntidad>();
		lista = persistencia.listarPersonas();
		return lista;
	}

	public void modificarPersona() {
		// TODO Auto-generated method stub
	
	}
	
	public PersonaEntidad obtenerPersonaData() {
		return new PersonaEntidad(id, nombre, edad);
	}

	public void modificarPersona(PersonaEntidad persona) {
		// TODO Auto-generated method stub
		PersonaPersistencia persistencia = new PersonaPersistencia();
		persistencia.modificarPersona(persona);
		
	}
}
