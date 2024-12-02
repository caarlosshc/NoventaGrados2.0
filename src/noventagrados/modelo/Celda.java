package noventagrados.modelo;

import java.util.Objects;

import noventagrados.util.Color;
import noventagrados.util.Coordenada;

/**
 * Clase: Celda
 *
 * Representa una celda en el tablero de la práctica noventagrados. Cada celda
 * tiene una coordenada y puede contener una pieza.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public class Celda {

	/**
	 * Coordenada de la celda en el tablero.
	 */
	private final Coordenada coordenada;

	/**
	 * Pieza colocada en la celda, puede ser null si la celda está vacía.
	 */
	private Pieza pieza;

	/**
	 * Constructor que inicializa la celda con una coordenada y sin pieza.
	 *
	 * @param coordenada la coordenada de la celda
	 */
	public Celda(Coordenada coordenada) {
		this.coordenada = coordenada;
		this.pieza = null;
	}

	/**
	 * Clona la celda actual, incluyendo su pieza si la tiene.
	 *
	 * @return una nueva instancia de Celda con los mismos valores
	 */
	public Celda clonar() {
		Celda clon = new Celda(this.coordenada);
		if (this.pieza != null) {
			clon.colocar(this.pieza.clonar());
		}
		return clon;
	}

	/**
	 * Coloca una pieza en la celda.
	 *
	 * @param pieza la pieza a colocar
	 */
	public void colocar(Pieza pieza) {
		this.pieza = pieza;
	}

	/**
	 * Consulta el color de la pieza en la celda.
	 *
	 * @return el color de la pieza, o null si la celda está vacía
	 */
	public Color consultarColorDePieza() {
		return (pieza != null) ? pieza.consultarColor() : null;
	}

	/**
	 * Consulta la coordenada de la celda.
	 *
	 * @return la coordenada de la celda
	 */
	public Coordenada consultarCoordenada() {
		return this.coordenada;
	}

	/**
	 * Consulta la pieza colocada en la celda.
	 *
	 * @return la pieza en la celda, o null si está vacía
	 */
	public Pieza consultarPieza() {
		return this.pieza;
	}

	/**
	 * Elimina la pieza de la celda, dejándola vacía.
	 */
	public void eliminarPieza() {
		this.pieza = null;
	}

	/**
	 * Verifica si la celda está vacía.
	 *
	 * @return true si la celda no tiene pieza, false en caso contrario
	 */
	public boolean estaVacia() {
		return this.pieza == null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordenada, pieza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Celda other = (Celda) obj;
		return Objects.equals(coordenada, other.coordenada) && Objects.equals(pieza, other.pieza);
	}

	@Override
	public String toString() {
		return "Celda [coordenada=" + coordenada + ", pieza=" + pieza + "]";
	}
}
