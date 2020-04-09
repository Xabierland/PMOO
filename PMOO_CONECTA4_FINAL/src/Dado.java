
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dado {
    private static Dado miDado;

    /**
     * Constructor de dado
     */
    private Dado() {

    }

    /**
     * Obtiene el generador de números que la IA usará para marcar casilla
     * @return Generador de números
     */
    public static Dado obtenerMiDado() {
        if(Dado.miDado==null) {
            Dado.miDado=new Dado();
        }
        return Dado.miDado;
    }
    /**
     * Obtiene un número al azar del 1 al 7
     * @return Número al azar
     */
    public int obtenerNumAzar() {
        return ThreadLocalRandom.current().nextInt(1, 7 + 1);
    }

	public int tirarDado()
    {
    	return Teclado.getTeclado().leerEntero();
    }
    
    


}
