package edu.neumont;

import java.util.ArrayList;
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
    	PlayerInput input = getInput();
    	board.removePiece(input.row, input.numPieces);
    }
    
    private PlayerInput getInput() {
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Which Row would you like to select from? ");
    	boolean rowCheck = scan.hasNextInt();
    	int row = scan.nextInt();
    	System.out.print("How many pieces do you want to remove from this row? ");
    	Scanner scan2 = new Scanner(System.in);
    	boolean numPiecesCheck = scan2.hasNextInt();
    	int numPieces = scan2.nextInt();

    	return new PlayerInput(row, numPieces);
    }
}
