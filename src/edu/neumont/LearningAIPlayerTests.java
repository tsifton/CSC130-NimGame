package edu.neumont;

import static org.junit.Assert.*;
import org.junit.Test;

public class LearningAIPlayerTests {

	@Test
	public void LearningAIPlayerTest() throws Exception {
	    // Arrange
        Board board = new Board(2, 0, 0);
	    FileIO file = new FileIO();
	    StateHistory history = new StateHistory(file.readFromFile("AIHistory"));
		LearningAIPlayer ai = new LearningAIPlayer(history);
	    BoardState expectedState = new BoardState(new int[] {1,0,0});

	    // Act
        ai.makeMove(board);

		//Assert
        assertArrayEquals(board.getState().rows, expectedState.rows);
	}

    @Test
    public void RemoveInvalidNumberOfPiecesTest() throws Exception {
        // Arrange
        Board board = new Board(3, 5, 7);

        // Act
        boolean result = board.removePieces(0, 4);

        //Assert
        assertFalse(result);
    }

    @Test
    public void RemovePiecesFromInvalidRowTest() throws Exception {
        // Arrange
        Board board = new Board(3, 5, 7);

        // Act
        boolean result = board.removePieces(4, 3);

        //Assert
        assertFalse(result);
    }
}
