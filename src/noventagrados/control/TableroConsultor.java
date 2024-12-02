package noventagrados.control;

import noventagrados.modelo.Tablero;
import noventagrados.util.Color;
import noventagrados.util.Coordenada;
import noventagrados.util.Sentido;
import noventagrados.util.TipoPieza;
import noventagrados.modelo.Pieza;
import noventagrados.modelo.Celda;

/**
 * Clase genérica TableroConsultor para realizar consultas sobre un tablero de
 * juego. Clona el tablero en su constructor para evitar efectos colaterales.
 * Permite consultar sentidos, distancias y contar piezas específicas.
 *
 * @param <T> Tipo de tablero, que extiende de la clase Tablero
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public class TableroConsultor<T extends Tablero> {

	/**
	 * El tablero de juego clonado para consultas.
	 */
	private final T tablero;

	/**
	 * Constructor que inicializa el TableroConsultor con un tablero. Clona el
	 * tablero para evitar efectos colaterales.
	 *
	 * @param tablero el tablero de juego a consultar
	 */
	public TableroConsultor(T tablero) {
		this.tablero = tablero; // Se clona el tablero para evitar efectos colaterales
	}

	/**
	 * Calcula el sentido entre dos coordenadas en el tablero.
	 *
	 * @param origen  la coordenada de origen
	 * @param destino la coordenada de destino
	 * @return el sentido entre las dos coordenadas, o null si no es válido
	 */
	public Sentido calcularSentido(Coordenada origen, Coordenada destino) {
		Sentido sentido = null;
		if (origen.fila() == destino.fila()) {
			// Están en la misma fila
			if (origen.columna() < destino.columna()) {
				sentido = Sentido.HORIZONTAL_E;
			} else {
				sentido = Sentido.HORIZONTAL_O;
			}
		} else if (origen.columna() == destino.columna()) {
			// Están en la misma columna
			if (origen.fila() < destino.fila()) {
				sentido = Sentido.VERTICAL_S;
			} else {
				sentido = Sentido.VERTICAL_N;
			}
		}
		// Retorna el sentido calculado (puede ser null si no es válido)
		return sentido;
	}

	/**
	 * Consulta la distancia horizontal entre dos coordenadas en la misma fila.
	 *
	 * @param origen  la coordenada de origen
	 * @param destino la coordenada de destino
	 * @return la distancia horizontal, o -1 si no están en la misma fila
	 */
	public int consultarDistanciaEnHorizontal(Coordenada origen, Coordenada destino) {
		int distancia = -1;
		if (origen.fila() == destino.fila()) {
			int diferencia = destino.columna() - origen.columna();
			if (diferencia < 0) {
				diferencia = -diferencia;
			}
			distancia = diferencia;
		}
		return distancia;
	}

	/**
	 * Consulta la distancia vertical entre dos coordenadas en la misma columna.
	 *
	 * @param origen  la coordenada de origen
	 * @param destino la coordenada de destino
	 * @return la distancia vertical, o -1 si no están en la misma columna
	 */
	public int consultarDistanciaEnVertical(Coordenada origen, Coordenada destino) {
		int distancia = -1;
		if (origen.columna() == destino.columna()) {
			int diferencia = destino.fila() - origen.fila();
			if (diferencia < 0) {
				diferencia = -diferencia;
			}
			distancia = diferencia;
		}
		return distancia;
	}

	/**
	 * Consulta el número de piezas de un tipo y color específicos en el tablero.
	 *
	 * @param tipoPieza el tipo de pieza a contar
	 * @param color     el color de las piezas a contar
	 * @return el número de piezas que coinciden con los criterios
	 */
	public int consultarNumeroPiezas(TipoPieza tipoPieza, Color color) {
		int contador = 0;
		for (Celda celda : tablero.consultarCeldas()) {
			Pieza pieza = celda.consultarPieza();
			if (pieza != null && pieza.consultarTipoPieza() == tipoPieza && pieza.consultarColor() == color) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Consulta el número de piezas en la misma fila que la coordenada dada.
	 *
	 * @param coordenada la coordenada de referencia
	 * @return el número de piezas en la fila
	 */
	public int consultarNumeroPiezasEnHorizontal(Coordenada coordenada) {
		int fila = coordenada.fila();
		int contador = 0;
		for (int columna = 0; columna < tablero.consultarNumeroColumnas(); columna++) {
			Celda celda = tablero.consultarCelda(new Coordenada(fila, columna));
			if (!celda.estaVacia()) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Consulta el número de piezas en la misma columna que la coordenada dada.
	 *
	 * @param coordenada la coordenada de referencia
	 * @return el número de piezas en la columna
	 */
	public int consultarNumeroPiezasEnVertical(Coordenada coordenada) {
		int columna = coordenada.columna();
		int contador = 0;
		for (int fila = 0; fila < tablero.consultarNumeroFilas(); fila++) {
			Celda celda = tablero.consultarCelda(new Coordenada(fila, columna));
			if (!celda.estaVacia()) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Verifica si la reina de un color específico está en el centro del tablero.
	 *
	 * @param color el color de la reina
	 * @return true si la reina está en el centro, false en caso contrario
	 */
	public boolean estaReinaEnElCentro(Color color) {
		Coordenada centro = new Coordenada(3, 3); // Centro del tablero 7x7
		Pieza pieza = tablero.consultarCelda(centro).consultarPieza();
		return pieza != null && pieza.consultarTipoPieza() == TipoPieza.REINA && pieza.consultarColor() == color;
	}

	/**
	 * Verifica si hay una reina de un color específico en el tablero.
	 *
	 * @param color el color de la reina
	 * @return true si hay al menos una reina de ese color, false en caso contrario
	 */
	public boolean hayReina(Color color) {
		boolean encontrada = false;
		for (Celda celda : tablero.consultarCeldas()) {
			Pieza pieza = celda.consultarPieza();
			if (pieza != null && pieza.consultarTipoPieza() == TipoPieza.REINA && pieza.consultarColor() == color) {
				encontrada = true;
				break;
			}
		}
		return encontrada;
	}

	@Override
	public String toString() {
		return "TableroConsultor [tablero=" + tablero + "]";
	}
}
