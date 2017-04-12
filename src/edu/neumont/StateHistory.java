package edu.neumont;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/10/2017.
 */
public class StateHistory {

    private ArrayList<BoardState> history;

    public StateHistory()
    {
        history = new ArrayList<>();
    }

    public StateHistory(ArrayList<BoardState> history)
    {
        this.history = history;
    }

    public void Add(BoardState state) {
        for (BoardState prevState : history) {
            if (prevState.rows.equals(state.rows)) {
                prevState.weight = Average(prevState.weight, state.weight);
                return;
            }
        }
        history.add(new BoardState(state.rows.clone(), state.weight));
    }

    public void Add(StateHistory newHistory)
    {
        for (BoardState newState : newHistory.getStates())
        {
            Add(newState);
        }
    }

    public ArrayList<BoardState> getStates()
    {
        return history;
    }

    private float Average(float weight1, float weight2) {
        return (weight1 + weight2) / 2;
    }
}
