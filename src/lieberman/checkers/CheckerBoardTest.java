package lieberman.checkers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CheckerBoardTest {

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringOnEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		final String expected = "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringAfterNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n"
				+ "--------\n" + "--------\n" + "r-r-r-r-\n" + "-r-r-r-r\n"
				+ "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test that isOnBoard() returns the correct result for different xs and ys
	 */
	public void testIsOnBoard() {
		CheckerBoard board = new CheckerBoard();
		boolean testTrue = board.isOnBoard(0, 4);
		Assert.assertTrue(testTrue);
		boolean testFalse = board.isOnBoard(9, 4);
		Assert.assertFalse(testFalse);
	}

	@Test
	/**
	 * Test that isEmptySquare() returns the correct result before and after setPiece() is called
	 */
	public void testIsEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		boolean testTrue = board.isEmptySquare(3, 4);
		Assert.assertTrue(testTrue);
		board.setPiece(3, 4, Piece.WHITE_MAN);
		boolean testFalse = board.isEmptySquare(3, 4);
		Assert.assertFalse(testFalse);
	}

	@Test
	/**
	 * Given an board with pieces, test that calling clear() clears the board
	 */
	public void testClear() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.WHITE_MAN);
		Piece test1 = board.getPiece(3, 4);
		Piece expected1 = Piece.WHITE_MAN;
		Assert.assertEquals(test1, expected1);
		board.clear();
		Piece test2 = board.getPiece(3, 4);
		Piece expected2 = null;
		Assert.assertEquals(test2, expected2);

	}

	@Test
	/**
	 * Test that the board is in the correct configuration after
	 * resetNewGame() is called
	 */
	public void testResetNewGame() {
		CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n"
				+ "--------\n" + "--------\n" + "r-r-r-r-\n" + "-r-r-r-r\n"
				+ "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test execute(Move) moves a piece from one square to the other
	 */
	public void testMove() {
		CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		Move move1 = new Move(2, 1, 3, 2);
		board.execute(move1);
		Piece testPiece = board.getPiece(3, 2);
		Piece expected = Piece.WHITE_MAN;
		Assert.assertEquals(testPiece, expected);
	}

	@Test
	/**
	 * Test execute(Move) promotes a WHITE_MAN to a WHITE_KING when moving to the 8th row
	 */
	public void testMovePromoteToWhiteKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(6, 5, Piece.WHITE_MAN);
		Move move = new Move(6, 5, 7, 6);
		board.execute(move);
		Piece testPiece = board.getPiece(7, 6);
		Piece expected = Piece.WHITE_KING;
		Assert.assertEquals(testPiece, expected);
	}

	@Test
	/**
	 * Test execute(Move) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testMovePromoteToRedKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 2, Piece.RED_MAN);
		Move move = new Move(1, 2, 0, 1);
		board.execute(move);
		Piece testPiece = board.getPiece(0, 1);
		Piece expected = Piece.RED_KING;
		Assert.assertEquals(testPiece, expected);
	}

	@Test
	/**
	 * Test execute(Jump) moves a piece from one square to another AND removes the piece that was jumped
	 */
	public void testJump() {
		CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		Jump jump1 = new Jump(2, 1, 3, 2, 4, 3);
		board.execute(jump1);
		Piece testPiece = board.getPiece(4, 3);
		Piece expected = Piece.WHITE_MAN;
		Piece testNull = board.getPiece(3, 2);
		Piece expected2 = null;
		Assert.assertEquals(testPiece, expected);
		Assert.assertEquals(testNull, expected2);
	}

	@Test
	/**
	 * Test execute(Jump) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testJumpPromoteToRedKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 4, Piece.WHITE_MAN);
		Jump jump1 = new Jump(5, 4, 6, 5, 7, 6);
		board.execute(jump1);

		Piece testPiece = board.getPiece(7, 6);
		Piece expected = Piece.WHITE_KING;
		Assert.assertEquals(testPiece, expected);
	}

	@Test
	/**
	 * Test execute(Jump) promotes a WHITE_MAN to a WHITE_KING when moving to the 1st row
	 */
	public void testJumpPromoteToWhiteKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 3, Piece.RED_MAN);
		Jump jump1 = new Jump(2, 3, 1, 2, 0, 1);
		board.execute(jump1);

		Piece testPiece = board.getPiece(0, 1);
		Piece expected = Piece.RED_KING;
		Assert.assertEquals(testPiece, expected);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct number of Move objects when called on an empty square
	 */
	public void testGetMovesForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		List<Move> test = board.getMoves(4, 1);
		List<Move> expected = new ArrayList<Move>();
		Assert.assertEquals(test.size(), expected.size());
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.RED_MAN);
		List<Move> test = board.getMoves(3, 4);
		List<Move> expectedList = new ArrayList<Move>();
		Move move1 = new Move(3, 4, 2, 3);
		Move move2 = new Move(3, 4, 2, 5);
		expectedList.add(move1);
		expectedList.add(move2);
		Assert.assertEquals(test, expectedList);

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.RED_KING);
		List<Move> test = board.getMoves(3, 4);
		List<Move> expectedList = new ArrayList<Move>();
		Move move1 = new Move(3, 4, 4, 5);
		Move move2 = new Move(3, 4, 4, 3);
		Move move3 = new Move(3, 4, 2, 3);
		Move move4 = new Move(3, 4, 2, 5);
		expectedList.add(move1);
		expectedList.add(move2);
		expectedList.add(move3);
		expectedList.add(move4);
		Assert.assertEquals(test, expectedList);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a WHITE_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.WHITE_MAN);
		List<Move> test = board.getMoves(3, 4);
		List<Move> expectedList = new ArrayList<Move>();
		Move move1 = new Move(3, 4, 4, 5);
		Move move2 = new Move(3, 4, 4, 3);
		expectedList.add(move1);
		expectedList.add(move2);
		Assert.assertEquals(test, expectedList);

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a WHITE_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.WHITE_KING);
		List<Move> test = board.getMoves(3, 4);
		List<Move> expectedList = new ArrayList<Move>();
		Move move1 = new Move(3, 4, 4, 5);
		Move move2 = new Move(3, 4, 4, 3);
		Move move3 = new Move(3, 4, 2, 3);
		Move move4 = new Move(3, 4, 2, 5);
		expectedList.add(move1);
		expectedList.add(move2);
		expectedList.add(move3);
		expectedList.add(move4);
		Assert.assertEquals(test, expectedList);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is surrounded in 4 directions and
	 * cannot move.
	 * This should be an empty List
	 */
	public void testGetMovesForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 4, Piece.RED_KING);
		board.setPiece(4, 5, Piece.WHITE_KING);
		board.setPiece(2, 3, Piece.RED_MAN);
		board.setPiece(4, 3, Piece.WHITE_MAN);
		board.setPiece(2, 5, Piece.RED_MAN);
		List<Move> test = board.getMoves(3, 4);
		List<Move> expectedList = new ArrayList<Move>();
		Assert.assertEquals(test, expectedList);
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (0,7) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt07() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 7, Piece.RED_KING);
		List<Move> expectedList = new ArrayList<Move>();
		Move move1 = new Move(0, 7, 1, 6);
		expectedList.add(move1);
		List<Move> test = board.getMoves(0, 7);
		Assert.assertEquals(test, expectedList);
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (7,0) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt70() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(7, 0, Piece.RED_KING);
		List<Move> expectedList = new ArrayList<Move>();
		Move move1 = new Move(7, 0, 6, 1);
		expectedList.add(move1);
		List<Move> test = board.getMoves(7, 0);
		Assert.assertEquals(test, expectedList);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on an empty square
	 */
	public void testGetJumpsForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		List<Jump> expectedList = new ArrayList<Jump>();
		List<Jump> test = board.getJumps(4, 3);
		Assert.assertEquals(test.size(), expectedList.size());

	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on square that does not have
	 * any possible jumps
	 */
	public void testGetJumpsForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(4, 3, Piece.RED_KING);
		List<Jump> test = board.getJumps(4, 3);
		List<Jump> expectedList = new ArrayList<Jump>();
		Assert.assertEquals(test.size(), expectedList.size());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when a King can jump in 4 directions
	 */
	public void testGetJumpsForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(4, 3, Piece.RED_KING);
		board.setPiece(3, 2, Piece.WHITE_MAN);
		board.setPiece(3, 4, Piece.WHITE_MAN);
		board.setPiece(5, 2, Piece.WHITE_MAN);
		board.setPiece(5, 4, Piece.WHITE_MAN);
		List<Jump> test = board.getJumps(4, 3);
		List<Jump> expectedList = new ArrayList<Jump>();

		Jump jump1 = new Jump(4, 3, 5, 4, 6, 5);
		Jump jump2 = new Jump(4, 3, 5, 2, 6, 1);
		Jump jump3 = new Jump(4, 3, 3, 2, 2, 1);
		Jump jump4 = new Jump(4, 3, 3, 4, 2, 5);

		expectedList.add(jump1);
		expectedList.add(jump2);
		expectedList.add(jump3);
		expectedList.add(jump4);
		Assert.assertEquals(test, expectedList);
	}

	@Test
	/**
	 * Test that getJumps() returns the returns the correct Jump objects when a Piece can jump in 2 directions
	 */
	public void testGetJumpsForRedManWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(4, 3, Piece.RED_MAN);
		board.setPiece(3, 2, Piece.WHITE_MAN);
		board.setPiece(3, 4, Piece.WHITE_MAN);
		board.setPiece(5, 2, Piece.WHITE_MAN);
		board.setPiece(5, 4, Piece.WHITE_MAN);
		List<Jump> test = board.getJumps(4, 3);
		List<Jump> expectedList = new ArrayList<Jump>();
		Jump jump1 = new Jump(4, 3, 3, 2, 2, 1);
		Jump jump2 = new Jump(4, 3, 3, 4, 2, 5);
		expectedList.add(jump1);
		expectedList.add(jump2);
		Assert.assertEquals(test, expectedList);
	}

}
