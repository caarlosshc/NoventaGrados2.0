package noventagrados.control;

import noventagrados.modelo.Tablero;
import noventagrados.modelo.Pieza;
import noventagrados.util.Color;
import noventagrados.util.Coordenada;
import noventagrados.util.TipoPieza;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Celda;
import noventagrados.util.Sentido;
import java.util.List;
import java.util.Objects;

/**
 * Clase: Arbitro
 *
 * Representa el árbitro del juego noventagrados, encargado de gestionar el
 * estado del juego, las reglas y la lógica de movimientos.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public class Arbitro {

	/**
	 * El tablero del juego.
	 */
	private Tablero tablero;

	/**
	 * La caja de piezas capturadas del jugador blanco.
	 */
	private Caja cajaBlanca;

	/**
	 * La caja de piezas capturadas del jugador negro.
	 */
	private Caja cajaNegra;

	/**
	 * El turno actual del juego.
	 */
	private Color turnoActual;

	/**
	 * El número de la jugada actual.
	 */
	private int numeroJugada;

	/**
	 * Constructor de la clase Arbitro. Inicializa el árbitro con un tablero dado o
	 * uno nuevo si el tablero es null, las cajas de piezas capturadas de cada
	 * color, el número de jugada y el turno actual.
	 *
	 * @param tablero el tablero inicial del juego; si es null, se crea un tablero
	 *                nuevo
	 */
	public Arbitro(Tablero tablero) {
		this.tablero = (tablero != null) ? tablero : new Tablero();
		this.cajaBlanca = new Caja(Color.BLANCO);
		this.cajaNegra = new Caja(Color.NEGRO);
		this.numeroJugada = 0;
		this.turnoActual = null;
	}

	/**
	 * Cambia el turno actual al otro jugador.
	 */
	public void cambiarTurno() {
		if (turnoActual == Color.BLANCO) {
			turnoActual = Color.NEGRO;
		} else {
			turnoActual = Color.BLANCO;
		}
	}

	/**
	 * Crea y devuelve una copia profunda del árbitro actual.
	 *
	 * @return una nueva instancia de Arbitro que es una copia del actual
	 */
	public Arbitro clonar() {
		Arbitro clon = new Arbitro(this.tablero.clonar());
		clon.cajaBlanca = this.cajaBlanca.clonar();
		clon.cajaNegra = this.cajaNegra.clonar();
		clon.turnoActual = this.turnoActual;
		clon.numeroJugada = this.numeroJugada;
		return clon;
	}

	/**
	 * Coloca las piezas dadas en las coordenadas especificadas y establece el turno
	 * actual.
	 *
	 * @param piezas      lista de piezas a colocar
	 * @param coordenadas lista de coordenadas correspondientes a las piezas
	 * @param turnoActual el turno actual del juego
	 */
	public void colocarPiezas(List<Pieza> piezas, List<Coordenada> coordenadas, Color turnoActual) {
		if (piezas != null && coordenadas != null && piezas.size() == coordenadas.size()) {
			for (int i = 0; i < piezas.size(); i++) {
				if (piezas.get(i) != null && coordenadas.get(i) != null) {
					tablero.colocar(piezas.get(i), coordenadas.get(i));
				}
			}
			this.turnoActual = turnoActual;
		}
	}

	/**
	 * Coloca las piezas en el tablero en la configuración inicial del juego.
	 */
	public void colocarPiezasConfiguracionInicial() {
		this.turnoActual = Color.BLANCO;
		tablero.colocar(new Pieza(TipoPieza.REINA, Color.BLANCO), new Coordenada(0, 0));
		tablero.colocar(new Pieza(TipoPieza.REINA, Color.NEGRO), new Coordenada(6, 6));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.BLANCO), new Coordenada(0, 1));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.BLANCO), new Coordenada(0, 2));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.BLANCO), new Coordenada(0, 3));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.BLANCO), new Coordenada(1, 0));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.BLANCO), new Coordenada(2, 0));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.BLANCO), new Coordenada(3, 0));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.NEGRO), new Coordenada(6, 5));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.NEGRO), new Coordenada(6, 4));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.NEGRO), new Coordenada(6, 3));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.NEGRO), new Coordenada(5, 6));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.NEGRO), new Coordenada(4, 6));
		tablero.colocar(new Pieza(TipoPieza.PEON, Color.NEGRO), new Coordenada(3, 6));
	}

	/**
	 * Consulta la caja de piezas capturadas del color especificado.
	 *
	 * @param color el color del jugador
	 * @return la caja de piezas capturadas del jugador especificado
	 */
	public Caja consultarCaja(Color color) {
		return (color == Color.BLANCO) ? cajaBlanca : cajaNegra;
	}

	/**
	 * Consulta el número actual de la jugada.
	 *
	 * @return el número de la jugada actual
	 */
	public int consultarNumeroJugada() {
		return numeroJugada;
	}

	/**
	 * Devuelve una copia del tablero actual.
	 *
	 * @return una copia del tablero
	 */
	public Tablero consultarTablero() {
		return tablero.clonar();
	}

	/**
	 * Consulta el turno actual.
	 *
	 * @return el color del jugador que tiene el turno actual
	 */
	public Color consultarTurno() {
		return turnoActual;
	}

	/**
	 * Consulta el turno del jugador ganador si la partida ha finalizado.
	 *
	 * @return el color del jugador ganador, o null si es empate o la partida no ha
	 *         finalizado
	 */
	public Color consultarTurnoGanador() {
		if (!estaFinalizadaPartida()) {
			return null;
		}

		TableroConsultor<Tablero> consultor = new TableroConsultor<>(tablero);
		boolean hayReinaBlanca = consultor.hayReina(Color.BLANCO);
		boolean hayReinaNegra = consultor.hayReina(Color.NEGRO);
		boolean reinaBlancaEnCentro = consultor.estaReinaEnElCentro(Color.BLANCO);
		boolean reinaNegraEnCentro = consultor.estaReinaEnElCentro(Color.NEGRO);

		Color ganador = null;

		if ((!hayReinaBlanca && !hayReinaNegra) || (reinaBlancaEnCentro && reinaNegraEnCentro)) {
			ganador = null; // Empate
		} else if (reinaBlancaEnCentro || !hayReinaNegra) {
			ganador = Color.BLANCO;
		} else if (reinaNegraEnCentro || !hayReinaBlanca) {
			ganador = Color.NEGRO;
		}

		return ganador;
	}

	/**
	 * Realiza la jugada especificada, empujando las piezas en la dirección
	 * correspondiente.
	 *
	 * @param jugada la jugada a realizar
	 */
	public void empujar(Jugada jugada) {
		numeroJugada++;
		Pieza pieza = jugada.origen().consultarPieza();
		Coordenada origen = jugada.origen().consultarCoordenada();
		Coordenada destino = jugada.destino().consultarCoordenada();
		Sentido sentido = new TableroConsultor<>(tablero).calcularSentido(origen, destino);

		if (pieza == null)
			return;

		if (!tablero.estaEnTablero(destino)) {
			capturarPieza(pieza);
		} else {
			empujarPiezas(origen, destino, sentido);
		}

		tablero.colocar(pieza, destino);
	}

	/**
	 * Captura una pieza y la añade a la caja correspondiente.
	 *
	 * @param pieza la pieza a capturar
	 */
	private void capturarPieza(Pieza pieza) {
		if (pieza.consultarColor() == Color.BLANCO) {
			cajaBlanca.añadir(pieza);
		} else {
			cajaNegra.añadir(pieza);
		}
	}

	/**
	 * Empuja las piezas desde la coordenada origen hasta la coordenada destino en
	 * el sentido dado.
	 *
	 * @param origen  la coordenada de origen
	 * @param destino la coordenada de destino
	 * @param sentido el sentido del movimiento
	 */
	private void empujarPiezas(Coordenada origen, Coordenada destino, Sentido sentido) {
		if (sentido.consultarDesplazamientoEnColumnas() == 0) {
			trasladarPiezaVertical(origen, destino, sentido);
		} else if (sentido.consultarDesplazamientoEnFilas() == 0) {
			trasladarPiezaHorizontal(origen, destino, sentido);
		}
	}

	/**
	 * Verifica si la jugada especificada es legal según las reglas del juego.
	 *
	 * @param jugada la jugada a verificar
	 * @return true si el movimiento es legal, false en caso contrario
	 */
	public boolean esMovimientoLegal(Jugada jugada) {
		Coordenada origen = jugada.origen().consultarCoordenada();
		Coordenada destino = jugada.destino().consultarCoordenada();
		TableroConsultor<Tablero> tableroConsultor = new TableroConsultor<>(tablero);

		if (tablero.estaEnTablero(origen) && tablero.estaEnTablero(destino) && !origen.equals(destino)) {
			if (!jugada.origen().estaVacia() && this.turnoActual == jugada.origen().consultarColorDePieza()) {
				Sentido sentido = tableroConsultor.calcularSentido(origen, destino);
				if (sentido == null)
					return false;
				if (sentido.consultarDesplazamientoEnFilas() == 0) {
					return tableroConsultor.consultarDistanciaEnHorizontal(origen, destino) == tableroConsultor
							.consultarNumeroPiezasEnVertical(origen);
				} else if (sentido.consultarDesplazamientoEnColumnas() == 0) {
					return tableroConsultor.consultarDistanciaEnVertical(origen, destino) == tableroConsultor
							.consultarNumeroPiezasEnHorizontal(origen);
				}
			}
		}
		return false;
	}

	/**
	 * Verifica si la partida ha finalizado.
	 *
	 * @return true si la partida ha finalizado, false en caso contrario
	 */
	public boolean estaFinalizadaPartida() {
		TableroConsultor<Tablero> tableroConsultor = new TableroConsultor<>(tablero);
		return !tableroConsultor.hayReina(Color.NEGRO) || !tableroConsultor.hayReina(Color.BLANCO)
				|| tableroConsultor.estaReinaEnElCentro(Color.NEGRO)
				|| tableroConsultor.estaReinaEnElCentro(Color.BLANCO);
	}

	/**
	 * Traslada una pieza desde la coordenada origen a la coordenada destino en el
	 * sentido dado, moviéndose verticalmente.
	 *
	 * @param origen  la coordenada de origen
	 * @param destino la coordenada de destino
	 * @param sentido el sentido del movimiento
	 */
	private void trasladarPiezaVertical(Coordenada origen, Coordenada destino, Sentido sentido) {
		int posicionOrigen = origen.fila();
		int posicionDestino = destino.fila();
		int desplazamiento = sentido.consultarDesplazamientoEnFilas();
		Coordenada siguienteCoordenada = origen;

		while (posicionOrigen != posicionDestino) {
			tablero.eliminarPieza(siguienteCoordenada);
			posicionOrigen += desplazamiento;
			siguienteCoordenada = new Coordenada(posicionOrigen, origen.columna());
			Celda siguienteCelda = tablero.consultarCelda(siguienteCoordenada);
			if (siguienteCelda != null && !siguienteCelda.estaVacia()) {
				Coordenada nuevaCoordenadaDestino = new Coordenada(destino.fila() + desplazamiento, destino.columna());
				Jugada nuevaJugada = new Jugada(siguienteCelda, new Celda(nuevaCoordenadaDestino));
				numeroJugada--;
				empujar(nuevaJugada);
			}
		}
	}

	/**
	 * Traslada una pieza desde la coordenada origen a la coordenada destino en el
	 * sentido dado, moviéndose horizontalmente.
	 *
	 * @param origen  la coordenada de origen
	 * @param destino la coordenada de destino
	 * @param sentido el sentido del movimiento
	 */
	private void trasladarPiezaHorizontal(Coordenada origen, Coordenada destino, Sentido sentido) {
		int posicionOrigen = origen.columna();
		int posicionDestino = destino.columna();
		int desplazamiento = sentido.consultarDesplazamientoEnColumnas();
		Coordenada siguienteCoordenada = origen;

		while (posicionOrigen != posicionDestino) {
			tablero.eliminarPieza(siguienteCoordenada);
			posicionOrigen += desplazamiento;

			siguienteCoordenada = new Coordenada(origen.fila(), posicionOrigen);

			Celda siguienteCelda = tablero.consultarCelda(siguienteCoordenada);
			if (siguienteCelda != null && !siguienteCelda.estaVacia()) {
				Coordenada nuevaCoordenadaDestino = new Coordenada(destino.fila(), destino.columna() + desplazamiento);

				Jugada nuevaJugada = new Jugada(siguienteCelda, new Celda(nuevaCoordenadaDestino));
				numeroJugada--;
				empujar(nuevaJugada);
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(cajaBlanca, cajaNegra, numeroJugada, tablero, turnoActual);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbitro other = (Arbitro) obj;
		return Objects.equals(cajaBlanca, other.cajaBlanca) && Objects.equals(cajaNegra, other.cajaNegra)
				&& numeroJugada == other.numeroJugada && Objects.equals(tablero, other.tablero)
				&& turnoActual == other.turnoActual;
	}

	@Override
	public String toString() {
		return "Arbitro [tablero=" + tablero + ", cajaBlanca=" + cajaBlanca + ", cajaNegra=" + cajaNegra
				+ ", turnoActual=" + turnoActual + ", numeroJugada=" + numeroJugada + "]";
	}
}
