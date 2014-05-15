package lieberman.morseCode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testAlphabetToMorseCode() {

		MorseCode morseCode = new MorseCode();
		// String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String code = morseCode.toMorseCode(alphabet);
		String expected = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";

		Assert.assertEquals(expected, code);

	}

	@Test
	public void testMorseCodeToAlphabet() {

		MorseCode morseCode = new MorseCode();
		String code = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
		String text = morseCode.toPlainText(code);
		String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Assert.assertEquals(expected, text);

	}

	@Test
	public void testNumbersToMorseCode() {

		MorseCode morseCode = new MorseCode();
		String numbers = "0123456789";
		String code = morseCode.toMorseCode(numbers);
		String expected = "----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.";

		Assert.assertEquals(expected, code);

	}

	@Test
	public void testMorseCodeToNumbers() {

		MorseCode morseCode = new MorseCode();
		String code = "----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.";
		String text = morseCode.toPlainText(code);
		String expected = "0123456789";
		Assert.assertEquals(expected, text);

	}

}
