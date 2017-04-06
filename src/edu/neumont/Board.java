package edu.neumont;


import java.util.ArrayList;

/**
 * Created by Trevor on 4/4/2017.
 */
public class Board {

	private int[] rows = new int[] { 3, 5, 7 };

	public void displayBoard() {
	    System.out.println();
	    for (int i = 0; i < rows.length; i++)
        {
            System.out.print("[" + (i + 1) + "] ");
            for (int j = 0; j < rows[i]; j++)
            {
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
	}

	public boolean removePiece(int row, int numPieces) {
        int rowIndex = row - 1;
		if (rowIndex < 0 || rowIndex >= rows.length)
		{
			System.out.println("Row " + row + " is an invalid Row! Try again.");
			return false;
		}

        if (rows[rowIndex] == 0)
        {
            System.out.println("Row " + row + " has no more pieces! Try again.");;
            return false;
        }

		if (numPieces <= 0 || numPieces > rows[rowIndex])
		{
			System.out.println(numPieces + " is an invalid number of pieces! Try again.");
			return false;
		}

		rows[rowIndex] = rows[rowIndex] - numPieces;
		return true;
	}

	public boolean anyPiecesLeft() {
		return !(rows[0] == 0 && rows[1] == 0 && rows[2] == 0);
	}

	public ArrayList<Integer> getValidRows()
	{
	    ArrayList<Integer> validRows = new ArrayList<>(rows.length);
		for(int i = 0; i < rows.length; i++)
        {
            if(rows[i] != 0) validRows.add(i + 1);
        }
        return validRows;
	}

	public int getNumPiecesLeftInRow(int row)
    {
        return rows[row - 1];
    }

}
