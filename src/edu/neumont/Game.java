package edu.neumont;

/**
 * Created by Trevor on 4/4/2017.
 */
public class Game {

    private Board board = new Board();
    private Player p1, p2;
    private Player currentPlayer;
    private Player loser;

    private boolean isGameOver = false;

    public Game(Player player1, Player player2) {
        p1 = player1;
        p2 = player2;
        currentPlayer = p1;
    }

    public void Play() {
        while(!isGameOver) {
            currentPlayer.makeMove(board);
            SwapCurrentPlayer();
            /*
            if (!board.piecesLeft()) {
                loser = currentPlayer;
                isGameOver = true;
            }
             */
        }

        DisplayResults();
    }

    private void DisplayResults() {

    }

    private void SwapCurrentPlayer() {
        currentPlayer = (currentPlayer == p1) ? p2 : p1;
    }
}
