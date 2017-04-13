package edu.neumont;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        FileIO fileIO = new FileIO();
        StateHistory history = new StateHistory(fileIO.readFromFile("AIHistory"));

        int p1Wins = 0;
        int p2Wins = 0;
        for (int i = 0; i < 1000000; ++i)
        {
            Game game = new Game(new LearningAIPlayer(history), new RandomAIPlayer());
            game.play();
            if (game.getWinner() == 1) p1Wins++;
            else p2Wins++;
            history.Add(game.getHistory());
        }

        displayHistory(history);
        System.out.println("The Random AI won " + p1Wins + " out of " + (p1Wins + p2Wins) + " games.");
        System.out.println("The Smart AI won " + p2Wins + " out of " + (p1Wins + p2Wins) + " games.");
        fileIO.writeToFile(history.getStates(),"AIHistory");
    }

    private static void displayHistory(StateHistory history)
    {
        ArrayList<BoardState> states = history.getStates();
        Collections.sort(states, new Comparator<BoardState>() {
            @Override
            public int compare(BoardState state1, BoardState state2) {
                return Float.compare(state1.weight, state2.weight);
            }
        });
        Collections.reverse(states);

        for(BoardState state : states)
        {
            System.out.println("State: " + state.rows[0] + " " + state.rows[1] + " " + state.rows[2] + " Weight: " + state.weight);
        }
        System.out.println("Total States: " + states.size());
    }
}
