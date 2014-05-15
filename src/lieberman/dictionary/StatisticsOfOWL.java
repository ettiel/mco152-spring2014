package lieberman.dictionary;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class StatisticsOfOWL {
	private static Dictionary d;
	private static char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z' };
	private int[] occurances;
	private double[] percent;

	public StatisticsOfOWL() throws FileNotFoundException {
		d = new Dictionary();

		// try {
		// d.readData();
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }

		percent = d.getPercents();
		occurances = d.getTimes();

	}

	public static void main(String[] args) throws FileNotFoundException {
		StatisticsOfOWL stat = new StatisticsOfOWL();
		DecimalFormat dec = new DecimalFormat("  .00%");

		for (int i = 0; i < stat.occurances.length; i++) {
			System.out.println(letters[i] + " " + stat.occurances[i] + " "
					+ dec.format(stat.percent[i]));
		}

	}

}
