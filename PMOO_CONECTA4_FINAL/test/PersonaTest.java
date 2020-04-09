
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonaTest {
	Persona p1,p2;

	@Before
	public void setUp() throws Exception {
	p1= new Persona("Juan");
	p2=new Persona("Maria");
	}

	@After
	public void tearDown() throws Exception {
		p1=null;
		p2=null;
	}

	@Test
	public void testPersona() {
		assertNotNull(p1);
		assertNotNull(p2);
	}

	@Test
	public void testSetPuntuacion() {
		p1.setPuntuacion(45);
		assertEquals(p1.getPuntuacion(),45);
	}

	@Test
	public void testGetPuntuacion() {
		p1.setPuntuacion(45);
		assertEquals(p1.getPuntuacion(),45);
	}

	@Test
	public void testGetNombre() {
		assertEquals(p1.getNombre(),"Juan");
		assertNotEquals(p1.getNombre(),"Maria");
	}

	@Test
	public void testJugar() {
		Tablero.getTablero().ocuparCasilla(p1, Integer.parseInt(Teclado.getTeclado().insertarFicha()));
	}
	
	@Test
	public void testAumentarPuntuacion(){
		assertEquals(p1.getPuntuacion(),0);
		p1.aumentarPuntuacion();
		assertEquals(p1.getPuntuacion(),1);
	}

}
