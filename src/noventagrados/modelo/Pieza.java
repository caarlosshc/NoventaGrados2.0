package noventagrados.modelo;

import java.util.Objects;

import noventagrados.util.Color;
import noventagrados.util.TipoPieza;

/**
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */

public class Pieza {

	private final TipoPieza tipoPieza;
	private final Color color;

	public Pieza(TipoPieza tipoPieza, Color color) {
		this.tipoPieza = tipoPieza;
		this.color = color;
	}

	public String aTexto() {
		return tipoPieza.toChar() + "" + color.toChar();
	}

	public Pieza clonar() {
		return new Pieza(this.tipoPieza, this.color);
	}

	public Color consultarColor() {
		return this.color;
	}

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