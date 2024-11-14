package noventagrados.util;

/**
 * Clase: Color
 * Color de las piezas de la practica noventagrados.
 * Pueden ser Blancas o Negras
 * 
 * Dado que no tiene dependencias de otros módulos, se debería implementar en
 * las primeras etapas, tras implementar el paquete noventagrados.util.
 *
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */

public enum Color {

	/**
	 * Blanco con el carácter 'B' asignado.
	 */
	BLANCO('B'),

	/**
	 * Negro con el caracter 'N' asignado.
	 */
	NEGRO('N'); 

	/**
	 * Caracter correspondiente a cada color.
	 */
	
	private final char letra;
	
	private Color (char letra) {
		this.letra =letra;
	}
	
	
	public Color consultarContrario() {
		
		if(this == BLANCO) {
			return NEGRO;
		}else {
			return BLANCO;
		}
	}
	
	public char toChar() {
		return letra;
	}
}
