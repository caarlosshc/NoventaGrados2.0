package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaquinaDelTiempoConJugadas extends MecanismoDeDeshacerAbstracto {
    private List<Jugada> historialJugadas;
    private Arbitro arbitroInicial;

    public MaquinaDelTiempoConJugadas(Date fecha) {
        super(fecha);
        this.historialJugadas = new ArrayList<>();
        
        // Inicializar el árbitro en su estado inicial
        Tablero tableroInicial = new Tablero(); // Crear un nuevo tablero vacío
        this.arbitroInicial = new Arbitro(tableroInicial); // Crear un nuevo árbitro con el tablero
        this.arbitroInicial.colocarPiezasConfiguracionInicial(); // Colocar piezas en la configuración inicial
    }

    @Override
    public Arbitro consultarArbitroActual() {
        // Crear un clon del árbitro inicial y aplicar todas las jugadas
        Arbitro arbitro = arbitroInicial.clonar();
        for (Jugada jugada : historialJugadas) {
            arbitro.empujar(jugada);  // Aplicar cada jugada
            arbitro.cambiarTurno();   // Cambiar el turno después de cada jugada
        }
        return arbitro;
    }

    @Override
    public int consultarNumeroJugadasEnHistorico() {
        return historialJugadas.size();
    }

    @Override
    public void deshacerJugada() {
        if (!historialJugadas.isEmpty()) {
            historialJugadas.remove(historialJugadas.size() - 1); // Quitar la última jugada
        }
    }

    @Override
    public void hacerJugada(Jugada jugada) {
        historialJugadas.add(jugada); // Añadir la jugada al historial
    }
}
