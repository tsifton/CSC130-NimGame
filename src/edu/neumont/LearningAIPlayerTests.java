package edu.neumont;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

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
	
	@Test
	public void writeToFileTest() {
		FileIO fileIO = new FileIO();
		BoardState state = new BoardState(new int[] {1,5,7});
		ArrayList<BoardState> list = new ArrayList<BoardState>();
		list.add(state);
		fileIO.writeToFile(list, "testFile");
		File file = new File("testFile");
		assertTrue(file.exists());
	}
	
	@Test
	public void readFromFileTest() {
		FileIO fileIO = new FileIO();
		BoardState state = new BoardState(new int[] {1,5,7});
		BoardState state2 = new BoardState(new int[] {1,3,7});
		BoardState state3 = new BoardState(new int[] {1,2,7});

		ArrayList<BoardState> list = new ArrayList<BoardState>();
		list.add(state);
		list.add(state2);
		list.add(state3);
		fileIO.writeToFile(list, "testFile2");
		ArrayList<BoardState> readState = fileIO.readFromFile("testFile2");
		assertEquals(list.size(), readState.size());
	}
}
