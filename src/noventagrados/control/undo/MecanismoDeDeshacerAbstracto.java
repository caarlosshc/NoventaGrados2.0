package noventagrados.control.undo;

import java.util.Date;

public abstract class MecanismoDeDeshacerAbstracto implements MecanismoDeDeshacer {
    protected Date fechaInicio;

    public MecanismoDeDeshacerAbstracto(Date fechaInicio) {
        this.fechaInicio = fechaInicio != null ? fechaInicio : new Date();
    }

    @Override
    public Date obtenerFechaInicio() {
        return fechaInicio;
    }
}
