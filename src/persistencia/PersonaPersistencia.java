package persistencia;

import java.util.ArrayList;
import java.util.Iterator;

import entidades.PersonaEntidad;

public class PersonaPersistencia implements PersonaRepositorio {

	@Override
	public ArrayList<PersonaEntidad> listarPersonas() {
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstancia();
		ArrayList<PersonaEntidad> lista = singleton.listarPersonas();
		return lista;
	}

	@Override
	public ArrayList<PersonaEntidad> agregarPersona() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PersonaEntidad> eliminarPersona() {
		// TODO Auto-generated method stub
		return null;
	}

	public void modificarPersona(PersonaEntidad persona) {
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstancia();
		ArrayList<PersonaEntidad> lista = singleton.listarPersonas();
		Iterator<PersonaEntidad> iterator=lista.iterator();
		while (iterator.hasNext()) {
			PersonaEntidad elem= iterator.next();
			if (persona.getId()==elem.getId()) {
				iterator.remove();
			}			
		}
		lista.add(persona);		
	}

}
