package packlaboratorio4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	Cliente c1,c2,c3,c4;
	@Before
	public void setUp() throws Exception {
		//int pId, String pNombre, String pClave, double pSaldo, boolean pPref
		c1=new Cliente(1,"Amaia Basabe", "A100",100,true);
		c2=new Cliente(2,"Xabier Gabinna","B100",100,false);
		c3=new Cliente(3,"Extremo Duro","C100",-100,false);
	}

	@After
	public void tearDown() throws Exception {
		c1=null;
		c2=null;
		c3=null;
		c4=null;
	}

	@Test
	public void testCliente() {
		assertNotNull(c1);
		assertNotNull(c2);
		assertNotNull(c3);
	}

	@Test
	public void testEsPreferente() {
		assertTrue(c1.esPreferente());
		assertFalse(c2.esPreferente());
		assertFalse(c3.esPreferente());
	}

	@Test
	public void testTieneMismoId() {
		
		assertTrue(c1.tieneMismoId(1));
		assertFalse(c1.tieneMismoId(2));
		assertTrue(c2.tieneMismoId(2));
		assertFalse(c2.tieneMismoId(3));
		assertTrue(c3.tieneMismoId(3));
		assertFalse(c3.tieneMismoId(4));
		
	}

	@Test
	public void testObtenerSaldo() {
		assertEquals(c1.obtenerSaldo("A100"),100,0.1);
		assertEquals(c2.obtenerSaldo("B100"),100,0.1);
		assertEquals(c3.obtenerSaldo("C100"),-100,0.1);
	}

	@Test
	public void testActualizarSaldo() 
	{
		c1.actualizarSaldo("A100", 25);
		assertEquals(c1.obtenerSaldo("A100"),75,0.1);
		
		c1.actualizarSaldo("B100", 25);
		assertEquals(c1.obtenerSaldo("A100"),75,0.1);
		
		c2.actualizarSaldo("B100", 200);
		assertEquals(c2.obtenerSaldo("B100"),100,0.1);
		
		c3.actualizarSaldo("C100", 100);
		assertEquals(c3.obtenerSaldo("C100"),-100,0.1);
	}

}
