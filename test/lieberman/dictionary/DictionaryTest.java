package lieberman.dictionary;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {

	@Test
	public void testTrue() throws FileNotFoundException {
		Dictionary dict = new Dictionary();
		// try {
		// dict.readData();
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		String checkWord = " driver";
		Boolean answer = dict.exists(checkWord);

		Assert.assertTrue(answer);

	}

	@Test
	public void testFalse() throws FileNotFoundException {
		Dictionary dict = new Dictionary();
		String checkWord = "ADAAI";
		Boolean answer = dict.exists(checkWord);

		Assert.assertFalse(answer);

	}

}
