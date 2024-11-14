package noventagrados.util;

/**
 * Clase: Coordenada
 * Coordenadas de las piezas de la practica noventagrados.
 * 
 * Dado que no tiene dependencias de otros módulos, se debería implementar en
 * las primeras etapas, tras implementar el paquete noventagrados.util.
 *
 * 
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */

public record Coordenada(int fila, int columna) {
	
	public String aTexto() {
		return fila + "" + columna;
	}
}