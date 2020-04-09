import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Conecta4Test {
	Conecta4 c1;
	@Before
	public void setUp() throws Exception 
	{
		c1=Conecta4.getMiConecta4();
	}

	@After
	public void tearDown() throws Exception {
		c1=null;
	}

	@Test
	public void testGetMiConecta4() {
		assertEquals(Conecta4.getMiConecta4(),c1);
	}

	@Test
	public void testJugar() 
	{
		c1.jugar();
	}

}
