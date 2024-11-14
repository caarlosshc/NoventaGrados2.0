package noventagrados.modelo;



/**
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */
public record Jugada(Celda origen, Celda destino) {
	
	public String aTexto() {
		return origen.consultarCoordenada().aTexto() + "-" + destino.consultarCoordenada().aTexto();
	}
}