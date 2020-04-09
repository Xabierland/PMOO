
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RankingTest {
	ListaJugadores l1;
	Persona u1;

	@Before
	public void setUp() throws Exception {
		l1 = new ListaJugadores();
		u1 = new Persona("Jose");
	}

	@After
	public void tearDown() throws Exception {
		l1=null;
		u1=null;
	}

	@Test
	public void testGetMiRanking() {
		assertNotNull(l1.getScoreboardJugadores());
	}

	@Test
	public void testGetJugador() {
		assertNotNull(u1);
	}

	@Test
	public void testSetPuntuacion() {
		u1.setPuntuacion(56);
		assertEquals(u1.getPuntuacion(),56);
	}

	@Test
	public void testAnadirJugador() {
		l1.anadirJugador(u1);
		assertEquals(l1.getJugador("Jose"),u1);
	}

	@Test
	public void testEliminarJugador() {
		l1.anadirJugador(u1);
		assertEquals(l1.getJugador("Jose"),u1);
		l1.eliminarJugador(u1);
		assertNotEquals(l1.getJugador("Jose"),u1);
	}

	@Test
	public void testGetScoreboardJugadores() {
		assertNotNull(l1.getScoreboardJugadores());
		}

}
