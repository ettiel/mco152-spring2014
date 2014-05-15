package lieberman.triangle;

public class Triangle {

	private int height;
	private int width;

	// private String[][] grid;

	public Triangle(int height) {
		this.height = height;

		// for (int row = 0; row < height; row++){
		// for (int col = 0; col < width; col++){
		// grid[row][col] = " ";
		// }
		// }
		//
		// // bottom row
		// int h = height - 1;
		// for (int w = 0; w < width - 1; w++) {
		// grid[h][w] = "*";
		// }
		//
		// // right diagonal
		// int j = 0;
		// for (int i = height - 1; i > 0; i--) {
		// grid[i][j] = "*";
		// j++;
		//
		// }
		// // left diagonal
		// int k = width - 1;
		// for (int l = height - 1; l >= 0; l--) {
		// grid[l][k] = "*";
		// k--;
		// }

	}

	public String toString() {
		StringBuilder tri = new StringBuilder();
		int counter = 1;
		int numOfSpaces = 1;
		width = (height * 2) - 1;
		// grid = new String[height][width];

		// loop and print first line ???
		for (int i = 0; i < height - 1; i++) {
			tri.append(" ");
		}
		tri.append("*\n");
		counter++;

		// body
		while (counter != height) {
			for (int j = 0; j < height - counter; j++) {
				tri.append(" ");
			}
			tri.append("*");
			for (int k = 0; k < numOfSpaces; k++) {
				tri.append(" ");
			}
			tri.append("*\n");
			counter++;
			numOfSpaces += 2;
		}

		// bottom
		for (int l = 0; l < width; l++) {
			tri.append("*");
		}

		String triangle = tri.toString();
		return triangle;

		// String triangle = "";
		// for (int row = 0; row < height; row++) {
		// triangle += "\n";
		// for (int col = 0; col < width; col++) {
		// triangle += grid[row][col];
		// }
		// }
		//
		// return triangle;

	}

	public static void main(String args[]) {
		System.out.println(new Triangle(5));
	}

}
