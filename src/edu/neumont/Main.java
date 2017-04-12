package edu.neumont;



public class Main {

    public static void main(String[] args) {
        FileIO fileIO = new FileIO();
        StateHistory history = new StateHistory(fileIO.readFromFile("AIHistory"));

        for (int i = 0; i < 10000; ++i)
        {
            Game game = new Game(new RandomAIPlayer(), new LearningAIPlayer(history));
            game.play();
            history.Add(game.getHistory());
        }

        fileIO.writeToFile(history.getStates(), "AIHistory");
    }
}
