package lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonaTest {

	Persona p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11 ,p12, p13;
	@Before
	public void setUp() throws Exception {
		//int pID, String pNac, String pGrupoSang, String pNomCom, int pEdad
		p1=new Persona(111,"Etiopia","0+","Dios Mio",4);
		p2=new Persona(111,"Australiana","0-","Jesus Tuyo",5);
		p3=new Persona(222,"Australiana","AB+","Me Aburro Mucho",17);
	
	}
		

	@After
	public void tearDown() throws Exception {
		p1=null;
		p2=null;
		p3=null;
	}

	@Test
	public void testPersona() {
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
	}

	@Test
	public void testTieneMismaID() {
		assertFalse(p1.tieneMismaID(p3));
		assertTrue(p1.tieneMismaID(p2));
		assertFalse(p2.tieneMismaID(p3));
		assertTrue(p2.tieneMismaID(p1));
		assertFalse(p3.tieneMismaID(p1));
		assertFalse(p3.tieneMismaID(p2));
		
	}

	@Test
	public void testPuedeConducir() {
		p4=new Persona(111,"Etiopia","0+","Dios Mio",14);
		p5=new Persona(111,"Australiana","0+","Dios Mio",16);
		p6=new Persona(111,"Estadounidense","0+","Dios Mio",16);
		p7=new Persona(111,"Britanico","0+","Dios Mio",17);
		p8=new Persona(111,"Ruso","0+","Dios Mio",18);
		p9=new Persona(111,"Etiopia","0+","Dios Mio",13);
		p10=new Persona(111,"Australiana","0+","Dios Mio",15);
		p11=new Persona(111,"Estadounidense","0+","Dios Mio",15);
		p12=new Persona(111,"Britanico","0+","Dios Mio",16);
		p13=new Persona(111,"Ruso","0+","Dios Mio",17);
		assertTrue(p4.puedeConducir());
		assertTrue(p5.puedeConducir());
		assertTrue(p6.puedeConducir());
		assertTrue(p7.puedeConducir());
		assertTrue(p8.puedeConducir());
		assertFalse(p9.puedeConducir());
		assertFalse(p10.puedeConducir());
		assertFalse(p11.puedeConducir());
		assertFalse(p12.puedeConducir());
		assertFalse(p13.puedeConducir());
	}

	@Test
	public void testInicialNombre() {
		assertSame(p1.inicialNombre(),'D');
		assertSame(p2.inicialNombre(),'J');
	}

	@Test
	public void testInicialApellido() {
		assertSame(p1.inicialApellido(),'M');
		assertSame(p2.inicialApellido(),'T');
		assertSame(p3.inicialApellido(),'M');
	}

	@Test
	public void testPuedeDonarleSangre() {
		Persona O1, O2, A1, A2, B1, B2, AB1, AB2 ;
		O1=new Persona(111,"Etiopia","0+","Dios Mio",14);
		O2=new Persona(111,"Etiopia","0-","Dios Mio",14);
		A1=new Persona(111,"Etiopia","A+","Dios Mio",14);
		A2=new Persona(111,"Etiopia","A-","Dios Mio",14);
		B1=new Persona(111,"Etiopia","B+","Dios Mio",14);
		B2=new Persona(111,"Etiopia","B-","Dios Mio",14);
		AB1=new Persona(111,"Etiopia","AB+","Dios Mio",14);
		AB2=new Persona(111,"Etiopia","AB-","Dios Mio",14);
		
		assertTrue(O1.puedeDonarleSangre(O1));
		assertFalse(O1.puedeDonarleSangre(O2));
		assertTrue(O1.puedeDonarleSangre(A1));
		assertFalse(O1.puedeDonarleSangre(A2));
		assertTrue(O1.puedeDonarleSangre(B1));
		assertFalse(O1.puedeDonarleSangre(B2));
		assertTrue(O1.puedeDonarleSangre(AB1));
		assertFalse(O1.puedeDonarleSangre(AB2));
		
		assertTrue(O2.puedeDonarleSangre(O1));
		assertTrue(O2.puedeDonarleSangre(O2));
		assertTrue(O2.puedeDonarleSangre(A1));
		assertTrue(O2.puedeDonarleSangre(A2));
		assertTrue(O2.puedeDonarleSangre(B1));
		assertTrue(O2.puedeDonarleSangre(B2));
		assertTrue(O2.puedeDonarleSangre(AB1));
		assertTrue(O2.puedeDonarleSangre(AB2));
		
		assertFalse(A1.puedeDonarleSangre(O1));
		assertFalse(A1.puedeDonarleSangre(O2));
		assertTrue(A1.puedeDonarleSangre(A1));
		assertFalse(A1.puedeDonarleSangre(A2));
		assertFalse(A1.puedeDonarleSangre(B1));
		assertFalse(A1.puedeDonarleSangre(B2));
		assertTrue(A1.puedeDonarleSangre(AB1));
		assertFalse(A1.puedeDonarleSangre(AB2));
		
		assertFalse(A2.puedeDonarleSangre(O1));
		assertFalse(A2.puedeDonarleSangre(O2));
		assertTrue(A2.puedeDonarleSangre(A1));
		assertTrue(A2.puedeDonarleSangre(A2));
		assertFalse(A2.puedeDonarleSangre(B1));
		assertFalse(A2.puedeDonarleSangre(B2));
		assertTrue(A2.puedeDonarleSangre(AB1));
		assertTrue(A2.puedeDonarleSangre(AB2));
			
		assertFalse(B1.puedeDonarleSangre(O1));
		assertFalse(B1.puedeDonarleSangre(O2));
		assertFalse(B1.puedeDonarleSangre(A1));
		assertFalse(B1.puedeDonarleSangre(A2));
		assertTrue(B1.puedeDonarleSangre(B1));
		assertFalse(B1.puedeDonarleSangre(B2));
		assertTrue(B1.puedeDonarleSangre(AB1));
		assertFalse(B1.puedeDonarleSangre(AB2));
		
		assertFalse(B2.puedeDonarleSangre(O1));
		assertFalse(B2.puedeDonarleSangre(O2));
		assertFalse(B2.puedeDonarleSangre(A1));
		assertFalse(B2.puedeDonarleSangre(A2));
		assertTrue(B2.puedeDonarleSangre(B1));
		assertTrue(B2.puedeDonarleSangre(B2));
		assertTrue(B2.puedeDonarleSangre(AB1));
		assertTrue(B2.puedeDonarleSangre(AB2));
		
		assertFalse(AB1.puedeDonarleSangre(O1));
		assertFalse(AB1.puedeDonarleSangre(O2));
		assertFalse(AB1.puedeDonarleSangre(A1));
		assertFalse(AB1.puedeDonarleSangre(A2));
		assertFalse(AB1.puedeDonarleSangre(B1));
		assertFalse(AB1.puedeDonarleSangre(B2));
		assertTrue(AB1.puedeDonarleSangre(AB1));
		assertFalse(AB1.puedeDonarleSangre(AB2));
		
		assertFalse(AB2.puedeDonarleSangre(O1));
		assertFalse(AB2.puedeDonarleSangre(O2));
		assertFalse(AB2.puedeDonarleSangre(A1));
		assertFalse(AB2.puedeDonarleSangre(A2));
		assertFalse(AB2.puedeDonarleSangre(B1));
		assertFalse(AB2.puedeDonarleSangre(B2));
		assertTrue(AB2.puedeDonarleSangre(AB1));
		assertTrue(AB2.puedeDonarleSangre(AB2));
	}

}
