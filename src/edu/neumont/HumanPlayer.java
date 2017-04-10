package edu.neumont;

import java.util.Scanner;

/**
 * Created by Trevor on 4/4/2017.
 */

public class HumanPlayer implements Player{

	private class PlayerInput {
		public int row;
		public int numPieces;

		public PlayerInput(int row, int numPieces) {
			this.row = row;
			this.numPieces = numPieces;
		}
	}

	private Scanner scan = new Scanner(System.in);
	
    public void makeMove(Board board) {
    	PlayerInput input;
    	do {
        	input = getInput();
    	} while(!board.removePieces(input.row - 1, input.numPieces));
    }
    
    private int getInt(Scanner scan, String message) {
		System.out.print(message);
		while(!scan.hasNextInt())
		{
			System.out.print(message);
			scan.next();
		}

    	return scan.nextInt();
    }
    
    private PlayerInput getInput() {
    	int row = getInt(scan, "\nWhich Row would you like to remove from? ");
    	int numPieces = getInt(scan, "How many pieces do you want to remove from this row? ");
    	return new PlayerInput(row, numPieces);
    }
}
