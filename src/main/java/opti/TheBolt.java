package opti;
import constants.ConstsForOpti;

import javax.swing.*;

public class TheBolt extends JLabel {

    private int bolt;

    public TheBolt(int bolt) {
        this.bolt = bolt;
        view();
    }

    public void boltHundred() {
        bolt = ConstsForOpti.HUNDRED;
        view();
    }

    public void boltHalf() {
        bolt = ConstsForOpti.HALF;
        view();
    }

    public int getBolt() {
        return bolt;
    }

    private void view() {
        setText("The Bolt is: " + bolt);
    }

    public void setCount(int count) {
        bolt = count;
    }
}