package edu.neumont;

/**
 * Created by Trevor on 4/4/2017.
 */
public class Board {

	private int[] rows;
	private StateHistory history = new StateHistory();

    public Board()
    {
        init(3, 5, 7);
    }

	public Board(int row1, int row2, int row3) {
        init(row1, row2, row3);
    }

    private void init(int row1, int row2, int row3)
    {
        rows = new int[] {row1, row2, row3};
    }

	public BoardState getState()
    {
        return new BoardState(rows);
    }

    public boolean removePieces(int row, int numPieces) {
        if (row < 0 || row >= rows.length)
        {
            System.out.println("Row " + (row + 1) + " is an invalid Row! Try again.");
            return false;
        }

        if (rows[row] == 0)
        {
            System.out.println("Row " + (row + 1) + " has no more pieces! Try again.");;
            return false;
        }

        if (numPieces <= 0 || numPieces > rows[row])
        {
            System.out.println(numPieces + " is an invalid number of pieces! Try again.");
            return false;
        }

        rows[row] -= numPieces;
        history.Add(new BoardState(rows));
        return true;
    }

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

	public boolean hasPiecesLeft() {
		return rows[0] != 0 || rows[1] != 0 || rows[2] != 0;
	}

}
