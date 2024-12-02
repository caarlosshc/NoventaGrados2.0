package noventagrados.modelo;

/**
 * Clase: Jugada
 *
 * Representa una jugada en el juego noventagrados, que consiste en una celda de
 * origen y una celda de destino.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 * @param origen  celda de origen de la jugada
 * @param destino celda de destino de la jugada
 */
public record Jugada(

		/**
		 * Celda de origen de la jugada.
		 */
		Celda origen,

		/**
		 * Celda de destino de la jugada.
		 */
		Celda destino) {

	/**
	 * Devuelve una representación textual de la jugada.
	 *
	 * @return una cadena que representa la jugada en formato "origen-destino"
	 */
	public String aTexto() {
		return origen.consultarCoordenada().aTexto() + "-" + destino.consultarCoordenada().aTexto();
	}
}
