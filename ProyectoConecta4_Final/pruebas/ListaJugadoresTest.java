import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaJugadoresTest {

	ListaJugadores l1;
	Persona p1,p2,p3;
	@Before
	public void setUp() throws Exception 
	{
		l1=new ListaJugadores();
		p1=new Persona("Xabier");
		p2=new Persona("Javi");
		p3=new Persona("Eneko");
	}

	@After
	public void tearDown() throws Exception 
	{
		l1.reset();
		p1=null;
		p2=null;
		p3=null;
		
	}

	@Test
	public void testListaJugadores() 
	{
		assertNotNull(l1);
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
	}

	@Test
	public void testAnadirJugador() 
	{
		l1.anadirJugador(p1);
		l1.anadirJugador(p2);
		
		assertEquals(l1.getJugador("Xabier"), p1);
		assertEquals(l1.getJugador("Javi"), p2);
		assertEquals(l1.getJugador("Eneko"), null);
	}

	@Test
	public void testEliminarJugador() 
	{
		l1.anadirJugador(p1);
		l1.anadirJugador(p2);
		
		assertEquals(l1.getJugador("Xabier"), p1);
		assertEquals(l1.getJugador("Javi"), p2);
		assertEquals(l1.getJugador("Eneko"), null);
		
		l1.eliminarJugador(p1);
		
		assertNotEquals(l1.getJugador("Xabier"), p1);
		assertEquals(l1.getJugador("Javi"), p2);
		assertEquals(l1.getJugador("Eneko"), null);
		
		l1.eliminarJugador(p2);

		assertNotEquals(l1.getJugador("Xabier"), p1);
		assertNotEquals(l1.getJugador("Javi"), p2);
		assertEquals(l1.getJugador("Eneko"), null);
	}

	@Test
	public void testSetPuntuacion() 
	{
		l1.anadirJugador(p1);
		
		l1.setPuntuacion((Jugador)p1, 5);
		assertEquals(p1.getPuntuacion(),5);
		
		//Como la persona no esta en la lista no es posible añadirle los puntos
		l1.setPuntuacion((Jugador)p2, 5);
		assertEquals(p1.getPuntuacion(),0);
	}

	@Test
	public void testGetJugador() 
	{
		//Se demuestra mediante el testEliminarJugador y testAñadirJugador
	}
}
