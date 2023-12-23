package game;

import constants.ConstsForPoints;
import gamblers.Gambler;
import helping_thing.GameCondition;

public class TheCone {
    private final int countOfDice = ConstsForPoints.COUNT_OF_DICE;
    private final int theBolt;
    private static int theResult = 0;

    private final int gamblerNumer;

    private final Gambler[] gam;

    private int countOfLose;

    public TheCone(int gamblerNumer) {
        GameCondition gameCondition = new GameCondition();
        this.gamblerNumer = gamblerNumer;
        this.theBolt = gameCondition.getBolt();
        gam = GameMake.getGamblers();
    }

    public void throwDice() {
        int[] kindsOfNumbers = new int[ConstsForPoints.SIX];

        int result1 = 0;
        int result2 = 0;
        int result3 = 0;

        for (int t = 0; t < countOfDice; ++t) {
            int oneOfDice = (int)(Math.random() * 6 + 1);
            switch (oneOfDice) {
                case ConstsForPoints.ONE -> ++kindsOfNumbers[0];
                case ConstsForPoints.TWO -> ++kindsOfNumbers[ConstsForPoints.ONE];
                case ConstsForPoints.THREE -> ++kindsOfNumbers[ConstsForPoints.TWO];
                case ConstsForPoints.FOUR -> ++kindsOfNumbers[ConstsForPoints.THREE];
                case ConstsForPoints.FIVE -> ++kindsOfNumbers[ConstsForPoints.FOUR];
                case ConstsForPoints.SIX -> ++kindsOfNumbers[ConstsForPoints.FIVE];
            }
        }

        result1 += plusCombo(0, kindsOfNumbers);
        result1 += plusCombo(ConstsForPoints.ONE, kindsOfNumbers);

        for (int t = 0; t < countOfDice - 1; ++t) {
            result2 += plus(kindsOfNumbers[t], t + 1);
        }
        int one = kindsOfNumbers[0];
        int five = kindsOfNumbers[ConstsForPoints.FOUR];
        if (one < ConstsForPoints.THREE) {
            result3 += one * ConstsForPoints.TEN;
        }
        if (five < ConstsForPoints.THREE) {
            result3 += five * ConstsForPoints.FIVE;
        }
        result2 = Math.max(result2, result3);

        whichIsResult(Math.max(result1, result2), kindsOfNumbers);
    }

    protected int plus(int mainNumber, int number) {
        int res = 0;

        if (mainNumber == ConstsForPoints.THREE) {
            res += number * ConstsForPoints.TEN;
        } else if(mainNumber == ConstsForPoints.FOUR) {
            res += number * ConstsForPoints.TWENTY;
        } else if(mainNumber == ConstsForPoints.FIVE) {
            res += number * ConstsForPoints.HUNDRED;
        }

        return res;
    }

    protected int plusCombo(int schet, int[] kindsOfNumbers) {
        for (int t = schet; t < countOfDice - (ConstsForPoints.TWO - schet); ++t) {
            if (kindsOfNumbers[t] != 1) {
                return 0;
            }
        }
        return schet * ConstsForPoints.COMBO;
    }

    protected void whichIsResult(int plus, int[] cubes) {
        int thePoints = gam[gamblerNumer].getPoints();
        if (thePoints == 0 && plus < ConstsForPoints.HALF && theResult == 0 || thePoints != 0 && plus == 0) {
            ++countOfLose;
            GameMake.cubesOnBoard(cubes, false);
            if (countOfLose < 3) {
                return;
            }
            countOfLose = 0;
            GameMake.addBolt();
            theEnd0();
        } else {
            GameMake.cubesOnBoard(cubes, true);
            addToTheResult(plus);
            if (!gam[gamblerNumer].getPCOrGambler().equals("RealGamer")) {
                GameMake.secondThoughtsOfAI(theResult);
            } else {
                GameMake.deleteButtons();
                GameMake.setSecondButton();
            }
        }
    }

    protected void addToTheResult(int plus) {
        theResult += plus;
    }

    protected void theEnd() {
        int countOfBolt = gam[gamblerNumer].getCountOfBolt();
        while (theBolt <= theResult && countOfBolt != 0) {
            theResult -= theBolt;
            --countOfBolt;
        }
        GameMake.addPointsAndSetBolt(gamblerNumer, countOfBolt, theResult);
        GameMake.changeNumberForCone();
        GameMake.createCone();
        theResult = 0;
    }

    protected void theEnd0() {
        GameMake.changeNumberForCone();
        GameMake.deleteButtons();
        GameMake.createCone();
        theResult = 0;
    }

    protected int getTheResult() {
        return theResult;
    }
}
