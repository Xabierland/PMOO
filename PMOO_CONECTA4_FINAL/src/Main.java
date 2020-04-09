import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ManejadorFicheros fh = ManejadorFicheros.getManejadorFicheros();
			fh.abrirFlujoLectura();
			fh.leerFichero();
			fh.cerrarFlujoLectura();
		} catch (IOException e) {
			System.err.println("Error leyendo fichero");
		}

		Conecta4.getMiConecta4().jugar();
		try {
			ManejadorFicheros fh= ManejadorFicheros.getManejadorFicheros();
			fh.abrirFlujoEscritura();
			fh.escribirFichero();
			fh.cerrarFlujoEscritura();
		} catch (IOException e) {
			System.err.println("Error escribiendo fichero");
		}

	}
}
