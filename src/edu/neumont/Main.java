package edu.neumont;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new RandomAIPlayer(), new RandomAIPlayer());
        game.Play();
        FileIO file = new FileIO();
        BoardState state = new BoardState(new int[] {2, 0, 0}, 1.0f);
        ArrayList<BoardState> list = new ArrayList<>();
        list.add(state);
        file.writeToFile(list, "AIHistory");
    }
}
