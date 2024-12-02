package noventagrados.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import noventagrados.modelo.Pieza;
import noventagrados.util.Color;
import noventagrados.util.TipoPieza;

/**
 * Clase: Caja
 *
 * Representa la caja de piezas capturadas por un jugador en el juego
 * noventagrados. Cada caja tiene un color y puede contener hasta una capacidad
 * máxima de piezas.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public class Caja {

	/**
	 * Capacidad máxima de la caja.
	 */
	private static final int CAPACIDAD_MAXIMA = 7;

	/**
	 * Color de las piezas en la caja.
	 */
	private Color color;

	/**
	 * Lista de piezas en la caja.
	 */
	private List<Pieza> piezas;

	/**
	 * Constructor que inicializa la caja con el color dado.
	 *
	 * @param color el color de las piezas que contendrá la caja
	 */
	public Caja(Color color) {
		this.color = color;
		this.piezas = new ArrayList<>();
	}

	/**
	 * Añade una pieza a la caja si cumple con las condiciones.
	 *
	 * @param pieza la pieza a añadir
	 */
	public void añadir(Pieza pieza) {
		if (pieza != null && pieza.consultarColor() == this.color && piezas.size() < CAPACIDAD_MAXIMA) {
			piezas.add(pieza);
		}
	}

	/**
	 * Crea y devuelve un clon profundo de la caja.
	 *
	 * @return una nueva instancia de Caja que es una copia de la actual
	 */
	public Caja clonar() {
		Caja clon = new Caja(this.color);
		for (Pieza pieza : piezas) {
			clon.añadir(pieza.clonar());
		}
		return clon;
	}

	/**
	 * Consulta el color de la caja.
	 *
	 * @return el color de la caja
	 */
	public Color consultarColor() {
		return this.color;
	}

	/**
	 * Devuelve una lista de clones profundos de las piezas en la caja.
	 *
	 * @return una lista de piezas en la caja
	 */
	public List<Pieza> consultarPiezas() {
		List<Pieza> piezasClon = new ArrayList<>();
		for (Pieza pieza : piezas) {
			piezasClon.add(pieza.clonar());
		}
		return piezasClon;
	}

	/**
	 * Cuenta el total de piezas en la caja.
	 *
	 * @return el número de piezas en la caja
	 */
	public int contarPiezas() {
		return piezas.size();
	}

	/**
	 * Cuenta las piezas de un tipo específico en la caja.
	 *
	 * @param tipoPieza el tipo de pieza a contar
	 * @return el número de piezas del tipo especificado en la caja
	 */
	public int contarPiezas(TipoPieza tipoPieza) {
		int contador = 0;
		for (Pieza pieza : piezas) {
			if (pieza.consultarTipoPieza() == tipoPieza) {
				contador++;
			}
		}
		return contador;
	}

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
