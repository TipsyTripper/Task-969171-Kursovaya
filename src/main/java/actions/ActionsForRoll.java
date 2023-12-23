package actions;

import game.GameMake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionsForRoll implements ActionListener {
    private final int numberOfGambler;

    public  ActionsForRoll(int numberOfGambler) {
        this.numberOfGambler = numberOfGambler;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (numberOfGambler == 0) {
            GameMake.createCone();
            GameMake.throwDices();
        }
    }
}