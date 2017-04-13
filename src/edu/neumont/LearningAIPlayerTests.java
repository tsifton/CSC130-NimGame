package edu.neumont;

import static org.junit.Assert.*;
import org.junit.Test;

public class LearningAIPlayerTests {

	@Test
	public void moveTest1() throws Exception {
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
}
