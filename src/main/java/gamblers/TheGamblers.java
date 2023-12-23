package gamblers;
import constants.ConstsForOpti;

import javax.swing.*;

public class TheGamblers extends JLabel {
    private int gamblers;

    public TheGamblers(int gamblers) {
        this.gamblers = gamblers;
        view();
    }

    public void gamblersPlus() {
        if (gamblers == ConstsForOpti.MAX_GAMBLERS) {
            return;
        }

        gamblers ++;
        view();
    }

    public void gamblersMinus() {
        if (gamblers == ConstsForOpti.MIN_GAMBLERS) {
            return;
        }

        gamblers --;
        view();
    }

    public int getGamblers() {
        return gamblers;
    }
    private void view() {
        setText("Count of gamblers: " + gamblers);
    }
}
