public class Persona extends Jugador{
    private String nombre;
    private int puntuacion;

    /**
     * Crea una instancia de Persona, heredada de Jugador
     * @param pNombre Nombre de la persona
     */
    public Persona(String pNombre) {
        super( pNombre);
    }

    /**
     * Asigna a la persona una puntuación específica
     * @param pPuntuacion
     */
    public void setPuntuacion(int pPuntuacion) {
        this.puntuacion=pPuntuacion;
    }

    /**
     * Aumenta la puntuaci�n del jugador
     */
    public void aumentarPuntuacion() {
    	this.puntuacion++;
    }
    
    /**
     * Obtiene la puntuación que tiene la persona
     * @return Puntuación
     */
    public int getPuntuacion() {
        return this.puntuacion;
    }

    /**
     * Obtiene nombre de la persona
     * @return Nombre
     */
    public String getNombre() {
    	return super.escribirNombre();
    }
    
    public void jugar() {
        System.out.println("");
        System.out.println("Le toca a "+super.escribirNombre());
        String columna=Teclado.getTeclado().insertarFicha();
        int y = Integer.parseInt(columna);
        if(y!=-1) {
            Tablero.getTablero().ocuparCasilla(this, y);
        }else{
            System.out.println("");
        }
    }
}
