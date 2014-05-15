package lieberman.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

	private final Map<String, String> words;

	public Dictionary() throws FileNotFoundException {
		words = new HashMap<>();
		String word;
		String line = "";
		int countWords = 0;

		Scanner inputFile = new Scanner(new File("OWL.txt"));

		while (inputFile.hasNext()) {
			words.put(inputFile.next(), inputFile.nextLine());
			line = inputFile.nextLine();

			// get first token - should be the word
			// StringTokenizer tok = new StringTokenizer(line);
			// word = tok.nextToken();
			// words.put(word);
			countWords++;

			// while (tok.hasMoreTokens()) {
			// word = tok.nextToken();
			//
			// }

		}

	}

	public Iterator<String> iterator() {
		return words.keySet().iterator();
	}

	public Boolean exists(String word) {

		return words.containsKey(word.trim().toUpperCase());
	}

	public String getDefinition(String word) {
		return words.get(word);
	}

	public double[] getPercents() { // counts for each letter how many words
									// have it at least once then divides
		// each by the number of words to get percent
		int[] times = new int[26];
		double[] percent = new double[26];
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).contains("A")) {
				times[0]++;
			}
			if (words.get(i).contains("B")) {
				times[1]++;
			}
			if (words.get(i).contains("C")) {
				times[2]++;
			}
			if (words.get(i).contains("D")) {
				times[3]++;
			}
			if (words.get(i).contains("E")) {
				times[4]++;
			}
			if (words.get(i).contains("F")) {
				times[5]++;
			}
			if (words.get(i).contains("G")) {
				times[6]++;
			}
			if (words.get(i).contains("H")) {

				times[7]++;
			}
			if (words.get(i).contains("I")) {
				times[8]++;
			}
			if (words.get(i).contains("J")) {
				times[9]++;
			}
			if (words.get(i).contains("K")) {
				times[10]++;
			}
			if (words.get(i).contains("L")) {
				times[11]++;
			}
			if (words.get(i).contains("M")) {
				times[12]++;
			}
			if (words.get(i).contains("N")) {
				times[13]++;
			}
			if (words.get(i).contains("O")) {
				times[14]++;
			}
			if (words.get(i).contains("P")) {
				times[15]++;
			}
			if (words.get(i).contains("Q")) {
				times[16]++;
			}
			if (words.get(i).contains("R")) {
				times[17]++;
			}
			if (words.get(i).contains("S")) {
				times[18]++;
			}
			if (words.get(i).contains("T")) {
				times[19]++;
			}
			if (words.get(i).contains("U")) {
				times[20]++;
			}
			if (words.get(i).contains("V")) {
				times[21]++;
			}
			if (words.get(i).contains("W")) {
				times[22]++;
			}
			if (words.get(i).contains("X")) {
				times[23]++;
			}
			if (words.get(i).contains("Y")) {
				times[24]++;
			}
			if (words.get(i).contains("Z")) {
				times[25]++;
			}

		}
		for (int j = 0; j < 26; j++) {
			percent[j] = times[j] / (double) words.size();
		}
		return percent;
	}

	public int[] getTimes() {
		int[] times = new int[26];
		for (int i = 0; i < words.size(); i++) {
			for (int j = 0; j < words.get(i).length(); j++) {
				if (words.get(i).charAt(j) == 'A') {
					times[0]++;
				} else if (words.get(i).charAt(j) == 'B') {
					times[1]++;
				} else if (words.get(i).charAt(j) == 'C') {
					times[2]++;
				} else if (words.get(i).charAt(j) == 'D') {
					times[3]++;
				} else if (words.get(i).charAt(j) == 'E') {
					times[4]++;
				} else if (words.get(i).charAt(j) == 'F') {
					times[5]++;
				} else if (words.get(i).charAt(j) == 'G') {
					times[6]++;
				} else if (words.get(i).charAt(j) == 'H') {
					times[7]++;
				} else if (words.get(i).charAt(j) == 'I') {
					times[8]++;
				} else if (words.get(i).charAt(j) == 'B') {
					times[1]++;
				} else if (words.get(i).charAt(j) == 'C') {
					times[2]++;
				} else if (words.get(i).charAt(j) == 'D') {
					times[3]++;
				} else if (words.get(i).charAt(j) == 'E') {
					times[4]++;
				} else if (words.get(i).charAt(j) == 'F') {
					times[5]++;
				} else if (words.get(i).charAt(j) == 'G') {
					times[6]++;
				} else if (words.get(i).charAt(j) == 'H') {
					times[7]++;
				} else if (words.get(i).charAt(j) == 'I') {
					times[8]++;
				} else if (words.get(i).charAt(j) == 'D') {
					times[3]++;
				} else if (words.get(i).charAt(j) == 'E') {
					times[4]++;
				} else if (words.get(i).charAt(j) == 'F') {
					times[5]++;
				} else if (words.get(i).charAt(j) == 'G') {
					times[6]++;
				} else if (words.get(i).charAt(j) == 'H') {
					times[7]++;
				} else if (words.get(i).charAt(j) == 'I') {
					times[8]++;
				} else if (words.get(i).charAt(j) == 'J') {
					times[9]++;
				} else if (words.get(i).charAt(j) == 'K') {
					times[10]++;
				} else if (words.get(i).charAt(j) == 'L') {
					times[11]++;
				} else if (words.get(i).charAt(j) == 'M') {
					times[12]++;
				} else if (words.get(i).charAt(j) == 'N') {
					times[13]++;
				} else if (words.get(i).charAt(j) == 'O') {
					times[14]++;
				} else if (words.get(i).charAt(j) == 'P') {
					times[15]++;
				} else if (words.get(i).charAt(j) == 'Q') {
					times[16]++;
				} else if (words.get(i).charAt(j) == 'R') {
					times[17]++;
				} else if (words.get(i).charAt(j) == 'S') {
					times[18]++;
				} else if (words.get(i).charAt(j) == 'T') {
					times[19]++;
				} else if (words.get(i).charAt(j) == 'U') {
					times[20]++;
				} else if (words.get(i).charAt(j) == 'V') {
					times[21]++;
				} else if (words.get(i).charAt(j) == 'W') {
					times[22]++;
				} else if (words.get(i).charAt(j) == 'X') {
					times[23]++;
				} else if (words.get(i).charAt(j) == 'Y') {
					times[24]++;
				} else {
					times[25]++;
				}

			}
		}

		return times;
	}

}
