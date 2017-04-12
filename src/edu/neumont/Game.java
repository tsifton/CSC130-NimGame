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
            QueryMove();
            currentPlayer.makeMove(board);

            if (board.hasPiecesLeft()) {
                SwapCurrentPlayer();
            }
            else {
                isGameOver = true;
            }
        }
        
        DisplayResults();
    }

    private void QueryMove()
    {
        System.out.println("[" + GetPlayerString(currentPlayer) + "'s Turn]:");
    }

    private void DisplayResults() {
        board.displayBoard();
        String loser = GetPlayerString(currentPlayer);
        String winner = GetPlayerString(currentPlayer != p1 ? p1 : p2);
        System.out.println(loser + " took the last piece. " + winner + " wins!");
    }

    private String GetPlayerString(Player player)
    {
       return "Player " + (player == p1 ? "1" : "2");
    }

    private void SwapCurrentPlayer() {
        currentPlayer = (currentPlayer == p1) ? p2 : p1;
    }
}
