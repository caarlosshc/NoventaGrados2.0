package noventagrados.modelo;

import java.util.ArrayList;
import java.util.List;

import noventagrados.util.Coordenada;

/**
 * @author <a href="mailto:cmz1002@alu.ubu.es">Carmen Minguela Zamarro</a>
 * @author <a href="mailto:cdc1010@alu.ubu.es">Carlos De La Huerga Cenador</a>
 * @version 1.0
 */


import java.util.Objects;

public class Tablero {

    private static final int TAMANO = 7;
    private List<List<Celda>> matriz;

    // Constructor
    public Tablero() {
        matriz = new ArrayList<>();
        for (int fila = 0; fila < TAMANO; fila++) {
            List<Celda> filaCeldas = new ArrayList<>();
            for (int columna = 0; columna < TAMANO; columna++) {
                filaCeldas.add(new Celda(new Coordenada(fila, columna)));
            }
            matriz.add(filaCeldas);
        }
    }

    // Devuelve una representación del tablero en formato de texto
    public String aTexto() {
        StringBuilder resultado = new StringBuilder();
        for (int fila = 0; fila < TAMANO; fila++) {
            resultado.append(fila).append(" ");
            for (int columna = 0; columna < TAMANO; columna++) {
                Celda celda = matriz.get(fila).get(columna);
                resultado.append(celda.estaVacia() ? "--" : celda.consultarPieza().aTexto());
                if (columna < TAMANO - 1) {
                    resultado.append(" ");
                }
            }
            resultado.append("\n");
        }
        resultado.append(" ");
        for (int columna = 0; columna < TAMANO; columna++) {
            resultado.append(columna).append(" ");
        }
        return resultado.toString();
    }

    // Devuelve un clon profundo del tablero
    public Tablero clonar() {
        Tablero clon = new Tablero();
        for (int fila = 0; fila < TAMANO; fila++) {
            for (int columna = 0; columna < TAMANO; columna++) {
                clon.matriz.get(fila).set(columna, this.matriz.get(fila).get(columna).clonar());
            }
        }
        return clon;
    }

    // Coloca una pieza en la celda indicada por la coordenada
    public void colocar(Pieza pieza, Coordenada coordenada) {
        if (pieza == null || coordenada == null || !estaEnTablero(coordenada)) {
            return;
        }
        obtenerCelda(coordenada).colocar(pieza);
    }

    // Devuelve un clon profundo de la celda en la coordenada indicada
    public Celda consultarCelda(Coordenada coordenada) {
        if (estaEnTablero(coordenada)) {
            return obtenerCelda(coordenada).clonar();
        }
        return null;
    }

    // Devuelve una lista de clones profundos de todas las celdas del tablero
    public List<Celda> consultarCeldas() {
        List<Celda> celdas = new ArrayList<>();
        for (List<Celda> fila : matriz) {
            for (Celda celda : fila) {
                celdas.add(celda.clonar());
            }
        }
        return celdas;
    }

    // Devuelve el número de columnas del tablero
    public int consultarNumeroColumnas() {
        return TAMANO;
    }

    // Devuelve el número de filas del tablero
    public int consultarNumeroFilas() {
        return TAMANO;
    }

    // Elimina la pieza de la celda en la coordenada indicada
    public void eliminarPieza(Coordenada coordenada) {
        if (coordenada == null || !estaEnTablero(coordenada)) {
            return;
        }
        obtenerCelda(coordenada).eliminarPieza();
    }

    // Verifica si la coordenada está dentro de los límites del tablero
    public boolean estaEnTablero(Coordenada coordenada) {
        int fila = coordenada.fila();
        int columna = coordenada.columna();
        return fila >= 0 && fila < TAMANO && columna >= 0 && columna < TAMANO;
    }

    // Devuelve la referencia a la celda en la coordenada indicada
    Celda obtenerCelda(Coordenada coordenada) {
        if (estaEnTablero(coordenada)) {
            return matriz.get(coordenada.fila()).get(coordenada.columna());
        }
        return null;
    }

	@Override
	public int hashCode() {
		return Objects.hash(matriz);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablero other = (Tablero) obj;
		return Objects.equals(matriz, other.matriz);
	}

	@Override
	public String toString() {
		return "Tablero [matriz=" + matriz + "]";
	}
    
}
