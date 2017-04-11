package edu.neumont;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Trevor on 4/7/2017.
 */
public class LearningAIPlayer implements Player {

    private StateHistory history;

    public LearningAIPlayer(StateHistory history)
    {
        this.history = history;
    }

    private Random rand = new Random();

    @Override
    public void makeMove(Board board) {
        BoardState state = board.getState();
        ArrayList<Integer> validRows = getValidRows(state);
        int row = validRows.get(rand.nextInt(validRows.size()));
        int pieces = rand.nextInt(state.rows[row]) + 1;
        board.removePieces(row, pieces);
    }

    private ArrayList<Integer> getValidRows(BoardState state)
    {
        ArrayList<Integer> validRows = new ArrayList<>();
        for(int i = 0; i < state.rows.length; i++)
        {
            if(state.rows[i] != 0) validRows.add(i);
        }
        return validRows;
    }
}
