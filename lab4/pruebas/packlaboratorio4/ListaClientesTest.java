package packlaboratorio4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaClientesTest {

	ListaClientes l1;
	
	@Before
	public void setUp() throws Exception {
		l1=ListaClientes.getListaClientes();
		l1.anadirCliente(1,"Amaia Basabe", "A100",100.00,true);
		l1.anadirCliente(2,"Xabier Gabinna","B100",100.25,false);
		l1.anadirCliente(3,"Extremo Duro","C100",100.25,false);
	}

	@After
	public void tearDown() throws Exception {
		l1=null;
	}

	@Test
	public void testGetListaClientes() {
		assertEquals(ListaClientes.getListaClientes(),l1);
		
		l1.resetear();
	}

	@Test
	public void testCantidadClientes() {
		assertEquals(l1.cantidadClientes(),3);
		
		l1.resetear();
	}

	@Test
	public void testAnadirCliente() {
		l1.anadirCliente(4, "Prueba", "D100", 100.00, false);
		assertEquals(l1.cantidadClientes(),4);
		
		l1.resetear();
	}

	@Test
	public void testBuscarClientePorId() {
		assertNotNull(l1.buscarClientePorId(1));
		assertNull(l1.buscarClientePorId(10));
		
		l1.resetear();
	}

	@Test
	public void testResetear() {
		l1.resetear();
		assertEquals(l1.cantidadClientes(),0);
		
		l1.resetear();
	}

}
