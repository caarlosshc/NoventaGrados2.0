package noventagrados.modelo;

import java.util.Objects;

import noventagrados.util.Color;
import noventagrados.util.TipoPieza;

/**
 * Clase: Pieza
 *
 * Representa una pieza en el juego noventagrados, con un tipo y un color
 * específicos.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public class Pieza {

	/**
	 * El tipo de la pieza (Peón o Reina).
	 */
	private final TipoPieza tipoPieza;

	/**
	 * El color de la pieza (Blanco o Negro).
	 */
	private final Color color;

	/**
	 * Constructor que inicializa la pieza con un tipo y un color.
	 *
	 * @param tipoPieza el tipo de la pieza
	 * @param color     el color de la pieza
	 */
	public Pieza(TipoPieza tipoPieza, Color color) {
		this.tipoPieza = tipoPieza;
		this.color = color;
	}

	/**
	 * Devuelve una representación textual de la pieza.
	 *
	 * @return una cadena que representa la pieza en formato "tipo color"
	 */
	public String aTexto() {
		return tipoPieza.toChar() + "" + color.toChar();
	}

	/**
	 * Crea y devuelve una copia de la pieza actual.
	 *
	 * @return una nueva instancia de Pieza con los mismos valores
	 */
	public Pieza clonar() {
		return new Pieza(this.tipoPieza, this.color);
	}

	/**
	 * Consulta el color de la pieza.
	 *
	 * @return el color de la pieza
	 */
	public Color consultarColor() {
		return this.color;
	}

	/**
	 * Consulta el tipo de la pieza.
	 *
	 * @return el tipo de la pieza
	 */
	public TipoPieza consultarTipoPieza() {
		return this.tipoPieza;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, tipoPieza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pieza other = (Pieza) obj;
		return color == other.color && tipoPieza == other.tipoPieza;
	}

	@Override
	public String toString() {
		return "Pieza [tipoPieza=" + tipoPieza + ", color=" + color + "]";
	}
}
