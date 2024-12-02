package noventagrados.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import noventagrados.util.Coordenada;

/**
 * Clase: Tablero
 *
 * Representa el tablero del juego noventagrados. El tablero es una matriz
 * cuadrada de tamaño fijo que contiene celdas. Cada celda puede contener una
 * pieza o estar vacía.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public class Tablero {

	/**
	 * Tamaño del tablero (número de filas y columnas).
	 */
	private static final int TAMANO = 7;

	/**
	 * Matriz que representa el tablero, compuesta por listas de celdas.
	 */
	private List<List<Celda>> matriz;

	/**
	 * Constructor que inicializa el tablero con celdas vacías en todas las
	 * posiciones.
	 */
	public Tablero() {
		matriz = new ArrayList<>();
		for (int fila = 0; fila < TAMANO; fila++) {
			List<Celda> filaCeldas = new ArrayList<>();
			for (int columna = 0; columna < TAMANO; columna++) {
				filaCeldas.add(new Celda(new Coordenada(fila, columna)));
			}
			matriz.add(filaCeldas);
		}
	}

	/**
	 * Devuelve una representación en texto del tablero con columnas alineadas y
	 * números al final.
	 *
	 * @return una cadena que representa el tablero
	 */
	public String aTexto() {
		String resultado = "";
		for (int fila = 0; fila < TAMANO; fila++) {
			resultado += fila + " "; // Número de la fila
			for (int columna = 0; columna < TAMANO; columna++) {
				Celda celda = matriz.get(fila).get(columna);
				String piezaTexto = celda.estaVacia() ? "--" : celda.consultarPieza().aTexto();
				resultado += String.format("%-3s", piezaTexto); // Alinea las piezas con un ancho fijo
			}
			resultado += "\n"; // Salto de línea después de cada fila
		}
		resultado += "  "; // Espacios para alinear los números de columna
		for (int columna = 0; columna < TAMANO; columna++) {
			resultado += String.format("%-3d", columna); // Números de columna alineados
		}
		return resultado;
	}

	/**
	 * Devuelve un clon profundo del tablero actual.
	 *
	 * @return un nuevo tablero que es una copia del actual
	 */
	public Tablero clonar() {
		Tablero clon = new Tablero();
		for (int fila = 0; fila < TAMANO; fila++) {
			for (int columna = 0; columna < TAMANO; columna++) {
				clon.matriz.get(fila).set(columna, this.matriz.get(fila).get(columna).clonar());
			}
		}
		return clon;
	}

	/**
	 * Coloca una pieza en la celda indicada por la coordenada.
	 *
	 * @param pieza      la pieza a colocar
	 * @param coordenada la coordenada donde colocar la pieza
	 */
	public void colocar(Pieza pieza, Coordenada coordenada) {
		if (pieza == null || coordenada == null || !estaEnTablero(coordenada)) {
			return;
		}
		obtenerCelda(coordenada).colocar(pieza);
	}

	/**
	 * Consulta la celda en la coordenada indicada.
	 *
	 * @param coordenada la coordenada de la celda a consultar
	 * @return un clon profundo de la celda, o null si la coordenada no está en el
	 *         tablero
	 */
	public Celda consultarCelda(Coordenada coordenada) {
		if (estaEnTablero(coordenada)) {
			return obtenerCelda(coordenada).clonar();
		}
		return null;
	}

	/**
	 * Devuelve una lista de todas las celdas del tablero.
	 *
	 * @return una lista de clones profundos de las celdas del tablero
	 */
	public List<Celda> consultarCeldas() {
		List<Celda> celdas = new ArrayList<>();
		for (List<Celda> fila : matriz) {
			for (Celda celda : fila) {
				celdas.add(celda.clonar());
			}
		}
		return celdas;
	}

	/**
	 * Consulta el número de columnas del tablero.
	 *
	 * @return el número de columnas
	 */
	public int consultarNumeroColumnas() {
		return TAMANO;
	}

	/**
	 * Consulta el número de filas del tablero.
	 *
	 * @return el número de filas
	 */
	public int consultarNumeroFilas() {
		return TAMANO;
	}

	/**
	 * Elimina la pieza de la celda en la coordenada indicada.
	 *
	 * @param coordenada la coordenada de la celda de la que eliminar la pieza
	 */
	public void eliminarPieza(Coordenada coordenada) {
		if (coordenada == null || !estaEnTablero(coordenada)) {
			return;
		}
		obtenerCelda(coordenada).eliminarPieza();
	}

	/**
	 * Verifica si la coordenada está dentro de los límites del tablero.
	 *
	 * @param coordenada la coordenada a verificar
	 * @return true si la coordenada está en el tablero, false en caso contrario
	 */
	public boolean estaEnTablero(Coordenada coordenada) {
		int fila = coordenada.fila();
		int columna = coordenada.columna();
		return fila >= 0 && fila < TAMANO && columna >= 0 && columna < TAMANO;
	}

	/**
	 * Obtiene la celda en la coordenada indicada.
	 *
	 * @param coordenada la coordenada de la celda
	 * @return la celda en la coordenada, o null si la coordenada no está en el
	 *         tablero
	 */
	Celda obtenerCelda(Coordenada coordenada) {
		if (estaEnTablero(coordenada)) {
			return matriz.get(coordenada.fila()).get(coordenada.columna());
		}
		return null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matriz);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablero other = (Tablero) obj;
		return Objects.equals(matriz, other.matriz);
	}

	@Override
	public String toString() {
		return "Tablero [matriz=" + matriz + "]";
	}

}
