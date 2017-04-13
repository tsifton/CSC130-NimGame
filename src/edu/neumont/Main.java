package edu.neumont;



public class Main {

    public static void main(String[] args) {
        FileIO fileIO = new FileIO();
        StateHistory history = new StateHistory(fileIO.readFromFile("AIHistory"));

        int p1Wins = 0;
        int p2Wins = 0;
        for (int i = 0; i < 100000; ++i)
        {
            Game game = new Game(new LearningAIPlayer(history), new RandomAIPlayer());
            game.play();
            if (game.getWinner() == 1) p1Wins++;
            else p2Wins++;
            history.Add(game.getHistory());
        }

        System.out.println("The Random AI won " + p1Wins + " out of " + (p1Wins + p2Wins) + " games.");
        System.out.println("The Smart AI won " + p2Wins + " out of " + (p1Wins + p2Wins) + " games.");
        fileIO.writeToFile(history.getStates(),"AIHistory");
    }
}
