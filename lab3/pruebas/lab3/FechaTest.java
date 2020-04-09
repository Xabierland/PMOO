package lab3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FechaTest {
	
	Fecha f0,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29,f30,f31,f32,f33,f34,f35,f36,f37,f38,f39,f40,f41,f42,f43,f44,f45,f46,f47,f48;
	@Before
	public void setUp() throws Exception {
		//int pDia, int pMes, int pAnnio
		//Para aumentar
		f0 = new Fecha(32,12,1999);
		
		f1 = new Fecha(31,12,1999); 
		f2 = new Fecha(29,2,2000);
		f3 = new Fecha(28,2,1999);
		
		f4 = new Fecha(30,1,2001);
		f5 = new Fecha(31,1,2001);
		f6 = new Fecha(30,3,2001);
		f7 = new Fecha(31,3,2001);
		f8 = new Fecha(29,4,2001);
		f9 = new Fecha(30,4,2001);
		f10 = new Fecha(30,5,2001);
		f11 = new Fecha(31,5,2001);
		f12 = new Fecha(29,6,2001);
		f13 = new Fecha(30,6,2001);
		f14 = new Fecha(30,7,2001);
		f15 = new Fecha(31,7,2001);
		f16 = new Fecha(30,8,2001);
		f17 = new Fecha(31,8,2001);
		f18 = new Fecha(29,9,2001);
		f19 = new Fecha(30,9,2001);
		f20 = new Fecha(30,10,2001);
		f21 = new Fecha(31,10,2001);
		f22 = new Fecha(29,11,2001);
		f23 = new Fecha(30,11,2001);
		f24 = new Fecha(30,12,2001);
		
		//Para decrementar
		f25 = new Fecha(1,1,2001);
		f26 = new Fecha(1,3,2001);
		f27 = new Fecha(1,3,2000);
		
		f28 = new Fecha(2,1,2001);
		f29 = new Fecha(1,2,2001);
		f30 = new Fecha(2,2,2001);
		f31 = new Fecha(1,4,2001);
		f32 = new Fecha(2,4,2001);
		f33 = new Fecha(1,5,2001);
		f34 = new Fecha(2,5,2001);
		f35 = new Fecha(1,6,2001);
		f36 = new Fecha(2,6,2001);
		f37 = new Fecha(1,7,2001);
		f38 = new Fecha(2,7,2001);
		f39 = new Fecha(1,8,2001);
		f40 = new Fecha(2,8,2001);
		f41 = new Fecha(1,9,2001);
		f42 = new Fecha(2,9,2001);
		f43 = new Fecha(1,10,2001);
		f44 = new Fecha(2,10,2001);
		f45 = new Fecha(1,11,2001);
		f46 = new Fecha(2,11,2001);
		f47 = new Fecha(1,12,2001);
		f48 = new Fecha(2,12,2001);
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
		f9=null;
		f10=null;
		f11=null;
		f12=null;
		f13=null;
		f14=null;
		f15=null;
		f16=null;
		f17=null;
		f18=null;
		f19=null;
		f20=null;
		f21=null;
		f22=null;
		f23=null;
		f24=null;
		f25=null;
		f26=null;
		f27=null;
		f28=null;
		f29=null;
		f30=null;
		f31=null;
		f32=null;
		f33=null;
		f34=null;
		f35=null;
		f36=null;
		f37=null;
		f38=null;
		f39=null;
		f40=null;
		f41=null;
		f42=null;
		f43=null;
		f44=null;
		f45=null;
		f46=null;
		f47=null;
		f48=null;
	}

	@Test
	public void testFecha() {
		assertNotNull(f0);
		assertNotNull(f1);
		assertNotNull(f2);
		assertNotNull(f3);
		assertNotNull(f4);
		assertNotNull(f5);
		assertNotNull(f6);
		assertNotNull(f7);
		assertNotNull(f8);
		assertNotNull(f9);
		assertNotNull(f10);
		assertNotNull(f11);
		assertNotNull(f12);
		assertNotNull(f13);
		assertNotNull(f14);
		assertNotNull(f15);
		assertNotNull(f16);
		assertNotNull(f17);
		assertNotNull(f18);
		assertNotNull(f19);
		assertNotNull(f20);
		assertNotNull(f21);
		assertNotNull(f22);
		assertNotNull(f23);
		assertNotNull(f24);
		assertNotNull(f25);
		assertNotNull(f26);
		assertNotNull(f27);
		assertNotNull(f28);
		assertNotNull(f29);
		assertNotNull(f30);
		assertNotNull(f31);
		assertNotNull(f32);
		assertNotNull(f33);
		assertNotNull(f34);
		assertNotNull(f35);
		assertNotNull(f36);
		assertNotNull(f37);
		assertNotNull(f38);
		assertNotNull(f39);
		assertNotNull(f40);
		assertNotNull(f41);
		assertNotNull(f42);
		assertNotNull(f43);
		assertNotNull(f44);
		assertNotNull(f45);
		assertNotNull(f46);
		assertNotNull(f47);
		assertNotNull(f48);
		
	}

	@Test
	public void testToString() {
		assertEquals(f1.toString(),"31/12/1999");
		assertEquals(f2.toString(),"29/01/2001");
		assertEquals(f3.toString(),"31/12/1999");
		assertEquals(f4.toString(),"31/12/1999");
		assertEquals(f5.toString(),"31/12/1999");
		assertEquals(f6.toString(),"31/12/1999");
		assertEquals(f7.toString(),"31/12/1999");
		assertEquals(f8.toString(),"31/12/1999");
		assertEquals(f9.toString(),"31/12/1999");
		assertEquals(f10.toString(),"31/12/1999");
		assertEquals(f11.toString(),"31/12/1999");
		assertEquals(f12.toString(),"31/12/1999");
		assertEquals(f13.toString(),"31/12/1999");
		assertEquals(f14.toString(),"31/12/1999");
		assertEquals(f15.toString(),"31/12/1999");
		assertEquals(f16.toString(),"31/12/1999");
		assertEquals(f17.toString(),"31/12/1999");
		assertEquals(f18.toString(),"31/12/1999");
		assertEquals(f19.toString(),"31/12/1999");
		assertEquals(f20.toString(),"31/12/1999");
		assertEquals(f21.toString(),"31/12/1999");
		assertEquals(f22.toString(),"31/12/1999");
		assertEquals(f23.toString(),"31/12/1999");
		assertEquals(f24.toString(),"31/12/1999");
		assertEquals(f25.toString(),"31/12/1999");
		assertEquals(f26.toString(),"31/12/1999");
		assertEquals(f27.toString(),"31/12/1999");
		assertEquals(f28.toString(),"31/12/1999");
		assertEquals(f29.toString(),"31/12/1999");
		assertEquals(f30.toString(),"31/12/1999");
		assertEquals(f31.toString(),"31/12/1999");
		assertEquals(f32.toString(),"31/12/1999");
		assertEquals(f33.toString(),"31/12/1999");
		assertEquals(f34.toString(),"31/12/1999");
		assertEquals(f35.toString(),"31/12/1999");
		assertEquals(f36.toString(),"31/12/1999");
		assertEquals(f37.toString(),"31/12/1999");
		assertEquals(f38.toString(),"31/12/1999");
		assertEquals(f39.toString(),"31/12/1999");
		assertEquals(f40.toString(),"31/12/1999");
		assertEquals(f41.toString(),"31/12/1999");
		assertEquals(f42.toString(),"31/12/1999");
		assertEquals(f43.toString(),"31/12/1999");
		assertEquals(f44.toString(),"31/12/1999");
		assertEquals(f45.toString(),"31/12/1999");
		assertEquals(f46.toString(),"31/12/1999");
		assertEquals(f47.toString(),"31/12/1999");
		assertEquals(f48.toString(),"31/12/1999");
		
	}

	@Test
	public void testincrementar() {
		f1.incrementar();
		assertEquals("01/01/2000",f1.toString()); //cambiar año
		
		f2.incrementar();
		assertEquals("01/03/2000",f2.toString()); //febrero bisiesti
		
		f3.incrementar();
		assertEquals("01/03/1999",f3.toString()); //febrero normal
		
		f4.incrementar();
		assertEquals("31/01/2001",f4.toString()); 
		
		f5.incrementar();
		assertEquals("01/02/2001",f5.toString()); 
		
		f6.incrementar();
		assertEquals("31/03/2001",f6.toString());  
		
		f7.incrementar();
		assertEquals("01/04/2001",f7.toString()); 
		
		f8.incrementar();
		assertEquals("30/04/2001",f8.toString()); 
		
		f9.incrementar();
		assertEquals("01/05/2001",f9.toString()); 
		
		f10.incrementar();
		assertEquals("31/05/2001",f10.toString()); 
		
		f11.incrementar();
		assertEquals("01/06/2001",f11.toString()); 
		
		f12.incrementar();
		assertEquals("30/06/2001",f12.toString()); 
		
		f13.incrementar();
		assertEquals("01/07/2001",f13.toString()); 
		
		f14.incrementar();
		assertEquals("31/07/2001",f14.toString()); 
		
		f15.incrementar();
		assertEquals("01/08/2001",f15.toString()); 
		
		f16.incrementar();
		assertEquals("31/08/2001",f16.toString()); 
		
		f17.incrementar();
		assertEquals("01/09/2001",f17.toString()); 
		
		f18.incrementar();
		assertEquals("30/09/2001",f18.toString()); 

		f19.incrementar();
		assertEquals("01/10/2001",f19.toString()); 
		
		f20.incrementar();
		assertEquals("31/10/2001",f20.toString()); 
		
		f21.incrementar();
		assertEquals("01/11/2001",f21.toString()); 
		
		f22.incrementar();
		assertEquals("30/11/2001",f22.toString()); 
		
		f23.incrementar();
		assertEquals("01/12/2001",f23.toString()); 
		
		f24.incrementar();
		assertEquals("31/12/2001",f24.toString()); 
		
	}

	@Test
	public void testdecrementar() {
		f25.decrementar();
		assertEquals("31/12/2000",f25.toString());
		
		f26.decrementar();
		assertEquals("28/02/2001",f26.toString());
		
		f27.decrementar();
		assertEquals("29/02/2000",f27.toString());

		/////////////////////////////////////////
		
		f28.decrementar();
		assertEquals("01/01/2001",f28.toString());

		f29.decrementar();
		assertEquals("31/01/2001",f29.toString());

		f30.decrementar();
		assertEquals("01/02/2001",f30.toString());

		f31.decrementar();
		assertEquals("31/03/2001",f31.toString());

		f32.decrementar();
		assertEquals("01/04/2001",f32.toString());

		f33.decrementar();
		assertEquals("30/04/2001",f33.toString());

		f34.decrementar();
		assertEquals("01/05/2001",f34.toString());

		f35.decrementar();
		assertEquals("31/05/2001",f35.toString());

		f36.decrementar();
		assertEquals("01/06/2001",f36.toString());

		f37.decrementar();
		assertEquals("30/06/2001",f37.toString());

		f38.decrementar();
		assertEquals("01/07/2001",f38.toString());

		f39.decrementar();
		assertEquals("31/07/2001",f39.toString());

		f40.decrementar();
		assertEquals("01/08/2001",f40.toString());

		f41.decrementar();
		assertEquals("31/08/2001",f41.toString());

		f42.decrementar();
		assertEquals("01/09/2001",f42.toString());

		f43.decrementar();
		assertEquals("30/09/2001",f43.toString());

		f44.decrementar();
		assertEquals("01/10/2001",f44.toString());

		f45.decrementar();
		assertEquals("31/10/2001",f45.toString());

		f46.decrementar();
		assertEquals("01/11/2001",f46.toString());

		f47.decrementar();
		assertEquals("30/11/2001",f47.toString());

		f48.decrementar();
		assertEquals("01/12/2001",f48.toString());
		
	}

}