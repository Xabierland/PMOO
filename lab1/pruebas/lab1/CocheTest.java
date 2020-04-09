package lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CocheTest {

	Coche c1,c2,c3;
	Persona p1,p2;
	@Before
	public void setUp() throws Exception {
		//String pMat,String pMarcaM
		c1=new Coche("1111MMM","Chevrolet");
		c2=new Coche("2222MMM","Chevrolet");
		c3=new Coche("3333MMM","Chevrolet");
		
		//int pID, String pNac, String pGrupoSang, String pNomCom, int pEdad
		p1=new Persona(111,"Etiopia","0+","Dios Mio",4);
		p2=new Persona(222,"Australiana","0-","Jesus Tuyo",5);
	}
	

	@After
	public void tearDown() throws Exception {
		c1=null;
		c2=null;
		c3=null;		
	}

	@Test
	public void testCoche() {
		assertNotNull(c1);
		assertNotNull(c2);
		assertNotNull(c3);
	}

	@Test
	public void testCambiarDePropietario() {
		c1.cambiarDePropietario(p1);
		assertTrue(c1.esElPropietario(p1));
		assertFalse(c1.esElPropietario(p2));
		c2.cambiarDePropietario(p1);
		assertTrue(c2.esElPropietario(p1));
		assertFalse(c2.esElPropietario(p2));
		c3.cambiarDePropietario(p2);
		assertTrue(c3.esElPropietario(p2));
		assertFalse(c3.esElPropietario(p1));
	}

	@Test
	public void testEsElPropietario() {
		c1.cambiarDePropietario(p1);
		assertTrue(c1.esElPropietario(p1));
		assertFalse(c1.esElPropietario(p2));
		c2.cambiarDePropietario(p1);
		assertTrue(c2.esElPropietario(p1));
		assertFalse(c2.esElPropietario(p2));
		c3.cambiarDePropietario(p2);
		assertTrue(c3.esElPropietario(p2));
		assertFalse(c3.esElPropietario(p1));
	}

}
