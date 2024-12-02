package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase: MaquinaDelTiempoConJugadas
 *
 * Implementa un mecanismo para deshacer jugadas en el juego noventagrados,
 * utilizando una lista de jugadas para almacenar el historial de movimientos.
 * Extiende la clase abstracta {@code MecanismoDeDeshacerAbstracto}.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public class MaquinaDelTiempoConJugadas extends MecanismoDeDeshacerAbstracto {

	/**
	 * Historial de jugadas realizadas en el juego.
	 */
	private final List<Jugada> historialJugadas;

	/**
	 * Constructor que inicializa la máquina del tiempo con una fecha dada.
	 *
	 * @param fecha la fecha de creación de la máquina del tiempo
	 */
	public MaquinaDelTiempoConJugadas(Date fecha) {
		super(fecha);
		this.historialJugadas = new ArrayList<>();
	}

	/**
	 * Consulta el árbitro actual reconstruyendo el estado del juego a partir del
	 * historial de jugadas.
	 *
	 * @return una instancia del árbitro con el estado actual del juego
	 */
	@Override
	public Arbitro consultarArbitroActual() {
		// Crear un tablero inicial y luego un árbitro usando ese tablero
		Arbitro arbitro = new Arbitro(new Tablero());
		arbitro.colocarPiezasConfiguracionInicial(); // Colocar las piezas en la configuración inicial

		// Aplicar cada jugada en el historial para reconstruir el estado actual
		for (Jugada jugada : historialJugadas) {
			arbitro.empujar(new Jugada(arbitro.consultarTablero().consultarCelda(jugada.origen().consultarCoordenada()),
					arbitro.consultarTablero().consultarCelda(jugada.destino().consultarCoordenada())));
			arbitro.cambiarTurno(); // Cambia el turno después de cada jugada
		}

		return arbitro;
	}

	/**
	 * Realiza una jugada y la añade al historial.
	 *
	 * @param jugada la jugada a realizar
	 */
	@Override
	public void hacerJugada(Jugada jugada) {
		// Añadir una nueva jugada al historial si no es nula
		if (jugada != null) {
			historialJugadas.add(new Jugada(jugada.origen().clonar(), jugada.destino().clonar()));
		}
	}

	/**
	 * Deshace la última jugada realizada.
	 */
	@Override
	public void deshacerJugada() {
		// Remover la última jugada del historial si existe
		if (!historialJugadas.isEmpty()) {
			historialJugadas.remove(historialJugadas.size() - 1);
		}
	}

	/**
	 * Consulta el número de jugadas realizadas almacenadas en el historial.
	 *
	 * @return el número de jugadas en el historial
	 */
	@Override
	public int consultarNumeroJugadasEnHistorico() {
		return historialJugadas.size();
	}

}
