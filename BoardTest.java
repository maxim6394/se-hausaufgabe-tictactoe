import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class BoardTest extends TestCase {

	Board board = new Board();

	@Before
	public void testVorbereiten() {
		board = new Board();
	}

	@Test
	public void testEmptyBoard() {

		assertFalse(board.hasWinner());
	}

	@Test
	public void testSingleMark() {
		try {
			board.setMark(Board.Mark.O, 0, 0);
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(board.hasWinner());
	}

	@Test
	public void testValidWinner() {
		try {
			board.setMark(Board.Mark.O, 0, 0);
			board.setMark(Board.Mark.O, 1, 0);
			board.setMark(Board.Mark.O, 2, 0);
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(board.hasWinner());
	}

	@Test(expected = InvalidPositionException.class)
	public void testInvalidMark() {
		try {
			board.setMark(Board.Mark.O, -1, 0);
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
