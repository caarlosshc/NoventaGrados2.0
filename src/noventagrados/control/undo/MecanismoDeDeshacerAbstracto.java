package noventagrados.control.undo;

import java.util.Date;

public abstract class MecanismoDeDeshacerAbstracto implements MecanismoDeDeshacer {
    private final Date fechaInicio;

    public MecanismoDeDeshacerAbstracto(Date fecha) {
        this.fechaInicio = fecha != null ? new Date(fecha.getTime()) : new Date();
    }

    @Override
    public Date obtenerFechaInicio() {
        return new Date(fechaInicio.getTime());
    }
}
