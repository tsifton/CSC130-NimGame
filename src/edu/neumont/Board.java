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
		boolean canRemovePiece = false;
		if (row > 0 && row < 4) {
			if (row == 1) {
				if (numofPieces >= rows[0] && rows[0] > 0) {
					canRemovePiece = true;
					rows[0] = rows[0] - numofPieces;
				} else {
					canRemovePiece = false;
				}
			} else if (row == 2) {
				if (numofPieces >= rows[1] && rows[1] > 0) {
					canRemovePiece = true;
					rows[1] = rows[1] - numofPieces;
				} else {
					canRemovePiece = false;
				}
			} else if (row == 3) {
				if (numofPieces >= rows[2] && rows[2] > 0) {
					canRemovePiece = true;
					rows[2] = rows[2] - numofPieces;
				} else {
					canRemovePiece = false;
				}
			} else {
				canRemovePiece = false;
			}
		} else {
			canRemovePiece = false;
		}
		return canRemovePiece;
	}

	public boolean anyPiecesLeft() {
		if (rows[0] == 0 && rows[1] == 0 && rows[2] == 0) {
			return false;
		} else {
			return true;
		}
	}

}
