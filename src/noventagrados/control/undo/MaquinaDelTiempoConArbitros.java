package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaquinaDelTiempoConArbitros extends MecanismoDeDeshacerAbstracto {
    private final List<Arbitro> historialArbitros;

    public MaquinaDelTiempoConArbitros(Date fecha) {
        super(fecha);
        this.historialArbitros = new ArrayList<>();
        Arbitro arbitroInicial = new Arbitro(null); // Usa el constructor de Arbitro con tablero por defecto.
        arbitroInicial.colocarPiezasConfiguracionInicial(); // Configura las piezas iniciales.
        historialArbitros.add(arbitroInicial); // Guarda el estado inicial del árbitro.
    }

    @Override
    public Arbitro consultarArbitroActual() {
        return historialArbitros.get(historialArbitros.size() - 1).clonar();
    }

    @Override
    public int consultarNumeroJugadasEnHistorico() {
        return historialArbitros.size() - 1; // Excluye el estado inicial.
    }

    @Override
    public void deshacerJugada() {
        if (historialArbitros.size() > 1) {
            historialArbitros.remove(historialArbitros.size() - 1);
        }
    }

    @Override
    public void hacerJugada(Jugada jugada) {
        if (jugada != null) {
            Arbitro arbitroActual = consultarArbitroActual(); // Obtiene el árbitro actual.
            arbitroActual.empujar(jugada); // Aplica la jugada al árbitro actual.
            historialArbitros.add(arbitroActual.clonar()); // Agrega el estado clonado al historial.
        }
    }
}
