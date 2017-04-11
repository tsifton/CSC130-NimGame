package edu.neumont;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new RandomAIPlayer(), new RandomAIPlayer());
        game.Play();
    }
}
