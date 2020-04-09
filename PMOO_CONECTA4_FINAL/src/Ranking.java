import java.util.ArrayList;

public class Ranking {
    private ListaJugadores jugadores;
    public static Ranking miRanking;

    /**
     * Constructor Ranking
     */
    private Ranking() {
        this.jugadores=new ListaJugadores();
    }

    /**
     * Máquina Abstracta de Estados de puntuaciones de jugadores
     * @return Ranking de los jugadores que han participado
     */
    public static Ranking getMiRanking() {
        if(Ranking.miRanking==null) {
            Ranking.miRanking=new Ranking();
        }
        return Ranking.miRanking;
    }

    /**
     * Dado un jugador, obtiene su nombre
     * @param pNombre Nombre del jugador
     * @return Jugador específico
     */
    public Jugador getJugador(String pNombre) {
        return this.jugadores.getJugador(pNombre);
    }

    /**
     * Asigna a un jugador específico una puntuación específica y lo modifica en el ranking
     * @param pPuntuacion Puntuación a asignar en el ranking
     * @param pJugador Jugador que se modifica en el ranking
     */
    public void setPuntuacion(int pPuntuacion, Jugador pJugador) {
        jugadores.setPuntuacion(pJugador, pPuntuacion);
    }

    /**
     * Agrega un jugador al listado
     * @param pJugador Jugador al que agregar
     */
    public void anadirJugador(Persona pJugador) {
        jugadores.anadirJugador(pJugador);
    }

    /**
     * Elimina un jugador de la lista
     * @param pJugador Jugador a eliminar
     */
    public void eliminarJugador(Persona pJugador) {
    	jugadores.eliminarJugador(pJugador);
    }
    /**
     * Con finalidad de volcado de datos, devuelve ArrayList con todos los datos de todos los jugadores
     * @return Listado de jugadores
     */
    public ArrayList<Persona> getScoreboardJugadores() {
        return this.jugadores.getScoreboardJugadores();
    }
}
