package edu.neumont;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Trevor on 4/7/2017.
 */
public class LearningAIPlayer implements Player {

    private class Move {
        public int row;
        public int numPieces;

        public Move(int row, int numPieces) {
            this.row = row;
            this.numPieces = numPieces;
        }
    }

    private Random rand = new Random();
    private StateHistory history;

    public LearningAIPlayer(StateHistory history) {
        this.history = history;
    }

    @Override
    public void makeMove(Board board) {
        Move move = null;
        if (history != null) {
            ArrayList<BoardState> stateHistory = history.getStates();
            ArrayList<BoardState> possibleStates = getPossibleStates(stateHistory);
            move = getBestMove(board.getState(), possibleStates);
        }

        if (move == null){
            move = getRandomMove(board);
        }
        board.removePieces(move.row, move.numPieces);
    }

    private ArrayList<BoardState> getPossibleStates(ArrayList<BoardState> states) {

    }

    private Move getBestMove(BoardState currentState, ArrayList<BoardState> states) {
        BoardState bestState = new BoardState(new int[]{}, Float.MIN_VALUE);
        for (BoardState state : states)
        {
            if (state.weight > bestState.weight) bestState = state;
        }

        Move bestMove = null;
        if (bestState.weight < 0.0f) return bestMove;

        for (int i = 0; i < bestState.rows.length; ++i)
        {
            if (bestState.rows[i] != currentState.rows[i])
            {
                bestMove = new Move(bestState.rows[i], bestState.rows[i] - currentState.rows[i]);
            }
        }
        return bestMove;
    }

    private Move getRandomMove(Board board) {
        BoardState state = board.getState();
        ArrayList<Integer> validRows = getValidRows(state);
        int row = validRows.get(rand.nextInt(validRows.size()));
        int pieces = rand.nextInt(state.rows[row]) + 1;
        return new Move(row, pieces);
    }

    private ArrayList<Integer> getValidRows(BoardState state) {
        ArrayList<Integer> validRows = new ArrayList<>();
        for(int i = 0; i < state.rows.length; i++) {
            if(state.rows[i] != 0) validRows.add(i);
        }
        return validRows;
    }
}
