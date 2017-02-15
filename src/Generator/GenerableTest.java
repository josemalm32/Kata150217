package Generator;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenerableTest {

	Generable instancia;

	@Test
	public void testGeneratePassword() {
		int letters[] = { 3, 4, 5, 3, 2, 5, 4, 9, 4, 6 };
		int symbols[] = { 7, 6, 3, 9, 7, 6, 4, 7, 6, 3 };
		int numbers[] = { 6, 9, 2, 3, 1, 4, 5, 6, 7, 8 };
		for (int i = 0; i < numbers.length; i++) {
			String password = instancia.generatePassword(letters[i], symbols[i], numbers[i]);
			assertEquals(letters[i], count(password, Type.letter));
			assertEquals(symbols[i], count(password, Type.symbol));
			assertEquals(numbers[i], count(password, Type.number));
		}
	}

	protected int count(String password, Type type) {
		int contador = 0;
		for (int i = 0; i < password.length(); i++) {
			switch (type) {
			case number:
				if (Character.isDigit(password.charAt(i)))
					contador++;
				break;
			case symbol:
				if (!Character.isAlphabetic(password.charAt(i)) && !Character.isDigit(password.charAt(i))
						&& !Character.isWhitespace(password.charAt(i)))
					contador++;
				break;
			case letter:
				if (Character.isAlphabetic(password.charAt(i))) {
					contador++;
				}
				break;

			}
		}
		return contador;
	}
}
