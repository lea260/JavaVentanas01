package modelo;

import java.util.IllegalFormatCodePointException;

/*
  else {
     *      // Perform suitable alternative action
     *  }
     * }</pre>
     *
     * @param      s   the string to be parsed.
     * @return     a {@code Double} object holding the value
     *             represented by the {@code String} argument.
     * @throws     NumberFormatException  if the string does not contain a
     *             parsable number.
*/

import excepciones.OperacionRetiroInvalida;

//%userprofile%
//windows+r
public class Cuenta {
	private String titular;
	private double cantidad;

	public Cuenta(String titular, double cantidad) {
		super();
		this.titular = titular;
		this.setCantidad(cantidad);
	}

	public Cuenta(String titular) {
		this(titular, 0);
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		if (cantidad < 0) {
			throw new IllegalArgumentException("la cantidad no puede ser negativa");
		}
		this.cantidad = cantidad;
	}

	/*
	 * CTRL+SHIFT+F
	 */

	public void ingresar(double cantidad) {
		if (cantidad > 0) {
			this.cantidad += cantidad;
		}
	}

	public void retirar(double cantidad) throws IllegalArgumentException, OperacionRetiroInvalida {
		if (cantidad < 0) {
			throw new IllegalArgumentException("la cantidad no puede ser negativa");
		}
		double saldo = this.cantidad - cantidad;
		if (saldo >= 0) {
			this.cantidad = saldo;
		} else {
			throw new OperacionRetiroInvalida("saldo insuficiente cuenta");
		}
	}// end retirar

	@Override
	public String toString() {
		return "Cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
	}

}
