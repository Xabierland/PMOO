package packlaboratorio4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import packlaboratorio5.Libro;

public class LibroTest extends TestCase
{
	Libro l1,l2,l3;

	@Before
	public void setUp()
	{
		//String pTitulo, String pAutor, int pIdLibro
		l1=new Libro("El amor dura tres annos", "Frederic Beigbeder",4);
		l2=new Libro("El amor dura tres annos", "Frederic Beigbeder",4);
		l3=new Libro("El amor dura tres annos", "Frederic Beigbeder",0);
	}

	@After
	public void tearDown()
	{
		l1=null;
	}

	@Test
	public void testTieneEsteId()
	{
		assertTrue(l1.tieneEsteId(4));
		assertFalse(l1.tieneEsteId(0));
	}

	@Test
	public void testTieneElMismoId()
	{
		assertTrue(l1.tieneElMismoId(l2));
		assertFalse(l1.tieneElMismoId(l3));
	}

	@Test
	public void testImprimir()
	{
		assertNotNull(l1);

		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del metodo imprimir de la clase Libro");
		System.out.println("\nLa informacion del libro deberia mostrarse de este modo:\n");
		System.out.println("* El amor dura tres annos, escrito por Frederic Beigbeder.");
		System.out.println("\nY tu programa lo muestra de este modo:\n");
		l1.imprimir();
		System.out.println("\n===============================================================");
	}

}
