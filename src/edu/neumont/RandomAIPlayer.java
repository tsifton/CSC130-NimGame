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
        ArrayList<Integer> validRows = getValidRows(state);
        int row = validRows.get(rand.nextInt(validRows.size()));
        int pieces = rand.nextInt(board.getNumPiecesLeftInRow(row)) + 1;
        board.removePiece(row, pieces);
    }

    private ArrayList<Integer> getValidRows(BoardState state)
    {
        ArrayList<Integer> validRows = new ArrayList<>(rows.length);
        for(int i = 0; i < rows.length; i++)
        {
            if(rows[i] != 0) validRows.add(i + 1);
        }
        return validRows;
    }

    private int getNumPiecesLeftInRow(BoardState state, int row)
    {
        return state.rows[row - 1];
    }
}
