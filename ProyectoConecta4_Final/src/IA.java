public class IA extends Jugador{
    private int puntuacion;
    /**
     * Constructor de Inteligencia Artificial
     */
    public IA() {
        super("#Jugador artificial");
        this.puntuacion=0;
    }
    
    public void setPuntuacion(int pPuntuacion) {
        this.puntuacion=pPuntuacion;
    }
    
    /**
     * Cede el turno a la IA para realizar su jugada
     */
    public void jugar() {
        System.out.println("");
        System.out.println("Le toca a "+super.escribirNombre());
        int x=Dado.obtenerMiDado().obtenerNumAzar();
        Tablero.getTablero().ocuparCasilla((Jugador)this, x);
    }
    
    public void jugarTrucado() {
        System.out.println("");
        System.out.println("Le toca a "+super.escribirNombre());
        int x=Dado.obtenerMiDado().tirarDado();
        Tablero.getTablero().ocuparCasilla((Jugador)this, x);
    }
    
    public int getPuntuacion() {
    	System.out.println(this.puntuacion);
    	return this.puntuacion;
    }
}

