package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaquinaDelTiempoConJugadas extends MecanismoDeDeshacerAbstracto {
    private final List<Jugada> historialJugadas;

    public MaquinaDelTiempoConJugadas(Date fecha) {
        super(fecha);
        this.historialJugadas = new ArrayList<>();
    }

    @Override
    public Arbitro consultarArbitroActual() {
        // Crear un tablero inicial y luego un árbitro usando ese tablero
        Tablero tableroInicial = new Tablero(); // Crear el tablero
        Arbitro arbitro = new Arbitro(tableroInicial); // Iniciar el árbitro con el tablero inicial
        arbitro.colocarPiezasConfiguracionInicial(); // Colocar las piezas en la configuración inicial

        // Aplicar cada jugada en el historial para reconstruir el estado actual
        for (Jugada jugada : historialJugadas) {
            arbitro.empujar(jugada); // Aplica cada jugada en orden
            arbitro.cambiarTurno(); // Cambia el turno después de cada jugada
        }

        return arbitro;
    }

    @Override
    public int consultarNumeroJugadasEnHistorico() {
        return historialJugadas.size();
    }

    @Override
    public void deshacerJugada() {
        // Remover la última jugada del historial si existe
        if (!historialJugadas.isEmpty()) {
            historialJugadas.remove(historialJugadas.size() - 1);
        }
    }

    @Override
    public void hacerJugada(Jugada jugada) {
        // Añadir una nueva jugada al historial si no es nula
        if (jugada != null) {
            historialJugadas.add(jugada);
        }
    }
}
