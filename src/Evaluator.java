

import java.util.ArrayList;
import java.util.List;

public class Evaluator {
	private TicTacToeBoard board;
	private Symbol winner;
	private List<Location> winningSquares;

	public Evaluator(TicTacToeBoard board) {
		this.board = board;
	}

	public void evaluate() {

		winningSquares = null;
		winner = null;

		for (int i = 0; i < 3; i++) {
			// check columns
			if (board.getSquare(new Location(0, i)) != null
					&& (board.getSquare(new Location(0, i)).equals(Symbol.X)
							&& board.getSquare(new Location(1, i)) != null
							&& board.getSquare(new Location(1, i)).equals(
									Symbol.X)
							&& board.getSquare(new Location(2, i)) != null && board
							.getSquare(new Location(2, i)).equals(Symbol.X))) {
				winner = Symbol.X;
				winningSquares = new ArrayList<Location>();
				winningSquares.add(new Location(0, i));
				winningSquares.add(new Location(1, i));
				winningSquares.add(new Location(2, i));
				// System.out.println("X wins!");
				return;
			}
			if (board.getSquare(new Location(0, i)) != null
					&& board.getSquare(new Location(0, i)).equals(Symbol.O)
					&& board.getSquare(new Location(1, i)) != null
					&& board.getSquare(new Location(1, i)).equals(Symbol.O)
					&& board.getSquare(new Location(2, i)) != null
					&& board.getSquare(new Location(2, i)).equals(Symbol.O)) {
				winner = Symbol.O;
				winningSquares = new ArrayList<Location>();
				winningSquares.add(new Location(0, i));
				winningSquares.add(new Location(1, i));
				winningSquares.add(new Location(2, i));
				// System.out.println("O wins!");
				return;
			}

			// check rows
			if (board.getSquare(new Location(i, 0)) != null
					&& board.getSquare(new Location(i, 0)).equals(Symbol.X)
					&& board.getSquare(new Location(i, 1)) != null
					&& board.getSquare(new Location(i, 1)).equals(Symbol.X)
					&& board.getSquare(new Location(i, 2)) != null
					&& board.getSquare(new Location(i, 2)).equals(Symbol.X)) {
				winner = Symbol.X;
				winningSquares = new ArrayList<Location>();
				winningSquares.add(new Location(i, 0));
				winningSquares.add(new Location(i, 1));
				winningSquares.add(new Location(i, 2));
				// System.out.println("X wins!");
				return;
			}
			if (board.getSquare(new Location(i, 0)) != null
					&& board.getSquare(new Location(i, 0)).equals(Symbol.O)
					&& board.getSquare(new Location(i, 1)) != null
					&& board.getSquare(new Location(i, 1)).equals(Symbol.O)
					&& board.getSquare(new Location(i, 2)) != null
					&& board.getSquare(new Location(i, 2)).equals(Symbol.O)) {
				winner = Symbol.O;
				winningSquares = new ArrayList<Location>();
				winningSquares.add(new Location(i, 0));
				winningSquares.add(new Location(i, 1));
				winningSquares.add(new Location(i, 2));
				// System.out.println("O wins!");
				return;
			}
		}
		// check diagonals
		if (board.getSquare(new Location(0, 0)) != null
				&& board.getSquare(new Location(0, 0)).equals(Symbol.X)
				&& board.getSquare(new Location(1, 1)) != null
				&& board.getSquare(new Location(1, 1)).equals(Symbol.X)
				&& board.getSquare(new Location(2, 2)) != null
				&& board.getSquare(new Location(2, 2)).equals(Symbol.X)) {
			winner = Symbol.X;
			winningSquares = new ArrayList<Location>();
			winningSquares.add(new Location(0, 0));
			winningSquares.add(new Location(1, 1));
			winningSquares.add(new Location(2, 2));
			// System.out.println("X wins!");
			return;
		}
		if (board.getSquare(new Location(0, 2)) != null
				&& board.getSquare(new Location(0, 2)).equals(Symbol.X)
				&& board.getSquare(new Location(1, 1)) != null
				&& board.getSquare(new Location(1, 1)).equals(Symbol.X)
				&& board.getSquare(new Location(2, 0)) != null
				&& board.getSquare(new Location(2, 0)).equals(Symbol.X)) {
			winner = Symbol.X;
			winningSquares = new ArrayList<Location>();
			winningSquares.add(new Location(0, 2));
			winningSquares.add(new Location(1, 1));
			winningSquares.add(new Location(2, 0));
			// System.out.println("X wins!");
			return;
		}

		if (board.getSquare(new Location(0, 0)) != null
				&& board.getSquare(new Location(0, 0)).equals(Symbol.O)
				&& board.getSquare(new Location(1, 1)) != null
				&& board.getSquare(new Location(1, 1)).equals(Symbol.O)
				&& board.getSquare(new Location(2, 2)) != null
				&& board.getSquare(new Location(2, 2)).equals(Symbol.O)) {
			winner = Symbol.O;
			winningSquares = new ArrayList<Location>();
			winningSquares.add(new Location(0, 0));
			winningSquares.add(new Location(1, 1));
			winningSquares.add(new Location(2, 2));
			// System.out.println("O wins!");
			return;
		}
		if (board.getSquare(new Location(0, 2)) != null
				&& board.getSquare(new Location(0, 2)).equals(Symbol.O)
				&& board.getSquare(new Location(1, 1)) != null
				&& board.getSquare(new Location(1, 1)).equals(Symbol.O)
				&& board.getSquare(new Location(2, 0)) != null
				&& board.getSquare(new Location(2, 0)).equals(Symbol.O)) {
			winner = Symbol.O;
			winningSquares = new ArrayList<Location>();
			winningSquares.add(new Location(0, 2));
			winningSquares.add(new Location(1, 1));
			winningSquares.add(new Location(2, 0));
			// System.out.println("O wins!");
			return;
		}

	}

	public Symbol getWinner() {
		return winner;
	}

	public List<Location> getWinningSquares() {
		return winningSquares;
	}
}
