package teste.pilha;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fila.Fila;

public class PilhaTest {
	
	private Fila fila;
	
	@Test
	public void criaPilha() {
		
		this.fila = new Fila(10);
		
		testPush();
		testPeek();
		testPop();
	}

	
	public void testPush() {
		
		try {
			assertTrue(fila.add(4));
			assertTrue(fila.add(3));
			assertTrue(fila.add(1));
			assertTrue(fila.add(6));
			assertTrue(fila.add(5));
			assertTrue(fila.add(8));
			assertTrue(fila.add(2));
			assertTrue(fila.add(9));
			assertTrue(fila.add(0));
			assertTrue(fila.add(7));
		} catch (Exception e) {
			fail(); //Nao deve gerar exception
		}
		
		assertEquals(fila.size(), 10);
		assertTrue(fila.isFull());
		
		try {
			fila.add(10);
		} catch (Exception e) {
			assertEquals("full", e.getMessage());
		}
	}

	
	public void testPop() {
		
		try {
			
			assertEquals(fila.remove(), 4);
			assertEquals(fila.remove(), 3);
			assertEquals(fila.remove(), 1);
			assertEquals(fila.remove(), 6);
			assertEquals(fila.remove(), 5);
			assertEquals(fila.remove(), 8);
			assertEquals(fila.remove(), 2);
			assertEquals(fila.remove(), 9);
			assertEquals(fila.remove(), 0);
			assertEquals(fila.remove(), 7);
			
		} catch (Exception e) {
			fail();
		}
		
		assertTrue(fila.isEmpity());
		assertEquals(fila.size(), 0);
		
		try {
			fila.remove();
		} catch (Exception e) {
			
			assertEquals("empity", e.getMessage());
		}
	}

	
	public void testPeek() {
		
		try {
			assertEquals(fila.element(), 4);
		} catch (Exception e) {
			
			fail();
		}
	}

}
