package packlaboratorio4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaOperacionesTest {

	ListaOperaciones lo1;
	ListaClientes lc1;
	Cliente c1,c2;
	Operacion o1, o2;
	
	@Before
	public void setUp() throws Exception {
		lo1=ListaOperaciones.getListaOperaciones();
		lo1.anadirOperacion(1, 1, "A100", 25);
		lo1.anadirOperacion(2, 2, "B100", 50);
		
		lc1=ListaClientes.getListaClientes();
		lc1.anadirCliente(1,"Amaia Basabe", "A100",100,true);
		lc1.anadirCliente(2,"Xabier Gabinna","B100",100,false);
	}

	@After
	public void tearDown() throws Exception {
		lo1.resetear();
		lc1.resetear();
	}

	@Test
	public void testGetListaOperaciones() {
		assertEquals(ListaOperaciones.getListaOperaciones(),lo1);
		

	}

	@Test
	public void testCantidadOperaciones() {
		assertEquals(lo1.cantidadOperaciones(),2);
		

	}

	@Test
	public void testAnadirOperacion() {
		lo1.anadirOperacion(3, 3, "C100", 25);
		assertEquals(lo1.cantidadOperaciones(),3);

	}

	@Test
	public void testBuscarOperacionPorId() {
		assertNotNull(lo1.buscarOperacionPorId(1));
		assertNotNull(lo1.buscarOperacionPorId(10));
		

	}

	@Test
	public void testRealizarOperaciones() {
		o1=lo1.buscarOperacionPorId(1);
		o1.realizarOperacion();
		c1=lc1.buscarClientePorId(1);
		assertEquals(c1.obtenerSaldo("A100"),75,0.1);
		
		o1=lo1.buscarOperacionPorId(1);
		o1.realizarOperacion();
		c2=lc1.buscarClientePorId(2);
		assertEquals(c2.obtenerSaldo("B100"),100,0.1);
		
		o2=lo1.buscarOperacionPorId(2);
		o2.realizarOperacion();
		c2=lc1.buscarClientePorId(2);
		assertEquals(c2.obtenerSaldo("B100"),45,0.1);

		
		
	}

	@Test
	public void testResetear() {
		lo1.resetear();
		assertEquals(lo1.cantidadOperaciones(),0);
	}

}
