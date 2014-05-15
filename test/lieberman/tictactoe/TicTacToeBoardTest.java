package lieberman.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeBoardTest {

	@Test
	public void testGetSquare() {
		TicTacToeBoard game = new TicTacToeBoard();
		Location loc = new Location(0, 2);
		game.setSquare(loc, Symbol.O);
		Symbol test = game.getSquare(loc);
		Symbol expected = Symbol.O;
		Assert.assertEquals(test, expected);

	}

	@Test
	public void isFull() {
		TicTacToeBoard game = new TicTacToeBoard();
		Location l = new Location(0, 0);
		game.setSquare(l, Symbol.X);
		Location lo = new Location(0, 1);
		game.setSquare(lo, Symbol.O);
		Location loc = new Location(0, 2);
		game.setSquare(loc, Symbol.X);
		Location loca = new Location(1, 0);
		game.setSquare(loca, Symbol.O);
		Location locat = new Location(1, 1);
		game.setSquare(locat, Symbol.X);
		Location locati = new Location(1, 2);
		game.setSquare(locati, Symbol.O);
		Location locatio = new Location(2, 0);
		game.setSquare(locatio, Symbol.X);
		Location location = new Location(2, 1);
		game.setSquare(location, Symbol.O);
		// Location loc2 = new Location(2, 2);
		// game.setSquare(loc2, Symbol.X);

		Boolean test = game.isFull();
		Assert.assertFalse(test);
	}

	@Test
	public void reset() {
		TicTacToeBoard game = new TicTacToeBoard();
		Location loc = new Location(0, 2);
		game.setSquare(loc, Symbol.X);
		game.reset();
		Symbol test = game.getSquare(new Location(0, 2));
		Symbol expected = null;
		Assert.assertEquals(test, expected);

	}
}
