
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManejadorFicherosTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAbrirFlujoLectura() {
		boolean si = false;
		try {
			ManejadorFicheros.getManejadorFicheros().abrirFlujoEscritura();
			si=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(si);
	}

	@Test
	public void testAbrirFlujoEscritura() {
		boolean si = false;
		try {
			ManejadorFicheros.getManejadorFicheros().abrirFlujoEscritura();
			si=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(si);
	}
	

	@Test
	public void testGetManejadorFicheros() {
		boolean si = false;
		try {
			ManejadorFicheros.getManejadorFicheros();
			si=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(si);
	}
		
	

	@Test
	public void testLeerFichero() {
		boolean si = false;
		try {
			ManejadorFicheros.getManejadorFicheros().abrirFlujoLectura();
			ManejadorFicheros.getManejadorFicheros().leerFichero();
			ManejadorFicheros.getManejadorFicheros().cerrarFlujoLectura();
			si=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(si);
	}
	

	@Test
	public void testEscribirFichero() {
		boolean si = false;
		try {
			ManejadorFicheros.getManejadorFicheros().escribirFichero();
			si=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(si);
	}
	

	@Test
	public void testCerrarFlujoLectura() {
		boolean si = false;
		try {
			ManejadorFicheros.getManejadorFicheros().cerrarFlujoLectura();
			si=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(si);
	}
	

	@Test
	public void testCerrarFlujoEscritura()  {
		boolean si = false;
		try {
			ManejadorFicheros.getManejadorFicheros().cerrarFlujoEscritura();;
			si=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(si);
	}

}
