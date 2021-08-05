package entidades;

public class PersonaEntidad implements Comparable<PersonaEntidad> {
	private int id;
	private String nombre;
	private int edad;
	private double saldo;

	public PersonaEntidad(int id, String nombre, int edad, double saldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.saldo = saldo;
	}

	public PersonaEntidad(int id, String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public double getSaldo() {
		return saldo;
	}

	//ordenando por id
	@Override
	public int compareTo(PersonaEntidad p1) {
		// TODO Auto-generated method stub
		int valor = 0;
		if (this.getId() < p1.getId()) {
			valor = -1;
		} else if (this.getId() > p1.getId()) {
			valor = 1;
		} else {
			valor = 0;
		}
		return valor;
	}

}
