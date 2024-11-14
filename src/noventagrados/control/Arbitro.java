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

public class Arbitro {

	private Tablero tablero;
	private Caja cajaBlanca;
	private Caja cajaNegra;
	private Color turnoActual;
	private int numeroJugada;

	/**
	 * Constructor de la clase Arbitro. Inicializa el árbitro con un tablero dado o
	 * uno nuevo si el tablero es null, las cajas de piezas capturadas de cada
	 * color, el número de jugada y el turno actual.
	 *
	 * @param tablero el tablero inicial del juego; si es null, se crea un tablero
	 *                nuevo.
	 */
	public Arbitro(Tablero tablero) {
		this.tablero = (tablero != null) ? tablero : new Tablero();
		this.cajaBlanca = new Caja(Color.BLANCO);
		this.cajaNegra = new Caja(Color.NEGRO);
		this.numeroJugada = 0;
		this.turnoActual = null;
	}

	/**
	 * Cambia el turno actual al otro color.
	 */
	public void cambiarTurno() {
		if (turnoActual == Color.BLANCO) {
			turnoActual = Color.NEGRO;
		} else {
			turnoActual = Color.BLANCO;
		}
	}

	/**
	 * Clona el árbitro actual, creando una copia profunda.
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
	 */
	public Caja consultarCaja(Color color) {
		return (color == Color.BLANCO) ? cajaBlanca : cajaNegra;
	}

	/**
	 * Consulta el número actual de la jugada.
	 */
	public int consultarNumeroJugada() {
		return numeroJugada;
	}

	/**
	 * Devuelve una copia del tablero actual.
	 */
	public Tablero consultarTablero() {
		return tablero.clonar();
	}

	/**
	 * Consulta el turno actual.
	 */
	public Color consultarTurno() {
		return turnoActual;
	}

	/**
	 * Consulta el turno del jugador ganador si la partida ha finalizado.
	 */
	public Color consultarTurnoGanador() {
	    TableroConsultor<Tablero> tableroConsultor = new TableroConsultor<>(tablero);

	    // Verifica si la partida ha finalizado
	    if (estaFinalizadaPartida()) {
	        boolean reinaBlancaEnCentro = tableroConsultor.estaReinaEnElCentro(Color.BLANCO);
	        boolean reinaNegraEnCentro = tableroConsultor.estaReinaEnElCentro(Color.NEGRO);
	        boolean hayReinaBlanca = tableroConsultor.hayReina(Color.BLANCO);
	        boolean hayReinaNegra = tableroConsultor.hayReina(Color.NEGRO);

	        // Empate si ambas reinas han sido capturadas
	        if (!hayReinaBlanca && !hayReinaNegra) {
	            return null;
	        }
	        // Gana el jugador blanco si su reina está en el centro o si la reina negra ha sido capturada
	        if (reinaBlancaEnCentro || !hayReinaNegra) {
	            return Color.BLANCO;
	        }
	        // Gana el jugador negro si su reina está en el centro o si la reina blanca ha sido capturada
	        if (reinaNegraEnCentro || !hayReinaBlanca) {
	            return Color.NEGRO;
	        }
	    }

	    // Retorna null si la partida no ha finalizado o si hay empate
	    return null;
	}

	/**
	 * Realiza la jugada especificada, empujando las piezas en la dirección
	 * correspondiente.
	 */
	public void empujar(Jugada jugada) {
		numeroJugada++;
		TableroConsultor<Tablero> tableroConsultor = new TableroConsultor<>(tablero);
		Celda origen = jugada.origen();
		Celda destino = jugada.destino();

		Coordenada coordenadaOrigen = origen.consultarCoordenada();
		Coordenada coordenadaDestino = destino.consultarCoordenada();
		Pieza pieza = origen.consultarPieza();

		Sentido sentido = tableroConsultor.calcularSentido(coordenadaOrigen, coordenadaDestino);

		if (!tablero.estaEnTablero(coordenadaDestino) && pieza != null) {
			if (pieza.consultarColor() == Color.BLANCO) {
				cajaBlanca.añadir(pieza);
			} else {
				cajaNegra.añadir(pieza);
			}
		} else {
			if (sentido.consultarDesplazamientoEnColumnas() == 0) {
				trasladarPieza(coordenadaOrigen, coordenadaDestino, sentido, true);
			} else if (sentido.consultarDesplazamientoEnFilas() == 0) {
				trasladarPieza(coordenadaOrigen, coordenadaDestino, sentido, false);
			}
		}

		tablero.colocar(pieza, coordenadaDestino);
	}

	/**
	 * Verifica si la jugada especificada es legal según las reglas del juego.
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
	 */
	public boolean estaFinalizadaPartida() {
		TableroConsultor<Tablero> tableroConsultor = new TableroConsultor<>(tablero);
		return !tableroConsultor.hayReina(Color.NEGRO) || !tableroConsultor.hayReina(Color.BLANCO)
				|| tableroConsultor.estaReinaEnElCentro(Color.NEGRO)
				|| tableroConsultor.estaReinaEnElCentro(Color.BLANCO);
	}

	/**
	 * Traslada una pieza desde la coordenada origen a la coordenada destino en el
	 * sentido dado.
	 */
	private void trasladarPieza(Coordenada origen, Coordenada destino, Sentido sentido, boolean esVertical) {
		int posicionOrigen;
		int posicionDestino;
		int desplazamiento;
		Coordenada siguienteCoordenada = origen;

		if (esVertical) {
			posicionOrigen = origen.fila();
			posicionDestino = destino.fila();
			desplazamiento = sentido.consultarDesplazamientoEnFilas();
		} else {
			posicionOrigen = origen.columna();
			posicionDestino = destino.columna();
			desplazamiento = sentido.consultarDesplazamientoEnColumnas();
		}

		while (posicionOrigen != posicionDestino) {
			tablero.eliminarPieza(siguienteCoordenada);
			posicionOrigen += desplazamiento;

			siguienteCoordenada = esVertical ? new Coordenada(posicionOrigen, origen.columna())
					: new Coordenada(origen.fila(), posicionOrigen);

			Celda siguienteCelda = tablero.consultarCelda(siguienteCoordenada);
			if (siguienteCelda != null && !siguienteCelda.estaVacia()) {
				Coordenada nuevaCoordenadaDestino = esVertical
						? new Coordenada(destino.fila() + desplazamiento, destino.columna())
						: new Coordenada(destino.fila(), destino.columna() + desplazamiento);

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
