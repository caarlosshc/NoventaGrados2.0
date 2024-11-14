package noventagrados.util;

/**
 * Clase: TipoPieza
 * Tipo de las piezas de la practica noventagrados.
 * 
 * Dado que no tiene dependencias de otros módulos, se debería implementar en
 * las primeras etapas, tras implementar el paquete noventagrados.util.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * 
 * @version 1.0
 */

public enum TipoPieza{
	
	PEON('P'),
	
	/**
	 * El peon con el carácter 'P' asignado.
	 */
	
	REINA('R');
	/**
	 * La reina con el caracter 'R' asignado.
	 */
	
	
	
	/**
	 * Caracter correspondiente a cada tipo de pieza.
	 */
	
	
	private char caracter;
	
	private TipoPieza(char caracter) {
		this.caracter = caracter;
	}
	
	public char toChar() {
		return caracter;
	}
}