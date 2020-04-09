package packlaboratorio4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OperacionTest {

	Operacion o1,o2;
	ListaClientes lc1;
	Cliente c1,c2;
	@Before
	public void setUp() throws Exception {
		//int pIdOper, int pIdCliente, String pClaveTecleada, double pCant
		o1 = new Operacion(1,1,"A100",25);
		o2 = new Operacion(0,0,"A100",2000);
		
		//int pId, String pNombre, String pClave, double pSaldo, boolean pPref
		lc1=ListaClientes.getListaClientes();
		lc1.anadirCliente(0, "PRUEBA", "Z100", 1000, false);
		lc1.anadirCliente(1,"Amaia Basabe", "A100",100,true);
	}

	@After
	public void tearDown() throws Exception {
		o1=null;
	}

	@Test
	public void testOperacion() {
		assertNotNull(o1);
		assertNotNull(o2);
	}

	@Test
	public void testTieneMismoId() {
		assertTrue(o1.tieneMismoId(1));
		assertFalse(o1.tieneMismoId(10));
		assertTrue(o2.tieneMismoId(0));
		assertFalse(o2.tieneMismoId(10));
	}

	@Test
	public void testRealizarOperacion() {
		o1.realizarOperacion();
		c1=lc1.buscarClientePorId(1);
		assertEquals(c1.obtenerSaldo("A100"),75,0.1);
		
		o2.realizarOperacion();
		c2=lc1.buscarClientePorId(0);
		assertEquals(c2.obtenerSaldo("Z100"),1000,0.1);
	}

}
