import java.util.ArrayList;
import java.util.Iterator;


public class ListaJugadores {
	
	//private boolean ganar;
	private ArrayList<Persona> lista;
	
	/**
	 * Constructor est�ndar
	 */
	public ListaJugadores() {
		//ganador=new Jugador(-1,"");
		//ganar=false;
		lista=new ArrayList<Persona>();
	}
	
	/**
	 * Iterador de Jugadores
	 * @return Iterador
	 */
	private Iterator<Persona> getIterador(){
		return this.lista.iterator();
	}
	
	/**
	 * Agrega un jugador a la partida
	 * @param j1 Jugador a agregar
	 */
	public void anadirJugador(Persona j1) {
		if(!this.lista.contains(j1))
		this.lista.add(j1);
	}
	
	/**
	 * Elimina un jugador de la partida
	 * @param j1 Jugador a eliminar
	 */
	public void eliminarJugador(Persona j1) {
		if(this.lista.contains(j1))
		this.lista.remove(j1);
	}
	
	/**
	 * Configura la puntuaci�n del jugador
	 * @param pJugador Jugador con puntuaci�n a agregar
	 * @param pPuntuacion Puntuaci�n a agregar
	 */
	public void setPuntuacion(Jugador pJugador, int pPuntuacion){
		Jugador j1=this.getJugador(pJugador.escribirNombre());
		/*if(j1 instanceof IA){
			((IA)j1).setPuntuacion(pPuntuacion);
		}else*/ if(j1 instanceof Persona){
			((Persona) j1).setPuntuacion(pPuntuacion);
		}
	}
	
	/**
	 * Determina si el jugador figura en la lista
	 * @param j1 Jugador a buscar
	 * @return True si el jugador existe, False en caso contrario
	 
	private boolean existeJugador(Jugador j1) {
		return this.lista.contains(j1);
	}*/
	
	/**
	 * Dado el nombre del jugador, se obtiene de la lista
	 * @param pNombre Nombre del jugador
	 * @return Datos del jugador
	 */
	public Jugador getJugador(String pNombre) {
		Jugador res=null;
		Iterator<Persona> itr=this.getIterador();
		boolean salir=false;
		while(itr.hasNext() && !salir) {
			Jugador act=itr.next();
			if(act.escribirNombre().equals(pNombre)) {
				salir=true;
				res=act;
			}
		}
		return res;
	}

	/**
	 * Devuelve el esquema de puntuaciones de los jugadores
	 * @return Lista de jugadores con su puntuaci�n correspondiente
	 */
	public ArrayList<Persona> getScoreboardJugadores() {
		// TODO Auto-generated method stub
		return this.lista;
	}
	
	/**
	 * Elimina el listado de jugadores
	 */
	public void reset() {
		this.lista=new ArrayList<Persona>();
	}
	
}
