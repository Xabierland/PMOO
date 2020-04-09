import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ManejadorFicheros {
    private BufferedReader br;
    private BufferedWriter bw;
    private static final String FICHERO="usuarios.dat";
    private static ManejadorFicheros miManejadorFicheros;

    /**
     * Constructor princiapl
     * @throws IOException Fallos de lectura/escritura o E/S del fichero
     */
    private ManejadorFicheros() throws IOException {
        
        //br = new BufferedReader(new FileReader(FICHERO));
        //bw = new BufferedWriter(new FileWriter(FICHERO));
    }

    /**
     * Inicializa la lectura del fichero
     * @throws IOException Excepci髇 de lectura/escritura o E/S del fichero
     */
    public void abrirFlujoLectura() throws IOException {
    	br = new BufferedReader(new FileReader(FICHERO));
    }

    /**
     * Inicializa la escritura del fichero
     * @throws IOException Excepci髇 de lectura/escritura o E/S del fichero
     */
    public void abrirFlujoEscritura() throws IOException{
    	bw = new BufferedWriter(new FileWriter(FICHERO));
    }
    
    /**
     * Obtiene el conjunto de control de ficheros
     * @return Objeto para control de ficheros
     * @throws IOException Excepci贸n de E/S de ficheros (p.ej. Acceso concurrente)
     */
    public static ManejadorFicheros getManejadorFicheros() throws IOException {
        if(ManejadorFicheros.miManejadorFicheros==null) {
            ManejadorFicheros.miManejadorFicheros=new ManejadorFicheros();
        }
        return ManejadorFicheros.miManejadorFicheros;
    }

    /**
     * Lee el fichero y vuelca los datos al ranking
     * @throws IOException Excepci贸n de E/S de fichero (p.ej. Acceso concurrente)
     */
    public void leerFichero() throws IOException {
    	String fich=br.readLine();
        String[] datos = new String[2];
        
        while(fich!=null) {
            datos=fich.split(":");
            Persona p = new Persona(datos[0]);
            int puntuacion = Integer.parseInt(datos[1]);
            p.setPuntuacion(puntuacion);
            System.out.println("LE虳A PERSONA "+p.escribirNombre()+" con puntuaci髇 "+p.getPuntuacion());
            Ranking.getMiRanking().anadirJugador(p);
            fich=br.readLine();
        }
    }

    /**
     * Guarda datos del ranking en el fichero
     * @throws IOException Excepci贸n de E/S de ficheros (p.ej. Acceso concurrente)
     */
    public void escribirFichero() throws IOException {
        ArrayList<Persona> lista = Ranking.getMiRanking().getScoreboardJugadores();
        Iterator<Persona> itr= lista.iterator();
        while(itr.hasNext()) {
            Jugador j=itr.next();
            if(j instanceof Persona) {
                int punt=((Persona) j).getPuntuacion();
                String nom= ((Persona) j).getNombre();
                writeToFile(nom+":"+punt);
            }
        }


    }

    /**
     * M茅todo interno en el que se escriben los datos de estad铆sticas en fichero
     * @param pString Dato compuesto a escribir
     * @throws IOException Excepci贸n de E/S de ficheros (p.ej. Acceso concurrente)
     */
    private void writeToFile(String pString) throws IOException {
        bw.write(pString);
        bw.newLine();
    }

    /**
     * Cierra el flujo de lectura. <b>USO OBLIGADO ANTES DEL CIERRE DE APLICACI脫N</b>
     * @throws IOException Excepci贸n de E/S de ficheros (p.ej. Acceso concurrente)
     */
    public void cerrarFlujoLectura() throws IOException {
        br.close();
    }
    
    /**
     * Cierra el flujo de escritura. <b>USO OBLIGADO ANTES DEL CIERRE DE APLICACI脫N</b>
     * @throws IOException Excepci贸n de E/S de ficheros (p.ej. Acceso concurrente)
     */
    public void cerrarFlujoEscritura() throws IOException{
    	bw.close();
        
    }
}

