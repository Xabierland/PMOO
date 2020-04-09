
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TableroTest {
	Casilla u1;
	Jugador p1,p2;

	@Before
	public void setUp() throws Exception {
		p1=new Jugador("Jose");
		p2=new Jugador("Maria");
		u1=new Casilla(/*false,p1,'0'*/);
	}

	@After
	public void tearDown() throws Exception {
		p1=null;
		p2=null;
		u1=null;
		Tablero.getTablero().resetear();
		
	}

	@Test
	public void testGetTablero() {
		assertNotNull(Tablero.getTablero());
		}

	//@Test
	/*public void testOcupado() {
		assertFalse(Tablero.getTablero().ocupado());
	}*/
	@Test
	public void testImprimir(){
		Tablero.getTablero().imprimirTablero();
	}
	

	@Test
	public void testOcuparCasilla() {
		Tablero.getTablero().ocuparCasilla(p1, 2);
		Tablero.getTablero().ocuparCasilla(p1, 2);
		Tablero.getTablero().ocuparCasilla(p1, 2);
		assertFalse(Tablero.getTablero().hayGanador());
		Tablero.getTablero().ocuparCasilla(p1, 2);
		assertTrue(Tablero.getTablero().hayGanador());
	}

	@Test
	public void testHayGanador() {
		assertFalse(Tablero.getTablero().hayGanador());
		Tablero.getTablero().ocuparCasilla(p1, 4);
		Tablero.getTablero().ocuparCasilla(p1, 4);
		Tablero.getTablero().ocuparCasilla(p1, 4);
		Tablero.getTablero().ocuparCasilla(p1, 4);
		assertTrue(Tablero.getTablero().hayGanador());
		Tablero.getTablero().resetear();
	}

	@Test
	public void testBuscarGanadorHorizontal() {
		assertFalse(Tablero.getTablero().buscarGanadorHorizontal());
		Tablero.getTablero().ocuparCasilla(p1, 4);
		assertFalse(Tablero.getTablero().buscarGanadorHorizontal());
		Tablero.getTablero().ocuparCasilla(p1, 5);
		assertFalse(Tablero.getTablero().buscarGanadorHorizontal());
		Tablero.getTablero().ocuparCasilla(p1, 6);
		assertFalse(Tablero.getTablero().buscarGanadorHorizontal());
		Tablero.getTablero().ocuparCasilla(p1, 7);
		assertTrue(Tablero.getTablero().buscarGanadorHorizontal());
		Tablero.getTablero().resetear();

	}

	@Test
	public void testBuscarGanadorVertical() {
		assertFalse(Tablero.getTablero().buscarGanadorVertical());
		Tablero.getTablero().ocuparCasilla(p1, 4);
		assertFalse(Tablero.getTablero().buscarGanadorVertical());
		Tablero.getTablero().ocuparCasilla(p1, 4);
		assertFalse(Tablero.getTablero().buscarGanadorVertical());
		Tablero.getTablero().ocuparCasilla(p1, 4);
		assertFalse(Tablero.getTablero().buscarGanadorVertical());
		Tablero.getTablero().ocuparCasilla(p1, 4);
		assertTrue(Tablero.getTablero().buscarGanadorVertical());
		Tablero.getTablero().resetear();

	}

	@Test
	public void testBuscarGanadorDiagonal() {
		assertFalse(Tablero.getTablero().buscarGanadorDiagonal());
		Tablero.getTablero().ocuparCasilla(p1, 4);
		assertFalse(Tablero.getTablero().buscarGanadorDiagonal());
		Tablero.getTablero().ocuparCasilla(p1, 5);
		Tablero.getTablero().ocuparCasilla(p1, 5);
		assertFalse(Tablero.getTablero().buscarGanadorDiagonal());
		Tablero.getTablero().ocuparCasilla(p1, 6);
		Tablero.getTablero().ocuparCasilla(p1, 6);
		Tablero.getTablero().ocuparCasilla(p1, 6);
		assertFalse(Tablero.getTablero().buscarGanadorDiagonal());
		Tablero.getTablero().ocuparCasilla(p1, 7);
		Tablero.getTablero().ocuparCasilla(p1, 7);
		Tablero.getTablero().ocuparCasilla(p1, 7);
		Tablero.getTablero().ocuparCasilla(p1, 7);
		assertTrue(Tablero.getTablero().buscarGanadorDiagonal());
		Tablero.getTablero().resetear();

	}

	@Test
	public void testResetear() {
		Tablero.getTablero().resetear();
	}

}
