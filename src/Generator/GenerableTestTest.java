package Generator;
import static org.junit.Assert.*;

import org.junit.Test;

public class GenerableTestTest {

	@Test
	public void testcountNumbers() {
		String[] cadenas = { "hola", "1hola", "hola2", "1hola2", "a 1   hola 2  hola 3 " };
		int resultador[] = { 0, 1, 1, 2, 3 };
		GenerableTest instancia = new GenerableTest();
		for (int i = 0; i < resultador.length; i++) {
			assertEquals(resultador[i], instancia.count(cadenas[i],Type.number));
		}
	}

	@Test
	public void testcountSymbols() {
		String[] cadenas = { "hola", ",hola", "hola,", ",hola.", "a ?   hola !  hola - " };
		int resultador[] = { 0, 1, 1, 2, 3 };
		GenerableTest instancia = new GenerableTest();
		for (int i = 0; i < resultador.length; i++) {
			assertEquals(resultador[i], instancia.count(cadenas[i],Type.symbol));
		}
	}
	@Test
	public void testcountLetters() {
		String[] cadenas = { "hola", ",hola", "hola,", ",hola.", "a ?   hola !  hola - " };
		int resultador[] = { 4, 4, 4, 4, 9 };
		GenerableTest instancia = new GenerableTest();
		for (int i = 0; i < resultador.length; i++) {
			assertEquals(resultador[i], instancia.count(cadenas[i],Type.letter));
		}
	}
}
