import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DadoTest {
	Dado d1;
	@Before
	public void setUp() throws Exception {
		d1=Dado.obtenerMiDado();
	}

	@After
	public void tearDown() throws Exception {
		d1=null;
	}

	@Test
	public void testObtenerMiDado() {
		assertEquals(Dado.obtenerMiDado(),d1);
	}

	@Test
	public void testObtenerNumAzar() 
	{
		//Como el numero es al azar no podemos comprobar
	}
}
