package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import java.util.Date;

public interface MecanismoDeDeshacer {
	public Arbitro consultarArbitroActual(); // Devuelve un clon en profundidad del árbitro.

	public int consultarNumeroJugadasEnHistorico(); // Número de jugadas en el historial.

	public void deshacerJugada(); // Deshace la última jugada realizada.

	public void hacerJugada(Jugada jugada); // Registra una nueva jugada.

	public Date obtenerFechaInicio(); // Fecha de inicialización del mecanismo.
}
