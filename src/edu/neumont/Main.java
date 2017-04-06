package edu.neumont;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new HumanPlayer(), new HumanPlayer());
        game.Play();
    }
}
