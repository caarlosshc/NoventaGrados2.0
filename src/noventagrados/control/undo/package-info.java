/**
 * Paquete noventagrados.control.undo
 *
 * Este paquete contiene las clases e interfaces que implementan el mecanismo de
 * deshacer en el juego noventagrados.
 *
 * Incluye las siguientes clases e interfaces:
 *
 * - {@link noventagrados.control.undo.MaquinaDelTiempoConArbitros}: Implementa
 * el mecanismo de deshacer utilizando una lista de árbitros para almacenar el
 * historial de estados del juego. -
 * {@link noventagrados.control.undo.MaquinaDelTiempoConJugadas}: Implementa el
 * mecanismo de deshacer utilizando una lista de jugadas para reconstruir el
 * estado del juego. - {@link noventagrados.control.undo.MecanismoDeDeshacer}:
 * Interfaz que define los métodos para el mecanismo de deshacer. -
 * {@link noventagrados.control.undo.MecanismoDeDeshacerAbstracto}: Clase
 * abstracta que proporciona una implementación básica del mecanismo de deshacer
 * y almacena la fecha de inicio.
 *
 * Estas clases permiten gestionar el historial de jugadas y deshacer
 * movimientos, proporcionando flexibilidad en la implementación del mecanismo
 * de deshacer en el juego.
 *
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
package noventagrados.control.undo;
