package src;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SistemaCompeticoesTest {

	SistemaCompeticoes sistemasCompeticoes;
	
	@Before
	public void init() {
		sistemasCompeticoes = new SistemaCompeticoes(10, 3, Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 5.0, 4.0, 3.0, 2.0, 1.0));
	}
	
	@Test
	public void testClassified() {
		assertEquals(4, sistemasCompeticoes.classified());
	}
	
	@Test
	public void testArithmeticAverage() {
		assertEquals(1.5, sistemasCompeticoes.arithmeticAverage(sistemasCompeticoes.getVencedores()), 0.01);
	}
	
	@Test
	public void testStandardDeviation() {
		assertEquals(0.50, sistemasCompeticoes.standardDeviation(sistemasCompeticoes.getVencedores()), 0.01);
	}
	
	@Test
	public void testArithmeticAverageAll() {
		assertEquals(3.0, sistemasCompeticoes.arithmeticAverage(), 0.01);
	}
	
	@Test
	public void testStandardDeviationAll() {
		assertEquals(1.41, sistemasCompeticoes.standardDeviation(), 0.01);
	}
}
