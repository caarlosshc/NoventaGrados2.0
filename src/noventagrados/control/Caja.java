package noventagrados.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import noventagrados.modelo.Pieza;
import noventagrados.util.Color;
import noventagrados.util.TipoPieza;

/**
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */

public class Caja {
	private static final int CAPACIDAD_MAXIMA = 7;
	private Color color;
	private List<Pieza> piezas;

	// Constructor
	public Caja(Color color) {
		this.color = color;
		this.piezas = new ArrayList<>();
	}

	// Añade una pieza a la caja si cumple con las condiciones
	public void añadir(Pieza pieza) {
		if (pieza != null && pieza.consultarColor() == this.color && piezas.size() < CAPACIDAD_MAXIMA) {
			piezas.add(pieza);
		}
	}

	// Devuelve un clon profundo de la caja
	public Caja clonar() {
		Caja clon = new Caja(this.color);
		for (Pieza pieza : piezas) {
			clon.añadir(pieza.clonar());
		}
		return clon;
	}

	// Devuelve el color de la caja
	public Color consultarColor() {
		return this.color;
	}

	// Devuelve una lista de clones profundos de las piezas en la caja
	public List<Pieza> consultarPiezas() {
		List<Pieza> piezasClon = new ArrayList<>();
		for (Pieza pieza : piezas) {
			piezasClon.add(pieza.clonar());
		}
		return piezasClon;
	}

	// Cuenta el total de piezas en la caja
	public int contarPiezas() {
		return piezas.size();
	}

	// Cuenta las piezas de un tipo específico en la caja
	public int contarPiezas(TipoPieza tipoPieza) {
		int contador = 0;
		for (Pieza pieza : piezas) {
			if (pieza.consultarTipoPieza() == tipoPieza) {
				contador++;
			}
		}
		return contador;
	}

	// Métodos equals, hashCode y toString generados automáticamente
	@Override
	public int hashCode() {
		return Objects.hash(color, piezas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Caja other = (Caja) obj;
		return color == other.color && Objects.equals(piezas, other.piezas);
	}

	@Override
	public String toString() {
		return "Caja [color=" + color + ", piezas=" + piezas + "]";
	}
}
