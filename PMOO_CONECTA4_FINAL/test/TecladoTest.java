
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TecladoTest {
	Jugador u1;

	@Before
	public void setUp() throws Exception {
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTeclado() {
		assertNotNull(Teclado.getTeclado());
	}

	@Test
	public void testLeerString() {
		System.out.println("Introduce 1");
		assertEquals(Teclado.getTeclado().leerString(),"1");
	}

	@Test
	public void testLeer2Personas() {
		System.out.println("1: seguir jugando");
		System.out.println("2: acabar partida");
		System.out.println("Escribe 1");
		assertEquals(Teclado.getTeclado().leerString(),"1");
		System.out.println("Escribe 2");
		assertEquals(Teclado.getTeclado().leerString(),"2");
	}

	@Test
	public void testEscribirJugador() {
		System.out.println("Introduce Jose");
		assertEquals(Teclado.getTeclado().escribirJugador(1).escribirNombre(), "Jose");
		}

	@Test
	public void testInsertarFicha() {
		System.out.println("Introduce 10");
		assertEquals(Teclado.getTeclado().insertarFicha(),"10");
		System.out.println("Ahora un número >10 o <1");
		assertEquals(Teclado.getTeclado().insertarFicha(),"-1");
	}

}
