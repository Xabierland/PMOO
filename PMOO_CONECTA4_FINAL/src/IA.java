public class IA extends Jugador{
    private int puntuacion;
    /**
     * Constructor de Inteligencia Artificial
     */
    public IA() {
        super("#Jugador artificial");
        this.puntuacion=0;
    }
    
    /**
     * Asigna puntuación a un usuario
     * @param pPuntuacion Puntuación a asignar
     *
    public void setPuntuacion(int pPuntuacion) {
        this.puntuacion=pPuntuacion;
    }/
    
    /**
     * Cede el turno a la IA para realizar su jugada
     */
    public void jugar() {
        System.out.println("");
        System.out.println("Le toca a "+super.escribirNombre());
        int y=Dado.obtenerMiDado().obtenerNumAzar();
        Tablero.getTablero().ocuparCasilla(this, y);
    }

    /**
     * Admite tests en modo aleatorio
     */
    public void jugarTrucado() {
        System.out.println("");
        System.out.println("Le toca a "+super.escribirNombre());
        int x=Dado.obtenerMiDado().tirarDado();
        Tablero.getTablero().ocuparCasilla((Jugador)this, x);
    }
}

