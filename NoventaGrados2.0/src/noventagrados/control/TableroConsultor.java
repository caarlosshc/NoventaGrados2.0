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
 * @param <T> Tipo de tablero, que extiende de la clase Tablero. Autores: Carmen
 *            Minguela Zamarro, Carlos De La Huerga Cenador Versión: 1.0
 */

public class TableroConsultor<T extends Tablero> {
	private final T tablero;

	public TableroConsultor(T tablero) {
		this.tablero = tablero; // Se clona el tablero para evitar efectos colaterales
	}

	public Sentido calcularSentido(Coordenada origen, Coordenada destino) {
		if (origen.fila() == destino.fila()) {
			// Están en la misma fila
			return origen.columna() < destino.columna() ? Sentido.HORIZONTAL_E : Sentido.HORIZONTAL_O;
		} else if (origen.columna() == destino.columna()) {
			// Están en la misma columna
			return origen.fila() < destino.fila() ? Sentido.VERTICAL_S : Sentido.VERTICAL_N;
		}
		return null; // No es un sentido válido si no están en la misma fila ni columna
	}

	public int consultarDistanciaEnHorizontal(Coordenada origen, Coordenada destino) {
		if (origen.fila() != destino.fila()) {
			return -1; // No están en la misma fila
		}
		return Math.abs(destino.columna() - origen.columna());
	}

	public int consultarDistanciaEnVertical(Coordenada origen, Coordenada destino) {
		if (origen.columna() != destino.columna()) {
			return -1; // No están en la misma columna
		}
		return Math.abs(destino.fila() - origen.fila());
	}

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

	public boolean estaReinaEnElCentro(Color color) {
		Coordenada centro = new Coordenada(3, 3); // Centro del tablero 7x7
		Pieza pieza = tablero.consultarCelda(centro).consultarPieza();
		return pieza != null && pieza.consultarTipoPieza() == TipoPieza.REINA && pieza.consultarColor() == color;
	}

	public boolean hayReina(Color color) {
		for (Celda celda : tablero.consultarCeldas()) {
			Pieza pieza = celda.consultarPieza();
			if (pieza != null && pieza.consultarTipoPieza() == TipoPieza.REINA && pieza.consultarColor() == color) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "TableroConsultor [tablero=" + tablero + "]";
	}

}
