package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Celda;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase: MaquinaDelTiempoConArbitros
 *
 * Implementa un mecanismo para deshacer jugadas en el juego noventagrados,
 * utilizando una lista de árbitros para almacenar el historial de estados.
 * Extiende la clase abstracta {@code MecanismoDeDeshacerAbstracto}.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public class MaquinaDelTiempoConArbitros extends MecanismoDeDeshacerAbstracto {

	/**
	 * Historial de árbitros que representa los estados anteriores del juego.
	 */
	private final List<Arbitro> historialArbitros;

	/**
	 * Constructor que inicializa la máquina del tiempo con una fecha dada. Crea el
	 * árbitro inicial y configura el tablero con la configuración inicial.
	 *
	 * @param fecha la fecha de creación de la máquina del tiempo
	 */
	public MaquinaDelTiempoConArbitros(Date fecha) {
		super(fecha);
		this.historialArbitros = new ArrayList<>();

		// Crear y configurar el árbitro inicial con el tablero
		Arbitro arbitroInicial = new Arbitro(new Tablero());
		arbitroInicial.colocarPiezasConfiguracionInicial(); // Coloca las piezas en la configuración inicial
		historialArbitros.add(arbitroInicial); // Guarda el estado inicial del árbitro
	}

	/**
	 * Consulta el árbitro actual (el último en el historial).
	 *
	 * @return una copia del árbitro actual, o null si el historial está vacío
	 */
	@Override
	public Arbitro consultarArbitroActual() {
		if (historialArbitros.isEmpty()) {
			return null;
		}
		return historialArbitros.get(historialArbitros.size() - 1).clonar();
	}

	/**
	 * Realiza una jugada y actualiza el historial de árbitros.
	 *
	 * @param jugada la jugada a realizar
	 */
	@Override
	public void hacerJugada(Jugada jugada) {
		if (jugada != null) {
			// Clona el estado actual del árbitro para evitar modificaciones no deseadas
			Arbitro arbitroActual = consultarArbitroActual();
			Celda origen = arbitroActual.consultarTablero().consultarCelda(jugada.origen().consultarCoordenada());
			Celda destino = arbitroActual.consultarTablero().consultarCelda(jugada.destino().consultarCoordenada());
			Jugada jug = new Jugada(origen, destino);
			// Aplica la jugada al estado clonado
			arbitroActual.empujar(jug);

			// Cambia el turno en el árbitro
			arbitroActual.cambiarTurno();

			// Guarda el nuevo estado del árbitro en el historial
			historialArbitros.add(arbitroActual);
		}
	}

	/**
	 * Deshace la última jugada realizada.
	 */
	@Override
	public void deshacerJugada() {
		// Remueve el último estado en el historial si no es el estado inicial
		if (historialArbitros.size() > 1) {
			historialArbitros.remove(historialArbitros.size() - 1);
		}
	}

	/**
	 * Consulta el número de jugadas realizadas almacenadas en el historial.
	 *
	 * @return el número de jugadas en el historial, excluyendo el estado inicial
	 */
	@Override
	public int consultarNumeroJugadasEnHistorico() {
		// Devuelve el número de jugadas excluyendo el estado inicial
		return historialArbitros.size() - 1;
	}

}
