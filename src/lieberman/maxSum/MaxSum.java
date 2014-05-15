package lieberman.maxSum;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxSum {

	public static void main(String[] args) throws FileNotFoundException {
		int arraySize = 0;
		int[][] bigRec = new int[arraySize][arraySize];
		Scanner input = new Scanner(System.in);
		// System.out.println("Enter path of file");
		// Scanner inputFile = new Scanner(new File(input.nextLine()));

		while (input.hasNext()) {
			arraySize = input.nextInt(); // first number
			bigRec = new int[arraySize][arraySize];
			for (int i = 0; i < arraySize; i++) {
				for (int j = 0; j < arraySize; j++) {
					bigRec[i][j] = input.nextInt(); // fill array

				}

			}

		}

		int maxSum = 0;

		for (int startRow = 0; startRow < arraySize; startRow++) {
			for (int startColumn = 0; startColumn < arraySize; startColumn++) {
				for (int endRow = startRow; endRow < arraySize; endRow++) {
					for (int endColumn = startColumn; endColumn < arraySize; endColumn++) {

						int sum = 0;
						int x;
						int y;

						for (x = startRow; x <= endRow; x++) {
							for (y = startColumn; y <= endColumn; y++) {
								sum += bigRec[x][y];

							}
						}
						if (sum > maxSum) {
							maxSum = sum;
						}
					}

				}
			}
		}
		System.out.println(maxSum);

	}

}