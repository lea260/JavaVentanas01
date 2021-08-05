package persistencia;

import java.util.ArrayList;

import entidades.PersonaEntidad;

public interface PersonaRepositorio {
	ArrayList<PersonaEntidad> listarPersonas();

	ArrayList<PersonaEntidad> agregarPersona();

	ArrayList<PersonaEntidad> eliminarPersona();
}
