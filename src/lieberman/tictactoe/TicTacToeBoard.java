package lieberman.tictactoe;

public class TicTacToeBoard {
	private final Symbol[][] board;

	public TicTacToeBoard() {
		board = new Symbol[3][3];
		reset();
	}

	public void reset() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = null;
			}
		}
	}

	public void display() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				char symbol = '_';
				if (board[i][j].equals(Symbol.O)) {
					symbol = 'O';
				}
				if (board[i][j].equals(Symbol.X)) {
					symbol = 'X';
				}
				System.out.print(symbol + " ");
			}
			System.out.println();
		}

	}

	public void setSquare(Location loc, Symbol sym) {
		board[loc.getX()][loc.getY()] = sym;

	}

	public Symbol getSquare(Location loc) {
		Symbol s = board[loc.getX()][loc.getY()];
		return s;
	}

	public boolean isFull() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (board[i][j] != Symbol.X && board[i][j] != Symbol.O) {
					return false;
				}
			}
		}
		return true;
	}

}
