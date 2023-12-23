package gamblers;

import constants.ConstsForPoints;
import helping_thing.GameCondition;

import java.util.Objects;

public class Gambler {
    private final String name;
    static int points;
    private int countOfBolts;
    private final boolean pcOrNot;
    private final String pcOrNotString;

    public Gambler(String name, boolean pcOrNot) {
        this.name = Objects.requireNonNullElse(name, "Gambler");

        if (pcOrNot) {
            pcOrNotString = "PC";
        } else {
            pcOrNotString = "RealGamer";
        }

        this.pcOrNot = false;
    }

    public String getName() {
        return name;
    }

    public int getCountOfBolt() {
        return countOfBolts;
    }

    public void setCountOfBolt(int setter) {
        countOfBolts = setter;
    }

    public void addCountOfBolt(int adder) {
        countOfBolts += adder;
    }

    public String getPCOrGambler() {
        return pcOrNotString;
    }
    public boolean getPcOrNot() {
        return pcOrNot;
    }

    public void addPoints(int newPoints) {
        points += newPoints;
        if (!(points < ConstsForPoints.THOUSAND)) {
            points = 1000;
            GameCondition gameCondition = GameCondition.mainCondition();
            gameCondition.theWin(name);
        }
    }

    public int getPoints() {
        return points;
    }
}
