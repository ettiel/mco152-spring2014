package lieberman.morseCode;

import java.util.HashMap;
import java.util.StringTokenizer;

public class MorseCode {

	private final HashMap<Character, String> charToCode;
	private final HashMap<String, Character> codeToChar;

	public MorseCode() {
		charToCode = new HashMap<Character, String>();
		codeToChar = new HashMap<String, Character>();
		add("A", ".- ");
		add("B", "-... ");
		add("C", "-.-. ");
		add("D", "-.. ");
		add("E", ". ");
		add("F", "..-. ");
		add("G", "--. ");
		add("H", ".... ");
		add("I", ".. ");
		add("J", ".--- ");
		add("K", "-.- ");
		add("L", ".-.. ");
		add("M", "-- ");
		add("N", "-. ");
		add("O", "--- ");
		add("P", ".--. ");
		add("Q", "--.- ");
		add("R", ".-. ");
		add("S", "... ");
		add("T", "- ");
		add("U", "..- ");
		add("V", "...- ");
		add("W", ".-- ");
		add("X", "-..- ");
		add("Y", "-.-- ");
		add("Z", "--.. ");
		add("0", "----- ");
		add("1", ".---- ");
		add("2", "..--- ");
		add("3", "...-- ");
		add("4", "....- ");
		add("5", "..... ");
		add("6", "-.... ");
		add("7", "--... ");
		add("8", "---.. ");
		add("9", "----. ");
		add(" ", "/ ");
	}

	public void add(String s1, String s2) {
		charToCode.put(s1.charAt(0), s2);
		codeToChar.put(s2, s1.charAt(0));

	}

	public String toMorseCode(String text) {
		StringBuilder morse = new StringBuilder();
		add(text, morse.toString());
		for (int i = 0; i < text.length(); i++) {
			String upper = text.toUpperCase();
			if (upper.charAt(i) == ' ') {
			} else {
				morse.append(charToCode.get(upper.charAt(i)).toString());
			}

		}
		return morse.toString().trim();
	}

	public String toPlainText(String code) {
		StringBuilder plainText = new StringBuilder();
		StringTokenizer tokenizer = new StringTokenizer(code, " ");
		add(code, plainText.toString());
		while (tokenizer.hasMoreTokens()) {
			String theCode = tokenizer.nextToken();
			plainText.append(codeToChar.get(theCode + " "));
		}

		return plainText.toString();
	}
}
