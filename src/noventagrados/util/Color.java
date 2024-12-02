package noventagrados.util;

/**
 * Clase: Color
 * 
 * Representa el color de las piezas en la práctica noventagrados.
 * Pueden ser Blancas o Negras.
 * 
 * Dado que no tiene dependencias de otros módulos, se debería implementar en
 * las primeras etapas, tras implementar el paquete {@code noventagrados.util}.
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
     * Negro con el carácter 'N' asignado.
     */
    NEGRO('N');

    /**
     * Carácter correspondiente a cada color.
     */
    private final char letra;

    /**
     * Constructor privado de la enumeración Color.
     *
     * @param letra el carácter que representa el color
     */
    private Color(char letra) {
        this.letra = letra;
    }

    /**
     * Devuelve el color contrario al actual.
     *
     * @return el color contrario
     */
    public Color consultarContrario() {
        if (this == BLANCO) {
            return NEGRO;
        } else {
            return BLANCO;
        }
    }

    /**
     * Devuelve el carácter asociado al color.
     *
     * @return el carácter que representa el color
     */
    public char toChar() {
        return letra;
    }
}
