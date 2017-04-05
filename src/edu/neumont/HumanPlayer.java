package edu.neumont;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Trevor on 4/4/2017.
 */
public class HumanPlayer implements Player{
    public void makeMove(Board board) {
    	ArrayList<Integer> input = getInput();
    	board.removePiece(input.get(0), input.get(1));
    }
    
    private ArrayList<Integer> getInput() {
    	ArrayList<Boolean> checkList = new ArrayList<Boolean>();
    	ArrayList<Integer> values = new ArrayList<Integer>();
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Which Row would you like to select from? ");
    	boolean row = scan.hasNextInt();
    	checkList.add(row);
    	values.add(scan.nextInt());
    	System.out.print("How many pieces do you want to remove from this row? ");
    	Scanner scan2 = new Scanner(System.in);
    	boolean numOfPieces = scan2.hasNextInt();
    	checkList.add(numOfPieces);
    	values.add(scan2.nextInt());

    	return values;
    }
}
