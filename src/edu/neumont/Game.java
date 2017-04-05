package edu.neumont;

/**
 * Created by Trevor on 4/4/2017.
 */
public class Game {
	

    private Board board = new Board();
    private Player p1, p2;
    private Player currentPlayer;

    private boolean isGameOver = false;

    public Game(Player player1, Player player2) {
        p1 = player1;
        p2 = player2;
        currentPlayer = p1;
    }

    public void Play() {
        while(!isGameOver) {
            board.displayBoard();
            currentPlayer.makeMove(board);

            if (!board.anyPiecesLeft()) {
                isGameOver = true;
            }
            else {
                SwapCurrentPlayer();
            }
        }

        DisplayResults();
    }

    private void DisplayResults() {
        String loser = "Player " + (currentPlayer == p1 ? "1" : "2");
        String winner = "Player " + (currentPlayer == p1 ? "2" : "1");
        System.out.println(loser + " took the last piece. " + winner + " wins!");
    }

    private void SwapCurrentPlayer() {
        currentPlayer = (currentPlayer == p1) ? p2 : p1;
    }
}
