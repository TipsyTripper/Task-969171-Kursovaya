package game;

import constants.ConstsForPoints;
import gamblers.Gambler;
import gamblers.Pc;
import mega_ai.MegaAIThoughts;

import java.util.ArrayList;

public class GameMake {
    private static Gambler[] gamblers;
    private static Game game;
    private static int gamblersCount;
    private static TheCone theCone;
    private static int numberForCone = 0;


    public GameMake() {
    }

    public static void createGamblers(Gambler you, int gamCount) {
        gamblersCount = gamCount;
        gamblers = new Gambler[gamblersCount];
        gamblers[0] = you;
        for (int t = 1; t < gamblersCount; ++t) {
            gamblers[t] = new Pc("Gambler " + t, t);
        }
    }

    public static void createGameFrame() {
        game = new Game(numberForCone);
        game.setVisible(true);
        game.setResizable(false);
    }

    public static void theEndOfTheRoll() {
        theCone.theEnd();
        game.rewrite();
        createCone();
    }

    public static void gameDispose() {
        game.setVisible(false);
    }

    public static void createCone() {
        theCone = new TheCone(numberForCone);
        if (numberForCone != 0) {
            thoughtsOfAI();
        } else {
            game.mainButton();
        }
    }

    public static void throwDices() {
        theCone.throwDice();
    }

    public static void thoughtsOfAI() {
        MegaAIThoughts.rollOrNot();
    }

    public static void secondThoughtsOfAI(int countOfPlus) {
        MegaAIThoughts.rollAgain(gamblers[numberForCone].getPoints(), countOfPlus);
    }


    public static void cubesOnBoard(int[] cubes, boolean check) {
        ArrayList<String> cu = new ArrayList<>();
        for (int t = 0; t < cubes.length; ++t) {
            for (int m = 0; m < cubes[t]; ++m) {
                switch (t) {
                    case 0 -> cu.add("one");
                    case ConstsForPoints.ONE -> cu.add("two");
                    case ConstsForPoints.TWO -> cu.add("three");
                    case ConstsForPoints.THREE -> cu.add("four");
                    case ConstsForPoints.FOUR -> cu.add("five");
                    case ConstsForPoints.FIVE -> cu.add("six");
                }
            }
        }
        game.addCubes(cu, numberForCone, check);
    }

    public static void changeNumberForCone() {
        if (numberForCone < gamblersCount - 1) {
            ++numberForCone;
        } else {
            numberForCone = 0;
        }
    }

    public static void addBolt() {
        gamblers[numberForCone].addCountOfBolt(1);
    }

    public static void addPointsAndSetBolt(int t, int countOfBolt, int theResult) {
        gamblers[t].setCountOfBolt(countOfBolt);
        gamblers[t].addPoints(theResult);
    }


    public static void setSecondButton() {
        game.secondButton();
    }

    public static Gambler[] getGamblers() {
        return gamblers;
    }

    public static int getTheNowestResult() {
        if (theCone != null) {
            return theCone.getTheResult();
        } else {
            return 0;
        }
    }

    public static void deleteButtons() {
        game.deleteButton();
    }

}
