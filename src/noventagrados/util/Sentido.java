package noventagrados.util;

/**
 * Clase: Sentido
 * 
 * Representa los cuatro sentidos de movimiento en un tablero para las piezas de
 * la práctica noventagrados.
 * 
 * Dado que no tiene dependencias de otros módulos, se debería implementar en
 * las primeras etapas, tras implementar el paquete {@code noventagrados.util}.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public enum Sentido {

	/**
	 * Movimiento vertical hacia el norte (-1, 0).
	 */
	VERTICAL_N(-1, 0),

	/**
	 * Movimiento vertical hacia el sur (+1, 0).
	 */
	VERTICAL_S(+1, 0),

	/**
	 * Movimiento horizontal hacia el este (0, +1).
	 */
	HORIZONTAL_E(0, +1),

	/**
	 * Movimiento horizontal hacia el oeste (0, -1).
	 */
	HORIZONTAL_O(0, -1);

	/**
	 * Desplazamiento en filas.
	 */
	private final int desplazamientoEnFilas;

	/**
	 * Desplazamiento en columnas.
	 */
	private final int desplazamientoEnColumnas;

	/**
	 * Constructor que inicializa los desplazamientos en filas y columnas.
	 *
	 * @param desplazamientoEnFilas    el desplazamiento en filas
	 * @param desplazamientoEnColumnas el desplazamiento en columnas
	 */
	private Sentido(int desplazamientoEnFilas, int desplazamientoEnColumnas) {
		this.desplazamientoEnFilas = desplazamientoEnFilas;
		this.desplazamientoEnColumnas = desplazamientoEnColumnas;
	}

	/**
	 * Consulta el desplazamiento en filas.
	 *
	 * @return el desplazamiento en filas
	 */
	public int consultarDesplazamientoEnFilas() {
		return desplazamientoEnFilas;
	}

	/**
	 * Consulta el desplazamiento en columnas.
	 *
	 * @return el desplazamiento en columnas
	 */
	public int consultarDesplazamientoEnColumnas() {
		return desplazamientoEnColumnas;
	}
}
