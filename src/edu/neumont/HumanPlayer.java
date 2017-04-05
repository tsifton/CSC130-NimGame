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
	
    public void makeMove(Board board) {
    	PlayerInput input;
    	do {
        	input = getInput();
    	} while(!board.removePiece(input.row, input.numPieces));
    }
    
    private int getInt(Scanner scan, String message) {
    	do {
        	System.out.print(message);	
    	} while(!scan.hasNextInt());
    	return scan.nextInt();
    }
    
    private PlayerInput getInput() {
    	Scanner scan = new Scanner(System.in);
    	int row = getInt(scan, "Which Row would you like to select from? ");
    	int numPieces = getInt(scan, "How many pieces do you want to remove from this row? ");
    	return new PlayerInput(row, numPieces);
    }
}
