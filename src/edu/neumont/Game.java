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

    public void play() {
        while(!isGameOver) {
            //board.displayBoard();
            //queryMove();
            currentPlayer.makeMove(board);

            if (board.hasPiecesLeft()) {
                swapCurrentPlayer();
            }
            else {
                isGameOver = true;
            }
        }
        
        //displayResults();
    }

    public StateHistory getHistory()
    {
        return board.getStateHistory();
    }

    private void queryMove()
    {
        System.out.println("[" + getPlayerString(currentPlayer) + "'s Turn]:");
    }

    private void displayResults() {
        board.displayBoard();
        String loser = getPlayerString(currentPlayer);
        String winner = getPlayerString(currentPlayer != p1 ? p1 : p2);
        System.out.println(loser + " took the last piece. " + winner + " wins!");
    }

    private String getPlayerString(Player player)
    {
       return "Player " + (player == p1 ? "1" : "2");
    }

    private void swapCurrentPlayer() {
        currentPlayer = (currentPlayer == p1) ? p2 : p1;
    }
}
