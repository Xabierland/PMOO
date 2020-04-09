package packlaboratorio4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import packlaboratorio5.Libro;
import packlaboratorio5.Usuario;

public class UsuarioTest extends TestCase
{

	Usuario usuario1, usuario2, usuario3;
	Libro l1,l2,l3,l4;
	Libro l5,l6,l7,l8;

	@Before
	public void setUp()
	{
		usuario1= new Usuario("Lola Mento",1099);
		usuario2= new Usuario("Joseba Laka",2);
		usuario3= new Usuario("Xabier Arto",1099);

		l1=new Libro("El Cuaderno Dorado", "Doris Lessing",1);
		l2=new Libro("Rayuela", "Julio Cortazar",2);
		l3=new Libro("Paula", "Isabela Allende",3);
		l4=new Libro("La sonrisa Etrusca", "Sampedro",4);
	}

	@After
	public void tearDown() {
		usuario1=null;
		usuario2=null;
		usuario3=null;
		
		l1=null;
		l2=null;
		l3=null;
		l4=null;
	}

	@Test
	public void testUsuario()
	{
		assertNotNull(usuario1);
		assertNotNull(usuario2);
		assertNotNull(usuario3);
		
		assertNotNull(l1);
		assertNotNull(l2);
		assertNotNull(l3);
		assertNotNull(l4);
	}

	@Test
	public void testHaAlcanzadoElMaximo()
	{
		usuario1.anadirLibro(l1);
		usuario1.anadirLibro(l2);	//Maximo
		usuario1.anadirLibro(l3);
		
		usuario2.anadirLibro(l1);
		usuario2.anadirLibro(l2);
		usuario2.anadirLibro(l3);	//Mas del maximo luego el ultimo no se anade
		usuario2.anadirLibro(l4);
		
		usuario3.anadirLibro(l1);	//Menos del maximo
		
		assertTrue(usuario1.haAlcanzadoElMaximo());
		assertTrue(usuario2.haAlcanzadoElMaximo());
		assertFalse(usuario3.haAlcanzadoElMaximo());
	}

	@Test
	public void testloTieneEnPrestamoYAnadirLibroYEliminar()
	{
		usuario1.anadirLibro(l1);
		assertTrue(usuario1.loTieneEnPrestamo(l1));
		usuario1.eliminarLibro(l1);
		assertFalse(usuario1.loTieneEnPrestamo(l1));
	}

	@Test
	public void testTieneEsteId()
	{
		assertTrue(l1.tieneEsteId(1));
		assertFalse(l1.tieneEsteId(2));
		assertTrue(l2.tieneEsteId(2));
		assertFalse(l2.tieneEsteId(3));
		assertTrue(l3.tieneEsteId(3));
		assertFalse(l3.tieneEsteId(4));
		assertTrue(l4.tieneEsteId(4));
		assertFalse(l4.tieneEsteId(5));
	}

	@Test
	public void testTieneMismoId()
	{
		l5=new Libro("El Cuaderno Dorado", "Doris Lessing",4);
		l6=new Libro("Rayuela", "Julio Cortazar",3);
		l7=new Libro("Paula", "Isabela Allende",2);
		l8=new Libro("La sonrisa Etrusca", "Sampedro",1);
		
		assertTrue(l1.tieneElMismoId(l8));
		assertFalse(l1.tieneElMismoId(l7));
		assertTrue(l2.tieneElMismoId(l7));
		assertFalse(l2.tieneElMismoId(l6));
		assertTrue(l3.tieneElMismoId(l6));
		assertFalse(l3.tieneElMismoId(l5));
		assertTrue(l4.tieneElMismoId(l5));
		assertFalse(l4.tieneElMismoId(l8));
	}

	@Test
	public void testImprimir()
	{	
		assertNotNull(usuario1);

		System.out.println("\n===============================================================");
		System.out.println("\nCaso de prueba del metodo imprimir de la clase Usuario (0 libros)");
		System.out.println("\nLa informacion del usuario deberia mostrarse de este modo:\n");
		System.out.println("ID: 1099: Lola Mento");
		System.out.println("---> No tiene libros en prestamo.");

		System.out.println("\nY tu programa lo muestra de este modo:\n");
		usuario1.imprimir();
		System.out.println("\n===============================================================");

		usuario1.anadirLibro(l1);

		System.out.println("\nCaso de prueba del metodo imprimir de la clase Usuario (1 libro)");
		System.out.println("\nLa informacion del usuario deberia mostrarse de este modo:\n");
		System.out.println("ID: 1099: Lola Mento");
		System.out.println("---> Tiene el siguiente titulo en prestamo:");
		System.out.println("* El Cuaderno Dorado, escrito por Doris Lessing.");

		System.out.println("\nY tu programa lo muestra de este modo:\n");
		usuario1.imprimir();
		System.out.println("\n===============================================================");

		usuario1.anadirLibro(l2);		

		System.out.println("\nCaso de prueba del metodo imprimir de la clase Usuario (2 o mas libros)");
		System.out.println("\nLa informacion del usuario deberia mostrarse de este modo:\n");
		System.out.println("ID: 1099: Lola Mento");
		System.out.println("---> Tiene los siguientes 2 titulos en prestamo:");
		System.out.println("* El Cuaderno Dorado, escrito por Doris Lessing.");
		System.out.println("* Rayuela, escrito por Julio Cortazar.");

		System.out.println("\nY tu programa lo muestra de este modo:\n");
		usuario1.imprimir();
		System.out.println("\n===============================================================");
	}

}

