import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JugadorTest {
	
	Jugador p1,p2;
	@Before
	public void setUp() throws Exception 
	{
		p1=new Jugador("Xabier");
		p2=new Jugador("Javi");
	}

	@After
	public void tearDown() throws Exception 
	{
		p1=null;
		p2=null;
	}

	@Test
	public void testJugador() 
	{
		assertNotNull(p1);
		assertNotNull(p2);
	}

	@Test
	public void testEscribirNombre() 
	{
		assertEquals(p1.escribirNombre(),"Xabier");
		assertNotEquals(p1.escribirNombre(),"Javier");
		
		
		assertEquals(p2.escribirNombre(),"Javier");
		assertNotEquals(p2.escribirNombre(),"Xabier");
	}
}
