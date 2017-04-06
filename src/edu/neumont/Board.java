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

	public boolean removePiece(int row, int numPieces) {
        int rowIndex = row - 1;
		if (rowIndex >= 0 && rowIndex < rows.length)
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

	public int getNumRows()
	{
		return rows.length;
	}

}
