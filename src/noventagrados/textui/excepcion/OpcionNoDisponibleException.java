package noventagrados.textui.excepcion;

/**
 * Clase: OpcionNoDisponibleException
 *
 * Excepción comprobable que se lanza cuando una opción no está disponible.
 *
 * Dado que pertenece al paquete de excepciones, se debería implementar junto
 * con las demás excepciones del sistema.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public class OpcionNoDisponibleException extends Exception {
	
	/**
	 * Identificador único para la serialización de la clase.
	 */
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
	 * @param cause   la causa de la excepción
	 */
	public OpcionNoDisponibleException(String message, Throwable cause) {
		super(message, cause);
	}
}
