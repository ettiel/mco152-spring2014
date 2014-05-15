package lieberman.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {

	@Test
	public void testWinnerByRow() {
		TicTacToeBoard game = new TicTacToeBoard();

		game.setSquare(new Location(0, 2), Symbol.X);
		game.setSquare(new Location(1, 2), Symbol.X);
		game.setSquare(new Location(2, 2), Symbol.X);

		Evaluator evaluator = new Evaluator(game);
		evaluator.evaluate();
		Symbol test = evaluator.getWinner();
		Symbol expected = Symbol.X;
		Assert.assertEquals(test, expected);
	}

	@Test
	public void testWinnerByColumn() {
		TicTacToeBoard game = new TicTacToeBoard();

		game.setSquare(new Location(1, 0), Symbol.X);
		game.setSquare(new Location(1, 1), Symbol.X);
		game.setSquare(new Location(1, 2), Symbol.X);

		Evaluator evaluator = new Evaluator(game);
		evaluator.evaluate();
		Symbol test = evaluator.getWinner();
		Symbol expected = Symbol.X;
		Assert.assertEquals(test, expected);
	}

	@Test
	public void testWinnerByDiagonal() {
		TicTacToeBoard game = new TicTacToeBoard();

		game.setSquare(new Location(0, 0), Symbol.X);
		game.setSquare(new Location(1, 1), Symbol.X);
		game.setSquare(new Location(2, 2), Symbol.X);

		Evaluator evaluator = new Evaluator(game);
		evaluator.evaluate();
		Symbol test = evaluator.getWinner();
		Symbol expected = Symbol.X;
		Assert.assertEquals(test, expected);
	}

	@Test
	public void testNull() { // if board is empty
		TicTacToeBoard game = new TicTacToeBoard();
		Evaluator evaluator = new Evaluator(game);
		Symbol test = evaluator.getWinner();
		Symbol expected = null;
		Assert.assertEquals(test, expected);

	}

}
