package mega_ai;

import constants.ConstsForPoints;
import game.GameMake;

import java.util.Timer;
import java.util.TimerTask;

public class MegaAIThoughts {
    public static void rollOrNot() {
        int roller = (int)(Math.random() * 7 + 5);

        TimerTask task = new TimerTask() {
            public void run() {
                GameMake.throwDices();
            }
        };

        Timer timer = new Timer();
        roller = roller * ConstsForPoints.HUNDRED;

        timer.schedule(task, roller);
    }

    public static void rollAgain(int countOfPoints, int countOfPlus) {
        countOfPoints = countOfPoints / ConstsForPoints.HALF;
        int pointsRandom = (int)(Math.random() * countOfPoints + 1);
        countOfPlus = countOfPlus / ConstsForPoints.TEN;
        int plusRandom = (int)(Math.random() * countOfPlus + 1);

        int roller = (int)(Math.random() * 7 + 5);

        TimerTask task = new TimerTask() {
            public void run() {
                if (pointsRandom > ConstsForPoints.TEN || plusRandom < ConstsForPoints.TWENTY) {
                    GameMake.throwDices();
                } else {
                    GameMake.theEndOfTheRoll();
                }
            }
        };

        Timer timer = new Timer();
        roller = roller * ConstsForPoints.HUNDRED;

        timer.schedule(task, roller);
    }
}
