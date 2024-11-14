package noventagrados.control.undo;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaquinaDelTiempoConArbitros extends MecanismoDeDeshacerAbstracto {
    private List<Arbitro> historialArbitros;
    private Arbitro arbitroInicial;

    public MaquinaDelTiempoConArbitros(Date fecha) {
        super(fecha);
        this.historialArbitros = new ArrayList<>();
        
        // Inicializamos el tablero y el árbitro
        Tablero tableroInicial = new Tablero(); // Asumiendo que Tablero tiene un constructor vacío
        this.arbitroInicial = new Arbitro(tableroInicial); // Usamos el constructor adecuado de Arbitro
        this.arbitroInicial.colocarPiezasConfiguracionInicial(); // Colocamos la configuración inicial
        
        // Guardamos el estado inicial en el historial
        this.historialArbitros.add(this.arbitroInicial.clonar());
    }

    @Override
    public Arbitro consultarArbitroActual() {
        return historialArbitros.get(historialArbitros.size() - 1).clonar();
    }

    @Override
    public int consultarNumeroJugadasEnHistorico() {
        return historialArbitros.size() - 1;
    }

    @Override
    public void deshacerJugada() {
        if (historialArbitros.size() > 1) {
            historialArbitros.remove(historialArbitros.size() - 1);
        }
    }

    @Override
    public void hacerJugada(Jugada jugada) {
        Arbitro ultimoEstado = historialArbitros.get(historialArbitros.size() - 1).clonar();
        ultimoEstado.empujar(jugada);
        ultimoEstado.cambiarTurno();
        historialArbitros.add(ultimoEstado);
    }
}
