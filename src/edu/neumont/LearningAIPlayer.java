package edu.neumont;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Trevor on 4/7/2017.
 */
public class LearningAIPlayer implements Player {

	private Random rand = new Random();
	private StateHistory history;

	public LearningAIPlayer(StateHistory history) {
		this.history = history;
	}

	@Override
	public void makeMove(Board board) {
		if (history != null) {
			ArrayList<BoardState> stateHistory = history.getStates();
			ArrayList<BoardState> possibleStates = findPossibleStates(stateHistory);
		}
	}

	private ArrayList<BoardState> findPossibleStates(ArrayList<BoardState> states) {
		ArrayList<BoardState> list = new ArrayList<BoardState>();
		for (int state = 0; state < list.size(); state++) {
			for (int values = 0; values < states.get(state).rows.length; values++) {
				if (states.get(state).rows[values] > /*Current State*/) {
					
				}
			}
		}
		return list;
	}

	private void makeRandomMove(Board board) {
		BoardState state = board.getState();
		ArrayList<Integer> validRows = getValidRows(state);
		int row = validRows.get(rand.nextInt(validRows.size()));
		int pieces = rand.nextInt(state.rows[row]) + 1;
		board.removePieces(row, pieces);
	}

	private ArrayList<Integer> getValidRows(BoardState state) {
		ArrayList<Integer> validRows = new ArrayList<>();
		for (int i = 0; i < state.rows.length; i++) {
			if (state.rows[i] != 0)
				validRows.add(i);
		}
		return validRows;
	}
}