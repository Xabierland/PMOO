import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IATest {

	IA i1;
	@Before
	public void setUp() throws Exception {
		i1=new IA();
	}

	@After
	public void tearDown() throws Exception {
		i1=null;
	}

	@Test
	public void testIA() {
		assertNotNull(i1);
	}

	@Test
	public void testSetPuntuacion() {
		i1.setPuntuacion(5);
		assertEquals(i1.getPuntuacion(),5);
	}

	@Test
	public void testJugar() 
	{
		i1.jugarTrucado(); //Como jugar pero decidiendo el dado
		Tablero t1=Tablero.getTablero();
		t1.imprimirTablero();
		assertTrue(t1.existeFicha(1,9));
	}

}
