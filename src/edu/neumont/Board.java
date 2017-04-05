package edu.neumont;

/**
 * Created by Trevor on 4/4/2017.
 */
public class Board {
	private int[] rows = new int[] { 3, 5, 7 };

	public void displayBoard() {
		for (int x = 0; x < rows[0]; x++) {
			System.out.print(" * ");
		}
        System.out.println();

		for (int x = 0; x < rows[1]; x++) {
			System.out.print(" * ");
		}
        System.out.println();

		for (int x = 0; x < rows[2]; x++) {
			System.out.print(" * ");
		}
        System.out.println();
	}

	public boolean removePiece(int row, int numofPieces) {
		if (row <= 0 && row >= rows.length)
		{
			System.out.println(row + " is an invalid Row! Try again.");
			return false;
		}

		if (numofPieces <= 0 || numofPieces > rows[row - 1])
		{
			System.out.println(numofPieces + " is an invalid number of pieces! Try again.");
			return false;
		}

		rows[row] = rows[row] - numofPieces;
		return true;
	}

	public boolean anyPiecesLeft() {
		if (rows[0] == 0 && rows[1] == 0 && rows[2] == 0) {
			return false;
		} else {
			return true;
		}
	}

	public int getNumRows()
	{
		return rows.length;
	}

}
