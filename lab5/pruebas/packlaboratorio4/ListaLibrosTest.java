package packlaboratorio4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import packlaboratorio5.Libro;
import packlaboratorio5.ListaLibros;

public class ListaLibrosTest extends TestCase
{

	private ListaLibros lista1;
	private Libro l1,l2,l3;
	Libro l4,l5,l6,l7,l8,l9;

	@Before
	public void setUp()
	{
		lista1=new ListaLibros();	
		l1=new Libro("Construccion de software orientado a objetos", "Bertrand Meyer",1);
		l2=new Libro("Cien annos de soledad", "Gabriel Garcia Marquez",2);
		l3=new Libro("El hobbit", "JRR Tolkien",3);
	}

	@After
	public void tearDown()
	{
		lista1=null;
		l1=null;
		l2=null;
		l3=null;
	}

	@Test
	public void testListaLibros()
	{
		assertNotNull(lista1);
		assertEquals(0, lista1.obtenerNumLibros());
	}

	@Test
	public void testAnadirYEliminarLibros()
	{
		lista1.anadirLibro(l1);
		assertTrue(lista1.esta(l1));
		lista1.anadirLibro(l2);
		assertTrue(lista1.esta(l2));
		lista1.anadirLibro(l3);
		assertTrue(lista1.esta(l3));
		
		lista1.eliminarLibro(l1);
		assertFalse(lista1.esta(l1));
		lista1.eliminarLibro(l2);
		assertFalse(lista1.esta(l2));
		lista1.eliminarLibro(l3);
		assertFalse(lista1.esta(l3));
	}

	@Test
	public void testExisteUnLibroConMismoId()
	{
		lista1.anadirLibro(l1);
		lista1.anadirLibro(l2);
		lista1.anadirLibro(l3);
		
		l4=new Libro("Construccion de software orientado a objetos", "Bertrand Meyer",3);
		l5=new Libro("Cien annos de soledad", "Gabriel Garcia Marquez",1);
		l6=new Libro("El hobbit", "JRR Tolkien",2);
		
		l7=new Libro("Construccion de software orientado a objetos", "Bertrand Meyer",4);
		l8=new Libro("Cien annos de soledad", "Gabriel Garcia Marquez",5);
		l9=new Libro("El hobbit", "JRR Tolkien",6);
		
		assertTrue(lista1.existeUnLibroConMismoId(l4));
		assertTrue(lista1.existeUnLibroConMismoId(l5));
		assertTrue(lista1.existeUnLibroConMismoId(l6));
		
		assertFalse(lista1.existeUnLibroConMismoId(l7));
		assertFalse(lista1.existeUnLibroConMismoId(l8));
		assertFalse(lista1.existeUnLibroConMismoId(l9));
	}


	@Test
	public void testEsta()
	{
		lista1.anadirLibro(l1);
		lista1.anadirLibro(l3);
		
		assertTrue(lista1.esta(l1));
		assertFalse(lista1.esta(l2));
		assertTrue(lista1.esta(l3));
	}

	@Test
	public void testImprimir()
	{
		assertEquals(0,lista1.obtenerNumLibros());

		lista1.anadirLibro(l1);
		lista1.anadirLibro(l2);
		lista1.anadirLibro(l3);

		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del método imprimir de la clase ListaLibrosPrestados");
		System.out.println("\nLa información de la lista de libros debería mostrarse de este modo:\n");
		System.out.println("* Construcción de software orientado a objetos, escrito por Bertrand Meyer.");
		System.out.println("* Cien años de soledad, escrito por Gabriel García Márquez.");
		System.out.println("* El hobbit, escrito por JRR Tolkien.");

		System.out.println("\nY tu programa lo muestra de este modo:\n");
		lista1.imprimir();
		System.out.println("\n===============================================================");

		
	}
	
}
