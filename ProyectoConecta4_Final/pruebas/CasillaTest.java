import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CasillaTest {

	//Define los objetos
	Casilla c1,c2,c3;
	Jugador p1,p2;
	@Before
	public void setUp() throws Exception 
	{
	//Crea todos los objetos al principio
	p1=new Jugador("Xabier");
	p2=new Jugador("Javi");
	c1=new Casilla();
	c2=new Casilla();
	c3=new Casilla();
	}

	@After
	public void tearDown() throws Exception 
	{
		//Resetea todos los objetos despues de cada Test
		p1=null;
		p2=null;
		c1=null;
		c2=null;
		c3=null;
	}

	@Test
	public void testCasilla() 
	{
		//Se comprueba que todos los objetos se han creado correctamente
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(c1);
		assertNotNull(c2);
		assertNotNull(c3);
	}

	@Test
	public void testGetFicha() 
	{
		//Seteo dos de las casillas a cada jugador y una la dejo null
		c1.setCasilla(p1);
		c2.setCasilla(p2);
		
		//La casilla dos tiene un ficha X
		assertEquals(c1.getFicha(),'X');
		assertNotEquals(c1.getFicha(),'J');
		
		//La casilla dos tiene un ficha J
		assertEquals(c2.getFicha(),'J');
		assertNotEquals(c2.getFicha(),'X');
		
		//En el caso de la casilla 3 al no estar llena ninguno de las 
		assertNotEquals(c3.getFicha(),'X');
		assertNotEquals(c3.getFicha(),'J');

	}

	@Test
	public void testTieneFicha() 
	{
		//Seteo dos de las casillas a cada jugador y una la dejo null
		c1.setCasilla(p1);
		c2.setCasilla(p2);
		
		
		assertTrue(c1.tieneFicha());
		assertTrue(c2.tieneFicha());
		assertFalse(c3.tieneFicha());
	}

	@Test
	public void testSetCasilla() 
	{
		//Este metodo se demuestra perfectamente mediante el testTieneFicha() y el testGetFicha()
	}

	@Test
	public void testCasillaJugador() 
	{
		//Seteo dos de las casillas a cada jugador y una la dejo null
		c1.setCasilla(p1);
		c2.setCasilla(p2);
		
		//La casilla 1 como he dicho arriba pertenece al p1
		assertEquals(c1.casillaJugador(),p1);
		assertNotEquals(c1.casillaJugador(),p2);
		
		//La casilla 2 como he dicho arriba pertenece al p2
		assertNotEquals(c2.casillaJugador(),p1);
		assertEquals(c2.casillaJugador(),p2);
		
		//La casilla 3 como no la he definido no pertenece a nadie
		assertNotEquals(c3.casillaJugador(),p1);
		assertNotEquals(c3.casillaJugador(),p2);
	}

}
