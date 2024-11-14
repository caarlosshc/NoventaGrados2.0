package noventagrados.modelo;

import java.util.Objects;

import noventagrados.util.Color;
import noventagrados.util.Coordenada;

/**
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */

public class Celda {
	
	private final Coordenada coordenada;
	private Pieza pieza;
	
	public Celda(Coordenada coordenada) {
		this.coordenada = coordenada;
		this.pieza = null;
	}
	
	public Celda clonar() {
		Celda clon= new Celda(this.coordenada);
		if(this.pieza !=null) {
			clon.colocar(this.pieza.clonar());
		}
		return clon;
	}
	
	public void colocar(Pieza pieza) {
		this.pieza= pieza;
	}
	
	public Color consultarColorDePieza() {
        return (pieza != null) ? pieza.consultarColor() : null;
    }
	
	public Coordenada consultarCoordenada() {
        return this.coordenada;
    }
	
	public Pieza consultarPieza() {
		return this.pieza;	
	}
	
	public void eliminarPieza() {
		this.pieza=null;
	}
	
	public boolean estaVacia() {
		return this.pieza ==null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordenada, pieza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Celda other = (Celda) obj;
		return Objects.equals(coordenada, other.coordenada) && Objects.equals(pieza, other.pieza);
	}

	@Override
	public String toString() {
		return "Celda [coordenada=" + coordenada + ", pieza=" + pieza + "]";
	}
	

}