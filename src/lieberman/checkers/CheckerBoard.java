package lieberman.checkers;

import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard() {
		this.board = new Piece[HEIGHT][WIDTH];
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y) {
		if (x < 8 && x >= 0 && y < 8 && y >= 0) {
			return true;
		}
		return false;

	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y) {
		if (getPiece(x, y) == null) {
			return true;
		}
		return false;
	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				setPiece(i, j, null);
			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame() {
		setPiece(0, 1, Piece.WHITE_MAN);
		setPiece(0, 3, Piece.WHITE_MAN);
		setPiece(0, 5, Piece.WHITE_MAN);
		setPiece(0, 7, Piece.WHITE_MAN);
		setPiece(1, 0, Piece.WHITE_MAN);
		setPiece(1, 2, Piece.WHITE_MAN);
		setPiece(1, 4, Piece.WHITE_MAN);
		setPiece(1, 6, Piece.WHITE_MAN);
		setPiece(2, 1, Piece.WHITE_MAN);
		setPiece(2, 3, Piece.WHITE_MAN);
		setPiece(2, 5, Piece.WHITE_MAN);
		setPiece(2, 7, Piece.WHITE_MAN);
		setPiece(5, 0, Piece.RED_MAN);
		setPiece(5, 2, Piece.RED_MAN);
		setPiece(5, 4, Piece.RED_MAN);
		setPiece(5, 6, Piece.RED_MAN);
		setPiece(6, 1, Piece.RED_MAN);
		setPiece(6, 3, Piece.RED_MAN);
		setPiece(6, 5, Piece.RED_MAN);
		setPiece(6, 7, Piece.RED_MAN);
		setPiece(7, 0, Piece.RED_MAN);
		setPiece(7, 2, Piece.RED_MAN);
		setPiece(7, 4, Piece.RED_MAN);
		setPiece(7, 6, Piece.RED_MAN);

	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	// change to stringBuiler
	public String toString() {
		StringBuilder display = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (getPiece(i, j) != null) {
					display.append(getPiece(i, j).toString());
				} else {
					display.append('-');
				}
			}
			display.append("\n");

		}
		return display.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move) {
		Piece movePiece = getPiece(move.getX1(), move.getY1());

		if (move.getX2() == 7 && movePiece == Piece.WHITE_MAN) {
			setPiece(move.getX2(), move.getY2(), Piece.WHITE_KING);
		} else if (move.getX2() == 0 && movePiece == Piece.RED_MAN) {
			setPiece(move.getX2(), move.getY2(), Piece.RED_KING);
		} else {
			setPiece(move.getX2(), move.getY2(), movePiece);
		}
		setPiece(move.getX1(), move.getY1(), null);
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump) {
		Piece jumpPiece = getPiece(jump.getX1(), jump.getY1());

		if (jump.getX2() == 7 && jumpPiece == Piece.WHITE_MAN) {
			setPiece(jump.getX2(), jump.getY2(), Piece.WHITE_KING);
		} else if (jump.getX2() == 0 && jumpPiece == Piece.RED_MAN) {
			setPiece(jump.getX2(), jump.getY2(), Piece.RED_KING);
		} else {
			setPiece(jump.getX2(), jump.getY2(), jumpPiece);
		}

		setPiece(jump.getCaptureX(), jump.getCaptureY(), null);
		setPiece(jump.getX1(), jump.getY1(), null);
	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {
		List<Move> moves = new ArrayList<Move>();

		if (getPiece(x, y) == null) {
			return moves;

		} else if ((!isOnBoard(x + 1, y + 1) || (!isEmptySquare(x + 1, y + 1)))
				&& (!isOnBoard(x + 1, y - 1) || (!isEmptySquare(x + 1, y - 1)))
				&& ((!isOnBoard(x - 1, y - 1) || !isEmptySquare(x - 1, y - 1)))
				&& ((!isOnBoard(x - 1, y + 1) || !isEmptySquare(x - 1, y + 1)))) {
			return moves;
		} else {
			if (getPiece(x, y).equals(Piece.WHITE_KING)
					|| getPiece(x, y).equals(Piece.RED_KING)) {
				if (isOnBoard(x + 1, y + 1) && (isEmptySquare(x + 1, y + 1))) {
					moves.add(new Move(x, y, x + 1, y + 1));
				}
				if (isOnBoard(x + 1, y - 1) && (isEmptySquare(x + 1, y - 1))) {
					moves.add(new Move(x, y, x + 1, y - 1));
				}
				if (isOnBoard(x - 1, y - 1) && (isEmptySquare(x - 1, y - 1))) {
					moves.add(new Move(x, y, x - 1, y - 1));
				}
				if (isOnBoard(x - 1, y + 1) && (isEmptySquare(x - 1, y + 1))) {
					moves.add(new Move(x, y, x - 1, y + 1));
				}
			} else if (getPiece(x, y).equals(Piece.RED_MAN)) {
				if (isOnBoard(x - 1, y - 1) && (isEmptySquare(x - 1, y - 1))) {
					moves.add(new Move(x, y, x - 1, y - 1));
				}
				if (isOnBoard(x - 1, y + 1) && (isEmptySquare(x - 1, y + 1))) {
					moves.add(new Move(x, y, x - 1, y + 1));
				}
			} else { // white man
				if (isOnBoard(x + 1, y + 1) && (isEmptySquare(x + 1, y + 1))) {
					moves.add(new Move(x, y, x + 1, y + 1));
				}
				if (isOnBoard(x + 1, y - 1) && (isEmptySquare(x + 1, y - 1))) {
					moves.add(new Move(x, y, x + 1, y - 1));
				}
			}
		}
		return moves;
	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	// can only jump over enemy
	public List<Jump> getJumps(final int x, final int y) {
		List<Jump> jumps = new ArrayList<Jump>();
		if (getPiece(x, y) == null) {
			return jumps;

		} else if ((!isOnBoard(x + 2, y + 2) || (!isEmptySquare(x + 2, y + 2)))
				&& (!isOnBoard(x + 2, y - 2) || (!isEmptySquare(x + 2, y - 2)))
				&& ((!isOnBoard(x - 2, y - 2) || !isEmptySquare(x - 2, y - 2)))
				&& ((!isOnBoard(x - 2, y + 2) || !isEmptySquare(x - 2, y + 2)))) {
			return jumps;
		} else {
			if (getPiece(x, y).equals(Piece.RED_KING)) {

				if (isEmptySquare(x + 2, y + 2)
						&& (isOnBoard(x + 2, y + 2))
						&& (getPiece(x + 1, y + 1) == Piece.WHITE_MAN || getPiece(
								x + 1, y + 1) == Piece.WHITE_KING)) {
					jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
				}

				if (isEmptySquare(x + 2, y - 2)
						&& (isOnBoard(x + 2, y - 2))
						&& (getPiece(x + 1, y - 1) == Piece.WHITE_MAN || getPiece(
								x + 1, y - 1) == Piece.WHITE_KING)) {
					jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}
				if (isEmptySquare(x - 2, y - 2)
						&& (isOnBoard(x - 2, y - 2))
						&& (getPiece(x - 1, y - 1) == Piece.WHITE_MAN || getPiece(
								x - 1, y - 1) == Piece.WHITE_KING)) {
					jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
				}
				if (isEmptySquare(x - 2, y + 2)
						&& (isOnBoard(x - 2, y + 2))
						&& (getPiece(x - 1, y + 1) == Piece.WHITE_MAN || getPiece(
								x - 1, y + 1) == Piece.WHITE_KING)) {
					jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
				}
			}

			else if (getPiece(x, y).equals(Piece.WHITE_KING)) {

				if (isEmptySquare(x + 2, y + 2)
						&& (isOnBoard(x + 2, y + 2))
						&& (getPiece(x + 1, y + 1) == Piece.RED_MAN || getPiece(
								x + 1, y + 1) == Piece.RED_KING)) {
					jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
				}

				if (isEmptySquare(x + 2, y - 2)
						&& (isOnBoard(x + 2, y - 2))
						&& (getPiece(x + 1, y - 1) == Piece.RED_MAN || getPiece(
								x + 1, y - 1) == Piece.RED_KING)) {
					jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}
				if (isEmptySquare(x - 2, y - 2)
						&& (isOnBoard(x - 2, y - 2))
						&& (getPiece(x - 1, y - 1) == Piece.RED_MAN || getPiece(
								x - 1, y - 1) == Piece.RED_KING)) {
					jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
				}
				if (isEmptySquare(x - 2, y + 2)
						&& (isOnBoard(x - 2, y + 2))
						&& (getPiece(x - 1, y + 1) == Piece.RED_MAN || getPiece(
								x - 1, y + 1) == Piece.RED_KING)) {
					jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
				}

			} else if (getPiece(x, y).equals(Piece.WHITE_MAN)) {

				if (isEmptySquare(x + 2, y + 2)
						&& (isOnBoard(x + 2, y + 2))
						&& (getPiece(x + 1, y + 1) == Piece.RED_MAN || getPiece(
								x + 1, y + 1) == Piece.RED_KING)) {
					jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
				}

				if (isEmptySquare(x + 2, y - 2)
						&& (isOnBoard(x + 2, y - 2))
						&& (getPiece(x + 1, y - 1) == Piece.RED_MAN || getPiece(
								x + 1, y - 1) == Piece.RED_KING)) {
					jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}

			}

			else { // red man

				if (isEmptySquare(x - 2, y - 2)
						&& (isOnBoard(x - 2, y - 2))
						&& (getPiece(x - 1, y - 1) == Piece.WHITE_MAN || getPiece(
								x - 1, y - 1) == Piece.WHITE_KING)) {
					jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
				}
				if (isEmptySquare(x - 2, y + 2)
						&& (isOnBoard(x - 2, y + 2))
						&& (getPiece(x - 1, y + 1) == Piece.WHITE_MAN || getPiece(
								x - 1, y + 1) == Piece.WHITE_KING)) {
					jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
				}
			}
		}
		return jumps;
	}

}
