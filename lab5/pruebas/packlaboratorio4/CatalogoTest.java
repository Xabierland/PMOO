package packlaboratorio4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import packlaboratorio5.Catalogo;
import packlaboratorio5.Libro;
import packlaboratorio5.ListaUsuarios;
import packlaboratorio5.Usuario;

public class CatalogoTest extends TestCase
{

	private Libro l1;
	private Libro l2;
	private Libro l3;
	private Libro l4;

	private Usuario e1;
	private Usuario e2;

	@Before
	public void setUp()
	{
		l1 = new Libro("Construcción de software orientado a objetos", "Bertrand Meyer",1);
		l2 = new Libro("Cien años de soledad", "Gabriel García Márquez",2); 
		l3 = new Libro("El hobbit", "JRR Tolkien",3);
		l4=  new Libro("El perfume", "Patrick Suskind",4);

		e1=new Usuario("Kepa Sarasola", 1);	
		e2=new Usuario("Armando Guerra", 2);


		Catalogo.getCatalogo().catalogarLibro(l1);
		Catalogo.getCatalogo().catalogarLibro(l2);
		Catalogo.getCatalogo().catalogarLibro(l3);

		ListaUsuarios.getListaUsuarios().resetear();

	}

	@After
	public void tearDown()
	{
		l1 = null;
		l2 = null;
		l3 = null;
		l4 = null;

		e1=null;
		e2=null;

		Catalogo.getCatalogo().resetear();
	}

	@Test
	public void testGetCatalogo()
	{
		Catalogo CA=Catalogo.getCatalogo();
		assertEquals(Catalogo.getCatalogo(),CA);
	}

	@Test
	public void testBuscarLibroPorId()
	{
		Catalogo CA=Catalogo.getCatalogo();
		
		assertEquals(CA.buscarLibroPorId(1),l1);
		
		
	}

	@Test
	public void testCatalogarYDescatalogarLibroYResetear()
	{
		Catalogo CA=Catalogo.getCatalogo();
		CA.catalogarLibro(l4);
		assertEquals(CA.buscarLibroPorId(4),l4);
		CA.descatalogarLibro(4);
		assertEquals(CA.buscarLibroPorId(4),null);
		CA.resetear();
		assertEquals(CA.buscarLibroPorId(4),null);
	}

	@Test
	public void testPrestarYDevolverLibro()
	{
		Catalogo CA=Catalogo.getCatalogo();
		ListaUsuarios LU=ListaUsuarios.getListaUsuarios();
		CA.catalogarLibro(l1);
		CA.catalogarLibro(l2);
		LU.darDeAltaUsuario(e1);
		LU.darDeAltaUsuario(e2);
		
		CA.devolverLibro(1);
		CA.prestarLibro(1, 1);
		assertTrue(e1.loTieneEnPrestamo(l1));
		assertFalse(e1.loTieneEnPrestamo(l2));
		assertFalse(e2.loTieneEnPrestamo(l1));
		assertFalse(e2.loTieneEnPrestamo(l2));
		
		CA.prestarLibro(1, 2);
		assertTrue(e1.loTieneEnPrestamo(l1));
		assertFalse(e1.loTieneEnPrestamo(l2));
		assertFalse(e2.loTieneEnPrestamo(l1));
		assertFalse(e2.loTieneEnPrestamo(l2));
		
		CA.prestarLibro(2, 1);
		assertTrue(e1.loTieneEnPrestamo(l1));
		assertTrue(e1.loTieneEnPrestamo(l2));
		assertFalse(e2.loTieneEnPrestamo(l1));
		assertFalse(e2.loTieneEnPrestamo(l2));
		
		CA.prestarLibro(2, 2);
		assertTrue(e1.loTieneEnPrestamo(l1));
		assertTrue(e1.loTieneEnPrestamo(l2));
		assertFalse(e2.loTieneEnPrestamo(l1));
		assertFalse(e2.loTieneEnPrestamo(l2));
		
		CA.devolverLibro(1);
		assertFalse(e1.loTieneEnPrestamo(l1));
		assertTrue(e1.loTieneEnPrestamo(l2));
		assertFalse(e2.loTieneEnPrestamo(l1));
		assertFalse(e2.loTieneEnPrestamo(l2));
		
		CA.prestarLibro(1, 2);
		assertFalse(e1.loTieneEnPrestamo(l1));
		assertTrue(e1.loTieneEnPrestamo(l2));
		assertTrue(e2.loTieneEnPrestamo(l1));
		assertFalse(e2.loTieneEnPrestamo(l2));
		
		
	}
	
	@Test
	public void testimprimir()
	{
		assertEquals(3,Catalogo.getCatalogo().obtenerNumLibros());

		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del método imprimir de la clase Catalogo");
		System.out.println("\nLa información de la lista de usuarios debería mostrarse de este modo:\n");
		System.out.println("El catálogo tiene un total de 3 títulos.");
		System.out.println("* Construcción de software orientado a objetos, escrito por Bertrand Meyer.");
		System.out.println("* Cien años de soledad, escrito por Gabriel García Márquez.");
		System.out.println("* El hobbit, escrito por JRR Tolkien.");

		System.out.println("\nY tu programa lo muestra de este modo:");
		Catalogo.getCatalogo().imprimir();
		System.out.println("\n===============================================================");

		Catalogo.getCatalogo().descatalogarLibro(1);
		Catalogo.getCatalogo().descatalogarLibro(2);
		Catalogo.getCatalogo().descatalogarLibro(3);
		Catalogo.getCatalogo().descatalogarLibro(4);
		assertEquals(0,Catalogo.getCatalogo().obtenerNumLibros());	
	}

}
