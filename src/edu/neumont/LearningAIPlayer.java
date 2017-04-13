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
            ArrayList<BoardState> possibleStates = getPossibleStates(board.getState(), stateHistory);
            move = getBestMove(board.getState(), possibleStates);
        }

        if (move == null){
            move = getRandomMove(board);
        }
        board.removePieces(move.row, move.numPieces);
    }

    private ArrayList<BoardState> getPossibleStates(BoardState currentState, ArrayList<BoardState> states) {
		ArrayList<BoardState> list = new ArrayList<BoardState>();
		for (BoardState possibleState : states) {
			boolean rowHasLessPieces = false;
			int numEqualRows = 0;
			for (int row = 0; row < possibleState.rows.length; row++) {
				if (possibleState.rows[row] < currentState.rows[row]) rowHasLessPieces = true;
				if(possibleState.rows[row] == currentState.rows[row]) numEqualRows++;
			}
			if(rowHasLessPieces && numEqualRows == 2) list.add(possibleState);
		}
		return list;
	}

    private Move getBestMove(BoardState currentState, ArrayList<BoardState> states) {
        BoardState bestState = new BoardState(new int[]{}, Float.MIN_VALUE);
        for (BoardState state : states)
        {
            if (state.weight > bestState.weight) bestState = state;
        }

        Move bestMove = null;
        for (int row = 0; row < bestState.rows.length; ++row)
        {
            if (bestState.rows[row] != currentState.rows[row])
            {
                bestMove = new Move(row,currentState.rows[row] - bestState.rows[row]);
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
