package noventagrados.util;

/**
 * Clase: TipoPieza
 *
 * Representa el tipo de las piezas en la práctica noventagrados. Las piezas
 * pueden ser Peón o Reina.
 *
 * Dado que no tiene dependencias de otros módulos, se debería implementar en
 * las primeras etapas, tras implementar el paquete {@code noventagrados.util}.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public enum TipoPieza {

	/**
	 * El peón con el carácter 'P' asignado.
	 */
	PEON('P'),

	/**
	 * La reina con el carácter 'R' asignado.
	 */
	REINA('R');

	/**
	 * Carácter correspondiente a cada tipo de pieza.
	 */
	private final char caracter;

	/**
	 * Constructor privado de la enumeración TipoPieza.
	 *
	 * @param caracter el carácter que representa el tipo de pieza
	 */
	private TipoPieza(char caracter) {
		this.caracter = caracter;
	}

	/**
	 * Devuelve el carácter asociado al tipo de pieza.
	 *
	 * @return el carácter que representa el tipo de pieza
	 */
	public char toChar() {
		return caracter;
	}
}
