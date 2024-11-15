package noventagrados.textui.excepcion;

/**
 * Excepción comprobable que se lanza cuando una opción no está disponible.
 */
public class OpcionNoDisponibleException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor sin argumentos.
     */
    public OpcionNoDisponibleException() {
        super();
    }

    /**
     * Constructor que acepta un mensaje.
     *
     * @param message el mensaje de la excepción
     */
    public OpcionNoDisponibleException(String message) {
        super(message);
    }

    /**
     * Constructor que acepta una causa.
     *
     * @param cause la causa de la excepción
     */
    public OpcionNoDisponibleException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que acepta un mensaje y una causa.
     *
     * @param message el mensaje de la excepción
     * @param cause la causa de la excepción
     */
    public OpcionNoDisponibleException(String message, Throwable cause) {
        super(message, cause);
    }
}
