package edu.neumont;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new HumanPlayer(), new HumanPlayer());
        game.Play();
//    	HumanPlayer player = new HumanPlayer();
//    	Board board = new Board();
//    	player.makeMove(board);
    }
}
