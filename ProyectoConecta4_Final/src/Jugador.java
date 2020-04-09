import java.util.Iterator;

public class Jugador {
	private String nombre;
	private int puntuacion;
	
	/**
	 * Constructor de Jugador
	 * @param pNombre Nombre del jugador
	 */
	public Jugador(String pNombre) {
		nombre=pNombre;
		puntuacion=0;
	}
	
	/**
	 * Inserta una ficha en el tablero
	 * @param pX 
	 * @param pY
	 
	public void insertarFicha(int pX,int pY) {
		Tablero.getTablero().ocuparCasilla(this, pY);
	}*/
	public String escribirNombre() {
		return nombre;
	}

}
