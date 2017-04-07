package edu.neumont;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Trevor on 4/5/2017.
 */
public class RandomAIPlayer implements Player {

    @Override
    public void makeMove(BoardState state) {
        Random rand = new Random();
        ArrayList<Integer> validRows = state.getValidRows();
        int row = validRows.get(rand.nextInt(validRows.size()));
        int pieces = rand.nextInt(board.getNumPiecesLeftInRow(row)) + 1;
        board.removePiece(row, pieces);
    }

}
