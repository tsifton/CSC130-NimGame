package edu.neumont;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new RandomAIPlayer(), new RandomAIPlayer());
        game.Play();
        FileIO file = new FileIO();
        BoardState state = new BoardState(new int[] {1,2,3});
        ArrayList<BoardState> list = new ArrayList<BoardState>();
        list.add(state);
        file.writeToFile(list, "Bob.txt");
        ArrayList<BoardState> newList = file.readFromFile("Bob.txt");
    }
}
