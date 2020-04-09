package lab3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FraccionTest {

	Fraccion f0, f1, f2, f3, f4, f5, f6, f7, f8, f9;
	@Before
	public void setUp() throws Exception {
		//Fraccion(int pNumerador, int pDenominador)
		f0=new Fraccion(0,1);
		f1=new Fraccion(10,35);
		f2=new Fraccion (3,6);
		f3=new Fraccion (4,16);
		f4=new Fraccion (5,35);
		f5=new Fraccion (-4,24);
		f6=new Fraccion (6,-12);
		f7=new Fraccion (2,8);
		f8=new Fraccion (14,18);
		f9=new Fraccion (10,70);
	}

	@After
	public void tearDown() throws Exception {
		f0=null;
		f1=null;
		f2=null;
		f3=null;	
		f4=null;
		f5=null;
		f6=null;
		f7=null;
		f8=null;
	}

	@Test
	public void testFraccion() {
		assertNotNull(f0);
		assertNotNull(f1);
		assertNotNull(f2);
		assertNotNull(f3);
		assertNotNull(f4);
		assertNotNull(f5);
		assertNotNull(f6);
		assertNotNull(f7);
		assertNotNull(f8);
	}

	@Test
	public void testGetNumerador() {
		assertEquals(f1.getNumerador(),10);
		assertEquals(f2.getNumerador(),3);
		assertEquals(f3.getNumerador(),4);
		assertEquals(f4.getNumerador(),5);
		assertEquals(f5.getNumerador(),-4);
		assertEquals(f6.getNumerador(),6);
		assertEquals(f7.getNumerador(),2);
		assertEquals(f8.getNumerador(),14);
	}

	@Test
	public void testGetDenominador() {
		assertEquals(f1.getDenominador(),35);
		assertEquals(f2.getDenominador(),6);
		assertEquals(f3.getDenominador(),16);
		assertEquals(f4.getDenominador(),35);
		assertEquals(f5.getDenominador(),24);
		assertEquals(f6.getDenominador(),-12);
		assertEquals(f7.getDenominador(),8);
		assertEquals(f8.getDenominador(),18);
		
	}

	@Test
	public void testSimplificar() {
		Fraccion r1;
		r1=new Fraccion(2,7);
		
		f1.simplificar();
		assertEquals(f1.getNumerador(),r1.getNumerador());
		assertEquals(f1.getDenominador(),r1.getDenominador());
	}

	@Test
	public void testSumar() {
		Fraccion r1;
		
		r1=new Fraccion(11,14);
		assertEquals(f1.sumar(f2).getDenominador(),r1.getDenominador());
		assertEquals(f1.sumar(f2).getNumerador(),r1.getNumerador());
	}

	@Test
	public void testRestar() {
		Fraccion r1;
		
		r1=new Fraccion(-3,14);
		assertEquals(f1.restar(f2).getDenominador(),r1.getDenominador());
		assertEquals(f1.restar(f2).getNumerador(),r1.getNumerador());
	}

	@Test
	public void testMultiplicar() {
		Fraccion r1;
		
		r1=new Fraccion(1,7);
		assertEquals(f1.multiplicar(f2).getDenominador(),r1.getDenominador());
		assertEquals(f1.multiplicar(f2).getNumerador(),r1.getNumerador());
	}

	@Test
	public void testDividir() {
		Fraccion r1;
		
		r1=new Fraccion(4,7);
		assertEquals(f1.dividir(f2).getDenominador(),r1.getDenominador());
		assertEquals(f1.dividir(f2).getNumerador(),r1.getNumerador());
	}

	@Test
	public void testEsIgualQue() {
		assertFalse(f1.esIgualQue(f2));
		assertTrue(f3.esIgualQue(f7));
		assertTrue(f4.esIgualQue(f9));
	}

	@Test
	public void testEsMayorQue() {
		assertFalse(f1.esMayorQue(f3));
		assertTrue(f8.esMayorQue(f7));
		assertTrue(f2.esMayorQue(f3));
	}

	@Test
	public void testEsMenorQue() {
		assertFalse(f3.esMenorQue(f1));
	}
}