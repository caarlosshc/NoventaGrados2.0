package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import java.util.Date;

/**
 * Interfaz: MecanismoDeDeshacer
 *
 * Define los métodos para implementar un mecanismo de deshacer en el juego
 * noventagrados. Proporciona funcionalidades para consultar el árbitro actual,
 * manejar el historial de jugadas y deshacer movimientos.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public interface MecanismoDeDeshacer {

	/**
	 * Devuelve un clon en profundidad del árbitro actual.
	 *
	 * @return una copia del árbitro actual
	 */
	public Arbitro consultarArbitroActual();

	/**
	 * Consulta el número de jugadas en el historial.
	 *
	 * @return el número de jugadas registradas en el historial
	 */
	public int consultarNumeroJugadasEnHistorico();

	/**
	 * Deshace la última jugada realizada.
	 */
	public void deshacerJugada();

	/**
	 * Registra una nueva jugada en el historial.
	 *
	 * @param jugada la jugada a registrar
	 */
	public void hacerJugada(Jugada jugada);

	/**
	 * Obtiene la fecha de inicialización del mecanismo.
	 *
	 * @return la fecha de inicio
	 */
	public Date obtenerFechaInicio();
}
