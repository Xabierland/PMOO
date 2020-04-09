import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControlJuegoTest {

	ControlJuego cj1;
	ListaJugadores l1;
	Persona p1,p2;
	IA i1;
	@Before
	public void setUp() throws Exception 
	{
		cj1=new ControlJuego();
		l1=new ListaJugadores();
		p1=new Persona("Xabier");
		p2=new Persona("Javi");
		l1.anadirJugador(p1);
		l1.anadirJugador(p2);
	}

	@After
	public void tearDown() throws Exception 
	{
		cj1=null;
		l1.reset();
		p1=null;
		p2=null;
	}

	@Test
	public void testControlJuego() 
	{
		assertNotNull(cj1);
	}

	@Test
	public void testGetNumParticipantes() 
	{
		cj1.agregarParticipante(p1);
		cj1.agregarParticipante(p2);
		assertEquals(cj1.getNumParticipantes(),2);
	}

	@Test
	public void testJugarIndividual() 
	{
		cj1.agregarParticipante(p1);
		cj1.jugarIndividual();
	}

	@Test
	public void testJugarDosPersonas() 
	{
		cj1.agregarParticipante(p1);
		cj1.agregarParticipante(p2);
		cj1.jugarDosPersonas();
	}

	@Test
	public void testAgregarParticipante() 
	{
		//Queda demostrado con el resto de metodos
	}

}
