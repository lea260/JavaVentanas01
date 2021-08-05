package ordenar;

import java.util.Comparator;

import entidades.PersonaEntidad;

public class OrdenarPersonaEdad implements Comparator<PersonaEntidad>{

	@Override
	public int compare(PersonaEntidad p1, PersonaEntidad p2) {
		// TODO Auto-generated method stub
		int valor = 0;
		if (p1.getEdad() < p2.getEdad()) {
			valor = -1;
		} else if (p1.getEdad() > p1.getEdad()) {
			valor = 1;
		} else {
			valor = 0;
		}
		return valor;
	}

}
