package noventagrados.control.undo;

import java.util.Date;

/**
 * Clase: MecanismoDeDeshacerAbstracto
 *
 * Clase abstracta que implementa la interfaz {@code MecanismoDeDeshacer} y proporciona una implementación básica para almacenar la fecha de inicio del mecanismo de deshacer.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public abstract class MecanismoDeDeshacerAbstracto implements MecanismoDeDeshacer {

    /**
     * Fecha de inicialización del mecanismo de deshacer.
     */
    private final Date fechaInicio;

    /**
     * Constructor que inicializa el mecanismo con una fecha dada.
     *
     * @param fecha la fecha de inicio; si es null, se utiliza la fecha actual
     */
    public MecanismoDeDeshacerAbstracto(Date fecha) {
        this.fechaInicio = fecha != null ? new Date(fecha.getTime()) : new Date();
    }

    /**
     * Obtiene la fecha de inicialización del mecanismo.
     *
     * @return una copia de la fecha de inicio
     */
    @Override
    public Date obtenerFechaInicio() {
        return new Date(fechaInicio.getTime());
    }
}
