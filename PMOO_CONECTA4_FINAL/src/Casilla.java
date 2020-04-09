
public class Casilla {
	private boolean conFicha;
	private Jugador j1;
	private char ficha;
	
	
	public Casilla() {
		this.conFicha=false;
	}
	
	/**
	 * Constructor de casillas del tablero
	 * @param pConFicha Si tiene ficha o no
	 * @param pJ1 Jugador que pone la ficha
	 * @param pFicha Inicial del jugador 
	 *
	public Casilla(boolean pConFicha,Jugador pJ1,char pFicha) {
		conFicha=pConFicha;
		j1=pJ1;
		ficha=pFicha;
	}*/
	
	/**
	 * Obtiene la ficha
	 * @return Ficha en cuestión
	 */
	public char getFicha() {
		return ficha;
	}
	
	/**
	 * Determina si la casilla del tablero tiene ficha o no
	 * @return True si tiene ficha. False en caso conrario
	 */
	public boolean tieneFicha() {
		return conFicha;
	}
	
	/**
	 * Asigna la casilla a un jugador
	 * @param pJug Jugador que tiene la casilla
	 */
	public void setCasilla(Jugador pJug) {
		conFicha=true;
		j1=pJug;
		ficha=j1.escribirNombre().charAt(0);
	}
	
	/**
	 * Determina el jugador que ocupa la casilla
	 * @return Jugador que ocupa la casilla
	 */
	public Jugador casillaJugador() {
		return j1;
	}
}
